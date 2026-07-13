package portfolioproject.thread;

import portfolioproject.model.Stock;

public class PriceUpdater extends Thread {

    private Stock stock;

    public PriceUpdater(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {

        double oldPrice = stock.getMarketPrice();
        double newPrice = oldPrice + 10;

        stock.setMarketPrice(newPrice);

        System.out.println(
                stock.getCompanyName()
                + " Price Updated from "
                + oldPrice
                + " to "
                + newPrice);
    }
}