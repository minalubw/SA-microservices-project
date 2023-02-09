package com.swaproject.swaproject.controller;

import com.swaproject.swaproject.domains.Student;
import com.swaproject.swaproject.services.IStudentService;
import com.swaproject.swaproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private IStudentService studentService;

    @PostMapping ("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
//        kafkaTemplate.send("student", student.getFirstName() + "," + student.getLastName() + "," + student.getClass());
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
    }

    @GetMapping("/{studentNumber}")
    public ResponseEntity<Student> getStudent(@PathVariable("studentNumber") String studentNumber){
        return new ResponseEntity<>(studentService.viewStudent(studentNumber), HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id){
         return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);
    }



    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.OK);
}


}
