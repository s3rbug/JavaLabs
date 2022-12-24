package Bank;

import java.util.UUID;

public class Account {
    private int balance;
    private final String ID;

    public Account(int balance) {
        this.balance = balance;
        ID = String.valueOf(UUID.randomUUID());
    }

    void withdraw(int amount) {
        balance -= amount;
    }

    void deposit(int amount) {
        balance += amount;
    }

    String getID(){
        return ID;
    }

    String getShortenedID(){
        return ID.split("-")[0];
    }

    int getBalance(){
        return balance;
    }
}
