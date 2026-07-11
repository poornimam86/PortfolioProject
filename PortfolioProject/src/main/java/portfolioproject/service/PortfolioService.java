package portfolioproject.service;

import portfolioproject.model.Portfolio;

public class PortfolioService {

    // Display Portfolio Details
    public void displayPortfolio(Portfolio portfolio) {

        System.out.println("\n------ Portfolio Details ------");
        System.out.println("Portfolio ID   : " + portfolio.getPortfolioId());
        System.out.println("Portfolio Name : " + portfolio.getPortfolioName());
    }

    // Update Portfolio Name
    public void updatePortfolioName(Portfolio portfolio, String newName) {

        portfolio.setPortfolioName(newName);

        System.out.println("\nPortfolio name updated successfully!");
    }
}