package com.dev.cinema.exception;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
