package swaproject.schoolservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swaproject.schoolservice.domains.School;
import swaproject.schoolservice.services.ISchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private ISchoolService schoolService;

 @PostMapping("/add")
 public School addSchool(@RequestBody School school){
     return schoolService.addSchool(school);

        }
  @GetMapping("/get/{id}")
   public School getSchool(@PathVariable int id){
     return schoolService.viewSchool(id);
    }

  @DeleteMapping("/delete/{id}")
    public void deleteSchool(@PathVariable int id){
     schoolService.removeSchool(id);
  }

  @PutMapping("/update")
    public void UpdateSchool(@RequestBody School school){
     schoolService.updateSchool(school);
  }

}
