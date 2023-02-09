package saprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import saprojects.domains.*;

import java.util.Scanner;

import static java.lang.Thread.sleep;

@SpringBootApplication
public class StudentClientApplication implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Login login;


    public static void main(String[] args) {
        SpringApplication.run(StudentClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String serverUrl = "http://localhost:8080/order";
        String studentUrl = "http://localhost:8080/student";
        String loginFailedChoice = null;
        System.out.println("\n\n================================================");
        System.out.println("==========>  Welcome Please Login  <============");
        System.out.println("================================================");

        do{
            boolean token = login.login("http://localhost:8080");
            if(!token){
                System.out.println("Login failed. Check your username and password");
                System.out.println("Do you want to try again? (y/n)");
                Scanner scanner = new Scanner(System.in);
                loginFailedChoice = scanner.nextLine();
            }
            else{
                System.out.println("--------------Login successful----------------");
                sleep(1000);
                String goingBackToMainMenu=null;

                System.out.println("------------Student buying an element------------");
                ElementOrder elementOrder = new ElementOrder("4554","8765");

                try {
                    restTemplate.put(serverUrl + "/element/buy", elementOrder);
                    System.out.println(restTemplate.getForObject(studentUrl+ "/{studentNUmber}", Student.class, "4554"));
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

                System.out.println("--------------Student buying a reward---------------");
                RewardOrder rewardOrder = new RewardOrder("4554", "7777");
                try {
                    restTemplate.put(serverUrl + "/reward/buy", rewardOrder);
                    System.out.println(restTemplate.getForObject(studentUrl+ "/{studentNUmber}", Student.class, "4554"));
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }


                System.out.println("----------------Student redeeming a reward----------------");
                RedeemRewardOrder redeemRewardOrder = new RedeemRewardOrder("4554", "324", "7777");
                try{
                    restTemplate.put(serverUrl + "/reward/redeem", redeemRewardOrder);
                    System.out.println(restTemplate.getForObject(studentUrl+ "/{studentNUmber}", Student.class, "4554"));
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

                System.out.println("-----Student removing an element from his avatar.....");
                ElementOrder elementOrderRemove = new ElementOrder("4554","8765");
                try {
                    restTemplate.put(serverUrl + "/element/remove", elementOrderRemove);
                    System.out.println(restTemplate.getForObject(studentUrl+ "/{studentNUmber}", Student.class, "4554"));
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                System.exit(1);
            }
        }while(loginFailedChoice.equals("y"));
    }
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
