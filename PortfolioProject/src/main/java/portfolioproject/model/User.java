package portfolioproject.model;

public class User {

    // Instance Variables (Fields)
    private int userId;
    private String fullName;
    private String email;
    private String phone;

    // Default Constructor
    public User() {
        System.out.println("User object created.");
    }

    // Parameterized Constructor
    public User(int userId, String fullName, String email, String phone) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;

        System.out.println("User object created successfully!");
    }

    // Getter for userId
    public int getUserId() {
        return userId;
    }

    // Setter for userId
    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter for fullName
    public String getFullName() {
        return fullName;
    }

    // Setter for fullName
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Setter for phone
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "User [userId=" + userId
                + ", fullName=" + fullName
                + ", email=" + email
                + ", phone=" + phone + "]";
    }
    public void displayUser() {
        System.out.println("User Name: " + fullName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }
    
}