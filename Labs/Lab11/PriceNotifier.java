package com.portfolio.patterns;

import java.util.ArrayList;
import java.util.List;

public class PriceNotifier {

    private List<PriceObserver> observers = new ArrayList<>();

    public void addObserver(PriceObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String stockName, double newPrice) {

        for (PriceObserver observer : observers) {
            observer.priceUpdated(stockName, newPrice);
        }
    }
}
