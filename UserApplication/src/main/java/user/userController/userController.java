package user.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import user.userDomain.Role;
import user.userDomain.User;
import user.userService.UserService;

@RestController
public class userController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{username}")
	public void deleteUser(@PathVariable String username) {
		userService.removeUser(username);
	}
	
	@PutMapping("/user/{username}")
	public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(username, user), HttpStatus.OK);
	}
	
	@GetMapping("/user/{username}")
	public ResponseEntity<User> viewUser(@PathVariable("username") String username) {
		return new ResponseEntity<User>(userService.viewUser(username), HttpStatus.OK);
	}


}
