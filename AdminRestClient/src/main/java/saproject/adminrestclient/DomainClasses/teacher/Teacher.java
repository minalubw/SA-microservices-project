package saproject.adminrestclient.DomainClasses.teacher;



import lombok.*;


@Getter
@Setter
@ToString
@RequiredArgsConstructor

@AllArgsConstructor

public class Teacher {

    private int id;
    private String firstName, lastName;

    private School school;

    private TeachingClass teachingClass;

    private Contact contact;

    private User user;

//object of teacher


}
