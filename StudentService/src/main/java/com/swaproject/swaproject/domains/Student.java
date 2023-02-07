package com.swaproject.swaproject.domains;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "students")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String fName;
    private String lName;
    @Id
    private String studentNumber;
    private int score;
    private Avatar avatar;
    //private List<Reward> rewards;

    private  School school;
    private TeachingClass teachingClass;




}
