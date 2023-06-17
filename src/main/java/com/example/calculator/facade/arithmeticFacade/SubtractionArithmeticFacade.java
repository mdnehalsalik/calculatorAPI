package com.example.calculator.facade.arithmeticFacade;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubtractionArithmeticFacade {

    public double processSubtraction(List<Double> values) {
        double result = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            result -= values.get(i);
        }
        return result;
    }
}
