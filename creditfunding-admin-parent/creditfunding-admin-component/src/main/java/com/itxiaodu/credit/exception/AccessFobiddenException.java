package com.itxiaodu.credit.exception;

public class AccessFobiddenException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AccessFobiddenException() {
        super();
    }

    public AccessFobiddenException(String message) {
        super(message);
    }

    public AccessFobiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessFobiddenException(Throwable cause) {
        super(cause);
    }

    protected AccessFobiddenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
