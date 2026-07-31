package com.portfolio.service;
import com.portfolio.model.Asset;
import java.util.Scanner;
import com.portfolio.model.Portfolio;
import com.portfolio.model.Stock;

public class PortfolioService {

    private Portfolio portfolio = new Portfolio();
    private Scanner scanner = new Scanner(System.in);

    // Add Stock
    public void addStock() {

        System.out.print("Enter Stock ID: ");
        String stockId = scanner.nextLine();

        System.out.print("Enter Company Name: ");
        String companyName = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        Stock stock = new Stock(stockId, companyName, quantity, price);

        portfolio.addAsset(stock);

        System.out.println("Stock added successfully!");
    }

    // Display All Stocks
    public void displayStocks() {
        portfolio.displayPortfolio();
    }
 // Search Stock
    public void searchStock() {

        System.out.print("Enter Stock ID to Search: ");
        String stockId = scanner.nextLine();

        boolean found = false;

        for (Asset asset : portfolio.getAssets()) {

            Stock stock = (Stock) asset;

            if (stock.getStockId().equalsIgnoreCase(stockId)) {

                System.out.println("\nStock Found");
                System.out.println("----------------------------");
                System.out.println(stock);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Stock not found.");
        }
    }
 // Update Stock
    public void updateStock() {

        System.out.print("Enter Stock ID to Update: ");
        String stockId = scanner.nextLine();

        boolean found = false;

        for (Asset asset : portfolio.getAssets()) {
              Stock stock=(Stock) asset;
            if (stock.getStockId().equalsIgnoreCase(stockId)) {

                System.out.print("Enter New Company Name: ");
                stock.setCompanyName(scanner.nextLine());

                System.out.print("Enter New Quantity: ");
                stock.setQuantity(scanner.nextInt());

                System.out.print("Enter New Price: ");
                stock.setPrice(scanner.nextDouble());
                scanner.nextLine();

                System.out.println("Stock updated successfully.");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Stock not found.");
        }
    }
 // Delete Stock
    public void deleteStock() {

        System.out.print("Enter Stock ID to Delete: ");
        String stockId = scanner.nextLine();

        Stock stockToDelete = null;

        for (Asset asset : portfolio.getAssets()) {

            Stock stock = (Stock) asset;

            if (stock.getStockId().equalsIgnoreCase(stockId)) {

                stockToDelete = stock;   // VERY IMPORTANT

                break;
            }
        }

        if (stockToDelete != null) {

            portfolio.getAssets().remove(stockToDelete);

            System.out.println("Stock deleted successfully.");

        } else {

            System.out.println("Stock not found.");
        }
    }
    public void showPortfolioValue() {
        System.out.println("Total Portfolio Value : " + portfolio.totalValue());
    }
}
