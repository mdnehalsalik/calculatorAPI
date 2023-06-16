package com.example.calculator.service;

import com.example.calculator.dto.AccountsRequestDTO;
import com.example.calculator.exception.ValidationException;
import com.example.calculator.factory.AccountsFactory;
import com.example.calculator.validation.GeneralRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

    private final AccountsFactory accountsFactory;
    private final GeneralRequestValidator generalRequestValidator;

    @Autowired
    public AccountsService(AccountsFactory accountsFactory, GeneralRequestValidator generalRequestValidator) {
        this.accountsFactory = accountsFactory;
        this.generalRequestValidator = generalRequestValidator;
    }

    public double performOperation(AccountsRequestDTO requestDTO) throws ValidationException {
        generalRequestValidator.validate(requestDTO);
        return accountsFactory.executeOperation(requestDTO);
    }
}
