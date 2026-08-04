package com.portfolio.service;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Scanner;
import java.util.List;

import com.portfolio.concurrent.ConcurrentPortfolio;
import com.portfolio.concurrent.PriceUpdater;

import com.portfolio.exception.InvalidTradeException;
import com.portfolio.exception.InsufficientHoldingException;
import com.portfolio.exception.PortfolioPersistenceException;

import com.portfolio.model.Asset;
import com.portfolio.model.Portfolio;
import com.portfolio.model.Stock;

import com.portfolio.util.DataStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.portfolio.executor.PerformanceComparator;
import com.portfolio.executor.PerformanceComparator;

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
            logger.info("Portfolio loaded successfully.");
        } else {
        	logger.info("Starting with a new portfolio.");
        }
    }
    // Add Stock
    public void addStock() throws InvalidTradeException
    {

        System.out.print("Enter Stock ID: ");
        String stockId = scanner.nextLine();

        System.out.print("Enter Company Name: ");
        String companyName = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        if (quantity <= 0) {
            throw new InvalidTradeException(
                    "Quantity must be greater than zero.");
        }

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        if (price <= 0) {
            throw new InvalidTradeException(
                    "Price must be greater than zero.");
        }

        Stock stock = new Stock(stockId, companyName, quantity, price);

        portfolio.addAsset(stock);

        logger.info("Stock added successfully: {}", companyName);

        portfolioStore.save(portfolio, PORTFOLIO_FILE);
    }

    // Display All Stocks
    public void displayStocks() {

        if (portfolio.getAssets().isEmpty()) {
            System.out.println("No stocks available.");
            return;
        }
        portfolio.getAssets()
        .values()
        .forEach(System.out::println);


        for (Stock stock : portfolio.getAssets().values()) {
            System.out.println(stock);
        }
    }
    
    public void highestPricedStock() {

        portfolio.getAssets()
                 .values()
                 .stream()
                 .max((s1, s2) -> Double.compare(s1.getPrice(), s2.getPrice()))
                 .ifPresent(stock -> {
                     System.out.println("\nHighest Priced Stock");
                     System.out.println("------------------------");
                     System.out.println(stock);
                 });
    }
    
    public void lowestPricedStock() {

        portfolio.getAssets()
                 .values()
                 .stream()
                 .min((s1, s2) -> Double.compare(s1.getPrice(), s2.getPrice()))
                 .ifPresent(stock -> {
                     System.out.println("\nLowest Priced Stock");
                     System.out.println("------------------------");
                     System.out.println(stock);
                 });
    }
    
    public void averageStockPrice() {

        double average = portfolio.getAssets()
                                  .values()
                                  .stream()
                                  .mapToDouble(Stock::getPrice)
                                  .average()
                                  .orElse(0.0);

        System.out.println("\nAverage Stock Price : ₹" + average);
    }
    
    public void totalStocks() {

        long total = portfolio.getAssets()
                              .values()
                              .stream()
                              .count();

        System.out.println("\nTotal Stocks : " + total);
    }
    
    public void totalQuantity() {

        int quantity = portfolio.getAssets()
                                .values()
                                .stream()
                                .mapToInt(Stock::getQuantity)
                                .sum();

        System.out.println("\nTotal Quantity : " + quantity);
    
    }
    
    public void portfolioAnalytics() {

        System.out.println("\n========== Portfolio Analytics ==========");

        totalStocks();

        totalQuantity();

        averageStockPrice();

        highestPricedStock();

        lowestPricedStock();

        System.out.println("=========================================");
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

        	logger.warn("Stock not found.");
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

            logger.info("Stock updated successfully.");
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

            logger.info("Stock deleted successfully.");
            portfolioStore.save(portfolio, PORTFOLIO_FILE);

        } else {

        	logger.warn("Stock not found.");
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

        logger.info("Lookup Time: {} ns", (endTime - startTime));
    }
    public ConcurrentHashMap<String, Stock> getStocks() {
        return portfolio.getAssets();
    }
    public void concurrentPriceUpdate() {

        ConcurrentPortfolio portfolio = new ConcurrentPortfolio();

        portfolio.addStock("TCS", 3400.00);
        portfolio.addStock("Infosys", 1800.00);
        portfolio.addStock("Wipro", 550.00);

        System.out.println("\n===== Before Price Update =====");
        portfolio.displayStocks();

        Thread t1 = new Thread(new PriceUpdater(portfolio, "TCS", 3500.00));
        Thread t2 = new Thread(new PriceUpdater(portfolio, "Infosys", 1900.00));
        Thread t3 = new Thread(new PriceUpdater(portfolio, "Wipro", 600.00));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n===== After Price Update =====");
        portfolio.displayStocks();
    }
    public void executorPerformanceDemo() {
        PerformanceComparator.main(new String[0]);
    }
    private static final Logger logger =
            LoggerFactory.getLogger(PortfolioService.class);
}
