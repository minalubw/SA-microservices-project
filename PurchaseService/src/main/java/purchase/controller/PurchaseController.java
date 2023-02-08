package purchase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import purchase.domain.Element;
import purchase.domain.ElementOrder;
import purchase.domain.Student;
import purchase.services.IPurchaseService;

@RestController
@RequestMapping("/order")
public class PurchaseController {

    @Autowired
    ElementFeignClient elementFeignClient;

    @Autowired
    StudentFeignClient studentFeignClient;

    @Autowired
    private IPurchaseService purchaseService;

    @PutMapping("/buyelement")
    public Student buyElement(@RequestBody ElementOrder elementOrder){
        Student student = studentFeignClient.getStudent(elementOrder.getStudentNumber());
        Element element = elementFeignClient.getElement(elementOrder.getElementId());
        Student updated = purchaseService.buyElement(student, element);
        return studentFeignClient.updateStudent(updated);
    }

    @PutMapping("/remove")
    public Student removeElement(@RequestBody ElementOrder elementOrder){
        Student student = studentFeignClient.getStudent(elementOrder.getStudentNumber());
        Student updated = purchaseService.removeElement(student, elementOrder.getElementId());
        return studentFeignClient.updateStudent(updated);
    }



    @FeignClient("ElementService")
    interface ElementFeignClient{
        @RequestMapping("/element/{elementId}")
        Element getElement(@PathVariable("elementId") String elementId);
    }

    @FeignClient("StudentService")
    interface StudentFeignClient{
        @RequestMapping("/student/{studentNumber}")
        Student getStudent(@PathVariable("studentNumber") String studentNumber);

        @PutMapping("/student/update")
        public Student updateStudent(@RequestBody Student student);
    }
}
