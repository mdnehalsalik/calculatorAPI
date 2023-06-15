package com.example.calculator.facade.arithmeticFacade;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DivisionArithmeticFacade {

    public double processDivision(List<Double> values) {
        double result = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            double divisor = values.get(i);
            if (divisor == 0) {
                throw new IllegalArgumentException("Division by zero is not allowed.");
            }
            result /= divisor;
        }
        return result;
    }
}
