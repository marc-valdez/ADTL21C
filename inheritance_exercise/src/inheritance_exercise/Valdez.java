package inheritance_exercise;

public class Valdez {
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
