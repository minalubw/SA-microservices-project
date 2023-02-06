package swaproject.schoolservice.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "schools")
public class School {
    @Id
    private String schoolName;
    private String address;

    private Contact contact;

}
