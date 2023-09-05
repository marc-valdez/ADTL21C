package encapsulation_exercise;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		clearScreen();

		Scanner input = new Scanner(System.in);
		Account users[] = new Account[Constants.MAX_ACCOUNTS];
		for (int i = 0; i < Constants.MAX_ACCOUNTS; i++) {
			users[i] = new Account();
		}
		int users_size = users.length;

		Account logged_in = new Account();

		users[0].set_account_number("2022-1-01130");
		users[0].set_account_name("Marc Joshua Valdez");
		users[0].set_account_balance(Constants.INITIAL_BALANCE);

		users[1].set_account_number("2022-1-01377");
		users[1].set_account_name("John Daniel Binegas");
		users[1].set_account_balance((float) 44000.0);

		System.out.print("Please enter your StudentID: ");
		String inputID = input.nextLine();

		for (int i = 0; i < users_size; i++) {
			if (users[i].get_account_number().equals(inputID)) {
				logged_in.set_account_number(users[i].get_account_number());
				logged_in.set_account_name(users[i].get_account_name());
				logged_in.set_account_balance(users[i].get_account_balance());
				break;
			}
		}

		if (logged_in.get_account_number() == null) {
			System.out.println("Account Not Found!");
		} else {
			System.out.println("Account Name: " + logged_in.get_account_name());
			System.out.println("Account Balance: " + Constants.CURRENCY + logged_in.get_account_balance());
		}

		input.close();
	}

	public static void clearScreen() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				// For non-Windows systems, you can use ANSI escape codes to clear the screen
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (Exception e) {
			System.err.println("An error occurred while clearing the screen: " + e.getMessage());
			System.exit(1); // Exit with an error status code
		}
	}
}