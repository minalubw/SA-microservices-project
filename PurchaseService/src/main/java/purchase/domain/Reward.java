package purchase.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reward {
    private Integer id;
    private String name;
    private int quantity;
    private RewardType rewardType;
}
