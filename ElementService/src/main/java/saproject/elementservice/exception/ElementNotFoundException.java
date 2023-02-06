package saproject.elementservice.exception;

public class ElementNotFoundException extends RuntimeException{
    private String message;

    public ElementNotFoundException(String message){
        this.message = message;
    }
}
