package saproject.adminrestclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import saproject.adminrestclient.DomainClasses.ElementDomain.Element;
import saproject.adminrestclient.DomainClasses.ElementDomain.ElementType;
import saproject.adminrestclient.DomainClasses.StudentDomain.Avatar;
import saproject.adminrestclient.DomainClasses.StudentDomain.Reward;
import saproject.adminrestclient.DomainClasses.StudentDomain.RewardType;
import saproject.adminrestclient.DomainClasses.StudentDomain.Student;
import saproject.adminrestclient.DomainClasses.teacher.*;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class AdminOperations {
    @Bean
     RestOperations restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        return new RestTemplate();
    }
    @Autowired
    private  RestOperations restTemplate;
    private static Scanner scanner = new Scanner(System.in);

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                    Teacher Operations
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public  void addTeacher(String serverUrl){  // return type teacher

        System.out.println("Teacher First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Teacher Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("===================================================");
        System.out.println("===============>  School Details  <================");
        System.out.println("===================================================\n");
        System.out.println("School Name:");
        String schoolName = scanner.nextLine();
        System.out.println("School Address:");
        String schoolAddress = scanner.nextLine();
        System.out.println("School Phone Number:");
        String schoolPhoneNumber = scanner.nextLine();
        System.out.println("School Email:");
        String schoolEmail = scanner.nextLine();

        System.out.println("===================================================");
        System.out.println("===============>  Class Details  <=================");
        System.out.println("===================================================\n");
        System.out.println("Class group:");
        String classGroup = scanner.nextLine();
        System.out.println("Class year:");
        String classYear = scanner.nextLine();

        System.out.println("===================================================");
        System.out.println("===============>  Contact Details  <===============");
        System.out.println("===================================================\n");
        System.out.println("Teacher email:");
        String teacherEmail = scanner.nextLine();
        System.out.println("Teacher phone number:");
        String teacherPhoneNumber = scanner.nextLine();

        System.out.println("===================================================");
        System.out.println("===============>  User Account  <==================");
        System.out.println("===================================================\n");
        System.out.println("Username:");
        String username = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        Contact schoolContact = new Contact(schoolEmail, schoolPhoneNumber);
        int id = restTemplate.getForObject(serverUrl+"/teacher/getAll",Integer.class);
        int randomId = (int) (Math.random() * 1000);
        School school = new School(randomId,schoolName, schoolAddress,schoolContact);
        TeachingClass teachingClass = new TeachingClass(classGroup, classYear);
        Contact teacherContact = new Contact(teacherEmail, teacherPhoneNumber);
        User user = new User(username, password,  Role.TEACHER);
        randomId = (int) (Math.random() * 1000);// need to check if the user exists in the database
        Teacher teacher = new Teacher(randomId,firstName, lastName, school,teachingClass,teacherContact,user);
        try{
            ResponseEntity<Teacher> resonseEntity = restTemplate.postForEntity(serverUrl+"/teacher/add",teacher,Teacher.class);
            System.out.println("Teacher with id: "+resonseEntity.getBody().getId()+" added successfully");
        }catch (Exception e){
            System.out.println("Teacher with id: "+teacher.getId()+" already exists");
        }


    }
    public  void removeTeacher(String serverUrl){ // return type teacher
        System.out.print("Teacher ID:");
        int id = scanner.nextInt();
        try {
            ResponseEntity<Teacher> responseEntity = restTemplate.getForEntity(serverUrl+"/teacher/get/"+id,Teacher.class);
            restTemplate.delete(serverUrl+"/teacher/delete/"+id);
            System.out.println("Teacher with id: "+responseEntity.getBody().getId()+" deleted successfully");
        }catch (Exception e){
            System.out.println("Teacher with id: "+id+" does not exist");
        }
    }
    public  void updateTeacher(String serverUrl){ // return type teacher // need response entity
        System.out.print("Teacher ID:");
        int id = scanner.nextInt();
        try{
            ResponseEntity<Teacher> responseEntity = restTemplate.getForEntity(serverUrl+"/teacher/get/"+id,Teacher.class);
            System.out.println("Updated Teacher First Name:");
            String firstName = scanner.next();
            Teacher teach =responseEntity.getBody();
            teach.setFirstName(firstName);
            restTemplate.put(serverUrl+"/teacher/update",teach);
            System.out.println("Updated Teacher First Name successfully");
        }catch (Exception e){
            System.out.println("Teacher with id: "+id+" does not exist");
        }

    }
    public  void getTeacher(String serverUrl){ // return type teacher   // need response entity
        System.out.print("Teacher ID:");
        int id = scanner.nextInt();
        try{
            ResponseEntity<Teacher> responseEntity = restTemplate.getForEntity(serverUrl+"/teacher/get/"+id,Teacher.class);
            Teacher teach =responseEntity.getBody();
            System.out.println(teach);
        }catch (Exception e){
            System.out.println("Teacher with id: "+id+" does not exist");
        }
    }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                    Element Operations
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public   void addElement(String serverUrl){  // return type element
        Element element = new Element("1", ElementType.EYE,10);
        ResponseEntity<Element> responseEntity = restTemplate.postForEntity(serverUrl+"/element/add",element,Element.class); // instead of Object, use element
        System.out.println("element with id: "+element.getElementId()+" added successfully");
    } //checked
    public  void removeElement(String serverUrl) { // return type element
        System.out.println("Enter element id to remove");
        String id = scanner.nextLine();
        try {
            ResponseEntity<Element> responseEntity = restTemplate.getForEntity(serverUrl + "/element/" + id, Element.class);
            restTemplate.delete(serverUrl + "/element/delete/" + id);
            System.out.println("element with id: " + responseEntity.getBody().getElementId() + " deleted successfully");
        } catch (Exception e) {
            System.out.println("element with id: " + id + " does not exist");
        } //checked
    }
    public  void updateElement(String serverUrl) { // return type element
        System.out.println("Enter element id to update");
        String id = scanner.nextLine();

        try {
            ResponseEntity<Element> responseEntity = restTemplate.getForEntity(serverUrl + "/element/" + id, Element.class);
            Element element = responseEntity.getBody();
            System.out.println("Enter new element price");
            int price = scanner.nextInt();
            element.setPrice(price);
            restTemplate.put(serverUrl + "/element/update/" + id, element); // instead of Object, use element
        } catch (Exception e) {
            System.out.println("element with id: " + id + " does not exist");


        } //checked
    }
    public  void getElement(String serverUrl){ // return type element
        System.out.println("Enter element id to get ");
        String id = scanner.nextLine();

        try {
            ResponseEntity<Element> responseEntity = restTemplate.getForEntity(serverUrl + "/element/" + id, Element.class);
            Element element = responseEntity.getBody();
            System.out.println(element);
        } catch (Exception e) {
            System.out.println("element with id: " + id + " does not exist");
        }
    }  //checked

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                    School Operations
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public  void addSchool(String serverUrl){  // return type school
        saproject.adminrestclient.DomainClasses.SchoolPackage.Contact schoolContact = new saproject.adminrestclient.DomainClasses.SchoolPackage.Contact("cs@miu.edu", "123456789");
        saproject.adminrestclient.DomainClasses.SchoolPackage.School school = new saproject.adminrestclient.DomainClasses.SchoolPackage.School(123,"MIU", "1000N 4th St. Fairfield Iowa",schoolContact);
        restTemplate.postForLocation(serverUrl+"/school/add",school); // instead of Object, use school
    }
    public  void removeSchool(String serverUrl){ // return type school
        System.out.println("Enter school id to remove");
        int id = scanner.nextInt();
        try{
            ResponseEntity<School> responseEntity = restTemplate.getForEntity(serverUrl+"/school/get/"+id,School.class);
            restTemplate.delete(serverUrl+"/school/delete/"+id);
        }catch (Exception e){
            System.out.println("School with id: "+id+" does not exist");
        }
    }
    public  void updateSchool(String serverUrl) { // return type school
        System.out.println("Enter school id to update");
        int id = scanner.nextInt();

        try {
            ResponseEntity<School> responseEntity = restTemplate.getForEntity(serverUrl + "/school/get/" + id, School.class);
            School school = restTemplate.getForObject(serverUrl + "/school/get/" + id, School.class);
            System.out.println("Enter new school name");
            String name = scanner.next();
            school.setName(name);
            restTemplate.put(serverUrl + "/school/update", school);
        } catch (Exception e) {
            System.out.println("School with id: " + id + " does not exist");

            // instead of Object, use school
        }
    }
    public  void getSchool(String serverUrl){ // return type school
        System.out.println("Enter school id to get ");
        int id = scanner.nextInt();
        try {
            ResponseEntity<School> responseEntity = restTemplate.getForEntity(serverUrl + "/school/get/" + id, School.class);
            School school = responseEntity.getBody();
            System.out.println(school);
        } catch (Exception e) {
            System.out.println("School with id: " + id + " does not exist");
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                    Student Operations
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public  void addStudent(String serverUrl){  // return type school
        saproject.adminrestclient.DomainClasses.StudentDomain.School school =
                new saproject.adminrestclient.DomainClasses.StudentDomain.School(191,"MIU",
                        "1000N 4th St. Fairfield Iowa",
                        new saproject.adminrestclient.DomainClasses.StudentDomain.Contact("cs.miuiowa.edu",
                                "123456789"));
        saproject.adminrestclient.DomainClasses.StudentDomain.TeachingClass tc = new saproject.adminrestclient.DomainClasses.StudentDomain.TeachingClass("A","2020");
        Student student = new Student("999","John","Doe",1000,new Avatar(),new ArrayList<>(),school,tc);
        restTemplate.postForLocation(serverUrl+"/student/add",student); // instead of Object, use school
        System.out.println("Student with id: "+student.getStudentNumber()+" added successfully");
    } // checked
    public  void removeStudent(String serverUrl){ // return type school

        try{
            System.out.print("Enter student id to remove: ");
            int id = scanner.nextInt();
            ResponseEntity<Student> responseEntity = restTemplate.getForEntity(serverUrl+"/student/"+id,Student.class);
            restTemplate.delete(serverUrl+"/student/delete/"+id);
        }catch (Exception e){
            System.out.println("Student does not exist in record");
        }
    } //checked
    public  void updateStudent(String serverUrl){ // return type school
        System.out.println("Enter student id to update");
        int id = scanner.nextInt();
        try{
            ResponseEntity<Student> responseEntity = restTemplate.getForEntity(serverUrl+"/student/"+id,Student.class);
            Student student = responseEntity.getBody();
            System.out.println("Whats the new score? ");
            int score = scanner.nextInt();
            student.setScore(score);
            restTemplate.put(serverUrl+"/student/update",student);
        }
        catch (Exception e){
            System.out.println("Student with id: "+id+" does not exist");
        }
    }
    public  void getStudent(String serverUrl){ // return type school
        System.out.print("Enter student id to get ");
        int id = scanner.nextInt();
        try{
            ResponseEntity<Student> responseEntity = restTemplate.getForEntity(serverUrl+"/student/"+id,Student.class);
            Student student = responseEntity.getBody();
            System.out.println(student);
        }
        catch (Exception e){
            System.out.println("Student with id: "+id+" does not exist");
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                    Reward Operations
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addReward(String serverUrl){  // return type reward
        Reward reward = new Reward("1","Amazing Reward",10, RewardType.ELEMENT,140);
        restTemplate.postForLocation(serverUrl+"/reward/add",reward); // instead of Object, use reward
    }    //checked
    public  void removeReward(String serverUrl){ // return type reward
        System.out.println("Enter reward id to remove");
        String id = scanner.next();
        try{
            ResponseEntity<Reward> responseEntity = restTemplate.getForEntity(serverUrl+"/reward/"+id,Reward.class);
            restTemplate.delete(serverUrl+"/reward/delete/"+id); // instead of Object, use reward
        }catch (Exception e){
            System.out.println("Reward with id: "+id+" does not exist");
        }

    } //checked
    public  void updateReward(String serverUrl){ // return type reward
        System.out.println("Enter reward id to update");
        String id = scanner.nextLine();
        try {
            ResponseEntity<Reward> responseEntity = restTemplate.getForEntity(serverUrl + "/reward/" + id, Reward.class);
            Reward reward = responseEntity.getBody();
            System.out.println("Enter new reward price");
            int price = scanner.nextInt();
            reward.setPrice(price);
            restTemplate.put(serverUrl+"/reward/update/"+id,reward); // instead of Object, use reward
        }
        catch (Exception e){
            System.out.println("Reward with id: "+id+" does not exist");
        }

    }  // need to be checked after pull
    public  void getReward(String serverUrl){ // return type reward
        System.out.println("Enter reward id to get ");
        String id = scanner.nextLine();
        try{
            ResponseEntity<Reward> responseEntity = restTemplate.getForEntity(serverUrl+"/reward/"+id,Reward.class);
            Reward reward = responseEntity.getBody();
            System.out.println(reward);
        }
          catch (Exception e){
                System.out.println("Reward with id: "+id+" does not exist");
          }
    }  // checked
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
