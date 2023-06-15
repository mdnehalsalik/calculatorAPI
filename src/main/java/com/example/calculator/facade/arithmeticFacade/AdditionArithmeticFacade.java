package com.example.calculator.facade.arithmeticFacade;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdditionArithmeticFacade {

    public double processAddition(List<Double> values) {
        return values.stream().mapToDouble(Double::doubleValue).sum();
    }
}
