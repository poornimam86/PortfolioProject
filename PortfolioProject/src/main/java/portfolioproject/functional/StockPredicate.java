package portfolioproject.functional;

import java.util.function.Predicate;

import portfolioproject.model.Stock;

public class StockPredicate {

    public static Predicate<Stock> highValueStock =
            stock -> stock.getMarketPrice() > 1000;
}