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

@SpringBootApplication
public class TeacherClientApplication implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(TeacherClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://localhost:8080/student";
		String studentUrl = "http://localhost:8080/student";


		System.out.println("--------Teacher adding a student-------");
		Avatar avatar = new Avatar();
		School school = new School(9, "MIU", "Fairfield", new Contact("email@gmail.com", "789"));
		List<Reward> rewardList = new ArrayList<>();
		TeachingClass teachingClass = new TeachingClass("August", "2022");
		User user = new User("uname2", "pass2", Role.STUDENT);
		Student student = new Student("4554", "Raytu", "Bitew", 1000, avatar, rewardList, school, teachingClass, user);
		restTemplate.postForLocation(serverUrl + "/add", student);
		System.out.println(restTemplate.getForObject(studentUrl+ "/{studentNUmber}", Student.class, "4554"));


		System.out.println("---------Teacher updating a student-----------");
		student.setLastName("Michael");
		restTemplate.put(serverUrl + "/update", student);
		System.out.println(restTemplate.getForObject(studentUrl+ "/{studentNUmber}", Student.class, "4554"));


		System.out.println("---------Teacher rewarding a student----------");
		RewardOrder rewardOrder = new RewardOrder("4554", "2354");
		restTemplate.put("http://localhost:8080/order/teacher/givereward", rewardOrder);
		System.out.println(restTemplate.getForObject(studentUrl+ "/{studentNUmber}", Student.class, "4554"));

		System.out.println("---------Teacher deleting student----------");
		restTemplate.delete(studentUrl + "/delete/{id}", "3455");





	}
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
