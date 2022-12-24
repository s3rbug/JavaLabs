import Bank.Bank;
import Bank.Account;
import Bank.BankTransferThread;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        final int COUNT_ACCOUNTS = 20;
        Account[] accounts = new Account[COUNT_ACCOUNTS];
        for(int i = 0; i < COUNT_ACCOUNTS; ++i){
            int randomBalance = ThreadLocalRandom.current().nextInt(10000, 100000);
            accounts[i] = new Account(randomBalance);
        }
        for (Account account : accounts) {
            bank.addAccount(account);
        }
        int totalMoneyBeforeTransfers = bank.totalMoney();
        System.out.println("Total money: " + totalMoneyBeforeTransfers + "$");
        final int COUNT_TRANSFERS = 30;
        BankTransferThread[] threads = new BankTransferThread[COUNT_TRANSFERS];

        for (int i = 0; i < COUNT_TRANSFERS; ++i) {
            int randomAccountIndexFrom = ThreadLocalRandom.current().nextInt(0, COUNT_ACCOUNTS);
            int randomAccountIndexTo = ThreadLocalRandom.current().nextInt(0, COUNT_ACCOUNTS);
            int randomTransferAmount = ThreadLocalRandom.current().nextInt(10, 101);
            while (randomAccountIndexFrom == randomAccountIndexTo) {
                randomAccountIndexTo = ThreadLocalRandom.current().nextInt(0, COUNT_ACCOUNTS);
            }
            threads[i] = new BankTransferThread(
                    "BankTransferThread " + i,
                    bank,
                    accounts[randomAccountIndexFrom],
                    accounts[randomAccountIndexTo],
                    randomTransferAmount);
            threads[i].start();
        }
        try {
            for (BankTransferThread thread : threads) {
                thread.join();
            }
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
        }
        System.out.println("\nTotal money before transfers: " + totalMoneyBeforeTransfers + "$");
        System.out.println("Total money after transfers: " + bank.totalMoney() + "$");
    }
}