package portfolioproject.service;

import java.util.ArrayList;

import portfolioproject.model.Stock;

public class StockService {

    // ArrayList to store multiple stocks
    private ArrayList<Stock> stockList;

    // Constructor
    public StockService() {
        stockList = new ArrayList<>();
    }

    // Add Stock
    public void addStock(Stock stock) {
        stockList.add(stock);
        System.out.println("\nStock added successfully.");
    }

    // Display All Stocks
    public void displayStocks() {

        if (stockList.isEmpty()) {
            System.out.println("\nNo stocks available.");
            return;
        }

        System.out.println("\n========== STOCK LIST ==========");

        for (Stock stock : stockList) {
            stock.displayDetails();
            System.out.println("-----------------------------------");
        }
    }

    // Search Stock
    public void searchStock(String assetName) {

        boolean found = false;

        for (Stock stock : stockList) {

            if (stock.getAssetName().equalsIgnoreCase(assetName)) {

                System.out.println("\nStock Found");
                stock.displayDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nStock not found.");
        }
    }

    // Remove Stock
    public void removeStock(String assetName) {

        for (Stock stock : stockList) {

            if (stock.getAssetName().equalsIgnoreCase(assetName)) {

                stockList.remove(stock);
                System.out.println("\nStock removed successfully.");
                return;
            }
        }

        System.out.println("\nStock not found.");
    }
}