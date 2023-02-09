package saproject.adminrestclient.DomainClasses.StudentDomain;

import lombok.*;

@ToString
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
