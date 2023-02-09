package saproject.adminrestclient.DomainClasses.ElementDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Element {
    private String elementId;
    private ElementType type;
    private int price;

}
