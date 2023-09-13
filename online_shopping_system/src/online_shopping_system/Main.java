package online_shopping_system;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        ClearScreen.run();

        LoginSystem loginSystem = new LoginSystem();

        List<Product> customerProducts = new ArrayList<>();
        customerProducts.add(new Product("Shipping Fee", 1.0));
        loginSystem.addCustomer(new Customer("1", "Erika", "erika@customer.com", "123", 4000.0, customerProducts));
        loginSystem.addCustomer(new Customer("2", "Eugeo", "eugeo@customer.com", "123", 10.0, customerProducts));

        List<Product> potions = new ArrayList<>();
        potions.add(new Product("Healing Potion", 19.99));
        potions.add(new Product("Potion of Might", 29.99));
        loginSystem.addSeller(new Seller("PS1", "Marc", "marc@seller.com", "123", potions));

        List<Product> weapons = new ArrayList<>();
        weapons.add(new Product("Royal Blade", 199.99));
        weapons.add(new Product("Flame of Shmargenrog", 2999.99));
        loginSystem.addSeller(new Seller("WS1", "Greg", "greg@seller.com", "123", weapons));

        List<Product> armors = new ArrayList<>();
        armors.add(new Product("Helm of Sight", 219.99));
        armors.add(new Product("Boots of Flight", 4999.99));
        loginSystem.addSeller(new Seller("AS1", "Rivald", "rivald@seller.com", "123", armors));

        while (true) {
            System.out.print("Please enter your email: ");
            String email = System.console().readLine();
            System.out.print("Please enter your password: ");
            String password = System.console().readLine();

            if (loginSystem.login(email, password) instanceof Seller) {
                Seller seller = (Seller) loginSystem.login(email, password);
                seller.displayMenu();
            } else if (loginSystem.login(email, password) instanceof Customer) {
                Customer customer = (Customer) loginSystem.login(email, password);
                while (runCustomer(customer, loginSystem)) {}

            } else {
                System.out.println(" ! Authentication failed. Please try again.");
            }
        }
    }

    public static boolean runCustomer(Customer customer, LoginSystem loginSystem) {
        Seller chosenSeller = customer.displaySellers(customer, loginSystem.getSellerDatabase());
        if (chosenSeller == null) {
            return false;
        }

        double toPay = customer.displayMenu(chosenSeller);
        if (toPay == 0.0) {
            return true;
        }

        System.out.println("You have to pay: $" + toPay);
        System.out.println("Your balance is: " + customer.getBalance());
        if (customer.getBalance() >= toPay) {
            customer.setBalance(customer.getBalance() - toPay);
            System.out.println("=====================================");
            System.out.println("After paying, your updated balance is: " + customer.getBalance());
            System.out.println("Thank you for shopping with us!");
            System.exit(0);
        } else {
            System.out.println("=====================================");
            System.out.println("You don't have enough money to pay. :(\n");
            System.exit(0);
        }
        return true;
    }
}
