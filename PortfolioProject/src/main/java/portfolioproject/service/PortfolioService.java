package portfolioproject.service;
import portfolioproject.repository.PortfolioRepository;

import portfolioproject.comparator.PurchasePriceComparator;
import portfolioproject.model.Portfolio;
import portfolioproject.comparator.QuantityComparator;
import java.util.Collections;
public class PortfolioService {
	private PortfolioRepository repository = new PortfolioRepository();
    // Display Portfolio Details
    public void displayPortfolio(Portfolio portfolio) {

        System.out.println("\n------ Portfolio Details ------");
        System.out.println("Portfolio ID   : " + portfolio.getPortfolioId());
        System.out.println("Portfolio Name : " + portfolio.getPortfolioName());
    }

    // Update Portfolio Name
    public void updatePortfolioName(Portfolio portfolio, String newName) {

        portfolio.setPortfolioName(newName);

        System.out.println("\nPortfolio name updated successfully!");
    }
    public void sortStocksByQuantity(Portfolio portfolio) {

        Collections.sort(portfolio.getStockList(), new QuantityComparator());

        System.out.println("\nStocks sorted by Quantity successfully.");
    }
    public void sortStocksByPurchasePrice(Portfolio portfolio) {

        Collections.sort(portfolio.getStockList(), new PurchasePriceComparator());

        System.out.println("\nStocks sorted by Purchase Price successfully.");
    }
 // Save Portfolio to JSON
    public void savePortfolio(Portfolio portfolio) {

        repository.savePortfolio(portfolio);
    }

    // Load Portfolio from JSON
    public Portfolio loadPortfolio() {

        return repository.loadPortfolio();
    }
}