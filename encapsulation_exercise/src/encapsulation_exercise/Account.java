package encapsulation_exercise;

public class Account {
	private String account_number;
	public void set_account_number(String new_value) {
		account_number = new_value;
	}
	public String get_account_number() {
		return account_number;
	}
	
//	private String pin_number;
//	public void set_pin_number(String new_value) {
//		pin_number = new_value;
//	}
//	public String get_pin_number() {
//		return pin_number;
//	}
	
	private String account_name;
	public void set_account_name(String new_value) {
		account_name = new_value;
	}
	public String get_account_name() {
		return account_name;
	}
	
	private float account_balance;
	public void set_account_balance(float new_value) {
		account_balance = new_value;
	}
	public float get_account_balance() {
		return account_balance;
	}
}