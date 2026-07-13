package portfolioproject.comparator;

import java.util.Comparator;
import portfolioproject.model.Stock;

public class QuantityComparator implements Comparator<Stock> {

    @Override
    public int compare(Stock s1, Stock s2) {
        return Integer.compare(s1.getQuantity(), s2.getQuantity());
    }
}