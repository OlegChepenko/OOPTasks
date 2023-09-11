package observer_pattern;

public class Robot implements Subscriber {

    @Override
    public void changeBalance(Account account, int money) {
        if (money > 100000) {
            System.out.println("Отправляю транзакцию на проверку");
        }
    }
}
