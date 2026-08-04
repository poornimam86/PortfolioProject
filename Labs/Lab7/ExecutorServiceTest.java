package com.portfolio.executor;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ExecutorServiceTest {

    @Test
    public void testFetchPrice() {

        PriceFetcher fetcher = new PriceFetcher();

        double price = fetcher.fetchPrice("TCS");

        assertTrue(price > 0);

    }
}
