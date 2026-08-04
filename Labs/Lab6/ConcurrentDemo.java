package com.portfolio.concurrent;

public class ConcurrentDemo {

    public static void main(String[] args) {

        // Create portfolio
        ConcurrentPortfolio portfolio = new ConcurrentPortfolio();

        // Add sample stocks
        portfolio.addStock("TCS", 3400.00);
        portfolio.addStock("Infosys", 1800.00);
        portfolio.addStock("Wipro", 550.00);

        System.out.println("\n===== Before Price Update =====");
        portfolio.displayStocks();

        // Create threads
        Thread t1 = new Thread(
                new PriceUpdater(portfolio, "TCS", 3500.00));

        Thread t2 = new Thread(
                new PriceUpdater(portfolio, "Infosys", 1900.00));

        Thread t3 = new Thread(
                new PriceUpdater(portfolio, "Wipro", 600.00));

        // Start threads
        t1.start();
        t2.start();
        t3.start();

        // Wait until all threads finish
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display updated portfolio
        System.out.println("\n===== After Price Update =====");
        portfolio.displayStocks();
    }
}
