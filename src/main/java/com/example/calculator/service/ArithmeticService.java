package com.example.calculator.service;

import com.example.calculator.dto.ArithmeticRequestDTO;
import com.example.calculator.exception.ValidationException;
import com.example.calculator.factory.ArithmeticFactory;
import com.example.calculator.validation.GeneralRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArithmeticService {

    private final ArithmeticFactory arithmeticFactory;
    private final GeneralRequestValidator generalRequestValidator;

    @Autowired
    public ArithmeticService(ArithmeticFactory arithmeticFactory, GeneralRequestValidator generalRequestValidator) {
        this.arithmeticFactory = arithmeticFactory;
        this.generalRequestValidator = generalRequestValidator;
    }

    public double performOperation(ArithmeticRequestDTO requestDTO) throws ValidationException {
        generalRequestValidator.validate(requestDTO);
        return arithmeticFactory.executeOperation(requestDTO);
    }
}
