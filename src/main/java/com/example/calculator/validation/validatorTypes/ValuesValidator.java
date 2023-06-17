package com.example.calculator.validation.validatorTypes;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValuesValidator {
    private static final String VALUES_FIELD = "values";

    public void arithmeticValuesValidate(List<Double> values, List<String> validationErrors, String operation) {
        if (operation.equals("div")) {
            if (values.size() != 2) {
                validationErrors.add("[Values issue] For division operation, the values list must contain exactly 2 elements.");
            } else {
                double divisor = values.get(1);
                if (divisor == 0) {
                    validationErrors.add("[Values issue] Division by zero is not allowed.");
                }
            }
        }

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

    public void scientificExpressionValidate(List<String> expression, List<String> validationErrors) {
        if (expression == null || expression.isEmpty()) {
            validationErrors.add("[Expression issue] Expression list cannot be null or empty");
            return;
        }

        if (expression.size() != 1) {
            validationErrors.add("[Expression issue] Expression list must contain exactly one element");
            return;
        }

        String exp = expression.get(0);

        // Validate the expression
        Pattern pattern = Pattern.compile("[0-9.()+\\-*/\\s]+");
        Matcher matcher = pattern.matcher(exp);

        if (!matcher.matches()) {
            validationErrors.add("[Expression issue] Invalid characters in the expression");
            return;
        }

        int openBracketCount = 0;
        int closeBracketCount = 0;

        for (char c : exp.toCharArray()) {
            if (c == '(') {
                openBracketCount++;
            } else if (c == ')') {
                closeBracketCount++;
            }
        }

        if (openBracketCount != closeBracketCount) {
            validationErrors.add("[Expression issue] Unbalanced brackets in the expression");
        }
    }

    private boolean isNumeric(double value) {
        return true; // All values are considered valid in this example
    }
}
