package observer_pattern;

public class Main {
    public static void main(String[] args) {
        Account account = new Account("456756756657", 10000);
        Robot robot = new Robot();
        account.subscribe(robot);
        Client client = new Client("Максим Петров");
        account.subscribe(client);

        account.putMoney(20000);
        account.putMoney(150000);
    }
}
