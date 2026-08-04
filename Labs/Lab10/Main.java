package com.portfolio.app;
import java.util.Scanner;
import com.portfolio.concurrent.ConcurrentPortfolio;
import com.portfolio.concurrent.PriceUpdater;
import com.portfolio.service.PortfolioService;
//import java.util.Scanner;
import com.portfolio.concurrent.PortfolioStatistics;
import com.portfolio.concurrent.ReaderTask;
import com.portfolio.service.PortfolioService;
import com.portfolio.threading.PriceFeedSimulator;
//import com.portfolio.threading.PriceFeedSimulator;
import com.portfolio.exception.InvalidTradeException;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PortfolioService service = new PortfolioService();

        int choice;
        
        PortfolioStatistics stats = new PortfolioStatistics();
        Thread priceThread =
                new Thread(new PriceFeedSimulator(service.getStocks()));

        priceThread.setDaemon(true);
        priceThread.start();
        for (int i = 1; i <= 10; i++) {

        	Thread reader = new Thread(
        	        new ReaderTask(service.getStocks(), stats));

        	reader.setName("Reader-" + i);

        	reader.start();
        }
        do {
        	 System.out.println("\n===== Portfolio Management System =====");
        	System.out.println("1. Add Stock");
        	System.out.println("2. Display Stocks");
        	System.out.println("3. Search Stock");
        	System.out.println("4. Update Stock");
        	System.out.println("5. Delete Stock");
        	System.out.println("6. Display Portfolio Value");
        	System.out.println("7. Benchmark Lookup");
        	System.out.println("8. Concurrent Price Update");
        	System.out.println("9. ExecutorService Performance Demo");
        	System.out.println("10. Portfolio Analytics");
        	System.out.println("11. Exit");
        	System.out.print("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {

            case 1:
                try {
                    service.addStock();
                } catch (InvalidTradeException e) {
                    System.out.println("Error: " + e.getMessage());
                }
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
                    service.concurrentPriceUpdate();
                    break;

                case 9:
                    service.executorPerformanceDemo();
                    break;

                case 10:
                    service.portfolioAnalytics();
                    break;

                case 11:
                    priceThread.interrupt();
                    System.out.println("Stopping Price Feed...");
                    System.out.println("Thank you for using Portfolio Management System.");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 11);
        try {
            priceThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
