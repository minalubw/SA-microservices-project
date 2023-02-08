package com.swaproject.swaproject.domains;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "students")
@Data
@Getter
@Setter
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
