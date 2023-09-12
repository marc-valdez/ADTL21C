package online_shopping_system;

public class Seller extends User {
    private String sellerID;

    public String getSellerID() {
        return sellerID;
    }

    public void setSellerID(String newValue) {
        sellerID = newValue;
    }

    // Constructor
    public Seller(String sellerID, String name, String email, String password) {
        super(name, email, password);
        this.sellerID = sellerID;
    }

    // list of products
    // implement method to add and remove products
}