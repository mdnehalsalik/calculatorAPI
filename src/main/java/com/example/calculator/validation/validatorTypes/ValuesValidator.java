package com.example.calculator.validation.validatorTypes;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValuesValidator {
    private static final String VALUES_FIELD = "values";

    public void arithmeticValuesValidate(List<Double> values, List<String> validationErrors) {
        for (Double value : values) {
            if (!isNumeric(value)) {
                validationErrors.add("[Numeric issue] Values can only contain numbers");
                break; // Stop further validation if a non-numeric value is found
            }
        }
    }

    public void accountsValuesValidate(Double principal, Double interestRate, Integer timePeriod, List<String> validationErrors) {
        if (principal == null || principal <= 0) {
            validationErrors.add("[Principal issue] Principal must be a positive number");
        }
        if (interestRate == null || interestRate < 1 || interestRate > 100) {
            validationErrors.add("[Interest Rate issue] Interest Rate must be between 1 and 100");
        }
        if (timePeriod == null || timePeriod <= 0) {
            validationErrors.add("[Time issue] Time Period must be a positive number");
        }
    }

    private boolean isNumeric(double value) {
        return true; // All values are considered valid in this example
    }
}
