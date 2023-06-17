package com.example.calculator.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class ScientificRequestDTO {

    @Valid
    @NotNull(message = "Expression inside a list is required")
    @NotEmpty(message = "Expression list cannot be empty")
    @Size(max = 1, message = "Expression list can only contain one element")
    private List<String> expression;

    @NotNull(message = "Operation cannot be null")
    private String operation;

    private List<String> errors; // Field to store validation errors
    private List<Exception> exceptions; // Field to store exceptions

    @JsonCreator
    public ScientificRequestDTO(
            @JsonProperty("expression") List<String> expression,
            @JsonProperty("operation") String operation) {
        this.expression = expression;
        this.operation = operation;
        this.errors = new ArrayList<>();
        this.exceptions = new ArrayList<>();
    }

    public List<String> getExpression() {
        return expression;
    }

    public void setExpression(List<String> expression) {
        this.expression = expression;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
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
