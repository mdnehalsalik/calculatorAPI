package com.example.calculator.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.calculator.utils.LoggerUtil;
import org.slf4j.Logger;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class AccountsRequestDTO {
    @NotNull(message = "Principal amount is required")
    private Double principal;

    @NotNull(message = "Interest rate is required")
    private Double interestRate;

    @NotNull(message = "Time period is required")
    private Integer timePeriod;

    @NotNull(message = "Operation cannot be null")
    private String operation;

    private List<String> errors; // Field to store validation errors
    private List<Exception> exceptions; // Field to store exceptions

    private static final Logger logger = LoggerUtil.getLogger();

    @JsonCreator
    public AccountsRequestDTO(
            @JsonProperty("principal") Double principal,
            @JsonProperty("interestRate") Double interestRate,
            @JsonProperty("timePeriod") Integer timePeriod,
            @JsonProperty("operation") String operation) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.timePeriod = timePeriod;
        this.operation = operation;
        this.errors = new ArrayList<>();
        this.exceptions = new ArrayList<>();
    }

    // Getters and setters

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public Double getRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getTime() {
        return timePeriod;
    }

    public void setTimePeriod(Integer timePeriod) {
        this.timePeriod = timePeriod;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        if (operation == null) {
            logger.error("Operation cannot be null");
        }
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
