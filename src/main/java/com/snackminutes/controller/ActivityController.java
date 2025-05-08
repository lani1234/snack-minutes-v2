package com.snackminutes.controller;

import com.snackminutes.converter.ActivityConverter;
import com.snackminutes.dto.ActivityDTO;
import com.snackminutes.model.Activity;
import com.snackminutes.service.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityService activityService;
    private final ActivityConverter activityConverter;

    public ActivityController(ActivityService activityService, ActivityConverter activityConverter) {
        this.activityService = activityService;
        this.activityConverter = activityConverter;
    }

    @GetMapping("/test")
    public Activity testActivity() {
        return Activity.builder()
                .name("Test Activity")
                .met(1.0)
                .build();
    }

    @GetMapping
    public List<ActivityDTO> getAllActivities() {
        List<Activity> allActivities = activityService.getAllActivities();
        return allActivities.stream()
                .map(activityConverter::convert)
                .toList();
    }

    @GetMapping("/{id}")
    public ActivityDTO getActivityById(Long id) {
        Activity activity = activityService.getActivityById(id);
        return activityConverter.convert(activity);
    }

    @PostMapping
    public ActivityDTO createActivity(Activity activity) {
        Activity activityModel = activityService.createActivity(activity);
        return activityConverter.convert(activityModel);
    }

    @PostMapping("/bulk")
    public List<ActivityDTO> createActivities(List<Activity> activities) {
        List<Activity> activityModelList = activityService.createActivities(activities);
        return activityModelList.stream()
                .map(activityConverter::convert)
                .toList();
    }

    @PutMapping("/{id}")
    public ActivityDTO updateActivity(@PathVariable Long id, @RequestBody Activity activity) {
        Activity updatedActivity = activityService.updateActivity(id, activity);
        return activityConverter.convert(updatedActivity);
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
    }
}
