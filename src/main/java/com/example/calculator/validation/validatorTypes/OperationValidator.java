package com.example.calculator.validation.validatorTypes;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationValidator {
    private static final String OPERATION_FIELD = "operation";

    public void validate(String operation, List<String> validationErrors) {
        if (operation == null || operation.trim().isEmpty()) {    // Not checking if the operation content is one of the case
            validationErrors.add("[Operation issue] Operation field is required");
        }
    }
}

