package saproject.adminrestclient.DomainClasses.SchoolPackage;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {

    private int id;
    private String schoolName;
    private String address;

    private Contact contact;

}
