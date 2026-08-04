package com.portfolio.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.portfolio.model.Portfolio;
import com.portfolio.model.Stock;


public class PortfolioTest {


    @Test
    void testAddStock(){

        Portfolio portfolio = new Portfolio();

        Stock stock =
                new Stock(
                "101",
                "TCS",
                10,
                3000);


        portfolio.addAsset(stock);


        assertEquals(
                1,
                portfolio.getAssets().size()
        );

    }



    @Test
    void testPortfolioValue(){

        Portfolio portfolio =
                new Portfolio();


        Stock stock =
                new Stock(
                "102",
                "Infosys",
                5,
                2000);


        portfolio.addAsset(stock);


        double value =
                stock.getQuantity()
                *
                stock.getPrice();


        assertEquals(
                10000,
                value
        );

    }

}
