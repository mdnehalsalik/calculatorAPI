package com.example.calculator.controller;

import com.example.calculator.dto.ArithmeticRequestDTO;
import com.example.calculator.exception.BadRequestException;
import com.example.calculator.exception.CustomExceptionHandler;
import com.example.calculator.exception.ErrorResponse;
import com.example.calculator.model.ArithmeticResponse;
import com.example.calculator.service.ArithmeticService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/calculator")
public class ArithmeticController {

    private final ArithmeticService arithmeticService;

    public ArithmeticController(ArithmeticService arithmeticService) {
        this.arithmeticService = arithmeticService;
    }

    @PostMapping("/arithmetic")
    public ResponseEntity<ArithmeticResponse> performArithmeticOperation(
            @Valid @RequestBody ArithmeticRequestDTO requestDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            //throw new IllegalArgumentException("");
            return ResponseEntity.badRequest().build();
        }

        double result = arithmeticService.performOperation(requestDTO);
        ArithmeticResponse response = new ArithmeticResponse();
        response.setResult(result);
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(ValidationException ex) {
        return new ErrorResponse(ex.getMessage(), ex.getErrors());
    }

    private static class ValidationException extends RuntimeException {
        private final List<String> errors;

        public ValidationException(String message, List<String> errors) {
            super(message);
            this.errors = errors;
        }

        public List<String> getErrors() {
            return errors;
        }
    }
}
