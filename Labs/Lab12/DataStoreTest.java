package com.portfolio.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.portfolio.model.Portfolio;
import com.portfolio.util.DataStore;

public class DataStoreTest {

    @Test
    void testDataStoreCreation() {

        DataStore<Portfolio> store = new DataStore<>();

        assertNotNull(store);
    }

    @Test
    void testLoadNonExistingFile() {

        DataStore<Portfolio> store = new DataStore<>();

        Portfolio portfolio = store.load("dummy.json", Portfolio.class);

        assertNull(portfolio);
    }
}
