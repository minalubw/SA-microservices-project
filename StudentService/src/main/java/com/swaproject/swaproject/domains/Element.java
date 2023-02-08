package com.swaproject.swaproject.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Element {

    private String elementId;
    private ElementType type;
    private int price;


}
