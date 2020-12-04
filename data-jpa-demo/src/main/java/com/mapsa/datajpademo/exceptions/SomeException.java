package com.mapsa.datajpademo.exceptions;

public class SomeException extends RuntimeException {
    public SomeException() {
        super();
    }

    public SomeException(String message) {
        super(message);
    }

    public SomeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SomeException(Throwable cause) {
        super(cause);
    }
}
