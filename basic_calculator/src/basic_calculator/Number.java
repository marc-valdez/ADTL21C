package basic_calculator;
public class Number {
    private double value;

    public double getValue() {
        return value;
    }

    public double setValue(String prompt) {
        while(true) {
            try {
                System.out.print(prompt);
                String newValue = System.console().readLine();
                return Integer.parseInt(newValue);
            } catch (NumberFormatException e) {
                System.out.println("! Invalid number. Please try again.");
                continue;
            }
        }
    }

    public Number (String prompt)
    {
        value = setValue(prompt);
    }
}
