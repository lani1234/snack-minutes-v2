package com.snackminutes.converter;

import com.snackminutes.dto.ActivityDTO;
import com.snackminutes.model.Activity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ActivityConverter implements Converter<Activity, ActivityDTO> {

    @Override
    public ActivityDTO convert(Activity activity) {
        return new ActivityDTO(activity.getId(),
                               activity.getName(),
                               activity.getMet());
    }
}
