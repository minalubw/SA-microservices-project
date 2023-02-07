package user.userService;

import user.userDomain.User;

public interface IUserService {
	User addUser(User user);
	void removeUser(String username);
	User updateUser(String username, User user);
	User viewUser(String username);

}
