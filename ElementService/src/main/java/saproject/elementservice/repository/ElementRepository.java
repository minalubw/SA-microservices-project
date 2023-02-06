package saproject.elementservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import saproject.elementservice.domain.Element;

public interface ElementRepository extends MongoRepository<Element, String> {
}
