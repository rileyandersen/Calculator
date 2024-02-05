import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The CalculatorInput class handles user input for the calculator program.
 * It validates and parses the input to ensure correct mathematical expressions.
 * @author Riley Andersen
 */
public class CalculatorInput {

    Scanner keyboard;
    Scanner input;
    int num1, num2;
    String sign, equals, buffer;

    /**
     * Constructor for the CalculatorInput class.
     * It initializes the keyboard scanner for user input.
     */
    public CalculatorInput() {
        keyboard = new Scanner(System.in);
    }

    /**
     * Gets user input, validates and parses it to extract the necessary components for calculation.
     * Handles various exceptions to prevent program crashes.
     */
    public void getUserInput() {
        while (true) {
            System.out.print("Enter your equation: ");

            buffer = keyboard.nextLine().trim();  // Trim to handle blank entries

            if (buffer.isEmpty()) {
                System.out.println("\nError: Equation incomplete. First number is missing.");
                continue;
            }

            if ("0 =".equals(buffer)) {
                System.out.println("\nProgram exiting.");
                System.exit(0);
            }

            try (Scanner input = new Scanner(buffer)) {
                // Check if there are enough elements in the input
                if (!input.hasNextInt()) {
                    System.out.println("\nError: First number is not an integer.");
                    continue;
                }

                num1 = input.nextInt();

                if (!input.hasNext()) {
                    System.out.println("\nError: Equation incomplete. Operator is missing.");
                    continue;
                }

                sign = input.next();

                // Check if the operator is valid
                if (!"+-*/".contains(sign) || sign.length() != 1) {
                    System.out.println("\nError: Invalid operator. Valid operators are +, -, /, and *");
                    continue;
                }

                // Check if there are enough elements in the input
                if (!input.hasNextInt()) {
                    System.out.println("\nError: Second number is missing.");
                    continue;
                }

                num2 = input.nextInt();

                // Check if the equation ends with '='
                if (!input.hasNext("=")) {
                    System.out.println("\nError: Equation incomplete. Equation must end with =");
                    continue;
                }

                equals = input.next();
                break;  // Exit the loop if input is valid
            } catch (NoSuchElementException e) {
                System.out.println("\nError: Equation incomplete. Please try again.");
            }
        }
    }
}