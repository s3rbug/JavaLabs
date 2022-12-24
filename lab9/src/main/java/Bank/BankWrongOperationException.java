package Bank;

public class BankWrongOperationException extends Exception {
    public BankWrongOperationException(String message){
        super(message);
    }
}
