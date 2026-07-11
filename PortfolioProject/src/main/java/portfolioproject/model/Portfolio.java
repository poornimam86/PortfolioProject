package portfolioproject.model;

import java.util.ArrayList;

public class Portfolio {

    private int portfolioId;
    private String portfolioName;

    // Collection to store multiple stocks
    private ArrayList<Stock> stockList;

    // Default Constructor
    public Portfolio() {
        stockList = new ArrayList<>();
    }

    // Parameterized Constructor
    public Portfolio(int portfolioId, String portfolioName) {
        this.portfolioId = portfolioId;
        this.portfolioName = portfolioName;
        stockList = new ArrayList<>();
    }

    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public ArrayList<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(ArrayList<Stock> stockList) {
        this.stockList = stockList;
    }

    // Add Stock
    public void addStock(Stock stock) {
        stockList.add(stock);
        System.out.println(stock.getAssetName() + " added successfully.");
    }

    // Display Portfolio
    public void displayPortfolio() {

        System.out.println("\n========== Portfolio Details ==========");
        System.out.println("Portfolio ID   : " + portfolioId);
        System.out.println("Portfolio Name : " + portfolioName);

        if (stockList.isEmpty()) {
            System.out.println("No stocks available.");
            return;
        }

        System.out.println("---------------------------------------");

        for (Stock stock : stockList) {
            stock.displayDetails();
            System.out.println("---------------------------------------");
        }
    }
}