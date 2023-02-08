package com.swaproject.swaproject.controller;

import com.swaproject.swaproject.domains.Student;
import com.swaproject.swaproject.services.IStudentService;
import com.swaproject.swaproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Student addStudent(@RequestBody Student student) {
        kafkaTemplate.send("student", student.getFName() + "," + student.getLName() + "," + student.getClass());
        return studentService.addStudent(student);
}

    @GetMapping("/{StudentNumber}")
    public Student getStudent(@PathVariable String studentNumber){
        return studentService.viewStudent(studentNumber);
    }



    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable String id){
        studentService.deleteStudent(id);
    }



    @PutMapping("/update/")
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
}


}
