//package com.example.calculator.dto;
//
//import javax.validation.constraints.NotNull;

//public class ScientificRequestDTO {
//
//    @NotNull(message = "Value is required")
//    private Double value;
//
//    // Getters and setters
//
//    public Double getValue() {
//        return value;
//    }
//
//    public void setValue(Double value) {
//        this.value = value;
//    }
//}

package com.example.calculator.dto;

import javax.validation.constraints.NotNull;

public class ScientificRequestDTO {

    @NotNull(message = "Expression is required")
    private String expression;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}



