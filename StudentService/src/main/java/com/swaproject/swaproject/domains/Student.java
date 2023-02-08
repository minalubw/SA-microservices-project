package com.swaproject.swaproject.domains;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "students")
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    private String studentNumber;
    private String fName;
    private String lName;
    private int score;
    private Avatar avatar;
    private List<Reward> rewards;
    private  School school;
    private User user;
    private TeachingClass teachingClass;




}
