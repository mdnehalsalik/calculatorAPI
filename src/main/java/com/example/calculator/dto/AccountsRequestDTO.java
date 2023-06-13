package com.example.calculator.dto;

import javax.validation.constraints.NotNull;

public class AccountsRequestDTO {

    @NotNull(message = "Principal amount is required")
    private Double principal;

    @NotNull(message = "Interest rate is required")
    private Double interestRate;

    @NotNull(message = "Time period is required")
    private Integer timePeriod;

    // Getters and setters

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(Integer timePeriod) {
        this.timePeriod = timePeriod;
    }
}

