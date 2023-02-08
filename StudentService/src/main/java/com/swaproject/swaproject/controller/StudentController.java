package com.swaproject.swaproject.controller;

import com.swaproject.swaproject.domains.Student;
import com.swaproject.swaproject.services.IStudentService;
import com.swaproject.swaproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping ("/add")
    public Student addStudent(@RequestBody Student student) {
       return studentService.addStudent(student);
    }

    @GetMapping("/{studentNumber}")
    public Student getStudent(@PathVariable("studentNumber") String studentNumber){
        return studentService.viewStudent(studentNumber);
    }



    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable String id){
        studentService.deleteStudent(id);
    }



    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
}


}
