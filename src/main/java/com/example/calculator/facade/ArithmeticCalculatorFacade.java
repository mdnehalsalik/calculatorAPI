package com.example.calculator.facade;

import com.example.calculator.dto.ArithmeticRequestDTO;
import com.example.calculator.service.ArithmeticCalculatorService;
import org.springframework.stereotype.Component;

@Component
public class ArithmeticCalculatorFacade {

    private final ArithmeticCalculatorService arithmeticCalculatorService;

    public ArithmeticCalculatorFacade(ArithmeticCalculatorService arithmeticCalculatorService) {
        this.arithmeticCalculatorService = arithmeticCalculatorService;
    }

    public double performOperation(ArithmeticRequestDTO dto) {
        switch (dto.getOperation()) {
            case "add":
                return arithmeticCalculatorService.add(dto.getValue1(), dto.getValue2());
            case "subtract":
                return arithmeticCalculatorService.subtract(dto.getValue1(), dto.getValue2());
            case "multiply":
                return arithmeticCalculatorService.multiply(dto.getValue1(), dto.getValue2());
            case "divide":
                return arithmeticCalculatorService.divide(dto.getValue1(), dto.getValue2());
            default:
                throw new IllegalArgumentException("Invalid operation: " + dto.getOperation());
        }
    }
}

