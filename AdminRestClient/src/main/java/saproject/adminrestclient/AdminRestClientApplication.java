package saproject.adminrestclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

import static java.lang.Thread.sleep;

@SpringBootApplication
public class AdminRestClientApplication implements CommandLineRunner {

    @Autowired
    private AdminOperations AdminOperations;
    @Autowired
    private Login login;
    public static void main(String[] args) {
        SpringApplication.run(AdminRestClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String loginFailedChoice = null;
        String serverUrl = "http://localhost:8080"; // server goes here
        System.out.println("\n\n================================================");
        System.out.println("==========>  Welcome Please Login  <============");
        System.out.println("================================================");
        do{
            boolean token = login.login(serverUrl);
            if(!token){
                System.out.println("Login failed. Check your username and password");
                System.out.println("Do you want to try again? (y/n)");
                Scanner scanner = new Scanner(System.in);
                loginFailedChoice = scanner.nextLine();
            }
            else{
                System.out.println("Login successful");
                sleep(2000);
                String goingBackToMainMenu=null;
                do{
                    System.out.println("================================================");
                    System.out.println("======>  Welcome Admin Select Operation  <======");
                    System.out.println("================================================");
                    int choice = Menu.mainMenu();  // 1. user 2. school 3. element

                    switch (choice) {  //Main Menu
                        case 1 -> {    //user administration
                            switch (Menu.userMenu()) {
                                case 1 -> { //Teacher
                                    switch (Menu.userSubMenu()) {
                                        case 1 -> {
                                            System.out.println("Add Teacher");
                                            AdminOperations.addTeacher(serverUrl);

                                        }
                                        case 2 -> {
                                            System.out.println("Delete Teacher");
                                            AdminOperations.removeTeacher(serverUrl);
                                        }
                                        case 3 -> {
                                            System.out.println("Update Teacher");
                                            AdminOperations.updateTeacher(serverUrl);
                                        }
                                        case 4 -> {
                                            System.out.println("Get Teacher");
                                            AdminOperations.getTeacher(serverUrl);
                                        }
                                        case 5 -> {
                                            System.out.println("Press any key to go back to main menu");
                                            Scanner scanner = new Scanner(System.in);
                                            goingBackToMainMenu = scanner.nextLine();
                                        }
                                        default -> System.out.println("Invalid choice");
                                    }
                                }
                                case 2 -> { //Student
                                    switch (Menu.userSubMenu()) {
                                        case 1 -> {
                                            System.out.println("Add Student");
                                            AdminOperations.addStudent(serverUrl);
                                        }
                                        case 2 -> {
                                            System.out.println("Delete Student");
                                            AdminOperations.removeStudent(serverUrl);
                                        }
                                        case 3 -> {
                                            System.out.println("Update Student");
                                            AdminOperations.updateStudent(serverUrl);
                                        }
                                        case 4 -> {
                                            System.out.println("Get Student");
                                            AdminOperations.getStudent(serverUrl);
                                        }
                                        case 5 -> {
                                            System.out.println("Press any key to go back to main menu");
                                            Scanner scanner = new Scanner(System.in);
                                            goingBackToMainMenu = scanner.nextLine();
                                        }
                                        default -> System.out.println("Invalid choice");
                                    }
                                }
                                case 3 -> {
                                    System.out.println("Press any key to go back to main menu");
                                    Scanner scanner = new Scanner(System.in);
                                    goingBackToMainMenu = scanner.nextLine();
                                }
                                default -> System.out.println("Invalid choice");
                            }
                        }
                        case 2 -> {    //school administration
                            switch (Menu.schoolMenu()) {
                                case 1 -> AdminOperations.addSchool(serverUrl);
                                case 2 -> AdminOperations.removeSchool(serverUrl);
                                case 3 -> AdminOperations.updateSchool(serverUrl);
                                case 4 -> AdminOperations.getSchool(serverUrl);
                                case 5 -> {
                                    System.out.println("Press any key to go back to main menu");
                                    Scanner scanner = new Scanner(System.in);
                                    goingBackToMainMenu = scanner.nextLine();
                                }
                                default -> System.out.println("Invalid choice");
                            }
                        }
                        case 3 -> {    //element administration
                            switch (Menu.elementMenu()) {
                                case 1 -> AdminOperations.addElement(serverUrl);
                                case 2 -> AdminOperations.removeElement(serverUrl);
                                case 3 -> AdminOperations.updateElement(serverUrl);
                                case 4 -> AdminOperations.getElement(serverUrl);
                                case 5 -> {
                                    System.out.println("Press any key to go back to main menu");
                                    Scanner scanner = new Scanner(System.in);
                                    goingBackToMainMenu = scanner.nextLine();
                                }
                                default -> System.out.println("Invalid choice");
                            }
                        }
                        case 4 -> {     //reward administration
                            switch(Menu.rewardMenu()){
                                case 1 -> AdminOperations.addReward(serverUrl);
                                case 2 -> AdminOperations.removeReward(serverUrl);
                                case 3 -> AdminOperations.updateReward(serverUrl);
                                case 4 -> AdminOperations.getReward(serverUrl);
                                case 5 -> {
                                    System.out.println("Press any key to go back to main menu");
                                    Scanner scanner = new Scanner(System.in);
                                    goingBackToMainMenu = scanner.nextLine();
                                }
                                default -> System.out.println("Invalid choice");
                            }
                        }
                        case 5 -> System.exit(0);
                        default -> System.out.println("Invalid choice");
                    }
                }while(goingBackToMainMenu!=null);
            }
        }while(loginFailedChoice.equals("y"));

    }



}
