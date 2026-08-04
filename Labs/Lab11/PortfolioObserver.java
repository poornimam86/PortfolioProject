package com.portfolio.patterns;

public class PortfolioObserver implements PriceObserver {

    @Override
    public void priceUpdated(String stockName, double newPrice) {

        System.out.println("Portfolio Updated:");
        System.out.println(stockName + " new price = ₹" + newPrice);

    }
}
