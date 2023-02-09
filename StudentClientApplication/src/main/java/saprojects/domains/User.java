package saprojects.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	
	@Id
	private String username;
	private String password;
	private Role role;
	
	public User() {}

	public void setRole(Role role) {
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public User(String username, String password, Role role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
enum Role {
	ADMIN("ADMIN"), STUDENT("STUDENT"), TEACHER("TEACHER");

	private String name;

	Role(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

