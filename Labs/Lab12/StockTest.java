package com.portfolio.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.portfolio.model.Stock;

class StockTest {

    @Test
    void testStockParameterizedConstructor() {

        Stock stock = new Stock("S101", "TCS", 10, 3500.0);

        assertEquals("S101", stock.getStockId());
        assertEquals("TCS", stock.getCompanyName());
        assertEquals(10, stock.getQuantity());
        assertEquals(3500.0, stock.getPrice());
    }


    @Test
    void testStockDefaultConstructor() {

        Stock stock = new Stock();

        assertNotNull(stock);
    }


    @Test
    void testSetStockId() {

        Stock stock = new Stock();

        stock.setStockId("S102");

        assertEquals("S102", stock.getStockId());
    }


    @Test
    void testSetCompanyName() {

        Stock stock = new Stock();

        stock.setCompanyName("Infosys");

        assertEquals("Infosys", stock.getCompanyName());
    }


    @Test
    void testSetQuantity() {

        Stock stock = new Stock();

        stock.setQuantity(20);

        assertEquals(20, stock.getQuantity());
    }


    @Test
    void testSetPrice() {

        Stock stock = new Stock();

        stock.setPrice(1500.50);

        assertEquals(1500.50, stock.getPrice());
    }


    @Test
    void testCalculateCurrentValue() {

        Stock stock = new Stock("S103", "Wipro", 5, 1000);

        double value = stock.calculateCurrentValue();

        assertEquals(5000, value);
    }


    @Test
    void testToStringContainsCompanyName() {

        Stock stock = new Stock("S104", "HCL", 10, 2000);

        String result = stock.toString();

        assertTrue(result.contains("HCL"));
    }


    @Test
    void testToStringContainsStockId() {

        Stock stock = new Stock("S105", "Tech Mahindra", 15, 1200);

        String result = stock.toString();

        assertTrue(result.contains("S105"));
    }

}
