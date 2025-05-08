package com.snackminutes.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SnackDTO {

    private Long id;
    private String name;
    private String servingSize;
    private int caloriesPerServing;
}
