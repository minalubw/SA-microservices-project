package saproject.adminrestclient.DomainClasses.teacher;


import lombok.*;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class School {
    private int id;
    private String name, address;
    private Contact contact;

}
