package observer_pattern;

public class Client implements Subscriber {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void changeBalance(Account account, int money) {
        System.out.println(name + " ваш баланс изменен на " + money + ", текущий баланс = " + account.getBalance());
    }
}
