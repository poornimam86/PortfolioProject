package portfolioproject.singleton;

public class PortfolioManager {

    // Create only one object
    private static PortfolioManager instance = new PortfolioManager();

    // Private constructor
    private PortfolioManager() {

    }

    // Public method to access the object
    public static PortfolioManager getInstance() {
        return instance;
    }

    public void displayMessage() {
        System.out.println("Portfolio Manager Singleton Object Created.");
    }
}