package com.example.calculator.serviceimpl;

import com.example.calculator.dto.AccountsRequestDTO;
import com.example.calculator.service.AccountsCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class AccountsCalculatorServiceImpl implements AccountsCalculatorService {

    @Override
    public double calculateSimpleInterest(AccountsRequestDTO requestDTO) {
        double principal = requestDTO.getPrincipal();
        double rate = requestDTO.getRate();
        double time = requestDTO.getTime();

        return (principal * rate * time) / 100;
    }
}


