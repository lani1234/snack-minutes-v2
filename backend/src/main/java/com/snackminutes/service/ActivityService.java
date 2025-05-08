package com.snackminutes.service;

import com.snackminutes.exception.ResourceNotFoundException;
import com.snackminutes.model.Activity;
import com.snackminutes.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Activity getActivityById(Long id) {
        return activityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found with id: " + id));
    }

    public Activity createActivity(Activity activityModel) {
        return activityRepository.save(activityModel);
    }

    public List<Activity> createActivities(List<Activity> activityModels) {
        return activityRepository.saveAll(activityModels); // Save all activities in one go
    }

    public Activity updateActivity(Long id, Activity activityModel) {
        // Check if the activity exists
        if (!activityRepository.existsById(id)) {
            throw new ResourceNotFoundException("Activity not found with id " + id);
        }
        Activity existingActivity = getActivityById(id);
        existingActivity.setName(activityModel.getName());
        existingActivity.setMet(activityModel.getMet());
        return activityRepository.save(activityModel);
    }

    public void deleteActivity(Long id) {
        if (!activityRepository.existsById(id)) {
            throw new ResourceNotFoundException("Activity not found with id " + id);
        }
        activityRepository.deleteById(id);
    }
}
