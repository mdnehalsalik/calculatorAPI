package com.example.calculator.controller;

import com.example.calculator.dto.ScientificRequestDTO;
import com.example.calculator.exception.ErrorResponse;
import com.example.calculator.exception.ValidationException;
import com.example.calculator.model.ScientificResponse;
import com.example.calculator.service.ScientificService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calculator")
public class ScientificController {

    private final ScientificService scientificService;

    @Autowired
    public ScientificController(ScientificService scientificService) {
        this.scientificService = scientificService;
    }

    @PostMapping("/scientific")
    public ResponseEntity<Object> performScientificOperation(
            @Valid @RequestBody ScientificRequestDTO requestDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(new ErrorResponse(errors));
        }

        try {
            double result = scientificService.performOperation(requestDTO);

            ScientificResponse response = new ScientificResponse();
            response.setResult(result);

            return ResponseEntity.ok(response);

        } catch (ValidationException ex) {
            return ResponseEntity.badRequest().body(new ErrorResponse(ex.getValidationErrors()));
        } catch (HttpMessageNotReadableException ex) {
            List<String> errors = new ArrayList<>();
            errors.add("Invalid request payload");
            return ResponseEntity.badRequest().body(new ErrorResponse(errors));
        }
    }
}
