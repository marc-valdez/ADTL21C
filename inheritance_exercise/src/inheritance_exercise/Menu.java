package inheritance_exercise;

import java.util.Scanner;

public class Menu {
    public static void printMenu(Employee[] employees, Manager[] managers) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Information Kiosk:");
            System.out.println(" [1] View Employee Information");
            System.out.println(" [2] View Manager Information");
            System.out.println(" [3] Exit");
            System.out.print("Enter your choice [1-3]: ");
            choice = scanner.nextInt();

            switch (choice) {
                default:
                    System.out.println("Please enter a number between 1 and 3");
                    continue;
                case 1:
                    System.out.println("\n--------------------------------------------------");
                    System.out.println("Employees:");
                    System.out.println("--------------------------------------------------");
                    System.out.println("\tID\t|\tName\t|\tSalary\t");
                    System.out.println("--------------------------------------------------");
                    for (int i = 0; i < employees.length; i++) {
                        System.out.println("\t" + employees[i].get_ID() + "\t|\t" + employees[i].get_name() + "\t|\t" + employees[i].get_salary() + "\t");
                    }
                    System.out.println("--------------------------------------------------\n");
                    break;
                case 2:
                    System.out.println("\n-------------------------------------------------------------------------------");
                    System.out.println("\tManagers:");
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("\tID\t|\tName\t|\tSalary\t|\tNumber of Employees");
                    System.out.println("-------------------------------------------------------------------------------");
                    for (int i = 0; i < managers.length; i++) {
                        System.out.println("\t" + managers[i].get_ID() + "\t|\t" + managers[i].get_name() + "\t|\t" + managers[i].get_salary() + "\t|\t" + managers[i].get_employeeCount());
                    }
                    System.out.println("------------------------------------------------------------------------------\n");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }
}