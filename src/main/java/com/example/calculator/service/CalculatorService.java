package com.example.calculator.service;

import com.example.calculator.dto.AccountsRequestDTO;
import com.example.calculator.dto.ScientificRequestDTO;

import java.util.List;

public interface CalculatorService {

//    int add(List<Integer> values);
    double add(double a, double b);
//    int subtract(List<Integer> values);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);

    double evaluateExpression(String expression);



    // double performScientificOperation(ScientificRequestDTO requestDTO);
    double calculateSimpleInterest(AccountsRequestDTO requestDTO);

}

