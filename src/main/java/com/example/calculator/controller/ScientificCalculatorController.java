package com.example.calculator.controller;

import com.example.calculator.dto.ScientificRequestDTO;
import com.example.calculator.facade.ScientificCalculatorFacade;
import com.example.calculator.model.ScientificResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/scientific")
@RequestMapping("/api/calculator")
public class ScientificCalculatorController {

    private final ScientificCalculatorFacade scientificCalculatorFacade;

    public ScientificCalculatorController(ScientificCalculatorFacade scientificCalculatorFacade) {
        this.scientificCalculatorFacade = scientificCalculatorFacade;
    }

    @PostMapping("/scientific")
    public ResponseEntity<ScientificResponse> evaluateExpression(@RequestBody ScientificRequestDTO dto) {
        double result = scientificCalculatorFacade.evaluateExpression(dto);
        ScientificResponse response = new ScientificResponse();
        response.setResult(result);
        return ResponseEntity.ok(response);
    }
}

