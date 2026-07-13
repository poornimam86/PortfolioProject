package portfolioproject.app;

import java.util.Scanner;

import portfolioproject.model.Portfolio;
import portfolioproject.model.Stock;
import portfolioproject.model.User;

import portfolioproject.service.PortfolioService;
import portfolioproject.service.StockService;
import portfolioproject.service.UserService;

public class Main {

    public static void main(String[] args) {

    	PortfolioService portfolioService = new PortfolioService();
        Scanner sc = new Scanner(System.in);
        Portfolio portfolio = new Portfolio();
        UserService userService = new UserService();
        StockService stockService = new StockService();
        
        int choice;

        do {

            System.out.println("\n========================================");
            System.out.println("     STOCK PORTFOLIO MANAGEMENT");
            System.out.println("========================================");
            System.out.println("1. User Module");
            System.out.println("2. Stock Module");
            System.out.println("3. Portfolio Module");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {

            case 1:

                // ==========================
                // User Module
                // ==========================

                System.out.print("Enter User ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Full Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Phone Number: ");
                String phone = sc.nextLine();

                User user = new User();

                user.setUserId(id);
                user.setFullName(name);
                user.setEmail(email);
                user.setPhone(phone);

                System.out.println("\nUser object created successfully.");

                userService.displayUser(user);

                System.out.print("\nDo you want to update user details? (Y/N): ");
                String updateChoice = sc.nextLine();

                if (updateChoice.equalsIgnoreCase("Y")) {

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter New Phone Number: ");
                    String newPhone = sc.nextLine();

                    userService.updateUser(user, newName, newEmail, newPhone);

                    System.out.println("\nUpdated User Details");

                    userService.displayUser(user);
                }

                break;

            case 2:

                int stockChoice;

                do {

                    System.out.println("\n=================================");
                    System.out.println("        STOCK MODULE");
                    System.out.println("=================================");
                    System.out.println("1. Add Stock");
                    System.out.println("2. View Stocks");
                    System.out.println("3. Sell Stock");
                    System.out.println("4. Search Stock");
                    System.out.println("5. Update Stock");
                    System.out.println("6. Delete Stock");
                    System.out.println("7. Sort by Asset Name");
                    System.out.println("8. Sort by Market Price");
                    System.out.println("9. Sort by Quantity");
                    System.out.println("10. Sort by Purchase Price");
                    System.out.println("11. Back to Main Menu");

                    System.out.print("Enter your choice: ");
                    stockChoice = sc.nextInt();
                    sc.nextLine();

                    switch(stockChoice) {

                    case 1:

                        Stock stock = new Stock();

                        System.out.print("Enter Asset ID: ");
                        stock.setAssetId(sc.nextInt());
                        sc.nextLine();

                        System.out.print("Enter Asset Name: ");
                        stock.setAssetName(sc.nextLine());

                        System.out.print("Enter Purchase Price: ");
                        stock.setPurchasePrice(sc.nextDouble());

                        System.out.print("Enter Quantity: ");
                        stock.setQuantity(sc.nextInt());
                        sc.nextLine();

                        System.out.print("Enter Company Name: ");
                        stock.setCompanyName(sc.nextLine());

                        System.out.print("Enter Market Price: ");
                        stock.setMarketPrice(sc.nextDouble());
                        sc.nextLine();

                        stockService.addStock(stock);
                        portfolio.addStock(stock);

                       // System.out.println("\nStock added successfully!");

                        break;
                       

                    case 2:

                        // Display Stocks
                    	stockService.displayStocks();
                    	break;
                       

                    case 3:

                        // Sell Stock
                    	System.out.print("Enter Asset Name : ");
                    	String assetName = sc.nextLine();

                    	System.out.print("Enter Quantity to Sell : ");
                    	int sellQty = sc.nextInt();
                    	sc.nextLine();

                    	stockService.sellStock(assetName, sellQty);

                    	break;
                        

                    case 4:

                        // Search Stock
                    	System.out.print("Enter Asset ID to Search: ");
                        int searchId = sc.nextInt();
                        sc.nextLine();

                        stockService.searchStock(searchId);
                        break;

                    case 5:

                        // Update Stock
                   

                        System.out.print("Enter Asset ID : ");
                        int updateId = sc.nextInt();

                        System.out.print("Enter New Purchase Price : ");
                        double newPurchase = sc.nextDouble();

                        System.out.print("Enter New Quantity : ");
                        int newQty = sc.nextInt();

                        System.out.print("Enter New Market Price : ");
                        double newMarket = sc.nextDouble();
                        sc.nextLine();

                        stockService.updateStock(updateId,
                                                 newPurchase,
                                                 newQty,
                                                 newMarket);

                        break;
                    	
                        

                    case 6:

                        // Delete Stock
                    	System.out.print("Enter Asset ID to Delete: ");
                        int deleteId = sc.nextInt();
                        sc.nextLine();

                        stockService.removeStock(deleteId);
                        break;

                    case 7:
                    	 stockService.sortStocksByName();
                       // System.out.println("Returning to Main Menu...");
                        break;
                    case 8:
                        stockService.sortStocksByMarketPrice();
                        break;

                    case 9:
                        stockService.sortStocksByQuantity();
                        break;

                    case 10:
                        stockService.sortStocksByPurchasePrice();
                        break;
                    default:

                        System.out.println("Invalid Choice!");

                    }

                } while(stockChoice != 11);

                break;

            case 3:

                int portfolioChoice;

                do {

                    System.out.println("\n=================================");
                    System.out.println("      PORTFOLIO MODULE");
                    System.out.println("=================================");
                    System.out.println("1. Create Portfolio");
                    System.out.println("2. Display Portfolio");
                    System.out.println("3. Update Portfolio Name");
                    System.out.println("4. Save Portfolio to JSON");
                    System.out.println("5. Load Portfolio from JSON");
                    System.out.println("6. Back to Main Menu");

                    System.out.print("Enter your choice: ");
                    portfolioChoice = sc.nextInt();
                    sc.nextLine();

                    switch (portfolioChoice) {

                    case 1:

                        System.out.print("Enter Portfolio ID: ");
                        portfolio.setPortfolioId(sc.nextInt());
                        sc.nextLine();

                        System.out.print("Enter Portfolio Name: ");
                        portfolio.setPortfolioName(sc.nextLine());

                        System.out.println("\nPortfolio Created Successfully.");

                        break;

                    case 2:

                        portfolio.displayPortfolio();

                        break;

                    case 3:

                        System.out.print("Enter New Portfolio Name: ");
                        String newPortfolioName = sc.nextLine();

                        portfolioService.updatePortfolioName(portfolio, newPortfolioName);

                        break;

                    case 4:

                        portfolioService.savePortfolio(portfolio);

                        break;

                    case 5:

                        Portfolio loadedPortfolio = portfolioService.loadPortfolio();

                        if (loadedPortfolio != null) {

                            portfolio = loadedPortfolio;

                            System.out.println("\nPortfolio Loaded Successfully.");

                        }

                        break;

                    case 6:

                        System.out.println("Returning to Main Menu...");

                        break;

                    default:

                        System.out.println("Invalid Choice!");

                    }

                } while (portfolioChoice != 6);

                break;
            case 4:

                System.out.println("\nThank You for using Stock Portfolio Management System.");

                break;

            default:

                System.out.println("\nInvalid Choice! Please try again.");

            }

        } while (choice != 4);

        sc.close();
    }
}