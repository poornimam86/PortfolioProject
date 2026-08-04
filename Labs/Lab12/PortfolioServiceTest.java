package com.portfolio.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.portfolio.service.PortfolioService;

public class PortfolioServiceTest {

    @Test
    void testServiceCreation() {

        PortfolioService service = new PortfolioService();

        assertNotNull(service);
    }

}
