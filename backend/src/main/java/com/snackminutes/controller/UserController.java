package com.snackminutes.controller;

import com.snackminutes.converter.UserConverter;
import com.snackminutes.dto.UserDTO;
import com.snackminutes.model.User;
import com.snackminutes.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    public UserController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @GetMapping("/test")
    public User testUser() {
        return User.builder()
                .firstName("Test")
                .lastName("User")
                .email("test@test.com")
                .weightLbs(126)
                .build();
    }

    @GetMapping("/by-email")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody User user) {
        User userModel = userService.createUser(user);
        return userConverter.convert(userModel);
    }

    @PutMapping("/{email}")
    public UserDTO updateUser(@PathVariable String email, @RequestBody User user) {
        User updatedUser = userService.updateUser(email, user);
        return userConverter.convert(updatedUser);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteUserByEmail(@PathVariable String email) {
        boolean deleted = userService.deleteUserByEmail(email);
        if (deleted) {
            return ResponseEntity.ok("User deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }

}
