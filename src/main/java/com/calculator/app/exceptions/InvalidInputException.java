package com.calculator.app.exceptions;

public class InvalidInputException extends InvalidOperationException{
    public InvalidInputException(String message) {
        super(message);
    }
}
