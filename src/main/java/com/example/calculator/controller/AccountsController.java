package com.example.calculator.controller;

import com.example.calculator.dto.AccountsRequestDTO;
import com.example.calculator.exception.ErrorResponse;
import com.example.calculator.exception.ValidationException;
import com.example.calculator.model.AccountsResponse;
import com.example.calculator.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calculator")
public class AccountsController {

    private final AccountsService accountsService;

    @Autowired
    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @PostMapping("/accounts")
    public ResponseEntity<Object> performAccountsOperation(
            @Valid @RequestBody AccountsRequestDTO requestDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(new ErrorResponse(errors));
        }

        try {
            double result = accountsService.performOperation(requestDTO);

            AccountsResponse response = new AccountsResponse();
            response.setResult(result);

            return ResponseEntity.ok(response);

        } catch (ValidationException ex) {
            return ResponseEntity.badRequest().body(new ErrorResponse(ex.getValidationErrors()));
        } catch (HttpMessageNotReadableException ex) {
            List<String> errors = new ArrayList<>();
            errors.add("Invalid request payload");
            return ResponseEntity.badRequest().body(new ErrorResponse(errors));
        }
    }
}
