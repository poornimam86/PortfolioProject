package com.portfolio.patterns;

import com.portfolio.model.Stock;

public class FIFOStrategy implements ValuationStrategy {

    @Override
    public double calculateValue(Stock stock) {

        return stock.getQuantity() * stock.getPrice();

    }
}
