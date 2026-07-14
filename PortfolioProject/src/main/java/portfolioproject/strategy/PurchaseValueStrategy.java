package portfolioproject.strategy;

import portfolioproject.model.Stock;

public class PurchaseValueStrategy implements ValuationStrategy {

    @Override
    public double calculateValue(Stock stock) {

        return stock.getPurchasePrice() * stock.getQuantity();

    }

}