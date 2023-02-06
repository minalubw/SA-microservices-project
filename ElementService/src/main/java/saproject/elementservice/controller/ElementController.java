package saproject.elementservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saproject.elementservice.domain.Element;
import saproject.elementservice.domain.Type;
import saproject.elementservice.dto.ElementDto;
import saproject.elementservice.service.IElementService;

@RestController
public class ElementController {

    @Autowired
    private IElementService elementService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/element/{elementId}")
    public ResponseEntity<ElementDto> viewElement(@PathVariable("elementId") String elementId){
        Element element = elementService.viewElement(elementId);
        return ResponseEntity.ok().body(modelMapper.map(element, ElementDto.class));
    }

    @PostMapping("/element")
    public ResponseEntity<ElementDto> addElement(@RequestBody Element element){
        Element e1 = elementService.addElement(element);
        return ResponseEntity.ok().body(modelMapper.map(e1, ElementDto.class));
    }

    @PutMapping("/element/{elementId}")
    public ResponseEntity<ElementDto> updateElement(@PathVariable("elementId") String elementId, @RequestBody Element element){
        element.setElementId(elementId);
        Element element1 = elementService.updateElement(elementId, element);
        return ResponseEntity.ok().body(modelMapper.map(element1, ElementDto.class));
    }

    @DeleteMapping("/element/{elementId}")
    public ResponseEntity<String> deleteElement(@PathVariable("elementId") String elementId){
        return ResponseEntity.ok().body(elementService.deleteElement(elementId));
    }
}
