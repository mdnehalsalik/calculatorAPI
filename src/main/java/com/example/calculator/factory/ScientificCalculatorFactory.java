package com.example.calculator.factory;

import com.example.calculator.service.ScientificCalculatorService;
import com.example.calculator.serviceimpl.ScientificCalculatorServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class ScientificCalculatorFactory {

    public ScientificCalculatorService createService() {
        return new ScientificCalculatorServiceImpl();
    }
}
