package com.example.calculator.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class ArithmeticRequestDTO {

    @NotNull(message = "Operation cannot be null")
    private final String operation;

    @Valid
    @NotEmpty(message = "Values array cannot be empty")
    @Size(min = 1, message = "Values array must contain at least one element")
    private final List<@NotNull(message = "Values array cannot contain null elements") Double> values;

    private List<String> errors; // Field to store validation errors
    private List<Exception> exceptions; // Field to store exceptions

    @JsonCreator
    public ArithmeticRequestDTO(
            @JsonProperty("operation") String operation,
            @JsonProperty("values") List<Double> values) {
        this.operation = operation;
        this.values = values;
        this.errors = new ArrayList<>();
        this.exceptions = new ArrayList<>();
    }

    public String getOperation() {

        return operation;
    }

    public List<Double> getValues() {

        return values;
    }

    public List<String> getErrors() {   // Q - Why it says never used

        return errors;
    }

    public void setErrors(List<String> errors) {

        this.errors = errors;
    }

    public List<Exception> getExceptions() {  // Q - Why it says never used

        return exceptions;
    }

    public void setExceptions(List<Exception> exceptions) {

        this.exceptions = exceptions;
    }
}
