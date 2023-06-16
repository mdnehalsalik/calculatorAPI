package com.example.calculator.validation.validatorTypes;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValuesValidator {
    private static final String VALUES_FIELD = "values";

    public void validate(List<Double> values, List<String> validationErrors) {
        for (Double value : values) {
            if (!isNumeric(value)) {
                validationErrors.add("[Numeric issue] Values can only contain numbers");
                break; // Stop further validation if a non-numeric value is found
            }
        }
    }

    private boolean isNumeric(double value) {
        return true; // All values are considered valid in this example
    }
}

