package com.example.calculator.factory;

import com.example.calculator.dto.ArithmeticRequestDTO;
import com.example.calculator.facade.arithmeticFacade.AdditionArithmeticFacade;
import com.example.calculator.facade.arithmeticFacade.SubtractionArithmeticFacade;
import com.example.calculator.facade.arithmeticFacade.MultiplicationArithmeticFacade;
import com.example.calculator.facade.arithmeticFacade.DivisionArithmeticFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArithmeticFactory {

    private final AdditionArithmeticFacade additionArithmeticFacade;
    private final SubtractionArithmeticFacade subtractionArithmeticFacade;
    private final MultiplicationArithmeticFacade multiplicationArithmeticFacade;
    private final DivisionArithmeticFacade divisionArithmeticFacade;

    @Autowired
    public ArithmeticFactory(AdditionArithmeticFacade additionArithmeticFacade,
                             SubtractionArithmeticFacade subtractionArithmeticFacade,
                             MultiplicationArithmeticFacade multiplicationArithmeticFacade,
                             DivisionArithmeticFacade divisionArithmeticFacade) {
        this.additionArithmeticFacade = additionArithmeticFacade;
        this.subtractionArithmeticFacade = subtractionArithmeticFacade;
        this.multiplicationArithmeticFacade = multiplicationArithmeticFacade;
        this.divisionArithmeticFacade = divisionArithmeticFacade;
    }

    public double executeOperation(ArithmeticRequestDTO requestDTO) {
        switch (requestDTO.getOperation()) {
            case "add":
                return additionArithmeticFacade.processAddition(requestDTO.getValues());
            case "sub":
                return subtractionArithmeticFacade.processSubtraction(requestDTO.getValues());
            case "mul":
                return multiplicationArithmeticFacade.processMultiplication(requestDTO.getValues());
            case "div":
                return divisionArithmeticFacade.processDivision(requestDTO.getValues());
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
