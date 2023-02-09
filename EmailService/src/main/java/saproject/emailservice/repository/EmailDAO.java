package saproject.emailservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import saproject.emailservice.domain.Email;

@Repository
public interface EmailDAO extends MongoRepository<Email, Integer> {
}
