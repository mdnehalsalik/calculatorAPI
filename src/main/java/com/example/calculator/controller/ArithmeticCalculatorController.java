package com.example.calculator.controller;

import com.example.calculator.dto.ArithmeticRequestDTO;
import com.example.calculator.facade.ArithmeticCalculatorFacade;
import com.example.calculator.model.ArithmeticResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class ArithmeticCalculatorController {

    private final ArithmeticCalculatorFacade arithmeticCalculatorFacade;

    public ArithmeticCalculatorController(ArithmeticCalculatorFacade arithmeticCalculatorFacade) {
        this.arithmeticCalculatorFacade = arithmeticCalculatorFacade;
    }

    @PostMapping("/arithmetic")
    public ResponseEntity<ArithmeticResponse> performOperation(@RequestBody ArithmeticRequestDTO dto) {
        double result = arithmeticCalculatorFacade.performOperation(dto);
        ArithmeticResponse response = new ArithmeticResponse();
        response.setResult(result);
        return ResponseEntity.ok(response);
    }
}

