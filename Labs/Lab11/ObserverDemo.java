package com.portfolio.patterns;

public class ObserverDemo {

    public static void main(String[] args) {

        PriceNotifier notifier = new PriceNotifier();

        PortfolioObserver portfolio = new PortfolioObserver();

        notifier.addObserver(portfolio);

        notifier.notifyObservers("TCS", 3500);

        notifier.notifyObservers("Infosys", 1900);
    }
}
