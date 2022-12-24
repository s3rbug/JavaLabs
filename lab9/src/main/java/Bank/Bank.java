package Bank;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    HashMap<String, Account> accounts = new HashMap<>();
    private final Lock bankLock = new ReentrantLock();
    private final Condition condition = bankLock.newCondition();

    public void transfer(Account from, Account to, int amount) throws BankWrongOperationException, InterruptedException {
        if (!accounts.containsKey(from.getID())
                || !accounts.containsKey(to.getID())
        ) {
            throw new BankWrongOperationException("Can not transfer money, wrong accounts are provided!");
        }
        bankLock.lock();
        try {
            while (from.getBalance() < amount) {
                condition.await();
            }
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println(Thread.currentThread().getName() + ": " +
                    amount + "$ from " + from.getShortenedID() + " to " + to.getShortenedID()
                    + "; Total: " + totalMoney() + "$");
            condition.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

    public void addAccount(Account newAccount) {
        accounts.put(newAccount.getID(), newAccount);
    }

    public int totalMoney() {
        bankLock.lock();
        try {
            int total = 0;
            for (Account account : accounts.values()) {
                total += account.getBalance();
            }
            return total;
        } finally {
            bankLock.unlock();
        }
    }
}
