package com.calculator.app;

import com.calculator.app.core.AdvancedCalculator;
import com.calculator.app.core.EOperation;
import com.calculator.app.core.ICalculator;
import com.calculator.app.exceptions.InvalidOperationException;
import com.calculator.app.history.HistoryManager;

import java.util.Scanner;

/**
 * Entry point for the CLI Calculator application.
 * ScientificCalculator extends BasicCalculator, so all operations are available.
 */
public class CalculatorApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ICalculator calculator = new AdvancedCalculator();
        HistoryManager history = new HistoryManager();

        System.out.println("=== CLI Scientific Calculator ===");

        boolean running = true;
        while (running) {
            try {
                double a = readNumber(scanner, "Enter first number: ");
                String opSymbol = readOperation(scanner);
                EOperation operation = EOperation.fromSymbol(opSymbol);

                double b = 0;
                assert operation != null;
                if (operation.requiresSecondOperand()) {
                    b = readNumber(scanner, "Enter second number: ");
                }

                double result = calculator.calculate(a, b, operation);
                System.out.println("Result: " + result);
                history.addRecord(a, b, operation, result);

            } catch (InvalidOperationException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("\nPerform another calculation? (y/n): ");
            char cont = scanner.next().toLowerCase().charAt(0);
            if (cont != 'y') {
                running = false;
            }
        }

        System.out.print("\nDo you want to view calculation history? (y/n): ");
        char view = scanner.next().toLowerCase().charAt(0);
        if (view == 'y') {
            history.displayHistory();
        }

        System.out.print("Clear history? (y/n): ");
        if (scanner.next().toLowerCase().charAt(0) == 'y') {
            history.clearHistory();
        }

        System.out.println("Calculator closed.");
        scanner.close();
    }

    private static double readNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    private static String readOperation(Scanner scanner) {
        while (true) {
            System.out.print("Enter operation (+, -, *, /, ^, sqrt, sin, cos, tan, factorial, fibonacci, gcd, lcm): ");
            String input = scanner.next();
            if (EOperation.fromSymbol(input) != null) {
                return input;
            } else {
                System.out.println("Invalid operation. Please enter a valid operator.");
            }
        }
    }
}

