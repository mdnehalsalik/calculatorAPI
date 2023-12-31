//package com.example.calculator.validation;
//
//import com.example.calculator.dto.ArithmeticRequestDTO;
//import com.example.calculator.dto.AccountsRequestDTO;
//import com.example.calculator.exception.ValidationException;
//import com.example.calculator.validation.validatorTypes.OperationValidator;
//import com.example.calculator.validation.validatorTypes.ValuesValidator;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class GeneralRequestValidator implements Validator {
//    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralRequestValidator.class);
//
//    private final OperationValidator operationValidator;
//    private final ValuesValidator valuesValidator;
//
//    public GeneralRequestValidator(OperationValidator operationValidator, ValuesValidator valuesValidator) {
//        this.operationValidator = operationValidator;
//        this.valuesValidator = valuesValidator;
//    }
//
//    @Override
//    public void validate(Object requestDTO) {
//
//        List<String> validationErrors = new ArrayList<>();
//
//        if (requestDTO instanceof ArithmeticRequestDTO) {
//            ArithmeticRequestDTO arithmeticRequestDTO = (ArithmeticRequestDTO) requestDTO;
//
//            // Validate operation
//            operationValidator.validate(arithmeticRequestDTO.getOperation(), validationErrors);
//
//            // Validate values
//            valuesValidator.arithmeticValuesValidate(arithmeticRequestDTO.getValues(), validationErrors, arithmeticRequestDTO.getOperation());
//        }
//
//        else if (requestDTO instanceof AccountsRequestDTO) {
//            AccountsRequestDTO accountsRequestDTO = (AccountsRequestDTO) requestDTO;
//
//            // Validate operation
//            operationValidator.validate(accountsRequestDTO.getOperation(), validationErrors);
//
//            // Validate values
//            valuesValidator.accountsValuesValidate(accountsRequestDTO.getPrincipal(), accountsRequestDTO.getRate(), accountsRequestDTO.getTime(), validationErrors);
//        }
//
//        if (!validationErrors.isEmpty()) {
//            throw new ValidationException("Validation error", validationErrors);
//        }
//    }
//}

package com.example.calculator.validation;

import com.example.calculator.dto.ArithmeticRequestDTO;
import com.example.calculator.dto.AccountsRequestDTO;
import com.example.calculator.dto.ScientificRequestDTO;
import com.example.calculator.exception.ValidationException;
import com.example.calculator.validation.validatorTypes.OperationValidator;
import com.example.calculator.validation.validatorTypes.ValuesValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneralRequestValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralRequestValidator.class);

    private final OperationValidator operationValidator;
    private final ValuesValidator valuesValidator;

    public GeneralRequestValidator(OperationValidator operationValidator, ValuesValidator valuesValidator) {
        this.operationValidator = operationValidator;
        this.valuesValidator = valuesValidator;
    }

    @Override
    public void validate(Object requestDTO) {

        List<String> validationErrors = new ArrayList<>();

        if (requestDTO instanceof ArithmeticRequestDTO) {
            ArithmeticRequestDTO arithmeticRequestDTO = (ArithmeticRequestDTO) requestDTO;

            // Validate operation
            operationValidator.validate(arithmeticRequestDTO.getOperation(), validationErrors);

            // Validate values
            valuesValidator.arithmeticValuesValidate(arithmeticRequestDTO.getValues(), validationErrors, arithmeticRequestDTO.getOperation());
        } else if (requestDTO instanceof AccountsRequestDTO) {
            AccountsRequestDTO accountsRequestDTO = (AccountsRequestDTO) requestDTO;

            // Validate operation
            operationValidator.validate(accountsRequestDTO.getOperation(), validationErrors);

            // Validate values
            valuesValidator.accountsValuesValidate(accountsRequestDTO.getPrincipal(), accountsRequestDTO.getRate(), accountsRequestDTO.getTime(), validationErrors);
        } else if (requestDTO instanceof ScientificRequestDTO) {
            ScientificRequestDTO scientificRequestDTO = (ScientificRequestDTO) requestDTO;

            // Validate operation
            operationValidator.validate(scientificRequestDTO.getOperation(), validationErrors);

            // Validate expression
            valuesValidator.scientificExpressionValidate(scientificRequestDTO.getExpression(), validationErrors);
        }

        if (!validationErrors.isEmpty()) {
            throw new ValidationException("Validation error", validationErrors);
        }
    }
}

