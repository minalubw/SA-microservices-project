package saprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import saprojects.domains.ElementOrder;
import saprojects.domains.RedeemRewardOrder;
import saprojects.domains.RewardOrder;
import saprojects.domains.Student;

@SpringBootApplication
public class StudentClientApplication implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;


    public static void main(String[] args) {
        SpringApplication.run(StudentClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String serverUrl = "http://localhost:8080/order";
        String studentUrl = "http://localhost:8080/student";

        System.out.println("Student buying an element");

        ElementOrder elementOrder = new ElementOrder("3455","8765");
        restTemplate.put(serverUrl + "/element/buy", elementOrder);
        System.out.println(restTemplate.getForObject(studentUrl+ "/{studentNUmber}", Student.class, "3455"));


    /**************** Student cannot buy a reward type of the same! It will throw an exception!********/
//        System.out.println("Student buying a reward");
//        RewardOrder rewardOrder = new RewardOrder("3455", "7777");
//        restTemplate.put(serverUrl + "/reward/buy", rewardOrder);
//        System.out.println(restTemplate.getForObject(studentUrl+ "/{studentNUmber}", Student.class, "3455"))



        System.out.println("Student redeeming a reward");
        RedeemRewardOrder redeemRewardOrder = new RedeemRewardOrder("3455", "324", "7777");
        restTemplate.put(serverUrl + "/reward/redeem", redeemRewardOrder);
        System.out.println(restTemplate.getForObject(studentUrl+ "/{studentNUmber}", Student.class, "3455"));

        System.out.println("Student removing an element from his avatar.....");
        ElementOrder elementOrderRemove = new ElementOrder("3455","8765");
        restTemplate.put(serverUrl + "/element/remove", elementOrderRemove);
        System.out.println(restTemplate.getForObject(studentUrl+ "/{studentNUmber}", Student.class, "3455"));



    }
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
