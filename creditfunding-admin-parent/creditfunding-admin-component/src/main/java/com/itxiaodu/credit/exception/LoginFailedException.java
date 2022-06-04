package com.itxiaodu.credit.exception;

/*
@Function:登录失败异常
 */
public class LoginFailedException extends RuntimeException {
    public LoginFailedException() {
        super();
    }
    private static final long serialVersionUID=1L;

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    protected LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
