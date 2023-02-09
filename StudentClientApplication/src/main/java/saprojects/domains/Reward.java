package saprojects.domains;

import lombok.*;
import org.springframework.data.annotation.Id;
@ToString
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reward {
    @Id
    private String rewardId;
    private String name;
    private int quantity;
    private RewardType type;
    private int price;
}
