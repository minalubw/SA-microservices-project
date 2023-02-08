package com.swaproject.swaproject.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reward {

    private Integer id;
    private String name;
    private int quantity;
    private RewardType rewardType;
}
