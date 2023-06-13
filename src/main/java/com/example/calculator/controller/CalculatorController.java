package com.example.calculator.controller;


import com.example.calculator.dto.AccountsRequestDTO;
import com.example.calculator.dto.ArithmeticRequestDTO;
import com.example.calculator.dto.ScientificRequestDTO;
import com.example.calculator.model.AccountsResponse;
import com.example.calculator.model.ArithmeticResponse;
import com.example.calculator.model.ScientificResponse;
import com.example.calculator.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {

        this.calculatorService = calculatorService;
    }

    @PostMapping("/arithmetic")
    public ResponseEntity<ArithmeticResponse> performArithmeticOperation(
            @Valid @RequestBody ArithmeticRequestDTO requestDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return ResponseEntity.badRequest().build();
        }

        double result;
        switch (requestDTO.getOperation()) {
            case "add":
                result = calculatorService.add(requestDTO.getValue1(), requestDTO.getValue2());
                break;
            case "subtract":
                result = calculatorService.subtract(requestDTO.getValue1(), requestDTO.getValue2());
                break;
            case "multiply":
                result = calculatorService.multiply(requestDTO.getValue1(), requestDTO.getValue2());
                break;
            case "divide":
                result = calculatorService.divide(requestDTO.getValue1(), requestDTO.getValue2());
                break;
            default:
                return ResponseEntity.badRequest().build();
        }
        ArithmeticResponse response = new ArithmeticResponse();
        response.setResult(result);
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/scientific")
//    public ResponseEntity<ScientificResponse> performScientificOperation(
//            @Valid @RequestBody ScientificRequestDTO requestDTO, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            // Handle validation errors
//            return ResponseEntity.badRequest().build();
//        }
//        // Handle the scientific operation and return the response
//        double result = calculatorService.performScientificOperation(requestDTO);
//        ScientificResponse response = new ScientificResponse();
//        response.setResult(result);
//        return ResponseEntity.ok(response);
//    }

    @PostMapping("/scientific")
    public ResponseEntity<Object> performScientificOperation(
            @Valid @RequestBody ScientificRequestDTO requestDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return ResponseEntity.badRequest().build();
        }
        double result = calculatorService.evaluateExpression(requestDTO.getExpression());
        ScientificResponse response = new ScientificResponse();
        response.setResult(result);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/accounts")
    public ResponseEntity<Object> calculateSimpleInterest(
            @Valid @RequestBody AccountsRequestDTO requestDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return ResponseEntity.badRequest().build();
        }
        // Handle the accounts operation and return the response
        double interest = calculatorService.calculateSimpleInterest(requestDTO);
        AccountsResponse response = new AccountsResponse();
        response.setSimpleInterest(interest);
        return ResponseEntity.ok(response);
    }
}
