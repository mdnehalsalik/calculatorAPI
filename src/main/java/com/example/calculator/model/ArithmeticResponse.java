package com.example.calculator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

public class ArithmeticResponse {
    private double result;

    @JsonInclude(JsonInclude.Include.NON_NULL) // Include only if not null
    private List<String> errors;

    @JsonInclude(JsonInclude.Include.NON_NULL) // Include only if not null
    private List<Exception> exceptions;

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<Exception> getExceptions() {
        return exceptions;
    }

    public void setExceptions(List<Exception> exceptions) {
        this.exceptions = exceptions;
    }
}


