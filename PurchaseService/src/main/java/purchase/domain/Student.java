package purchase.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "students")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    private String studentNumber;
    private String firstName;
    private String lastName;
    private int score;
    private Avatar avatar = new Avatar();
    private Rewards rewards;
    private School school;
    private TeachingClass teachingClass;


}
