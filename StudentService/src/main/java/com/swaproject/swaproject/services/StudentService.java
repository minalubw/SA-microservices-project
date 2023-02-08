package com.swaproject.swaproject.services;

import com.swaproject.swaproject.dao.StudentRepository;
import com.swaproject.swaproject.domains.Student;
import com.swaproject.swaproject.domains.StudentDto;
import com.swaproject.swaproject.exception.StudentNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@Service
public class StudentService implements IStudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Optional<Student> stdnt = studentRepository.findById(student.getStudentNumber());
        if(stdnt.isPresent()){
            stdnt.get().setFirstName(student.getFirstName());
            stdnt.get().setLastName(student.getLastName());
            stdnt.get().setScore(student.getScore());
            stdnt.get().setAvatar(student.getAvatar());
            return studentRepository.save(stdnt.get());
        }
        else
            throw new StudentNotFound("Student with id" + student.getStudentNumber() + "not found!");
    }

    @Override
    public void deleteStudent(String studentId) throws StudentNotFound  {

        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            throw new StudentNotFound("Student with Id Not Found");
        }
        else
        studentRepository.deleteById(studentId);
    }


    @Override
    public Student viewStudent(String studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()){
            return student.get();
        }
        else
            throw new StudentNotFound("Student with " + studentId + " not found!");
    }


}

