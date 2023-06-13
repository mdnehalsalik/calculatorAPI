package com.example.calculator.facade;

import com.example.calculator.dto.AccountsRequestDTO;
import com.example.calculator.factory.AccountsCalculatorFactory;
import com.example.calculator.service.AccountsCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsCalculatorFacade {
    @Autowired
    private AccountsCalculatorFactory factory;

    public double calculateSimpleInterest(AccountsRequestDTO requestDTO) {
        AccountsCalculatorService service = factory.createService();
        return service.calculateSimpleInterest(requestDTO);
    }
}
