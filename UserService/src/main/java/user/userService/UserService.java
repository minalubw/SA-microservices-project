package user.userService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.userDomain.User;
import user.userException.UserNotFoundException;
import user.userRepositories.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public void removeUser(String username) {
		
		Optional<User> user = userRepository.findById(username);

		if(user.isPresent()) {
			userRepository.delete(user.get());
		}
		else
			throw new UserNotFoundException("User not found!");
	} 
	
	 @Override
	 public User updateUser(String username, User user) {
		 Optional<User> userinRepo = userRepository.findById(username);
		 if(userinRepo.isPresent()) {
			 userinRepo.get().setPassword(user.getPassword());
			 userinRepo.get().setRole(user.getRole());
			 return userRepository.save(userinRepo.get());
		 }
		 else
			 throw new UserNotFoundException("User" + username + "not found!");
		 
	 }
	
	 @Override
	 public User viewUser(String username) {
		 
		 Optional<User> user = userRepository.findById(username);
		 if(user.isPresent()) {
			 return user.get();
		 }
		 else
			 throw new UserNotFoundException("User" + username + " not found!");
	 }

	
}
