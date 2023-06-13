package com.example.calculator.service;

import com.example.calculator.dto.AccountsRequestDTO;

public interface AccountsCalculatorService {
    double calculateSimpleInterest(AccountsRequestDTO requestDTO);
}
