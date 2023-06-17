package com.example.calculator.service;

import com.example.calculator.dto.ScientificRequestDTO;
import com.example.calculator.exception.ValidationException;
import com.example.calculator.factory.ScientificFactory;
import com.example.calculator.validation.GeneralRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScientificService {

    private final ScientificFactory scientificFactory;
    private final GeneralRequestValidator generalRequestValidator;

    @Autowired
    public ScientificService(ScientificFactory scientificFactory, GeneralRequestValidator generalRequestValidator) {
        this.scientificFactory = scientificFactory;
        this.generalRequestValidator = generalRequestValidator;
    }

    public double performOperation(ScientificRequestDTO requestDTO) throws ValidationException {
        generalRequestValidator.validate(requestDTO);
        return scientificFactory.executeOperation(requestDTO);
    }
}
