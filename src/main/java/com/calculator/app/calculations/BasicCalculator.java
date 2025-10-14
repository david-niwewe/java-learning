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
            case FACTORIAL:
            case FIBONACCI:
            case GCD:
            case LCM:
                return ((AdvancedCalculator) this).calculateAdvanced(a, b, op);
            default:
                if (this instanceof ScientificCalculator) {
                   return ((ScientificCalculator) this).calculateScientific(a, b, op);
                }
                throw new IllegalArgumentException("Unknown operation: " + op);
        }
    }
}
