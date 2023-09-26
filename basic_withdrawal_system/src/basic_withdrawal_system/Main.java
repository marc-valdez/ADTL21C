package basic_withdrawal_system;

public class Main {
	public static void main(String[] args) {
		ClearScreen.run();

		Account accounts[] = new Account[3];
		accounts[0] = new Account("232323", "Perry Tail", 2000);

		System.out.println("Account Number: " + accounts[0].getNumber());
		System.out.println("Name: " + accounts[0].getName());
		System.out.println("Balance: PHP " + accounts[0].getBalance());
		accounts[0].withdraw("Withdrawal: ");
	}
}
