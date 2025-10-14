package com.calculator.app.calculations;

/**
 * Enum representing all supported operations.
 */
public enum EOperation {
    // Basic operations
    ADD("+", true),
    SUBTRACT("-", true),
    MULTIPLY("*", true),
    DIVIDE("/", true),

    // Scientific operations
    POWER("^", true),
    SQRT("sqrt", false),
    SIN("sin", false),
    COS("cos", false),
    TAN("tan", false);

    private final String symbol;
    private final boolean requiresSecondOperand;

    EOperation(String symbol, boolean requiresSecondOperand) {
        this.symbol = symbol;
        this.requiresSecondOperand = requiresSecondOperand;
    }

    public String getSymbol() { return symbol; }

    public boolean requiresSecondOperand() { return requiresSecondOperand; }

    public static EOperation fromSymbol(String symbol) {
        for (EOperation op : values()) {
            if (op.symbol.equals(symbol)) return op;
        }
        return null;
    }
}
