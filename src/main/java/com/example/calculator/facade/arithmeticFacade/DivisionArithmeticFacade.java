package com.example.calculator.facade.arithmeticFacade;
import org.springframework.stereotype.Component;

        import java.util.List;

@Component
public class DivisionArithmeticFacade {

    public double processDivision(List<Double> values) {
        double dividend = values.get(0);
        double divisor = values.get(1);
        return dividend / divisor;
    }
}

