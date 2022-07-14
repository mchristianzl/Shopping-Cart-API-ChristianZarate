package com.photon.exam.exception;

public class ShoppingCartException extends Exception {

    public ShoppingCartException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ShoppingCartException(final String message) {
        super(message);
    }
}
