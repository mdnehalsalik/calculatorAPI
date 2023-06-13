package com.example.calculator.controller;

import com.example.calculator.dto.AccountsRequestDTO;
import com.example.calculator.facade.AccountsCalculatorFacade;
import com.example.calculator.model.AccountsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/calculator")
public class AccountsCalculatorController {
    @Autowired
    private AccountsCalculatorFacade accountsCalculatorFacade;

    @PostMapping("/accounts")
    public ResponseEntity<AccountsResponse> calculateSimpleInterest(
            @Valid @RequestBody AccountsRequestDTO requestDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return ResponseEntity.badRequest().build();
        }
        double interest = accountsCalculatorFacade.calculateSimpleInterest(requestDTO);
        AccountsResponse response = new AccountsResponse();
        response.setSimpleInterest(interest);
        return ResponseEntity.ok(response);
    }
    // Similarly, you can inject and use other facades like ArithmeticCalculatorFacade, ScientificCalculatorFacade, etc.
}
