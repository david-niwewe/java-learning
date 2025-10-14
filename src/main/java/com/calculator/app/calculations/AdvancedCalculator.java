package com.calculator.app.calculations;

/**
 * Advanced calculator extends ScientificCalculator.
 * Adds more complex mathematical operations.
 */
public class AdvancedCalculator extends ScientificCalculator {

    /**
     * Handles advanced operations like factorial, fibonacci, GCD, LCM.
     *
     * @param a first operand
     * @param b second operand (optional)
     * @param op operation
     * @return result
     */
    public double calculateAdvanced(double a, double b, EOperation op) {
        switch (op) {
            case FACTORIAL:
                if (a < 0 || a != (int) a)
                    throw new IllegalArgumentException("Factorial requires a non-negative integer.");
                return factorial((int) a);
            case FIBONACCI:
                if (a < 0 || a != (int) a)
                    throw new IllegalArgumentException("Fibonacci requires a non-negative integer.");
                return fibonacci((int) a);
            case GCD:
                return gcd((int) a, (int) b);
            case LCM:
                return lcm((int) a, (int) b);
            default:
                throw new IllegalArgumentException("Unknown advanced operation: " + op);
        }
    }

    private long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    private long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
