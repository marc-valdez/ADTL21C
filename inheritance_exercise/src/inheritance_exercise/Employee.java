package inheritance_exercise;

public class Employee {
	private String name;
	public void set_name(String new_value) {
		name = new_value;
	}
	public String get_name() {
		return name;
	}
	
	private String ID;
	public void set_ID(String new_value) {
		ID = new_value;
	}
	public String get_ID() {
		return ID;
	}
	
	private double salary;
	public void set_salary(double new_value) {
		salary = new_value;
	}
	public double get_salary() {
		return salary;
	}
}