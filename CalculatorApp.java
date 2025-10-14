import java.util.Scanner;

/**
 * Entry point for the CLI Calculator application.
 * Demonstrates OOP, enums, and exception handling in Java.
 */
public class CalculatorApp {

    /**
     * Main method to run the CLI calculator.
     * Handles user input and displays results.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new BasicCalculator();

        System.out.println("=== Exception-based CLI Calculator ===");

        try {
            System.out.print("Enter first number: ");
            double a = scanner.nextDouble();

            System.out.print("Enter operation (+, -, *, /): ");
            String opSymbol = scanner.next();

            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();

            Operation operation = Operation.fromSymbol(opSymbol);
            if (operation == null) {
                throw new IllegalArgumentException("Invalid operator: " + opSymbol);
            }

            double result = calculator.calculate(a, b, operation);
            System.out.println("Result: " + result);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

/**
 * Calculator interface defining arithmetic operations.
 */
interface Calculator {

    /**
     * Calculates a result based on the given operands and operation.
     *
     * @param a  first operand
     * @param b  second operand
     * @param op arithmetic operation to perform
     * @return result of the calculation
     * @throws IllegalArgumentException if operation is invalid (e.g., division by zero)
     */
    double calculate(double a, double b, Operation op);
}

/**
 * Basic implementation of the Calculator interface.
 * Supports addition, subtraction, multiplication, and division.
 */
class BasicCalculator implements Calculator {

    /**
     * Performs calculation based on the given operation.
     *
     * @param a  first operand
     * @param b  second operand
     * @param op arithmetic operation
     * @return result of the calculation
     * @throws IllegalArgumentException if division by zero occurs or operation is unknown
     */
    @Override
    public double calculate(double a, double b, Operation op) {
        switch (op) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operation: " + op);
        }
    }
}

/**
 * Enum representing supported arithmetic operations.
 */
enum Operation {

    /** Addition operation. */
    ADD("+"),

    /** Subtraction operation. */
    SUBTRACT("-"),

    /** Multiplication operation. */
    MULTIPLY("*"),

    /** Division operation. */
    DIVIDE("/");

    private final String symbol;

    /**
     * Constructor to assign symbol to the enum.
     *
     * @param symbol operator symbol as a string
     */
    Operation(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Gets the symbol representing the operation.
     *
     * @return operator symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Converts a string symbol to the corresponding Operation enum.
     *
     * @param symbol operator symbol as string
     * @return matching Operation enum, or null if no match
     */
    public static Operation fromSymbol(String symbol) {
        for (Operation op : Operation.values()) {
            if (op.getSymbol().equals(symbol)) {
                return op;
            }
        }
        return null;
    }
}
