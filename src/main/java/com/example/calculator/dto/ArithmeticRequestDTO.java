package com.example.calculator.dto;
import javax.validation.constraints.NotNull;

public class ArithmeticRequestDTO {

    @NotNull(message = "Operation is required")
    private String operation;

    @NotNull(message = "Value1 is required")
    private Double value1;

    @NotNull(message = "Value2 is required")
    private Double value2;

    // Getters and setters

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getValue1() {
        return value1;
    }

    public void setValue1(Double value1) {
        this.value1 = value1;
    }

    public Double getValue2() {
        return value2;
    }

    public void setValue2(Double value2) {
        this.value2 = value2;
    }
}










