package com.example.calculator.factory;

import com.example.calculator.dto.AccountsRequestDTO;
import com.example.calculator.facade.accountsFacade.CompoundInterestAccountsFacade;
import com.example.calculator.facade.accountsFacade.SimpleInterestAccountsFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountsFactory {

    private final SimpleInterestAccountsFacade simpleInterestAccountsFacade;
    private final CompoundInterestAccountsFacade compoundInterestAccountsFacade;

    @Autowired
    public AccountsFactory(SimpleInterestAccountsFacade simpleInterestAccountsFacade,
                                     CompoundInterestAccountsFacade compoundInterestAccountsFacade) {
        this.simpleInterestAccountsFacade = simpleInterestAccountsFacade;
        this.compoundInterestAccountsFacade = compoundInterestAccountsFacade;
    }

    public double executeOperation(AccountsRequestDTO requestDTO) {
        switch(requestDTO.getOperation()) {
            case "simple":
                return simpleInterestAccountsFacade.calculateSimpleInterest(requestDTO);
            case "compound":
                return compoundInterestAccountsFacade.calculateCompoundInterest(requestDTO);
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
