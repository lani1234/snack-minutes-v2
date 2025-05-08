package com.snackminutes.controller;

import com.snackminutes.dto.CalculationRequestAnon;
import com.snackminutes.dto.CalculationRequest;
import com.snackminutes.dto.CalculationResponse;
import com.snackminutes.service.CalculationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculationController {

    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping
    public CalculationResponse calculateSnackBurn(@RequestBody CalculationRequest request) {
        return calculationService.calculateMinutes(request);
    }

    @PostMapping("/anonymous")
    public ResponseEntity<CalculationResponse> calculateForAnonymous(@RequestBody CalculationRequestAnon request) {
        CalculationResponse result = calculationService.calculateMinutesForAnonUser(request);
        return ResponseEntity.ok(result);
    }
}
