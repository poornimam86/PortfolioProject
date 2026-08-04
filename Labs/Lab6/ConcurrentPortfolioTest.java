package com.portfolio.concurrent;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ConcurrentPortfolioTest {

    @Test
    public void testUpdatePrice() {

        ConcurrentPortfolio portfolio = new ConcurrentPortfolio();

        portfolio.addStock("TCS", 3400.00);

        portfolio.updatePrice("TCS", 3500.00);

        double actualPrice = portfolio.getStocks().get("TCS");

        assertEquals(3500.00, actualPrice);
    }
}
