package com.example.calculator.exception;


import java.util.List;

public class HttpErrorResponse {
    private int statusCode;
    private String message;
    private List<String> errors;

    public HttpErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        this.errors = errors;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}

