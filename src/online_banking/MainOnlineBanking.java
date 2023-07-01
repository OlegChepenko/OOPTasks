package online_banking;

import java.io.*;
import java.util.*;

public class MainOnlineBanking {

    static ArrayList<Client> readClients() {
        ArrayList<Client> clients = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("online_banking.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] a = line.split(";");
                Client client = new Client(a[0], a[1], a[2]);
                int count = Integer.parseInt(a[3]);
                for (int i = 0; i < count; i++) {
                    String p = reader.readLine();
                    String[] b = p.split(";");
                    int balance = Integer.parseInt(b[1]);
                    Account account = new Account(b[0], balance);
                    client.addAccount(account);
                }
                clients.add(client);
            }
        } catch (IOException exc) {
            throw new RuntimeException(exc);
        }
        return clients;
    }

    //----------------------------------------------------------------------------------------
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to HSE‑BANK online!");
        ArrayList<Client> clients = readClients();
        while (true) {
            Client client = authorization(clients);
            smsAuthorization(client);

            String clientFullName = client.getFullName();
            System.out.println("Welcome, " + clientFullName);
            while (true) {
                System.out.println("1 ‑ list accounts");
                System.out.println("2 ‑ transfer money");
                System.out.println("3 ‑ open a new account");
                System.out.println("4 ‑ logout");
                System.out.println("5 - showTransaction");
                try {
                    int action = Integer.parseInt(scanner.nextLine());
                    if (action == 1) {
                        showAccounts(client);
                    } else if (action == 2) {
                        transferMany(client);
                        saveFile(clients);
                    } else if (action == 3) {
                        openNewAccount(client, clients);
                        saveFile(clients);
                        showAccounts(client);
                    } else if (action == 4) {
                        break;
                    }
                } catch (Exception exc) {
                    System.out.println(exc.getMessage());
                }
            }
        }
    }
    //---------------------------------------------
    static void writeTransfer(Client client){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("online_banking_transfers.txt", true))){
            Transaction t = client.getTransactions().get(client.getTransactions().size()-1);
                writer.write(t.getSrc().getNumber() + ";" + t.getDestination().getNumber() + ";" + t.getSum() + ";" + t.getDate() + ";" + t.getTypeOperation());
                writer.newLine();

        }catch (IOException exception){
            System.out.println("Ошибка при записи транзакции в файл");
        }

    }
    //--------------------------------------------
    static void saveFile(ArrayList<Client> clients){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("online_banking.txt"))){
            for (Client c : clients) {
                writer.write(c.getFullName() + ";" + c.getPhone() + ";" + c.getPassword() + ";" + c.getAccounts().size());
                writer.newLine();
                for ( Account account : c.getAccounts()) {
                    writer.write(account.getNumber() + ";" + account.getBalance());
                    writer.newLine();
                }
            }
        } catch (IOException exc){
            System.out.println("Сохранить файл не удалось");
        }
    }
    //-----------------------------------------------------------
    static boolean checkAccounts(ArrayList<Client> clients, String numberAccount){
        if (clients.stream().flatMap(t->t.getAccounts().stream()).anyMatch(t->t.getNumber().equals(numberAccount))){
            return false;
        }
        return true;
    }

    //------------------------------------------------------------
    static void transferMany(Client client) {
        Scanner scanner = new Scanner(System.in);
        if (client.getAccounts().size() < 2) {
            System.out.println("You need to have at least two accounts for this operation!");
        } else {
            showAccounts(client);
            System.out.println("С какого счета сделать перевод?");
            int n = scanner.nextInt();
            System.out.println("На какой счет сделать перевод?");
            int n2 = scanner.nextInt();
            System.out.println("Какую сумму перевести?");
            int sum = scanner.nextInt();
            Account from = client.getAccounts().get(n - 1);
            Account to = client.getAccounts().get(n2 - 1);
            if (client.transfer(from, to, sum)) {
                System.out.println("Operation successfully!");
                showAccounts(client);
                writeTransfer(client);
            } else {
                System.out.println("Недостаточно денег на счету");
            }
        }
    }

    //-------------------------------------------------------------
    static void showAccounts(Client client) {
        List<Account> accounts = client.getAccounts();
        int i = 1;
        for (Account a : accounts) {
            System.out.println(i + ". " + a.getNumber() + " - Balance: " + a.getBalance());
            i++;
        }
    }

    //-------------------------------------------------------------
    static void smsAuthorization(Client client) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String smsCode = smsCode();
            System.out.println("SMS on " + client.getPhone() + ": HSE‑BANK ‑ Your confirmation code is " + smsCode);
            System.out.println("Enter confirmation code:");
            String code = scanner.nextLine();
            if (smsCode.equals(code)) {
                break;
            }
        }
    }

    //-------------------------------------------------------------
    static Client authorization(ArrayList<Client> clients) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter username:");
            String phoneNumber = scanner.nextLine();
            System.out.println("Enter password:");
            String password = scanner.nextLine();
            Optional<Client> optionalClient = clients.stream().
                    filter(t -> t.getPhone().equals(phoneNumber) && t.getPassword().equals(password)).findFirst();
            if (optionalClient.isPresent()) {
                return optionalClient.get();
            } else {
                System.out.println("Incorrect username/password!");
            }
        }
    }
    //--------------------------------------------------------------

    // проверка логина пароля
    static boolean checkLogPass(String phoneNumber, String password, Client client) {
        if ((client.getPhone().equals(phoneNumber)) && (client.getPassword().equals(password))) {
            return true;
        }
        return false;
    }

    //----------------------------------------------------------------
    static String smsCode() {
        Random random = new Random();
        return String.valueOf(random.nextInt(1, 100000));
    }

    //-------------------------------------------------------------------
    static Client findClient(String phoneNumber, ArrayList<Client> clients) {
        Optional<Client> optionalClient = clients.stream().filter(t -> t.getPhone().equals(phoneNumber)).findFirst();
        if (optionalClient.isPresent()) {
            Client result = optionalClient.get();
            return result;
        }
        return null;
    }

    //---------------------------------------------------------------------
    static void openNewAccount(Client client, ArrayList<Client> clients) {

        String number = "";
        do {
            number = generateNumber(17);
        } while (!checkAccounts(clients, number));
        Account account = new Account(number, 0);
        client.addAccount(account);
//        Account account = new Account(s,0);
//        client.addAccount(account);

    }
//как принять и обработать исключение, что такой счет уже есть?
    //----------------------------------------------------------------------
    static String generateNumber(int length){
        Random random = new Random();
        String s = "";
        for (int i = 0; i < length; i++) {
            s += random.nextInt(0,10);
        }
        return s;
    }
}
