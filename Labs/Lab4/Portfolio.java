package com.portfolio.model;

import java.util.HashMap;

public class Portfolio {

	private HashMap<String, Stock> assets;

    // Default Constructor
    public Portfolio() {
        assets = new HashMap<>();
    }

    // Add Asset
    public void addAsset(Stock stock) {
        assets.put(stock.getStockId(), stock);
    }

    // Get All Assets
    public HashMap<String, Stock> getAssets() {
        return assets;
    }

    // Display Portfolio
    public void displayPortfolio() {

        if (assets.isEmpty()) {
            System.out.println("Portfolio is empty.");
            return;
        }

        for (Stock stock : assets.values()) {
            System.out.println("----------------------------");
            System.out.println(stock);
        }
    }

    // Total Portfolio Value
    public double totalValue() {

        double total = 0;

        for (Stock stock : assets.values()) {
            total += stock.calculateCurrentValue();
        }

        return total;
    }

    // Find Asset
    public Stock getAsset(String stockId) {
        return assets.get(stockId);
    }
    public void setAssets(HashMap<String, Stock> assets) {
        this.assets = assets;
    }

    // Remove Asset
    public void removeAsset(String stockId) {
        assets.remove(stockId);
    }
}
