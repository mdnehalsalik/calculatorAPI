package com.example.calculator.facade;

import com.example.calculator.dto.ScientificRequestDTO;
import com.example.calculator.service.ScientificCalculatorService;
import org.springframework.stereotype.Component;

@Component
public class ScientificCalculatorFacade {

    private final ScientificCalculatorService scientificCalculatorService;

    public ScientificCalculatorFacade(ScientificCalculatorService scientificCalculatorService) {
        this.scientificCalculatorService = scientificCalculatorService;
    }

    public double evaluateExpression(ScientificRequestDTO dto) {
        return scientificCalculatorService.evaluateExpression(dto.getExpression());
    }
}
