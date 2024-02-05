/**
 * The Calculator class serves as the main driver for the calculator program.
 * It interacts with the user, processes input, and performs calculations.
 * @author Riley Andersen
 */
public class Calculator {

    /**
     * The main method is the entry point of the program.
     * It initializes necessary objects and enters a loop to continuously process user input.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Display student name and number
        System.out.println("Welcome to calculator.");
        System.out.println("Written by Riley Andersen");

        // Display instructions on how to use the calculator
        System.out.println("\nEquations are in the form num1 operator num2 =");
        System.out.println("Where num1 and num2 must be integers,");
        System.out.println("operator is one of +, -, / or *");
        System.out.println("\nEnter 0 = to quit.\n\n");

        // Instantiate CalculatorEngine and CalculatorInput classes
        CalculatorEngine calculatorEngine = new CalculatorEngine();
        CalculatorInput calculatorInput = new CalculatorInput();

        // Continuous loop to keep asking for input until the user quits
        while (true) {
            // Get user input
            calculatorInput.getUserInput();

            // Check if the user wants to quit
            if ("0 =".equals(calculatorInput.buffer.trim())) {
                System.out.println("Program exiting.");
                System.exit(0);
            }

            // Perform calculations using CalculatorEngine
            int result = calculateResult(calculatorInput, calculatorEngine);

            // Display the result to the user
            System.out.println("That answer is: " + result);
        }
    }

    /**
     * Calculates the result based on the user's input.
     *
     * @param calculatorInput The CalculatorInput object containing user input.
     * @param calculatorEngine The CalculatorEngine object for performing calculations.
     * @return The result of the calculation.
     */
    private static int calculateResult(CalculatorInput calculatorInput, CalculatorEngine calculatorEngine) {
        int num1 = calculatorInput.num1;
        int num2 = calculatorInput.num2;
        String sign = calculatorInput.sign;

        switch (sign) {
            case "+":
                return calculatorEngine.add(num1, num2);
            case "-":
                return calculatorEngine.subtract(num1, num2);
            case "*":
                return calculatorEngine.multiply(num1, num2);
            case "/":
                return calculatorEngine.divide(num1, num2);
            default:
                System.out.println("Error: Invalid operator. Valid operators are +, -, /, and *");
                return 0;
        }
    }
}