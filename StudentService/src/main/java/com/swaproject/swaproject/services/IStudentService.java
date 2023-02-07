package com.swaproject.swaproject.services;


import com.swaproject.swaproject.domains.Student;

public interface IStudentService {

    Student addStudent(Student student);

    Student updateStudent(Student student);


    void deleteStudent(String studentId);


    Student viewStudent(String studentId);


}
