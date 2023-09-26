package integer_series;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		ClearScreen.run();

		System.out.println("Enter a series of integers (non-integers to exit): ");

		List<Integer> numbers = new ArrayList<>();
		while (true) {
			String newValue = System.console().readLine();
			try {
				int newValueInt = Integer.parseInt(newValue);
				numbers.add(newValueInt);
			} catch (NumberFormatException e) {
				break;
			}
		}

		// calculate the average of the series
		double sum = 0, average = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i);
		}
		average = sum / numbers.size();
		System.out.println("Average: " + average);
	}
}