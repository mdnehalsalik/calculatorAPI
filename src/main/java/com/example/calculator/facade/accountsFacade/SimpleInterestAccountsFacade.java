package com.example.calculator.facade.accountsFacade;

import com.example.calculator.dto.AccountsRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class SimpleInterestAccountsFacade {

    public double calculateSimpleInterest(AccountsRequestDTO requestDTO) {
        double principal = requestDTO.getPrincipal();
        double rate = requestDTO.getRate();
        double time = requestDTO.getTime();

        // Perform the simple interest calculation logic
        double simpleInterest;
        simpleInterest = (principal * rate * time) / 100;

        return simpleInterest;
    }
}

