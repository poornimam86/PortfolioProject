package portfolioproject.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import portfolioproject.model.Stock;

public class StockServiceTest {

    @Test
    public void testStockCreation() {

        Stock stock = new Stock(101, "TCS", 3000, 10, "TATA", 3200);

        assertEquals("TCS", stock.getAssetName());
    }

    @Test
    public void testPurchasePrice() {

        Stock stock = new Stock(101, "TCS", 3000, 10, "TATA", 3200);

        assertEquals(3000, stock.getPurchasePrice());
    }

    @Test
    public void testMarketPrice() {

        Stock stock = new Stock(101, "TCS", 3000, 10, "TATA", 3200);

        assertEquals(3200, stock.getMarketPrice());
    }

}