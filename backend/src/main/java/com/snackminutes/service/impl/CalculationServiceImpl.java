package com.snackminutes.service.impl;

import com.snackminutes.dto.CalculationRequest;
import com.snackminutes.dto.CalculationRequestAnon;
import com.snackminutes.dto.CalculationResponse;
import com.snackminutes.model.Activity;
import com.snackminutes.model.Snack;
import com.snackminutes.model.User;
import com.snackminutes.service.ActivityService;
import com.snackminutes.service.CalculationService;
import com.snackminutes.service.SnackService;
import com.snackminutes.service.UserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class CalculationServiceImpl implements CalculationService {

    private final UserService userService;
    private final SnackService snackService;
    private final ActivityService activityService;

    public CalculationServiceImpl(UserService userService, SnackService snackService, ActivityService activityService) {
        this.userService = userService;
        this.snackService = snackService;
        this.activityService = activityService;
    }

    @Override
    public CalculationResponse calculateMinutes(CalculationRequest request) {
        User user = userService.getUserByEmail(request.getEmail());
        Snack snack = snackService.getSnackById(request.getSnackId());
        Activity activity = activityService.getActivityById(request.getActivityId());

        double totalMinutes = calculateMinutes(snack, activity, user.getWeightLbs(), request.getNumberOfServings());

        return new CalculationResponse(
                snack.getName(),
                request.getNumberOfServings(),
                activity.getName(),
                totalMinutes
        );
    }

    public CalculationResponse calculateMinutesForAnonUser(CalculationRequestAnon requestAnon) {
        Snack snack = snackService.getSnackById(requestAnon.getSnackId());
        Activity activity = activityService.getActivityById(requestAnon.getActivityId());

        double totalMinutes = calculateMinutes(snack, activity, requestAnon.getWeightLbs(), requestAnon.getNumberOfServings());

        return new CalculationResponse(
                snack.getName(),
                requestAnon.getNumberOfServings(),
                activity.getName(),
                totalMinutes
        );
    }

    private double calculateMinutes(Snack snack, Activity activity, double weightLbs, int numberOfServings) {
        double calories = snack.getCaloriesPerServing() * numberOfServings;

        // assume a user's weight will be entered as pounds
        // convert to kg for calculation
        // To convert pounds to kilograms, you multiply by 0.45359237
        double userWeightKg = weightLbs * 0.45359237;

        // Calories burned per minute = (MET × weight in kg × 3.5) / 200
        double caloriesBurnedPerMinute = (activity.getMet() * userWeightKg * 3.5) / 200;

        // Total time in minutes = calories / calories burned per minute
        double minutesRequired = calories / caloriesBurnedPerMinute;
        return new BigDecimal(minutesRequired)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

}
