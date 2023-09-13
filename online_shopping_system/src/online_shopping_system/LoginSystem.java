package online_shopping_system;

import java.util.*;

public class LoginSystem {
    private List<Customer> customerDatabase;
    private List<Seller> sellerDatabase;

    // Constructor
    public LoginSystem() {
        customerDatabase = new ArrayList<>();
        sellerDatabase = new ArrayList<>();
    }

    // Get seller database
    public List<Seller> getSellerDatabase() {
        return sellerDatabase;
    }

    // Add customers to database
    public void addCustomer(Customer customer) {
        customerDatabase.add(customer);
    }

    // Add seller to database
    public void addSeller(Seller seller) {
        sellerDatabase.add(seller);
    }

    // Constructor and database initialization
    public User login(String email, String password) {
        // Check if the user exists in the customer database
        for (Customer customer : customerDatabase) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                return customer; // Successful login for a customer
            }
        }

        // Check if the user exists in the seller database
        for (Seller seller : sellerDatabase) {
            if (seller.getEmail().equals(email) && seller.getPassword().equals(password)) {
                return seller; // Successful login for a seller
            }
        }

        return null; // Authentication failed
    }
}
