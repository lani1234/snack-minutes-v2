package com.snackminutes.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculationRequestAnon {
    double weightLbs;
    Long snackId;
    int numberOfServings;
    Long activityId;
}
