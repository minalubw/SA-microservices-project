package saproject.elementservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saproject.elementservice.domain.Element;
import saproject.elementservice.dto.ElementDto;
import saproject.elementservice.service.IElementService;
@RequestMapping("/element")
@RestController
public class ElementController {

    @Autowired
    private IElementService elementService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{elementId}")
    public ResponseEntity<Element> viewElement(@PathVariable("elementId") String elementId){
        Element element = elementService.viewElement(elementId);
        return ResponseEntity.ok().body(element);
    }

    @PostMapping("/add")
    public ResponseEntity<Element> addElement(@RequestBody Element element){
        Element e1 = elementService.addElement(element);
        return ResponseEntity.ok().body(e1);
    }

    @PutMapping("/update/{elementId}")
    public ResponseEntity<Element> updateElement(@PathVariable("elementId") String elementId, @RequestBody Element element){
        element.setElementId(elementId);
        Element element1 = elementService.updateElement(elementId, element);
        return ResponseEntity.ok().body(element1);
    }

    @DeleteMapping("/delete/{elementId}")
    public ResponseEntity<String> deleteElement(@PathVariable("elementId") String elementId){
        return ResponseEntity.ok().body(elementService.deleteElement(elementId));
    }
}
