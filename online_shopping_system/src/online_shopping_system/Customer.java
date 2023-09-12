package online_shopping_system;

public class Customer extends User{
    private String customerID;
    public String getCustomerID() {
        return customerID;
    }
    public void setCustomerID(String newValue) {
        customerID = newValue;
    }

    // Constructor
    public Customer(String customerID, String name, String email, String password) {
        super(name, email, password);
        this.customerID = customerID;
    }

    // add a cart (array maybe? maybe structure?)
    // implement method to add and remove items from cart
    // calculate total price of items in their cart
}
