package com.app.exception;



public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    // Constructor that accepts a message
    public ResourceNotFoundException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
