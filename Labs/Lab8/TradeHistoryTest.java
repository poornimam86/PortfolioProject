package com.portfolio.jvm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TradeHistoryTest {

    @Test
    public void testBoundTradeHistory() {

        for (int i = 1; i <= 2000; i++) {
            TradeHistory.addTrade(
                    new Trade(i, "TCS", 1000 + i));
        }

        // History should never exceed 1000
        assertEquals(1000, TradeHistory.getTradeCount());

    }
}
