package portfolioproject.model;

public abstract class Asset {

    private int assetId;
    private String assetName;
    private double purchasePrice;
    private int quantity;

    // Default Constructor
    public Asset() {

    }

    // Parameterized Constructor
    public Asset(int assetId, String assetName,
                 double purchasePrice, int quantity) {

        this.assetId = assetId;
        this.assetName = assetName;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}