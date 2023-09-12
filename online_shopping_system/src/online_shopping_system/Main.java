package online_shopping_system;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("P1", "Potion of Might\t", 100));
        products.add(new Product("P2", "Potion of Speed\t", 200));

        List<Seller> sellers = new ArrayList<Seller>();
        sellers.add(new Seller("S1", "Marc", "marc@generic.com", "marc123"));

        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("C1", "Erika", "erika@generic.com", "erika123"));
        customers.add(new Customer("C2", "Eugeo", "eugeo@generic.com", "eugeo123"));

        List<Product> cart = new ArrayList<Product>();
        cart.add(new Product("P0", "Shipping Fee\t", 10));

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to PotionSellah!");
            System.out.println("What would you like to do?");
            System.out.println(" [0] Exit");
            System.out.println(" [1] View Products");
            System.out.println(" [2] View Cart");
            System.out.print("Enter your choice [0-2]: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                case 1:
                    while (true) {
                        printProducts(products);
                        System.out.print("Please select a product to add to your cart (ID): ");
                        String selectedProductID = input.nextLine();

                        if (products.stream().anyMatch(product -> product.getProductID().equals(selectedProductID))) {
                            cart.add(products.stream()
                                    .filter(product -> product.getProductID().equals(selectedProductID))
                                    .findFirst().get());
                            printCart(cart);
                        }

                        System.out.print("Would you like to continue shopping? [Y/N]: ");
                        String continueShopping = input.nextLine();
                        if (continueShopping.equalsIgnoreCase("y")) {
                            continue;
                        } else {
                            break;
                        }
                    }
                case 2:
                    printCart(cart);
                    break;
                default:
                    System.out.println("\n! Invalid choice.\n");
                    break;
            }
            input.close();
        }
    }

    public static void printProducts(List<Product> products) {
        System.out.println("\nProducts:");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\tID\t|\tName\t\t\t|\tPrice\t");
        System.out.println("------------------------------------------------------------------------");
        for (Product product : products) {
            System.out.println("\t" + product.getProductID() + "\t|\t" + product.getProductName() + "\t|\t"
                    + product.getProductPrice() + "\t");
        }
        System.out.println("------------------------------------------------------------------------\n");
    }

    public static void printCart(List<Product> cart) {
        System.out.println("\nCart:");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\tID\t|\tName\t\t\t|\tPrice\t");
        System.out.println("------------------------------------------------------------------------");
        for (Product product : cart) {
            System.out.println("\t" + product.getProductID() + "\t|\t" + product.getProductName() + "\t|\t"
                    + product.getProductPrice() + "\t");
        }
        System.out.println("------------------------------------------------------------------------\n");
        System.out
                .println("Total Cost: " + cart.stream().mapToDouble(product -> product.getProductPrice()).sum() + "\n");
    }
}
