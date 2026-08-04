package com.portfolio.jvm;

import java.util.ArrayList;
import java.util.List;

public class TradeHistory {

    // Deliberate memory leak
    private static List<Trade> tradeHistory = new ArrayList<>();

    public static void addTrade(Trade trade) {
        tradeHistory.add(trade);
    }

    public static int getTradeCount() {
        return tradeHistory.size();
    }
}
