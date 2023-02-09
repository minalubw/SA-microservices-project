package saproject.teacherservice.domain;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

@AllArgsConstructor
@Entity
@Document(collection = "teachers")
public class Teacher {
    @Id
    private int id;
    private String firstName, lastName;
    @OneToOne // one teacher can be assigned to one school
    private School school;
    @Embedded
    private TeachingClass teachingClass;
    @Embedded
    private Contact contact;
    @Embedded
    private User user;

//object of teacher


}
