package saproject.avatar.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import saproject.avatar.Domain.Avatar;

@Repository
public interface AvatarDAO extends MongoRepository<Avatar, Integer> {
}
