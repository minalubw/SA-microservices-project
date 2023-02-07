package user.userRepositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import user.userDomain.User;

public interface UserRepository extends MongoRepository<User, String>{
	
}
