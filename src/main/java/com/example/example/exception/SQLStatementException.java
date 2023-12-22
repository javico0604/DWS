package com.example.example.exception;

public class SQLStatementException extends RuntimeException{
    private static final String DESCRIPTION = "Error executing SQL statement";

    public SQLStatementException(String message) {
        super(DESCRIPTION + ". " + message);
    }
}
