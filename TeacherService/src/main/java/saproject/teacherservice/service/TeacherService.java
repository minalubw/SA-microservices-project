package saproject.teacherservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saproject.teacherservice.ExceptionHandling.TeacherException;
import saproject.teacherservice.domain.Teacher;
import saproject.teacherservice.repository.TeacherDAO;

import java.util.List;


@Service
public class TeacherService {
    @Autowired
    private TeacherDAO teacherRepository;

    public Teacher addTeacher(Teacher teacher) {
        //int id = teacher.getSchool().getId();
        return teacherRepository.save(teacher);
    }
    public String deleteTeacher(int id) throws TeacherException {

            Teacher teacher = teacherRepository.findById(id).orElse(null);
            if(teacher == null) {
                throw new TeacherException("Teacher not found");
            }
            else {
                teacherRepository.deleteById(id);
                return "Teacher Deleted!";
            }

    }
    public Teacher updateTeacher(Teacher teacher) throws TeacherException {

            Teacher teacher1 = teacherRepository.findById(teacher.getId())
                                                .isPresent() ? teacherRepository.findById(teacher.getId()).get()
                                                             : null;
            if(teacher1 == null) {
                throw new TeacherException("Teacher not found");
            }
            else {
                teacher1.setFirstName(teacher.getFirstName());
                teacher1.setLastName(teacher.getLastName());
                teacher1.setSchool(teacher.getSchool());
                teacher1.setContact(teacher.getContact());
                return teacherRepository.save(teacher1);
            }
    }
    public Teacher getTeacher(int id) throws TeacherException{
        if (teacherRepository.findById(id).isEmpty())
            throw new TeacherException("Teacher not found");
        else
            return teacherRepository.findById(id).get();

    }
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
    public Integer getNumberOfTeachers(){
        return teacherRepository.findAll().size();
    }
}
