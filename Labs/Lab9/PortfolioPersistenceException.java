package com.portfolio.exception;

public class PortfolioPersistenceException extends Exception {

    public PortfolioPersistenceException(String message) {
        super(message);
    }

    public PortfolioPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
