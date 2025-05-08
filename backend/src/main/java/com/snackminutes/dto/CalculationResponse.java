package com.snackminutes.dto;

import lombok.Value;

@Value
public class CalculationResponse {
    private String snackName;
    private int numberOfServings;
    private String activityName;
    private double minutesRequired;
}
