package portfolioproject.strategy;

import portfolioproject.model.Stock;

public interface ValuationStrategy {

    double calculateValue(Stock stock);

}