package online_shopping_system;

public class Product {
    private String productID;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String newValue) {
        productID = newValue;
    }

    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String newValue) {
        productName = newValue;
    }

    private double productPrice;

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double newValue) {
        productPrice = newValue;
    }

    // Constructor
    public Product(String productID, String productName, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
