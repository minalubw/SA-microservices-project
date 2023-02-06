package saproject.teacherservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import saproject.teacherservice.domain.Teacher;

@Repository
public interface TeacherDAO extends MongoRepository<Teacher, Integer> {
}
