package com.portfolio.model;

public abstract class Asset {

    private String assetId;
    private String assetName;

    // Default Constructor
    public Asset() {

    }

    // Parameterized Constructor
    public Asset(String assetId, String assetName) {
        this.assetId = assetId;
        this.assetName = assetName;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    // Abstract Method
    public abstract double calculateCurrentValue();

    @Override
    public String toString() {
        return "Asset ID : " + assetId +
               "\nAsset Name : " + assetName;
    }
}
