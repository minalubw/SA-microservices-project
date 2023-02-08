package purchase.exception;

public class NotEnoughScoreException extends RuntimeException{
    String message;

    public NotEnoughScoreException(String message){
        this.message = message;
    }
}
