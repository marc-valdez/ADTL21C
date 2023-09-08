package inheritance_exercise;

public class Main {
	public static void main(String[] args) {
		Valdez.clearScreen();

		Employee employees[] = new Employee[Constants.EMPLOYEECOUNT];
		employees[0] = new Employee();
		employees[0].set_name("Erika");
		employees[0].set_ID("0000");
		employees[0].set_salary(500);
		
		employees[1] = new Employee();
		employees[1].set_name("Eugeo");
		employees[1].set_ID("0001");
		employees[1].set_salary(490);
		
		Manager managers[]  = new Manager[Constants.MANAGERCOUNT];
		managers[0] = new Manager();
		managers[0].set_name("Marc");
		managers[0].set_ID("1111");
		managers[0].set_salary(1000);
		managers[0].set_employeeCount(Constants.EMPLOYEECOUNT);
		
		Menu.printMenu(employees, managers);
	}
}