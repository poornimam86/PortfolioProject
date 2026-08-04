package com.portfolio.patterns;

import com.portfolio.model.Stock;

public class BuilderDemo {

    public static void main(String[] args) {

        Stock stock = new StockBuilder()
                .stockId("101")
                .companyName("TCS")
                .quantity(20)
                .price(2000)
                .build();

        System.out.println(stock);
    }
}
