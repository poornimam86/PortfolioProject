package com.portfolio.executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PerformanceComparator {

    public static void main(String[] args) {

        PriceFetcher fetcher = new PriceFetcher();

        List<String> stocks = Arrays.asList(
                "TCS",
                "Infosys",
                "Wipro",
                "HCL",
                "TechM",
                "Oracle",
                "Google",
                "Amazon",
                "Microsoft",
                "Apple"
        );

        // ============================
        // Sequential Execution
        // ============================

        long sequentialStart = System.currentTimeMillis();

        for (String stock : stocks) {

            double price = fetcher.fetchPrice(stock);

            System.out.printf("Sequential : %-12s ₹%.2f%n",
                    stock, price);
        }

        long sequentialEnd = System.currentTimeMillis();

        // ============================
        // Concurrent Execution
        // ============================

        ExecutorService executor = Executors.newFixedThreadPool(4);

        long concurrentStart = System.currentTimeMillis();

        CompletableFuture<?>[] futures = stocks.stream()

                .map(stock -> CompletableFuture.runAsync(() -> {

                    double price = fetcher.fetchPrice(stock);

                    System.out.printf("Concurrent : %-12s ₹%.2f (%s)%n",
                            stock,
                            price,
                            Thread.currentThread().getName());

                }, executor))

                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();

        long concurrentEnd = System.currentTimeMillis();

        executor.shutdown();

        // ============================
        // Results
        // ============================

        System.out.println("\n==============================");
        System.out.println("Performance Comparison");
        System.out.println("==============================");

        System.out.println("Sequential Time : "
                + (sequentialEnd - sequentialStart) + " ms");

        System.out.println("Concurrent Time : "
                + (concurrentEnd - concurrentStart) + " ms");
    }
}
