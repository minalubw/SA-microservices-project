package teacherclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import teacherclient.domains.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

@SpringBootApplication
public class TeacherClientApplication implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private Login login;

	public static void main(String[] args) {
		SpringApplication.run(TeacherClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://localhost:8080/student";
		String studentUrl = "http://localhost:8080/student";
		String rewardUrl = "http://localhost:8080/reward";

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
				System.out.println("Login successful");
				sleep(1000);
				String goingBackToMainMenu=null;

				System.out.println("======> TEACHER ADMINISTERING STUDENT <=======");

				System.out.println("\n--------Teacher adding a student-------");
				Avatar avatar = new Avatar();
				School school = new School(9, "MIU", "Fairfield", new Contact("email@gmail.com", "789"));
				List<Reward> rewardList = new ArrayList<>();
				TeachingClass teachingClass = new TeachingClass("August", "2022");
				User user = new User("uname2", "pass2", Role.STUDENT);
				Student student = new Student("4554", "Raytu", "Bitew", 1000, avatar, rewardList, school, teachingClass, user);
				restTemplate.postForLocation(serverUrl + "/add", student);
				System.out.println(restTemplate.getForObject(studentUrl+ "/{studentNUmber}", Student.class, "4554"));


				System.out.println("\n\n--------Teacher adding a student-------");
				Avatar avatar1 = new Avatar();
				School school1 = new School(69, "MIT", "Boston", new Contact("345667", "mitguy@gmail.com"));
				List<Reward> rewards = new ArrayList<>();
				TeachingClass teachingClass1 = new TeachingClass("August", "2022");
				User user1 = new User("uname2", "pass2", Role.STUDENT);
				Student student1 = new Student("73562", "Gabriel", "Batistuta", 1000, avatar1, rewards, school1, teachingClass1, user1);
				restTemplate.postForLocation(serverUrl + "/add", student1);
				System.out.println(restTemplate.getForObject(studentUrl+ "/{studentNUmber}", Student.class, "73562"));


				System.out.println("\n\n---------Teacher updating a student-----------");
				student.setLastName("Michael");
				try {
					restTemplate.put(serverUrl + "/update", student);
					System.out.println(restTemplate.getForObject(studentUrl+ "/{studentNUmber}", Student.class, "4554"));
				}catch (Exception e){
					System.out.println(e.getMessage());
				}


				System.out.println("\n\n---------Teacher rewarding a student----------");
				RewardOrder rewardOrder = new RewardOrder("4554", "3567");
				restTemplate.put("http://localhost:8080/order/teacher/givereward", rewardOrder);
				System.out.println(restTemplate.getForObject(studentUrl+ "/{studentNUmber}", Student.class, "4554"));

				System.out.println("\n\n---------Teacher deleting student----------");
				try {
					restTemplate.delete(studentUrl + "/delete/{id}", "73562");
					System.out.println("Student with studentNumber 73562 delted" );
				}catch (Exception e){
					System.out.println(e.getMessage());
				}

				System.out.println("\n\n======> TEACHER ADMINISTERING REWARD <=======");

				System.out.println("\n\n-------Teacher creating reward------");
				Reward reward = new Reward("4545", "Participation Reward", 5, RewardType.INSCHOOL, 45);
				try {
					restTemplate.postForLocation(rewardUrl+"/add", reward);
					System.out.println(restTemplate.getForObject(rewardUrl+"/{rewardId}", Reward.class, "4545"));
				}catch (Exception e){
					System.out.println(e.getMessage());
				}

				System.out.println("\n\n-----Teacher updating reward------");
				reward.setName("Prize");
				reward.setType(RewardType.GIFT);
				try {
					restTemplate.put(rewardUrl+"/update/{rewardId}", reward,"4545");
					System.out.println(restTemplate.getForObject(rewardUrl+"/{rewardId}", Reward.class, "4545"));
				}catch(Exception e){
					System.out.println(e.getMessage());
				}

				System.out.println("\n\n----- Teacher deleting reward ------");
				try {
					restTemplate.delete(rewardUrl + "/delete/{rewardId}", "4545");
					System.out.println("Reward deleted!");
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







