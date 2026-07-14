package portfolioproject.functional;

import java.util.function.Consumer;

import portfolioproject.model.Stock;

public class StockConsumer {

    public static Consumer<Stock> displayStock =
            stock -> stock.displayDetails();
}