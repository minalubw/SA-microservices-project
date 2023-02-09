package saproject.adminrestclient.DomainClasses.StudentDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avatar {

    private int id;
    List<Element> elementList = new ArrayList<>();

    public void addElement(Element element){
        elementList.add(element);
    }
    public void removeElement(String elementId){
        for (Element element:
                elementList) {
            if(element.getElementId().equalsIgnoreCase(elementId)){
                elementList.remove(element);
                break;
            }
        }
    }
}


