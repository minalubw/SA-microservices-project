package saproject.adminrestclient.DomainClasses.SchoolPackage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private String phoneNumber;
    private String emailAddress;

}
