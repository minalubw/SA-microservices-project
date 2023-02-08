package saproject.rewardservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reward")
public class Reward {
    @Id
    private String rewardId;
    private String name;
    private int quantity;
    private RewardType type;
    private int price;
}
