package saproject.teacherservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import saproject.teacherservice.ExceptionHandling.TeacherException;
import saproject.teacherservice.domain.Teacher;
import saproject.teacherservice.service.TeacherService;
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;



    @Autowired
    private TeacherService teacherService;

    @PostMapping("/add")
    public String addTeacher(@RequestBody Teacher teacher) {
        try {
            teacherService.addTeacher(teacher);
            String message = teacher.getFirstName() + "," + teacher.getLastName() + "," + teacher.getContact().getEmail();
            kafkaTemplate.send("teacher", message);
            return "Teacher added";
        } catch (TeacherException e) {
            return e.getMessage();
        }
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable int id) {
        try{
            teacherService.deleteTeacher(id);
            return "Teacher deleted";
        } catch (TeacherException e) {
            return e.getMessage();
        }
    }
    @PutMapping("/update/{id}")  // TODO: 2020-04-30  update teacher
    public String updateTeacher(@PathVariable int id) {
        Teacher teacher = teacherService.getTeacher(id);
        try {
            teacherService.updateTeacher(teacher);
            return "Teacher updated";
        } catch (TeacherException e) {
            return e.getMessage();
        }
    }
    @GetMapping("/get/{id}")
    public String getTeacher(@PathVariable int id) {
        try {
            teacherService.getTeacher(id);
        } catch (TeacherException e) {
            return e.getMessage();
        }
        return teacherService.getTeacher(id).toString();
    }
    @GetMapping("/getAll")
    public String getAllTeachers() {
        return teacherService.getAllTeachers().toString();
    }
}
