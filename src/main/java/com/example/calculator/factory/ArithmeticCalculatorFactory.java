package com.example.calculator.factory;

import com.example.calculator.service.ArithmeticCalculatorService;
import com.example.calculator.service.ArithmeticCalculatorServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class ArithmeticCalculatorFactory {

    public ArithmeticCalculatorService createService() {
        return new ArithmeticCalculatorServiceImpl();
    }
}

