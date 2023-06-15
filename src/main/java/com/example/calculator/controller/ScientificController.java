package com.example.calculator.controller;

import com.example.calculator.dto.ScientificRequestDTO;
import com.example.calculator.model.ScientificResponse;
import com.example.calculator.service.ScientificService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/calculator")
public class ScientificController {

    private final ScientificService scientificService;

    public ScientificController(ScientificService scientificService) {
        this.scientificService = scientificService;
    }

    @PostMapping("/scientific")
    public ResponseEntity<ScientificResponse> performScientificOperation(
            @Valid @RequestBody ScientificRequestDTO requestDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return ResponseEntity.badRequest().build();
        }

        double result = scientificService.performOperation(requestDTO);
        ScientificResponse response = new ScientificResponse();
        response.setResult(result);
        return ResponseEntity.ok(response);
    }

}
