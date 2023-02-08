package purchase.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rewards {
    private String id;
    List<Reward> rewardsList = new ArrayList<>();

    public void addReward(Reward reward){
       // System.out.println(this.rewardsList.stream().forEach(System.out::Println));
        this.rewardsList.add(reward);
        System.out.println("Adding reward..."+ reward);
    }

    public void removeReward(Reward reward){
        this.rewardsList.remove(reward);
    }

    public void updateRewardQuantity(String rewardId){
        for (Reward r: rewardsList) {
            if(r.getRewardId().equalsIgnoreCase(rewardId)){
                r.setQuantity(r.getQuantity()-1);
            }
        }
    }

}
