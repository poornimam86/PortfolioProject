package com.portfolio.service;
import com.portfolio.model.Asset;
import com.portfolio.util.DataStore;
import java.util.Scanner;
import com.portfolio.model.Portfolio;
import com.portfolio.model.Stock;

public class PortfolioService {

    private Portfolio portfolio = new Portfolio();
    private Scanner scanner = new Scanner(System.in);
    
    private DataStore<Portfolio> portfolioStore = new DataStore<>();
    private final String PORTFOLIO_FILE = "portfolio.json";


 // Constructor
    public PortfolioService() {

        Portfolio loaded = portfolioStore.load(PORTFOLIO_FILE, Portfolio.class);

        if (loaded != null) {
            portfolio = loaded;
            System.out.println("Portfolio loaded successfully.");
        } else {
            System.out.println("Starting with a new portfolio.");
        }
    }
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
        portfolioStore.save(portfolio, PORTFOLIO_FILE);
    }

    // Display All Stocks
    public void displayStocks() {
        portfolio.displayPortfolio();
    }
 // Search Stock
    public void searchStock() {

        System.out.print("Enter Stock ID to Search: ");
        String stockId = scanner.nextLine();

        Asset asset = portfolio.getAsset(stockId);

        if (asset != null) {

            Stock stock = (Stock) asset;

            System.out.println("\nStock Found");
            System.out.println("----------------------------");
            System.out.println(stock);

        } else {

            System.out.println("Stock not found.");
        }
    }
 // Update Stock
    public void updateStock() {

        System.out.print("Enter Stock ID to Update: ");
        String stockId = scanner.nextLine();

        Asset asset = portfolio.getAsset(stockId);

        if (asset != null) {

            Stock stock = (Stock) asset;

            System.out.print("Enter New Company Name: ");
            stock.setCompanyName(scanner.nextLine());

            System.out.print("Enter New Quantity: ");
            stock.setQuantity(scanner.nextInt());

            System.out.print("Enter New Price: ");
            stock.setPrice(scanner.nextDouble());
            scanner.nextLine();

            System.out.println("Stock updated successfully.");
            portfolioStore.save(portfolio, PORTFOLIO_FILE);

        } else {

            System.out.println("Stock not found.");
        }
    }
 // Delete Stock
    public void deleteStock() {

        System.out.print("Enter Stock ID to Delete: ");
        String stockId = scanner.nextLine();

        Asset asset = portfolio.getAsset(stockId);

        if (asset != null) {

            portfolio.removeAsset(stockId);

            System.out.println("Stock deleted successfully.");
            portfolioStore.save(portfolio, PORTFOLIO_FILE);

        } else {

            System.out.println("Stock not found.");
        }
    }
    public void showPortfolioValue() {
        System.out.println("Total Portfolio Value : " + portfolio.totalValue());
    }
 // Performance Benchmark
    public void benchmarkLookup() {

        System.out.print("Enter Stock ID to Search: ");
        String stockId = scanner.nextLine();

        long startTime = System.nanoTime();

        Asset asset = portfolio.getAsset(stockId);

        long endTime = System.nanoTime();

        if (asset != null) {
            System.out.println("Stock Found");
            System.out.println(asset);
        } else {
            System.out.println("Stock not found.");
        }

        System.out.println("Lookup Time: " + (endTime - startTime) + " ns");
    }
}
