package portfolioproject.service;

import java.util.ArrayList;

import portfolioproject.model.Stock;

public class StockService 
{
    // ArrayList to store multiple stocks
    private ArrayList<Stock> stockList;
    // Constructor
    public StockService()
    {
        stockList = new ArrayList<>();
    }
    // Add Stock
    public void addStock(Stock stock) 
    {
        stockList.add(stock);
        System.out.println("\nStock added successfully.");
    }
    // Display All Stocks
    public void displayStocks() 
    {
        if (stockList.isEmpty()) 
        {
            System.out.println("\nNo stocks available.");
            return;
        }
        System.out.println("\n========== STOCK LIST ==========");
        for (Stock stock : stockList)
        {
            stock.displayDetails();
            System.out.println("-----------------------------------");
        }
    }

    
 // Search Stock by Asset ID
    public void searchStock(int assetId) 
    {
        for (Stock stock : stockList)
        {
            if (stock.getAssetId() == assetId)
            {
                System.out.println("\n========== STOCK FOUND ==========");
                stock.displayDetails();
                return;
            }
        }
        System.out.println("\nStock not found.");
    }
 // Sell Stock
    public void sellStock(String assetName, int sellQuantity)
    {
        for (int i = 0; i < stockList.size(); i++) 
        {
            Stock stock = stockList.get(i);
            if (stock.getAssetName().equalsIgnoreCase(assetName)) 
            {
                if (sellQuantity > stock.getQuantity()) 
                {
                    System.out.println("\nInsufficient quantity available.");
                    return;
                }
                stock.setQuantity(stock.getQuantity() - sellQuantity);
                if (stock.getQuantity() == 0) 
                {
                    stockList.remove(i);
                    System.out.println("\nAll shares sold. Stock removed from portfolio.");

                } 
                else 
                {
                    System.out.println("\nStock sold successfully.");
                    System.out.println("Remaining Quantity : " + stock.getQuantity());
                }
                return;
            }
        }
        System.out.println("\nStock not found.");
    }
 // Update Stock
    public void updateStock(int assetId, double purchasePrice,int quantity, double marketPrice)
    {
        for (Stock stock : stockList)
        {
            if (stock.getAssetId() == assetId) 
            {
                stock.setPurchasePrice(purchasePrice);
                stock.setQuantity(quantity);
                stock.setMarketPrice(marketPrice);
                System.out.println("\nStock updated successfully.");
                return;
            }
        }
        System.out.println("\nStock not found.");
    }
    // Remove Stock
    public void removeStock(int assetId)
    {
        for (int i = 0; i < stockList.size(); i++) 
        {
            if (stockList.get(i).getAssetId() == assetId) 
            {
                stockList.remove(i);
                System.out.println("\nStock deleted successfully.");
                return;
            }
        }

        System.out.println("\nStock not found.");
    }
}