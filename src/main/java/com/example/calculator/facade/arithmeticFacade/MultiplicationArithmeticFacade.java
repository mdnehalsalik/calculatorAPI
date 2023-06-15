package com.example.calculator.facade.arithmeticFacade;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MultiplicationArithmeticFacade {

    public double processMultiplication(List<Double> values) {
        double result = 1;
        for (double value : values) {
            result *= value;
        }
        return result;
    }
}

