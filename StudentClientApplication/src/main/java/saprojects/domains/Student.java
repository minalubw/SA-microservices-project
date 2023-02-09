package saprojects.domains;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {


    private String studentNumber;
    private String firstName;
    private String lastName;
    private int score;
    private Avatar avatar = new Avatar();
    private List<Reward> rewardList = new ArrayList<>();
    private School school;
    private TeachingClass teachingClass;
    private User user;
    public void addReward(Reward reward){
        this.rewardList.add(reward);
        System.out.println("Adding reward..."+ reward);
    }

    public void removeReward(Reward reward){
        this.rewardList.remove(reward);
    }


}
