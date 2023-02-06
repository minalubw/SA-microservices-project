package swaproject.schoolservice.exception;

public class SchoolNotFoundException extends RuntimeException{
    private String message;

public SchoolNotFoundException(String message) {
    super(message);
}

}
