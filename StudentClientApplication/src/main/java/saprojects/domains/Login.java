package saprojects.domains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.util.Scanner;

@Component
public class Login {

    @Autowired
    private  RestOperations restTemplate;

    public boolean login(String serverUrl) {
        System.out.print("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        try {
            ResponseEntity<User> user = restTemplate.getForEntity(serverUrl + "/user/{username}", User.class, username);
            if (user.getBody() == null) {
                return false;
            } else {
                if (user.getBody().getPassword().equalsIgnoreCase(password)) {
                    if (user.getBody().getRole() == Role.STUDENT) {
                        return true;
                    } else {
                        System.out.println("Unauthorized user");
                        return false;
                    }
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
    }

    }



