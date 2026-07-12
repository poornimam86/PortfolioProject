package portfolioproject.comparator;

import java.util.Comparator;

import portfolioproject.model.Stock;

public class MarketPriceComparator implements Comparator<Stock> {

    @Override
    public int compare(Stock s1, Stock s2) {

        return Double.compare(s1.getMarketPrice(), s2.getMarketPrice());

    }
}