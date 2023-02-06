package saproject.elementservice.service;

import saproject.elementservice.domain.Element;

public interface IElementService {
    Element addElement(Element element);
    Element viewElement(String elementId);
    Element updateElement(String elementId, Element element);
    String deleteElement(String elementId);


}
