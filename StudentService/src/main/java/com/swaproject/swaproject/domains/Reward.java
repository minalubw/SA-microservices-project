package com.swaproject.swaproject.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reward")
public class Reward {
    @Id
    private Integer id;
    private String name;
    private int quantity;
    private Type type;
}
