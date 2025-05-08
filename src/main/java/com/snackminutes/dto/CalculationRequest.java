package com.snackminutes.dto;

import lombok.Value;

@Value
public class CalculationRequest {
    String email;
    Long snackId;
    int numberOfServings;
    Long activityId;
}
