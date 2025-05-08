package com.snackminutes.repository;

import com.snackminutes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByEmail(String email);// Custom query methods can be defined here if needed
    // For example, you can add methods to find users by username or email
    // Example: User findByUsername(String username);
}
