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
        String loginFailedChoice = "y";
        String serverUrl = "http://localhost:8080"; // server goes here
        System.out.println("\n\n================================================");
        System.out.println("========>  Welcome Back Please Login  <==========");
        System.out.println("================================================");
        do{
            boolean token = login.login(serverUrl);
            if(!token){
                System.out.println("Login failed. Check your username and password");
                System.out.println("Do you want to try again? (y/n)");
                Scanner scanner = new Scanner(System.in);
                loginFailedChoice = scanner.next();
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
                                            goingBackToMainMenu=backToMainMenu();
                                        }
                                        case 2 -> {
                                            System.out.println("Delete Teacher");
                                            AdminOperations.removeTeacher(serverUrl);
                                            goingBackToMainMenu=backToMainMenu();
                                        }
                                        case 3 -> {
                                            System.out.println("Update Teacher");
                                            AdminOperations.updateTeacher(serverUrl);
                                            goingBackToMainMenu=backToMainMenu();
                                        }
                                        case 4 -> {
                                            System.out.println("Get Teacher");
                                            AdminOperations.getTeacher(serverUrl);
                                            goingBackToMainMenu=backToMainMenu();
                                        }
                                        case 5 -> goingBackToMainMenu=backToMainMenu();
                                        default -> {
                                            System.out.println("Invalid choice");
                                            goingBackToMainMenu=backToMainMenu();
                                        }
                                    }
                                }
                                case 2 -> { //Student
                                    switch (Menu.userSubMenu()) {
                                        case 1 -> {
                                            System.out.println("Add Student");
                                            AdminOperations.addStudent(serverUrl);
                                            goingBackToMainMenu=backToMainMenu();
                                        }
                                        case 2 -> {
                                            System.out.println("Delete Student");
                                            AdminOperations.removeStudent(serverUrl);
                                            goingBackToMainMenu=backToMainMenu();
                                        }
                                        case 3 -> {
                                            System.out.println("Update Student");
                                            AdminOperations.updateStudent(serverUrl);
                                            goingBackToMainMenu=backToMainMenu();
                                        }
                                        case 4 -> {
                                            System.out.println("Get Student");
                                            AdminOperations.getStudent(serverUrl);
                                            goingBackToMainMenu=backToMainMenu();
                                        }
                                        case 5 -> goingBackToMainMenu=backToMainMenu();
                                        default -> {
                                            System.out.println("Invalid choice");
                                            goingBackToMainMenu=backToMainMenu();
                                        }
                                    }
                                }
                                case 3 -> goingBackToMainMenu=backToMainMenu();
                                default -> {
                                    System.out.println("Invalid choice");
                                    goingBackToMainMenu=backToMainMenu();
                                }
                            }
                        }
                        case 2 -> {    //school administration
                            switch (Menu.schoolMenu()) {
                                case 1 -> {
                                    AdminOperations.addSchool(serverUrl);
                                    goingBackToMainMenu=backToMainMenu();
                                }
                                case 2 -> {
                                    AdminOperations.removeSchool(serverUrl);
                                    goingBackToMainMenu=backToMainMenu();
                                }
                                case 3 -> {
                                    AdminOperations.updateSchool(serverUrl);
                                    goingBackToMainMenu=backToMainMenu();
                                }
                                case 4 -> {
                                    AdminOperations.getSchool(serverUrl);
                                    goingBackToMainMenu=backToMainMenu();
                                }
                                case 5 -> goingBackToMainMenu=backToMainMenu();
                                default -> {
                                    System.out.println("Invalid choice");
                                    goingBackToMainMenu=backToMainMenu();
                                }
                            }
                        }
                        case 3 -> {    //element administration
                            switch (Menu.elementMenu()) {
                                case 1 -> {
                                    AdminOperations.addElement(serverUrl);
                                    goingBackToMainMenu=backToMainMenu();
                                }
                                case 2 -> {
                                    AdminOperations.removeElement(serverUrl);
                                    goingBackToMainMenu=backToMainMenu();
                                }
                                case 3 -> {
                                    AdminOperations.updateElement(serverUrl);
                                    goingBackToMainMenu=backToMainMenu();
                                }
                                case 4 -> {
                                    AdminOperations.getElement(serverUrl);
                                    goingBackToMainMenu=backToMainMenu();
                                }
                                case 5 -> {
                                    goingBackToMainMenu=backToMainMenu();
                                }

                                default -> {
                                    System.out.println("Invalid choice");
                                    goingBackToMainMenu=backToMainMenu();
                                }
                            }
                        }
                        case 4 -> {     //reward administration
                            switch(Menu.rewardMenu()){
                                case 1 -> {
                                    AdminOperations.addReward(serverUrl);
                                    goingBackToMainMenu=backToMainMenu();
                                }
                                case 2 -> {
                                    AdminOperations.removeReward(serverUrl);
                                    goingBackToMainMenu=backToMainMenu();
                                }
                                case 3 -> {
                                    AdminOperations.updateReward(serverUrl);
                                    goingBackToMainMenu=backToMainMenu();
                                }
                                case 4 -> {
                                    AdminOperations.getReward(serverUrl);
                                    goingBackToMainMenu=backToMainMenu();
                                }
                                case 5 -> {
                                    goingBackToMainMenu=backToMainMenu();
                                }
                                default -> {
                                    System.out.println("Invalid choice");
                                    goingBackToMainMenu=backToMainMenu();
                                }
                            }
                        }
                        case 5 -> System.exit(0);
                        default -> {
                            System.out.println("Invalid choice");
                            goingBackToMainMenu=backToMainMenu();
                        }
                    }
                }while(goingBackToMainMenu!=null);
            }
        }while(loginFailedChoice.equals("y"));
        System.exit(0);
    }

public String backToMainMenu() {
        System.out.println("Press any key to go back to main menu");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

}
}
