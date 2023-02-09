package saproject.avatar.ExceptionHandling;

public class AvatarException extends RuntimeException{

    public AvatarException(String message) {
        super(message);
    }
    public AvatarException(){
        super();
    }
}
