package saproject.teacherservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saproject.teacherservice.ExceptionHandling.TeacherException;
import saproject.teacherservice.domain.Teacher;
import saproject.teacherservice.repository.TeacherDAO;


@Service
public class TeacherService {
    @Autowired
    private TeacherDAO teacherRepository;

    public void addTeacher(Teacher teacher) {
        //int id = teacher.getSchool().getId();
        teacherRepository.save(teacher);
    }
    public void deleteTeacher(int id) throws TeacherException {

            Teacher teacher = teacherRepository.findById(id).orElse(null);
            if(teacher == null) {
                throw new TeacherException("Teacher not found");
            }
            else {
                teacherRepository.deleteById(id);
            }

    }
    public void updateTeacher(Teacher teacher) throws TeacherException {

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
                teacherRepository.save(teacher1);
            }
    }
    public Teacher getTeacher(int id) throws TeacherException{
        if (teacherRepository.findById(id).isEmpty())
            throw new TeacherException("Teacher not found");
        else
            return teacherRepository.findById(id).get();

    }
    public Iterable<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

}
