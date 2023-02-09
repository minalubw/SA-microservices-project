package saprojects.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedeemRewardOrder {
    private String studentNumber;
    private String elementId;
    private String rewardId;
}
