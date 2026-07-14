package portfolioproject.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import portfolioproject.model.Portfolio;
import portfolioproject.model.Stock;

public class PortfolioTest {

    @Test
    public void testAddStockToPortfolio() {

        Portfolio portfolio = new Portfolio();

        Stock stock = new Stock(101,
                "TCS",
                3000,
                10,
                "TATA",
                3200);

        portfolio.addStock(stock);

        assertEquals(1, portfolio.getStockList().size());

    }

}