package com.portfolio.patterns;

import com.portfolio.model.Stock;

public class StrategyDemo {

    public static void main(String[] args) {

        Stock stock = new Stock("101", "TCS", 20, 2000);

        ValuationStrategy fifo = new FIFOStrategy();
        ValuationStrategy lifo = new LIFOStrategy();

        System.out.println("FIFO Value : ₹" +
                fifo.calculateValue(stock));

        System.out.println("LIFO Value : ₹" +
                lifo.calculateValue(stock));
    }
}
