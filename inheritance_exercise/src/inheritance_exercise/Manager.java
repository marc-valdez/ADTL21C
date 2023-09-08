package inheritance_exercise;

public class Manager extends Employee {
	private byte employeeCount;
	public void set_employeeCount(byte new_value) {
		employeeCount = new_value;
	}
	public byte get_employeeCount() {
		return employeeCount;
	}
}