package saproject.rewardservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import saproject.rewardservice.domain.RewardType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RewardDto {
    @Id
    private Integer rewardId;
    private String name;
    private int quantity;
    private RewardType type;
    private int price;
}
