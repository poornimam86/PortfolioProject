package com.portfolio.jvm;

public class MemoryLeakDemo {

    public static void main(String[] args) {

        System.out.println("Adding trades...");

        for (int i = 1; i <= 100000; i++) {

            Trade trade = new Trade(
                    i,
                    "TCS",
                    1000 + i);

            TradeHistory.addTrade(trade);

            if (i % 10000 == 0) {

                System.out.println(
                        "Trades Stored : "
                        + TradeHistory.getTradeCount());

            }

        }

        System.out.println("\nFinished.");

    }

}
