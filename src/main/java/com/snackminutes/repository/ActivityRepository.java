package com.snackminutes.repository;

import com.snackminutes.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    // Custom query methods can be defined here if needed
    // For example, you can add methods to find activities by name or type
    // Example: List<ActivityModel> findByName(String name);
}
