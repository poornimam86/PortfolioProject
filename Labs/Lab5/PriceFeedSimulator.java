package com.portfolio.threading;

import java.util.HashMap;
import java.util.Random;

import com.portfolio.model.Stock;

public class PriceFeedSimulator implements Runnable {

    private final HashMap<String, Stock> stocks;
    private final Random random = new Random();

    public PriceFeedSimulator(HashMap<String, Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            synchronized (stocks) {

                if (!stocks.isEmpty()) {

                    for (Stock stock : stocks.values()) {

                        double oldPrice = stock.getPrice();

                        // Random movement between -5% and +5%
                        double percentage = (random.nextDouble() * 10) - 5;

                        double newPrice = oldPrice + (oldPrice * percentage / 100);

                        if (newPrice < 1) {
                            newPrice = 1;
                        }

                        stock.setPrice(newPrice);

                        System.out.printf(
                                "[Price Feed] %-15s %.2f -> %.2f%n",
                                stock.getCompanyName(),
                                oldPrice,
                                newPrice);
                    }

                    System.out.println("-----------------------------------");
                }
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Price Feed Stopped.");
    }
}
