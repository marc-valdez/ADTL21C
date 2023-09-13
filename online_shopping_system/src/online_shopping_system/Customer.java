package online_shopping_system;

import java.util.*;

public class Customer extends User {
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String newValue) {
        ID = newValue;
    }

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newValue) {
        balance = newValue;
    }

    // Constructor
    public Customer(String ID, String name, String email, String password, double balance, List<Product> defaultCart) {
        super(name, email, password);
        this.ID = ID;
        this.balance = balance;
        this.cart = new ArrayList<>(defaultCart);
    }

    private List<Product> cart;

    public List<Product> getCart() {
        return cart;
    }

    public void addToCart(Seller seller, int productID) {
        List<Product> sellerProducts = seller.getProducts();

        System.out.println("=====================================");
        for (Product product : sellerProducts) {
            if (product.getID() == productID) {
                cart.add(product);
                System.out.println("Product with ID " + productID + " has been added to your cart.");
                viewCart();
                return;
            }
        }

        // If no product with the specified ID was found
        System.out.println("Product with ID " + productID + " not found in the seller's products.");
    }

    public void removeProductByID(int ID) {
        System.out.println("=====================================");

        for (Product product : cart) {
            if (product.getID() == ID) {
                cart.remove(product);
                System.out.println("Product with ID " + ID + " has been removed.");
                viewCart();
                return;
            }
        }
        // If no product with the specified ID was found
        System.out.println("Product with ID " + ID + " not found.");
    }

    public void viewCart() {
        ClearScreen.run();
        System.out.println("=====================================");
        System.out.println("Cart:");
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        }
        for (Product product : cart) {
            System.out.println(product.toString());
        }
    }

    // Display Seller Selection Menu
    public Seller displaySellers(Customer customer, List<Seller> sellerDatabase) {
        while (true) {
            SelectionMenu chooseSeller = new SelectionMenu();
            chooseSeller.addOption("Potion Seller");
            chooseSeller.addOption("Weaponsmith");
            chooseSeller.addOption("Armorsmith");
            chooseSeller.addOption("Logout");
            int chosenSeller = chooseSeller.displayMenu("Please select an option: ");

            switch (chosenSeller) {
                case 1:
                    ClearScreen.run();
                    System.out.println("Welcome to the Potion Shop " + customer.getName() + "!");
                    System.out.println("Your Balance is: $" + customer.getBalance());
                    for (Seller seller : sellerDatabase) {
                        if (seller.getID().equals("PS1")) {
                            return seller;
                        }
                    }
                    break;
                case 2:
                    ClearScreen.run();
                    System.out.println("Welcome to the Weapon Shop!");
                    for (Seller seller : sellerDatabase) {
                        if (seller.getID().equals("WS1")) {
                            return seller;
                        }
                    }
                    break;
                case 3:
                    ClearScreen.run();
                    System.out.println("Welcome to the Armor Shop!");
                    for (Seller seller : sellerDatabase) {
                        if (seller.getID().equals("AS1")) {
                            return seller;
                        }
                    }
                    break;
                case 4:
                    ClearScreen.run();
                    return null;
            }
        }
    }

    // Display Customer Menu
    public double displayMenu(Seller chosenSeller) {
        while (true) {
            SelectionMenu menu = new SelectionMenu();
            menu.addOption("View Cart");
            menu.addOption("View Products");
            menu.addOption("Remove Items from Cart");
            menu.addOption("Checkout");
            menu.addOption("Return to Seller Menu");
            int choice = menu.displayMenu("Please select an option: ");

            switch (choice) {
                case 1:
                    viewCart();
                    break;
                case 2:
                    chosenSeller.viewProducts();
                    System.out.println("=====================================");
                    System.out.println("Add to Cart");
                    System.out.println("=====================================");
                    System.out.print("Please enter the product ID: ");
                    addToCart(chosenSeller, Integer.parseInt(System.console().readLine()));
                    break;
                case 3:
                    viewCart();
                    System.out.println("=====================================");
                    System.out.println("Remove from Cart");
                    System.out.println("=====================================");
                    System.out.print("Please enter the product ID: ");
                    removeProductByID(Integer.parseInt(System.console().readLine()));
                    break;
                case 4:
                    ClearScreen.run();
                    viewCart();
                    System.out.println("=====================================");
                    System.out.println("Total Price: $" + getTotalPrice());
                    System.out.println("=====================================");
                    System.out.print("Would you like to checkout? (y/n): ");
                    String checkout = System.console().readLine();
                    if (checkout.equals("y") || checkout.equals("Y")) {
                        ClearScreen.run();
                        return getTotalPrice();
                    }
                case 5:
                    ClearScreen.run();
                    return 0;
            }
        }

    }

    // calculate total price of items in their cart
    public double getTotalPrice() {
        return cart.stream().mapToDouble(product -> product.getPrice()).sum();
    }
}
