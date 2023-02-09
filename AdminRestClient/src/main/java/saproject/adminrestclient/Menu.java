package saproject.adminrestclient;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static int mainMenu(){
        System.out.println("1. User management");
        System.out.println("2. School management");
        System.out.println("3. Element management");
        System.out.println("4. Reward Management");
        System.out.println("5. Exit\n");
        System.out.print("Input your choice: ");
        return scanner.nextInt();
    }

    public static int userMenu(){                           //1
        System.out.println("1. Teacher Management");
        System.out.println("2. Student Management");
        System.out.println("3. Main Menu\n");
        System.out.print("Input your choice: ");
        return scanner.nextInt();
    }
    public static int userSubMenu(){
        System.out.println("1. Add User");
        System.out.println("2. Delete User");
        System.out.println("3. Update User");
        System.out.println("4. Get User");
        System.out.println("5. Main Menu\n");
        System.out.print("Input your choice: ");
        return scanner.nextInt();
    }
    public static int schoolMenu(){
        System.out.println("1. Add School");
        System.out.println("2. Delete School");
        System.out.println("3. Update School");
        System.out.println("4. Get School");
        System.out.println("5. Main Menu\n");
        System.out.print("Input your choice: ");
        return scanner.nextInt();
    }
    public static int elementMenu(){
        System.out.println("1. Add Element");
        System.out.println("2. Delete Element");
        System.out.println("3. Update Element");
        System.out.println("4. Get Element");
        System.out.println("5. Main Menu\n");
        System.out.print("Input your choice: ");
        return scanner.nextInt();
    }
    public static int rewardMenu(){
        System.out.println("1. Add Reward");
        System.out.println("2. Delete Reward");
        System.out.println("3. Update  Reward");
        System.out.println("4. Get Reward");
        System.out.println("5. Main Menu\n");
        System.out.print("Input your choice: ");
        return scanner.nextInt();
    }
}
