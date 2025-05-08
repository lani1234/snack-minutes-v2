package com.snackminutes.converter;

import com.snackminutes.dto.SnackDTO;
import com.snackminutes.model.Snack;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SnackConverter implements Converter<Snack, SnackDTO> {

    @Override
    public SnackDTO convert(Snack snack) {
        return new SnackDTO(snack.getId(),
                            snack.getName(),
                            snack.getServingSize(),
                            snack.getCaloriesPerServing());
    }
}
