package portfolioproject.thread;

import portfolioproject.model.Stock;

public class PriceUpdater extends Thread {

    private Stock stock;

    public PriceUpdater(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {

        synchronized (stock) {

            double currentPrice = stock.getMarketPrice();

            // Random price change between -5% and +5%
            double change = (Math.random() * 10) - 5;

            double newPrice = currentPrice + (currentPrice * change / 100);

            stock.setMarketPrice(Math.round(newPrice * 100.0) / 100.0);

            System.out.println(
                    Thread.currentThread().getName()
                    + " updated "
                    + stock.getAssetName()
                    + " price to ₹"
                    + stock.getMarketPrice());
        }
    }
}