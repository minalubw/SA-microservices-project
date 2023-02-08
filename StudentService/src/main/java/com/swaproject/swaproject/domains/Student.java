package com.swaproject.swaproject.domains;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


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
    private List<Reward> rewardList = new ArrayList<>();
    private School school;
    private TeachingClass teachingClass;

    public void addReward(Reward reward){
        this.rewardList.add(reward);
        System.out.println("Adding reward..."+ reward);
    }

    public void removeReward(Reward reward){
        this.rewardList.remove(reward);
    }


}
