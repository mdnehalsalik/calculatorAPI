package com.example.calculator.validation;

import com.example.calculator.dto.ArithmeticRequestDTO;
import com.example.calculator.dto.ScientificRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneralRequestValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralRequestValidator.class);

    @Override
    public void validate(Object requestDTO) {
        List<Double> values = new ArrayList<>();
        if(requestDTO instanceof ArithmeticRequestDTO) {
            values = ((ArithmeticRequestDTO) requestDTO).getValues();
        }
        else if(requestDTO instanceof ScientificRequestDTO) {
            List<String> expression = ((ScientificRequestDTO) requestDTO).getExpression();
            if (expression != null) {
                for (char c : expression.get(0).toCharArray()) {
                    if (Character.isDigit(c)) {
                        values.add((double) Character.getNumericValue(c));
                    }
                }
            }
        }
        // assuming values field is a List of Doubles in all DTOs
        for (Double value : values) {
            if (value.intValue() == value) {
                continue;
            }
            LOGGER.error("values can only contain integers or floats");
            throw new IllegalArgumentException("values can only contain integers or floats");
        }
    }
}
