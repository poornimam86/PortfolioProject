package portfolioproject.comparator;
import portfolioproject.comparator.PurchasePriceComparator;
import java.util.Comparator;
import portfolioproject.model.Stock;

public class PurchasePriceComparator implements Comparator<Stock> {

    @Override
    public int compare(Stock s1, Stock s2) {
        return Double.compare(s1.getPurchasePrice(), s2.getPurchasePrice());
    }
}