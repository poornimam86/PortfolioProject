package com.portfolio.patterns;

import com.portfolio.model.Stock;

public class StockBuilder {

    private String stockId;
    private String companyName;
    private int quantity;
    private double price;

    public StockBuilder stockId(String stockId) {
        this.stockId = stockId;
        return this;
    }

    public StockBuilder companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public StockBuilder quantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public StockBuilder price(double price) {
        this.price = price;
        return this;
    }

    public Stock build() {
        return new Stock(stockId, companyName, quantity, price);
    }
}
