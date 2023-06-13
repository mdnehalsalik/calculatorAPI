package com.example.calculator.factory;

import com.example.calculator.service.AccountsCalculatorService;
import com.example.calculator.serviceimpl.AccountsCalculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AccountsCalculatorFactory {
    @Autowired
    private ApplicationContext context;

    public AccountsCalculatorService createService() {
        return context.getBean(AccountsCalculatorServiceImpl.class);
    }
}

