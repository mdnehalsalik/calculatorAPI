package com.example.calculator.controller;

import com.example.calculator.dto.AccountsRequestDTO;
import com.example.calculator.model.AccountsResponse;
import com.example.calculator.service.AccountsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/calculator")
public class AccountsController {

    private final AccountsService accountsService;
    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @PostMapping("/accounts")
    public ResponseEntity<AccountsResponse> performAccountsOperation(
            @Valid @RequestBody AccountsRequestDTO requestDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return ResponseEntity.badRequest().build();
        }

        double result = accountsService.performOperation(requestDTO);
        AccountsResponse response = new AccountsResponse();
        response.setResult(result);
        return ResponseEntity.ok(response);

    }
}
