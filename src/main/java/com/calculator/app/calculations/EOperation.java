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
    TAN("tan", false),

    // Advanced operations
    FACTORIAL("factorial", false),
    FIBONACCI("fibonacci", false),
    GCD("gcd", true),
    LCM("lcm", true);

    private final String symbol;
    private final boolean requiresSecondOperand;

    EOperation(String symbol, boolean requiresSecondOperand) {
        this.symbol = symbol;
        this.requiresSecondOperand = requiresSecondOperand;
    }

    public boolean requiresSecondOperand() { return requiresSecondOperand; }

    public static EOperation fromSymbol(String symbol) {
        for (EOperation op : values()) {
            if (op.symbol.equals(symbol)) return op;
        }
        return null;
    }
}
