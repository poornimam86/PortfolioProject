package portfolioproject.model;

public class Stock extends Asset implements Comparable<Stock>
{

    private String companyName;
    private double marketPrice;
    private double purchasePrice;

    // Default Constructor
    public Stock() {

    }

    // Parameterized Constructor
    public Stock(int assetId,
                 String assetName,
                 double purchasePrice,
                 int quantity,
                 String companyName,
                 double marketPrice) {

        super(assetId, assetName, purchasePrice, quantity);

        this.companyName = companyName;
        this.marketPrice = marketPrice;
    }

    public String getCompanyName() {
        return companyName;
    }
    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }
    @Override
    public int compareTo(Stock other) {

        return this.getAssetName().compareToIgnoreCase(other.getAssetName());

    }

    public void displayDetails() {

        System.out.println("Asset ID        : " + getAssetId());
        System.out.println("Asset Name      : " + getAssetName());
        System.out.println("Purchase Price  : " + getPurchasePrice());
        System.out.println("Quantity        : " + getQuantity());
        System.out.println("Company Name    : " + companyName);
        System.out.println("Market Price    : " + marketPrice);
    }
}