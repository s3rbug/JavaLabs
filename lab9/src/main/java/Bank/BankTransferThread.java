package Bank;

public class BankTransferThread extends Thread {
    Bank bank;
    Account from, to;
    int amount;

    public BankTransferThread(String name, Bank bank, Account from, Account to, int amount) {
        super(name);
        this.bank = bank;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void run() {
        try {
            bank.transfer(from, to, amount);
        } catch (BankWrongOperationException exception) {
            System.out.println(exception.getMessage());
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
