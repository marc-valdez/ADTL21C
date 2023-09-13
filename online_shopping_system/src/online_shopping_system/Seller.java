package online_shopping_system;

import java.util.*;

public class Seller extends User {
    private String ID;

    public String getID() {
        return ID;
    }

    public void setSellerID(String newValue) {
        ID = newValue;
    }

    // Constructor
    public Seller(String ID, String name, String email, String password, List<Product> defaultProducts) {
        super(name, email, password);
        this.ID = ID;
        this.products = new ArrayList<>(defaultProducts);
    }

    // list of products
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    // Methods to add and remove products
    public void addProduct(String name, double price) {
        Product newProduct = new Product(name, price);
        products.add(newProduct);
        viewProducts();
    }

    public void removeProductByID(int ID) {
        System.out.println("=====================================");

        for (Product product : products) {
            if (product.getID() == ID) {
                products.remove(product);
                System.out.println("Product with ID " + ID + " has been removed.");
                viewProducts();
                return;
            }
        }
        // If no product with the specified ID was found
        System.out.println("Product with ID " + ID + " not found.");
    }

    public void viewProducts() {
        ClearScreen.run();
        System.out.println("=====================================");
        System.out.println("Products for Sale:");
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    // Display Seller Menu
    public void displayMenu() {
        while (true) {
            SelectionMenu menu = new SelectionMenu();
            menu.addOption("View Products");
            menu.addOption("Add Product");
            menu.addOption("Remove Product");
            menu.addOption("Logout");
            int choice = menu.displayMenu("Please select an option: ");

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    System.out.print("Please enter the product name: ");
                    String name = System.console().readLine();
                    System.out.print("Please enter the product price: ");
                    double price = Double.parseDouble(System.console().readLine());
                    addProduct(name, price);
                    break;
                case 3:
                    viewProducts();
                    System.out.print("Please enter the product ID: ");
                    removeProductByID(Integer.parseInt(System.console().readLine()));
                    break;
                case 4:
                    ClearScreen.run();
                    return;
            }
        }
    }
}