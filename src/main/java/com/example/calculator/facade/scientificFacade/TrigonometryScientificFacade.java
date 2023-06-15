package com.example.calculator.facade.scientificFacade;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
public class TrigonometryScientificFacade {

    public double performTrigonometryOperation(@NotNull(message = "Expression inside a list is required") List<String> expression) {
        // Perform trigonometry operation logic here
        return 0.0; // Placeholder, replace with actual implementation
    }
}
