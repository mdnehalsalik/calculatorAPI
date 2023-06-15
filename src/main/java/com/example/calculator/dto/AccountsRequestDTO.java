package com.example.calculator.dto;

import com.example.calculator.utils.LoggerUtil;
import org.slf4j.Logger;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    private static final Logger logger = LoggerUtil.getLogger();

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
        return
                timePeriod;
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
}

