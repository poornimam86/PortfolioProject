package com.portfolio.model;

public class Stock extends Asset{

    private String stockId;
    private String companyName;
    private int quantity;
    private double price;

    // Default Constructor
    public Stock() {

    }

    // Parameterized Constructor
    public Stock(String stockId, String companyName, int quantity, double price) {

        super(stockId, companyName);

        this.stockId = stockId;
        this.companyName = companyName;
        this.quantity = quantity;
        this.price = price;
    }
    // Getters and Setters

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Calculate Total Value
    @Override
    public double calculateCurrentValue() {
        return quantity * price;
    }

    // Display Stock Details
    @Override
    public String toString() {
        return "Stock ID : " + stockId +
               "\nCompany Name : " + companyName +
               "\nQuantity : " + quantity +
               "\nPrice : " + price +
               "\nTotal Value : " +  calculateCurrentValue();
    }
}
