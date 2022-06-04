package com.itxiaodu.credit.exception;

public class AccountExistException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public AccountExistException() {
        super();
    }

    public AccountExistException(String message) {
        super(message);
    }

    public AccountExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountExistException(Throwable cause) {
        super(cause);
    }

    protected AccountExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
