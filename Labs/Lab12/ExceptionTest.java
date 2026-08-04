package com.portfolio.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.portfolio.exception.InvalidTradeException;

public class ExceptionTest {

    @Test
    void testInvalidTradeException() {

        InvalidTradeException ex =
                new InvalidTradeException("Invalid Quantity");

        assertEquals("Invalid Quantity", ex.getMessage());
    }
}
