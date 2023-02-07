package swaproject.schoolservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import swaproject.schoolservice.domains.School;

public interface SchoolRepository extends MongoRepository<School, String> {


}
