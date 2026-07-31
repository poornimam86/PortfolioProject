package com.portfolio.app;

import java.util.Scanner;
import com.portfolio.service.PortfolioService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PortfolioService service = new PortfolioService();

        int choice;

        do {
        	System.out.println("\n===== Portfolio Management System =====");
        	System.out.println("1. Add Stock");
        	System.out.println("2. Display Stocks");
        	System.out.println("3. Search Stock");
        	System.out.println("4. Update Stock");
        	System.out.println("5. Delete Stock");
        	System.out.println("6. Display Portfolio Value");
        	System.out.println("7. Benchmark Lookup");
        	System.out.println("8. Exit");
        	System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {

                case 1:
                    service.addStock();
                    break;

                case 2:
                    service.displayStocks();
                    break;
                    
                case 3:
                    service.searchStock();
                    break;

                case 4:
                    service.updateStock();
                    break;

                case 5:
                    service.deleteStock();
                    break;
                case 6:
                    service.showPortfolioValue();
                    break;
                case 7:
                    service.benchmarkLookup();
                    break;
                case 8:
                    System.out.println("Thank you for using Portfolio Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 8);

        scanner.close();
    }
}
