package com.calculator.app.history;

import com.calculator.app.core.EOperation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Nested class representing a single history entry.
 */
public class HistoryRecord {
    private final double a;
    private final double b;
    private final EOperation operation;
    private final double result;
    private final LocalDateTime timestamp;

    public HistoryRecord(double a, double b, EOperation operation, double result) {
        this.a = a;
        this.b = b;
        this.operation = operation;
        this.result = result;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = timestamp.format(formatter);

        if (operation.requiresSecondOperand()) {
            return String.format("[%s] %.4f %s %.4f = %.4f",
                    time, a, operation.getSymbol(), b, result);
        } else {
            return String.format("[%s] %s(%.4f) = %.4f",
                    time, operation.getSymbol(), a, result);
        }
    }
}