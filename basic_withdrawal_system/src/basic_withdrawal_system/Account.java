package basic_withdrawal_system;

public class Account {
	private String number;
	private String name;
	private double balance;

	public Account(String number, String name, double balance) {
		this.number = number;
		this.name = name;
		this.balance = balance;
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public void withdraw(String prompt) {
		double amount = 0;
		while (true) {
			try {
				System.out.print(prompt);
				amount = Double.parseDouble(System.console().readLine());
			} catch (NumberFormatException e) {
				System.out.println("! Withdrawal Unsuccessful : Invalid Input");
				continue;
			}
			if (amount > balance) {
				System.out.println("! Withdrawal Unsuccessful : Insufficient Balance");
			} else {
				System.out.println("! Withdrawal Successful");
				balance -= amount;
			}
			System.out.println("Updated Balance: PHP " + balance);
			break;
		}
	}
}
