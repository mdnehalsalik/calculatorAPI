package com.example.calculator.factory;

import com.example.calculator.dto.ScientificRequestDTO;
import com.example.calculator.facade.scientificFacade.BodmasScientificFacade;
import com.example.calculator.facade.scientificFacade.TrigonometryScientificFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScientificFactory {

    private final BodmasScientificFacade bodmasScientificFacade;
    private final TrigonometryScientificFacade trigonometryScientificFacade;

    @Autowired
    public ScientificFactory(BodmasScientificFacade bodmasScientificFacade,
                                       TrigonometryScientificFacade trigonometryScientificFacade) {
        this.bodmasScientificFacade = bodmasScientificFacade;
        this.trigonometryScientificFacade = trigonometryScientificFacade;
    }

    public double executeOperation(ScientificRequestDTO requestDTO) {
        switch (requestDTO.getOperation()) {
            case "bodmas":
                return bodmasScientificFacade.performBodmasOperation(requestDTO.getExpression());
            case "trigonometry":
                return trigonometryScientificFacade.performTrigonometryOperation(requestDTO.getExpression());
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
