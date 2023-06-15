package com.example.calculator.dto;

import com.example.calculator.utils.LoggerUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ArithmeticRequestDTO {

    @NotNull(message = "Operation cannot be null")
    private final String operation;

    @NotEmpty(message = "Values array cannot be empty")
    private final List<@NotNull(message = "Values array cannot contain null elements") Double> values;

    private static final Logger logger = LoggerUtil.getLogger();

    @JsonCreator
    public ArithmeticRequestDTO(@JsonProperty("operation") String operation,
                                @JsonProperty("values") List<Double> values) {
        if (operation == null) {
            logger.error("Operation cannot be null");
            throw new IllegalArgumentException("Operation cannot be null");
        }

        if (values == null || values.isEmpty()) {
            logger.error("Values array cannot be empty");
            throw new IllegalArgumentException("Values array cannot be empty");
        }

        for (Double value : values) {
            if (value == null) {
                logger.error("Values array cannot contain null elements");
                throw new IllegalArgumentException("Values array cannot contain null elements");
            }
        }

        this.operation = operation;
        this.values = values;
    }

    public String getOperation() {
        return operation;
    }

    public List<Double> getValues() {
        return values;
    }
}
