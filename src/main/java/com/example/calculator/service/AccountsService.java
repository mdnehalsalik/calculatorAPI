package com.example.calculator.service;

import com.example.calculator.dto.AccountsRequestDTO;
import com.example.calculator.dto.ArithmeticRequestDTO;
import com.example.calculator.factory.AccountsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

    private final AccountsFactory accountsFactory;

    @Autowired
    public AccountsService(AccountsFactory accountsFactory) {
        this.accountsFactory = accountsFactory;
    }

    public double performOperation(AccountsRequestDTO requestDTO) {
        return accountsFactory.executeOperation(requestDTO);
    }
}
