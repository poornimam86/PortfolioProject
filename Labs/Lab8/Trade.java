package com.portfolio.jvm;

public class Trade {

    private int tradeId;
    private String companyName;
    private double amount;

    public Trade(int tradeId, String companyName, double amount) {
        this.tradeId = tradeId;
        this.companyName = companyName;
        this.amount = amount;
    }

    public int getTradeId() {
        return tradeId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Trade [tradeId=" + tradeId +
               ", companyName=" + companyName +
               ", amount=" + amount + "]";
    }
}
