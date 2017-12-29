package com.jackfrank.exception;

/**
 * Created by jack on 17-12-27.
 */
public class ExpensesException extends Exception{
    private static final long serialVersionUID = 1L;

    public ExpensesException() {
        //Construtor padrao
    }

    public ExpensesException(final String message) {
        super(message);
    }

    public ExpensesException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ExpensesException(final Throwable cause) {
        super(cause);
    }
}
