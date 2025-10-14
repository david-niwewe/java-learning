package com.calculator.app.exceptions;

public class DivisionByZeroException extends InvalidOperationException{
    public DivisionByZeroException(String message) {
        super(message);
    }
}
