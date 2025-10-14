package com.calculator.app.core;

import com.calculator.app.exceptions.InvalidOperationException;

public interface ICalculator {
    /**
     * Calculate result based on operation.
     *
     * @param a first operand
     * @param b second operand (optional for unary)
     * @param op operation to perform
     * @return result
     * @throws IllegalArgumentException for invalid operations
     *
     * @author David NIWEWE
     */
    double calculate(double a, double b, EOperation op) throws InvalidOperationException;
}
