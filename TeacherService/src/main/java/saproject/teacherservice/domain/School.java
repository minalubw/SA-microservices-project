package saproject.teacherservice.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

@AllArgsConstructor
@Entity
@Document(collection = "schools")
public class School {
    @Id
    private int id;
    private String name, address;
    @Embedded
    private Contact contact;

}
