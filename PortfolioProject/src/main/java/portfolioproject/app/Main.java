package portfolioproject.app;

import java.util.Scanner;

import portfolioproject.model.User;
import portfolioproject.service.UserService;

public class Main {

    public static void main(String[] args) {

        // Create Scanner object for keyboard input
        Scanner sc = new Scanner(System.in);

        // Read User ID
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline

        // Read Full Name
        System.out.print("Enter Full Name: ");
        String name = sc.nextLine();

        // Read Email
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        // Read Phone Number
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        // Create User object
        User user = new User();

        // Store the entered values into the User object
        user.setUserId(id);
        user.setFullName(name);
        user.setEmail(email);
        user.setPhone(phone);

        // Create UserService object
        UserService service = new UserService();

        // Display heading
        System.out.println();
        System.out.println("User object created.");
        System.out.println("================================");
        System.out.println(" Welcome to Portfolio Project");
        System.out.println("================================");

        // Display user details
        service.displayUser(user);
        System.out.println("\n----- Update User Details -----");

        System.out.print("Enter New Name: ");
        String newName = sc.nextLine();

        System.out.print("Enter New Email: ");
        String newEmail = sc.nextLine();

        System.out.print("Enter New Phone Number: ");
        String newPhone = sc.nextLine();

        // Update user details
        service.updateUser(user, newName, newEmail, newPhone);

        // Display updated details
        System.out.println("\n------ Updated User Details ------");
        service.displayUser(user);
        // Close Scanner
        sc.close();
    }
}