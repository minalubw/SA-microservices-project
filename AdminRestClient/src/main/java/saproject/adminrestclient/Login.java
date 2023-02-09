package saproject.adminrestclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import saproject.adminrestclient.DomainClasses.teacher.User;

import java.util.Scanner;

@Component
public class Login {

    @Autowired
    private  RestOperations restTemplate;

    public boolean login(String serverUrl){
        System.out.print("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        try{
            ResponseEntity<User> user = restTemplate.getForEntity(serverUrl + "/user/"+username, User.class);
            if(user.getBody()==null){
                return false;
            }
            else{
                if(user.getBody().getPassword().equals(password)){
                    return true;
                }
                else{
                    return false;
                }
            }
        }catch (Exception e) {
            return false;
        }



    }

}
