package com.example.calculator.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ArithmeticRequestDTO {

    @NotNull(message = "Operation cannot be null")
    private final String operation;

    @NotEmpty(message = "Values array cannot be empty")
    private final List<@NotNull(message = "Values array cannot contain null elements") Double> values;

    @JsonCreator
    public ArithmeticRequestDTO(
            @JsonProperty("operation") String operation,
            @JsonProperty("values") List<Double> values) {
        this.operation = operation;
        this.values = values;
    }

    public String getOperation() {
        return operation;
    }

    public List<Double> getValues() {
        return values;
    }
}
