package portfolioproject.functional;

import java.util.function.Function;

import portfolioproject.model.Stock;

public class StockFunction {

    public static Function<Stock, Double> totalValue =
            stock -> stock.getMarketPrice() * stock.getQuantity();
}