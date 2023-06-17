package com.example.calculator.validation.validatorTypes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class OperationValidator {

    @Value("${arithmetic.operations}")
    private String arithmeticOperations;

    @Value("${accounts.operations}")
    private String accountsOperations;

    @Value("${scientific.operations}")
    private String scientificOperations;

    public void validate(String operation, List<String> validationErrors) {
        if (operation == null || operation.trim().isEmpty()) {
            validationErrors.add("[Operation issue] Operation field is required");
        } else {
            List<String> validOperations = getAllValidOperations();
            if (!validOperations.contains(operation)) {
                validationErrors.add("[Operation issue] Invalid operation: " + operation + ", Check readme.md");
            }
        }
    }

    private List<String> getAllValidOperations() {
        List<String> arithmeticOps = Arrays.asList(arithmeticOperations.split(","));
        List<String> accountsOps = Arrays.asList(accountsOperations.split(","));
        List<String> scientificOps = Arrays.asList(scientificOperations.split(","));
        List<String> validOperations = new ArrayList<>();
        validOperations.addAll(arithmeticOps);
        validOperations.addAll(accountsOps);
        validOperations.addAll(scientificOps);
        return validOperations;
    }
}
