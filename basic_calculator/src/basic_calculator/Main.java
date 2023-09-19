package basic_calculator;

public class Main {

	public static void main(String[] args) {
		while (true) {
			ClearScreen.run();

			System.out.println("Basic Calculator :)\n");

			Number num1 = new Number("Please enter the first number: ");
			Number num2 = new Number("Please enter the second number: ");

			System.out.println("[1] Addition (+)");
			System.out.println("[2] Subtraction (-)");
			System.out.println("[3] Multiplication (*)");
			System.out.println("[4] Division (/)");
			System.out.println("[5] Modulo (%)");

			int choice = 0;
			while (true) {
				try {
					System.out.print("Please choose an operation: ");
					choice = Integer.parseInt(System.console().readLine());
					if (choice >= 1 && choice <= 5) {
						break;
					} else {
						System.out.println("! Please enter a number between 1 and 5.");
					}
				} catch (NumberFormatException e) {
					System.out.println("! Invalid input. Please try again.");
				}
			}

			System.out.print("\nSolution: ");
			switch (choice) {
				case 1:
					double sum = num1.getValue() + num2.getValue();
					System.out.println(num1.getValue() + " + " + num2.getValue() + " = " + sum);
					break;
				case 2:
					double difference = num1.getValue() - num2.getValue();
					System.out.println(num1.getValue() + " - " + num2.getValue() + " = " +
							difference);
					break;
				case 3:
					double product = num1.getValue() * num2.getValue();
					System.out.println(num1.getValue() + " * " + num2.getValue() + " = " +
							product);
					break;
				case 4:
					double quotient = num1.getValue() / num2.getValue();
					System.out.println(num1.getValue() + " / " + num2.getValue() + " = " +
							quotient);
					break;
				case 5:
					double remainder = num1.getValue() % num2.getValue();
					System.out.println(num1.getValue() + " % " + num2.getValue() + " = " +
							remainder);
					break;
			}

			outerLoop: while (true) {
				try {
					System.out.print("\nWould you like to continue? (y/n): ");
					String answer = System.console().readLine();
					if (answer.equals("y") || answer.equals("Y")) {
						break;
					} else if (answer.equals("n") || answer.equals("N")) {
						while (true) {
							try {
								System.out.print("Are you sure? (y/n): ");
								String confirm = System.console().readLine();
								if (confirm.equals("y") || confirm.equals("Y")) {
									System.out.println("Goodbye!");
									System.exit(0);
								} else if (confirm.equals("n") || confirm.equals("N")) {
									break outerLoop;
								} else {
									throw new IllegalArgumentException("! Invalid input. Please enter 'y' or 'n'.");
								}
							} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
							}
						}
					} else {
						throw new IllegalArgumentException("! Invalid input. Please enter 'y' or 'n'.");
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
