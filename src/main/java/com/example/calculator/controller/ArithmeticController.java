package com.example.calculator.controller;

import com.example.calculator.dto.ArithmeticRequestDTO;
import com.example.calculator.model.ArithmeticResponse;
import com.example.calculator.service.ArithmeticService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/calculator")
public class ArithmeticController {

    private final ArithmeticService arithmeticService;

    public ArithmeticController(ArithmeticService arithmeticService) {

        this.arithmeticService = arithmeticService;
    }

    @PostMapping("/arithmetic")
    public ResponseEntity<ArithmeticResponse> performArithmeticOperation(
            @Valid @RequestBody ArithmeticRequestDTO requestDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            //throw new IllegalArgumentException("");
            return ResponseEntity.badRequest().build();
        }

        double result = arithmeticService.performOperation(requestDTO);
        ArithmeticResponse response = new ArithmeticResponse();
        response.setResult(result);
        return ResponseEntity.ok(response);
    }
}

