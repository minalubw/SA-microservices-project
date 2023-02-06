package saproject.elementservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saproject.elementservice.domain.Element;
import saproject.elementservice.exception.ElementNotFoundException;
import saproject.elementservice.repository.ElementRepository;

import java.util.Optional;

@Service
public class ElementService implements IElementService{
    @Autowired
    private ElementRepository elementRepository;
    @Override
    public Element addElement(Element element) {
        return elementRepository.save(element);
    }

    @Override
    public Element viewElement(String elementId) {
        Optional<Element> element = elementRepository.findById(elementId);
        if(element.isPresent()){
            return element.get();
        }
        else
            throw new ElementNotFoundException("Element with + " + elementId + " not found!");
    }

    @Override
    public Element updateElement(String elementId, Element element) {
        Optional<Element> elementToBeUpdated = elementRepository.findById(elementId);
        if(elementToBeUpdated.isPresent()){
            elementToBeUpdated.get().setType(element.getType());
            elementToBeUpdated.get().setPrice(element.getPrice());
            return elementRepository.save(elementToBeUpdated.get());
        }
        else
            throw new ElementNotFoundException("Element with + " + elementId + " not found!");
    }

    @Override
    public String deleteElement(String elementId) {
        Optional<Element> elementToBeDeleted = elementRepository.findById(elementId);
        if(elementToBeDeleted.isPresent()){
            elementRepository.delete(elementToBeDeleted.get());
            return "Element Deleted!";
        }
        else
            throw new ElementNotFoundException("Element with + " + elementId + " not found!");
    }
}
