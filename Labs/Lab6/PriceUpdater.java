package com.portfolio.concurrent;

public class PriceUpdater implements Runnable {

    private ConcurrentPortfolio portfolio;
    private String companyName;
    private double newPrice;

    // Constructor
    public PriceUpdater(ConcurrentPortfolio portfolio,
                        String companyName,
                        double newPrice) {

        this.portfolio = portfolio;
        this.companyName = companyName;
        this.newPrice = newPrice;
    }

    @Override
    public void run() {

        try {
            // Simulate delay
            Thread.sleep(1000);

            // Update stock price
            portfolio.updatePrice(companyName, newPrice);

            System.out.println(Thread.currentThread().getName()
                    + " updated " + companyName);

        } catch (InterruptedException e) {

            System.out.println("Thread interrupted.");

        }

    }

}
