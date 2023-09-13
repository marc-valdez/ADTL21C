package online_shopping_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectionMenu {
    private List<String> options;
    private Scanner scanner;

    public SelectionMenu() {
        this.options = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Add an option to the menu
    public void addOption(String option) {
        options.add(option);
    }

    // Display the menu and get user input
    public int displayMenu(String prompt) {
        System.out.println("=====================================");

        for (int i = 0; i < options.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + options.get(i));
        }
        while (true) {
            System.out.print(prompt);

            try {
                int choice = scanner.nextInt();
                if (choice >= 1 && choice <= options.size()) {
                    return choice;
                } else {
                    System.out.println(
                            "\n! Invalid choice. Please enter a number between 1 and " + options.size() + ".\n");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("\n ! Invalid input. Please enter a valid number.\n");
                scanner.next(); // Consume the invalid input to prevent infinite loop
            }
        }
    }
}
