import java.util.Scanner;

import java.util.Scanner;

/**
 * Entry point for the CLI Calculator application.
 * ScientificCalculator extends BasicCalculator, so all operations are available.
 */
public class CalculatorApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new ScientificCalculator(); // Unified calculator

        System.out.println("=== CLI Scientific Calculator ===");

        boolean running = true;
        while (running) {
            try {
                // Validate first number
                double a = readNumber(scanner, "Enter first number: ");

                // Validate operation symbol
                String opSymbol = readOperation(scanner, "Enter operation (e.g., +, -, *, /, ^, % , sqrt, sin, cos, tan): ");
                Operation operation = Operation.fromSymbol(opSymbol);

                double b = 0;
                if (operation.requiresSecondOperand()) {
                    b = readNumber(scanner, "Enter second number: ");
                }

                double result = calculator.calculate(a, b, operation);
                System.out.println("Result: " + result);

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Ask user whether to continue
            System.out.print("\nPerform another calculation? (y/n): ");
            char cont = scanner.next().toLowerCase().charAt(0);
            if (cont != 'y') {
                running = false;
            }
        }

        System.out.println("Calculator closed.");
        scanner.close();
    }

    /**
     * Reads and validates a double number from the user.
     */
    private static double readNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // discard invalid input
            }
        }
    }

    /**
     * Reads and validates an operation symbol from the user.
     */
    private static String readOperation(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next();
            if (Operation.fromSymbol(input) != null) {
                return input;
            } else {
                System.out.println("Invalid operation. Please enter a valid operator.");
            }
        }
    }
}

/**
 * Calculator interface defining arithmetic operations.
 */
interface Calculator {
    /**
     * Calculate result based on operation.
     *
     * @param a first operand
     * @param b second operand (optional for unary)
     * @param op operation to perform
     * @return result
     * @throws IllegalArgumentException for invalid operations
     */
    double calculate(double a, double b, Operation op);
}

/**
 * Basic calculator implementation.
 */
class BasicCalculator implements Calculator {

    @Override
    public double calculate(double a, double b, Operation op) {
        switch (op) {
            case ADD: return a + b;
            case SUBTRACT: return a - b;
            case MULTIPLY: return a * b;
            case MODULUS: return a % b;
            case DIVIDE:
                if (b == 0) throw new IllegalArgumentException("Division by zero is not allowed.");
                return a / b;
            default:
                // Delegate unknown operations to subclass if applicable
                if (this instanceof ScientificCalculator) {
                    return ((ScientificCalculator) this).calculateScientific(a, b, op);
                }
                throw new IllegalArgumentException("Unknown operation: " + op);
        }
    }
}

/**
 * Scientific calculator extends BasicCalculator.
 * Adds scientific operations on top of basic ones.
 */
class ScientificCalculator extends BasicCalculator {

    /**
     * Handles scientific operations.
     *
     * @param a  first operand
     * @param b  second operand (optional)
     * @param op operation
     * @return calculation result
     */
    public double calculateScientific(double a, double b, Operation op) {
        switch (op) {
            case POWER: return Math.pow(a, b);
            case SQRT: return Math.sqrt(a);
            case SIN: return Math.sin(Math.toRadians(a));
            case COS: return Math.cos(Math.toRadians(a));
            case TAN: return Math.tan(Math.toRadians(a));
            default:
                throw new IllegalArgumentException("Unknown scientific operation: " + op);
        }
    }
}

/**
 * Enum representing all supported operations.
 */
enum Operation {
    // Basic operations
    ADD("+", true),
    SUBTRACT("-", true),
    MULTIPLY("*", true),
    DIVIDE("/", true),
    MODULUS("%",true),

    // Scientific operations
    POWER("^", true),
    SQRT("sqrt", false),
    SIN("sin", false),
    COS("cos", false),
    TAN("tan", false);

    private final String symbol;
    private final boolean requiresSecondOperand;

    Operation(String symbol, boolean requiresSecondOperand) {
        this.symbol = symbol;
        this.requiresSecondOperand = requiresSecondOperand;
    }

    public String getSymbol() { return symbol; }

    public boolean requiresSecondOperand() { return requiresSecondOperand; }

    public static Operation fromSymbol(String symbol) {
        for (Operation op : values()) {
            if (op.symbol.equals(symbol)) return op;
        }
        return null;
    }
}
