/**
 * The CalculatorEngine class performs mathematical calculations.
 * It includes methods for addition, subtraction, multiplication, and division.
 * @author Riley Andersen
 */
public class CalculatorEngine {

    /**
     * Adds two integers.
     *
     * @param num1 The first integer.
     * @param num2 The second integer.
     * @return The sum of num1 and num2.
     */
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    /**
     * Subtracts the second integer from the first integer.
     *
     * @param num1 The first integer.
     * @param num2 The second integer.
     * @return The result of subtracting num2 from num1.
     */
    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    /**
     * Multiplies two integers.
     *
     * @param num1 The first integer.
     * @param num2 The second integer.
     * @return The product of num1 and num2.
     */
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    /**
     * Divides the first integer by the second integer.
     * Handles division by zero with a try/catch block.
     *
     * @param num1 The dividend.
     * @param num2 The divisor.
     * @return The result of dividing num1 by num2.
     */
    public int divide(int num1, int num2) {
        try {
            return num1 / num2;
        } catch (ArithmeticException e) {
            System.out.println("Error: Can not divide by zero! Result is invalid, returning zero.");
            return 0;
        }
    }
}