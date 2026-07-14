package portfolioproject.service;
import portfolioproject.comparator.QuantityComparator;

import portfolioproject.comparator.PurchasePriceComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
//import java.util.Collections;
import portfolioproject.comparator.MarketPriceComparator;

import portfolioproject.model.Stock;
import portfolioproject.exception.InvalidStockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StockService 
{
	private static final Logger logger =
	        LoggerFactory.getLogger(StockService.class);
	
	// ArrayList to store multiple stocks
    private ArrayList<Stock> stockList;
    private HashMap<Integer, Stock> stockMap;
    
    // Constructor
    public StockService()
    {
        stockList = new ArrayList<>();
        stockMap = new HashMap<>();
    }
    // Add Stock
    public void addStock(Stock stock) throws InvalidStockException {

        if (stock == null) {
            throw new InvalidStockException("Stock object cannot be null.");
        }

        if (stockMap.containsKey(stock.getAssetId())) {
            throw new InvalidStockException("Stock with Asset ID " + stock.getAssetId() + " already exists.");
        }

        if (stock.getQuantity() <= 0) {
            throw new InvalidStockException("Quantity must be greater than zero.");
        }

        if (stock.getPurchasePrice() <= 0) {
            throw new InvalidStockException("Purchase Price must be greater than zero.");
        }

        if (stock.getMarketPrice() <= 0) {
            throw new InvalidStockException("Market Price must be greater than zero.");
        }

        stockList.add(stock);
        stockMap.put(stock.getAssetId(), stock);

       // System.out.println("\nStock added successfully.");
        logger.info("Stock added successfully.");
        System.out.println("\nStock added successfully.");
    }
 // Sort Stocks by Asset Name
    public void sortStocksByName() {

        Collections.sort(stockList);

        System.out.println("\nStocks sorted by Asset Name successfully.");
    }
 // Sort Stocks by Market Price
    public void sortStocksByMarketPrice() {

        //Collections.sort(stockList, new MarketPriceComparator());
    	Collections.sort(stockList, (s1, s2) ->
        Double.compare(s1.getMarketPrice(), s2.getMarketPrice()));
        System.out.println("\nStocks sorted by Market Price successfully.");
    }
    //Sort Stock by Quantity
    public void sortStocksByQuantity() {

        Collections.sort(stockList, new QuantityComparator());

        System.out.println("\nStocks sorted by Quantity successfully.");
    }
    //Sort Stock by PurchasePrice
    public void sortStocksByPurchasePrice() {

        Collections.sort(stockList, new PurchasePriceComparator());

        System.out.println("\nStocks sorted by Purchase Price successfully.");
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
    public void searchStock(int assetId) {

        Stock stock = stockMap.get(assetId);

        if (stock != null) {

            System.out.println("\n========== STOCK FOUND ==========");
            stock.displayDetails();

        } else {

            System.out.println("\nStock not found.");
        }
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
 // Update Stock using HashMap
    public void updateStock(int assetId, double purchasePrice,
                            int quantity, double marketPrice) {

        Stock stock = stockMap.get(assetId);

        if (stock != null) {

            stock.setPurchasePrice(purchasePrice);
            stock.setQuantity(quantity);
            stock.setMarketPrice(marketPrice);

            System.out.println("\nStock updated successfully.");

        } else {

            System.out.println("\nStock not found.");
        }
    }
 // Delete Stock using HashMap
    public void removeStock(int assetId) {

        // Get stock from HashMap
        Stock stock = stockMap.get(assetId);

        if (stock != null) {

            // Remove from HashMap
            stockMap.remove(assetId);

            // Remove from ArrayList
            stockList.remove(stock);

            System.out.println("\nStock deleted successfully.");

        } else {

            System.out.println("\nStock not found.");
        }
    }
    public ArrayList<Stock> getAllStocks() {
        return stockList;
    }
}