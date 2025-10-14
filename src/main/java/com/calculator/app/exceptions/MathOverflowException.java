package com.calculator.app.exceptions;

public class MathOverflowException extends InvalidOperationException{
    public MathOverflowException(String message) {
        super(message);
    }
}
