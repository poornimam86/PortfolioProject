package portfolioproject.service;

import portfolioproject.model.User;

public class UserService {

    public void displayUser(User user) {

        System.out.println("------ User Details ------");
        System.out.println("User ID   : " + user.getUserId());
        System.out.println("Name      : " + user.getFullName());
        System.out.println("Email     : " + user.getEmail());
        System.out.println("Phone     : " + user.getPhone());
    }

    public void updateUser(User user, String name, String email, String phone) {

        user.setFullName(name);
        user.setEmail(email);
        user.setPhone(phone);

        System.out.println("User details updated successfully!");
    }
}