package observer_pattern;

import observer_pattern.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String number;
    private int balance;
    private List<Subscriber> subscribers = new ArrayList<>();

    public Account(String number, int balance) {
        this.number = number;
        this.balance = balance;
    }

    public void putMoney(int money) {
        balance += money;

        notifySubscribers(money);
    }

    public void subscribe(Subscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    private void notifySubscribers(int money) {
        for(Subscriber subscriber : subscribers) {
            subscriber.changeBalance(this, money);
        }
    }

    public String getNumber() {
        return number;
    }

    public int getBalance() {
        return balance;
    }
}
