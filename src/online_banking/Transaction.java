package online_banking;

import java.time.LocalDateTime;

public class Transaction {
    private Account src;
    private Account destination;
    private int sum;
    private LocalDateTime date;
    private TypeOperation typeOperation;
    private Client client;

    public Transaction(Account src, Account destination, int sum, LocalDateTime date, TypeOperation typeOperation, Client client) {

        this.src = src;
        this.destination = destination;
        this.sum = sum;
        this.date = date;
        this.typeOperation = typeOperation;
        this.client = client;
    }

    public Account getSrc() {
        return src;
    }

    public Account getDestination() {
        return destination;
    }

    public int getSum() {
        return sum;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public Client getClient() {
        return client;
    }
}
