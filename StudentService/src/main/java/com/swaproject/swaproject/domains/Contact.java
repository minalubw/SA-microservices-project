package com.swaproject.swaproject.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private String phoneNumber;
    private String emailAddress;


}
