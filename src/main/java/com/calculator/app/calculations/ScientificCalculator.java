package com.calculator.app.calculations;

/**
 * Scientific calculator extends BasicCalculator.
 * Adds scientific operations on top of basic ones.
 */
public class ScientificCalculator extends BasicCalculator {

    /**
     * Handles scientific operations.
     *
     * @param a  first operand
     * @param b  second operand (optional)
     * @param op operation
     * @return calculation result
     */
    public double calculateScientific(double a, double b, EOperation op) {
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

