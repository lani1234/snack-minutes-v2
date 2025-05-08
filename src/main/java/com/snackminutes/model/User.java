package com.snackminutes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Min(value = 0, message = "Weight must be a positive number")
    private double weightLbs;

    // assume a user's weight will be entered as pounds
    // convert to kg for calculation
    // To convert pounds to kilograms, you multiply by 0.45359237
}
