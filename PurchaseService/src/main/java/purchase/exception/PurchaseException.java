package purchase.exception;

public class PurchaseException extends RuntimeException{
    String message;

    public PurchaseException(String message){
        this.message = message;
    }
}
