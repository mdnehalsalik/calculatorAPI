package com.example.calculator.facade.scientificFacade;

import org.mariuszgromada.math.mxparser.Expression;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BodmasScientificFacade {

    public double performBodmasOperation(List<String> expression) {
        String expr = expression.get(0);
        Expression mathExpression = new Expression(expr);
        double result = mathExpression.calculate();
        return result;
    }
}


