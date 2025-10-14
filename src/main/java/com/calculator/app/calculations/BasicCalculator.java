package com.calculator.app.calculations;

public class BasicCalculator implements ICalculator{
    @Override
    public double calculate(double a, double b, EOperation op) {
        switch (op) {
            case ADD: return a + b;
            case SUBTRACT: return a - b;
            case MULTIPLY: return a * b;
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
