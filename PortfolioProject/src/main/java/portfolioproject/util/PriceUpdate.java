package portfolioproject.util;

import java.util.Random;

public class PriceUpdate {

    private static final Random random = new Random();

    public static double generateNewPrice(double currentPrice) {

        // Random percentage between -5% and +5%
        double percentage = (random.nextDouble() * 10) - 5;

        double newPrice = currentPrice + (currentPrice * percentage / 100);

        return Math.round(newPrice * 100.0) / 100.0;
    }
}