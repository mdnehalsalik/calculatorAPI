package com.example.calculator.dto;

import com.example.calculator.utils.LoggerUtil;
import org.slf4j.Logger;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ScientificRequestDTO {

    @NotNull(message = "Expression inside a list is required")
    private List<String> expression;

    @NotNull(message = "Operation cannot be null")
    private String operation;

    private static final Logger logger = LoggerUtil.getLogger();

    public @NotNull(message = "Expression inside a list is required") List<String> getExpression() {

        return expression;
    }

    public void setExpression(@NotNull(message = "Expression inside a list is required") List<String> expression) {

        this.expression = expression;
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



