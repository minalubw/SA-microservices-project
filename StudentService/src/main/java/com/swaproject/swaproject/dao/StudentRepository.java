package com.swaproject.swaproject.dao;

import com.swaproject.swaproject.domains.Student;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

@Document
public interface StudentRepository extends MongoRepository<Student, String> {

}
