package com.example.calculator.dto;

import com.example.calculator.utils.LoggerUtil;
import org.slf4j.Logger;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ArithmeticRequestDTO {

    @NotNull(message = "Operation cannot be null")
    private String operation;

    @NotEmpty(message = "Values array cannot be empty")
    private List<@NotNull(message = "Values array cannot contain null elements") Double> values;

    private static final Logger logger = LoggerUtil.getLogger();

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        if (operation == null) {
            logger.error("Operation cannot be null");
        }
        this.operation = operation;
    }

    public List<Double> getValues() {
        return values;
    }

    public void setValues(List<Double> values) {
        if (values == null || values.isEmpty()) {
            logger.error("Values array cannot be empty");
        }
        for (Double value : values) {
            if (value == null) {
                logger.error("Values array cannot contain null elements");
            }
        }
        this.values = values;
    }
}
