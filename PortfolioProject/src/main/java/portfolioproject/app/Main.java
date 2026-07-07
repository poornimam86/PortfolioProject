package portfolioproject.app;

import portfolioproject.model.User;

public class Main {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to PortfolioProject ");
        System.out.println("=================================");

        // Create a User object
        User user = new User(
                101,
                "Poornima",
                "poornima@gmail.com",
                "9876543210");
        
        // Display User Details
        System.out.println("\n----- User Details -----");
        System.out.println("User ID    : " + user.getUserId());
        System.out.println("Full Name  : " + user.getFullName());
        System.out.println("Email      : " + user.getEmail());
        System.out.println("Phone      : " + user.getPhone());

        // Update User Details
        user.setFullName("M. M. Poornima");
        user.setEmail("mmpoornima@gmail.com");

        // Display Updated Details
        System.out.println("\n----- Updated User Details -----");
        System.out.println("User ID    : " + user.getUserId());
        System.out.println("Full Name  : " + user.getFullName());
        System.out.println("Email      : " + user.getEmail());
        System.out.println("Phone      : " + user.getPhone());
        System.out.println("\n----- Using toString() -----");
        System.out.println(user);

        System.out.println("\n----- Calling toString() Explicitly -----");
        System.out.println(user.toString());
    }
}