package com.snackminutes.service;

import com.snackminutes.exception.ResourceNotFoundException;
import com.snackminutes.model.User;
import com.snackminutes.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users) {
        return userRepository.saveAll(users); // Save all users in one go
    }

    public User updateUser(String email, User user) {
        Optional<User> userForEmailOptional = userRepository.getUserByEmail(email);// Check if the user exists
        if (userForEmailOptional.isEmpty()) {
            throw new ResourceNotFoundException("User not found with email " + email);
        } else {
            User userForEmail = userForEmailOptional.get();
            userForEmail.setFirstName(user.getFirstName());
            userForEmail.setLastName(user.getLastName());
            userForEmail.setWeightLbs(user.getWeightLbs());
            return userRepository.save(userForEmail);
        }
    }

    public boolean deleteUserByEmail(String email) {
        Optional<User> user = userRepository.getUserByEmail(email);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        }
        return false;
    }
}
