package com.swaproject.swaproject.domains;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rewards {
    private String id;
    List<Reward> rewardsList = new ArrayList<>();

    public void addReward(Reward reward){
        this.rewardsList.add(reward);
        System.out.println("Adding reward..."+ reward);
    }

    public void removeReward(Reward reward){
        this.rewardsList.remove(reward);
    }

}
