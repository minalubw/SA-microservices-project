package saproject.teacherservice.ExceptionHandling;

public class TeacherException extends RuntimeException{
    public TeacherException() {
        super();
    }
    public TeacherException(String message) {
        super(message);
    }

}
