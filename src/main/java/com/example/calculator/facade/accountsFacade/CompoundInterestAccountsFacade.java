package com.example.calculator.facade.accountsFacade;

import com.example.calculator.dto.AccountsRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class CompoundInterestAccountsFacade {

    public double calculateCompoundInterest(AccountsRequestDTO requestDTO) {
        double principal = requestDTO.getPrincipal();
        double rate = requestDTO.getRate();
        double time = requestDTO.getTime();

        // Perform the compound interest calculation logic
        double compoundInterest;
        compoundInterest = principal * Math.pow((1 + rate / 100), time);

        return compoundInterest;
    }
}
