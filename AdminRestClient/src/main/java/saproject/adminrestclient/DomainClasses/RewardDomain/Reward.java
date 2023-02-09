package saproject.adminrestclient.DomainClasses.RewardDomain;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Reward {

    private String rewardId;
    private String name;
    private int quantity;
    private RewardType type;
    private int price;
}
