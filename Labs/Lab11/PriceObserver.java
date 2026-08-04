package com.portfolio.patterns;

public interface PriceObserver {

    void priceUpdated(String stockName, double newPrice);

}
