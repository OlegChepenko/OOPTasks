package online_banking;

public class Account {
    private String number;
    private int balance;

    public Account(String number, int balance) {
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    //метод перенесен в класс Client
//    public boolean transfer (Account to, int money){
//        if (balance >= money){
//            balance -= money;
//            to.balance += money;
//            return true;
//        }
//        return false;
//    }
}
