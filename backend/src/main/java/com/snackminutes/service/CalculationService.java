package com.snackminutes.service;

import com.snackminutes.dto.CalculationRequest;
import com.snackminutes.dto.CalculationRequestAnon;
import com.snackminutes.dto.CalculationResponse;

public interface CalculationService {

    CalculationResponse calculateMinutes(CalculationRequest request);
    CalculationResponse calculateMinutesForAnonUser(CalculationRequestAnon requestAnon);
}
