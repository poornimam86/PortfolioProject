package portfolioproject.strategy;

import portfolioproject.model.Stock;

public class MarketValueStrategy implements ValuationStrategy {

    @Override
    public double calculateValue(Stock stock) {

        return stock.getMarketPrice() * stock.getQuantity();

    }

}