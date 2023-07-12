package online_banking;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Client {
    private String fullName;
    private String phone;
    private String password;
    private List<Account> accounts;
    private List<Transaction> transactions;

    public Client(String fullName, String phone, String password) {
        this.fullName = fullName;
        this.phone = phone;
        this.password = password;
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public void addAccount(Account account) {
// Проверка без Stream Api
//        boolean find = false;
//        for (Account a : accounts) {
//            if (a.getNumber().equals(account.getNumber())){
//                find = true;
//                break;
//            }
//        }
//        if (find) {
//            throw new IllegalArgumentException("Уже есть счет с таким номером");
//        }

        // Проверка со Stream Api
        if (accounts.stream().anyMatch(t -> t.getNumber().equals(account.getNumber()))) {
            throw new IllegalArgumentException("Уже есть счет с таким номером");
        }
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        //    return Collections.unmodifiableList(accounts);
        return new ArrayList<>(accounts);
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    //----------------------------------------------------------------------------------
    //Трансфер между своими счетами,
    // пополнение с чужого счета
    // и трансфер на другой счет не могут быть в одной функции. Т.к. тип операции разный

    public boolean transfer(Account from, Account to, int sum) {
        if (from.getBalance() >= sum) {
            from.setBalance(from.getBalance() - sum);
            to.setBalance(to.getBalance() + sum);
            LocalDateTime date = LocalDateTime.now();
//            TypeOperation moneyWriteOff = TypeOperation.MONEY_WRITE_OFF;
//            TypeOperation refill = TypeOperation.REFILL;
            TypeOperation between = TypeOperation.BETWEEN_YOUR_ACCOUNTS;
            transactions.add(new Transaction(from, to, sum, date, between, this));
//            writeTransfer();
            return true;
        }
        return false;
    }
    public Account findAccount(String number){
        Optional<Account> account = accounts.stream().filter(a ->a.getNumber().equals(number)).findFirst();
        if (account.isPresent()){
            return account.get();
        }else return null;
    }
//    public void writeTransfer(){
//      try (BufferedWriter writer = new BufferedWriter(new FileWriter("online_banking_transfers.txt"))){
//          for (Transaction t : transactions) {
//              writer.write(t.getSrc().getNumber() + ";" + t.getDestination().getNumber() + ";" + t.getSum() + ";" + t.getDate() + ";" + t.getTypeOperation());
//              writer.newLine();
//          }
//      }catch (IOException exception){
//          System.out.println("Ошибка при записи транзакции в файл");
//      }
//
//    }

}
