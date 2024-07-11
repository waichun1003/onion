package com.example.coreonion.controller;

import com.example.coreonion.model.User;
import com.example.coreonion.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        logger.info("Received request to register user with email: {}", user.getEmail());
        userService.registerUser(user);
        logger.info("User registered successfully with email: {}", user.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        logger.info("Received request to get user by id: {}", userId);
        User user = userService.getUserById(userId);
        if (user != null) {
            logger.info("User found: {}", user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            logger.warn("User not found with id: {}", userId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody User user) {
        logger.info("Received request to update user by id: {}", userId);
        user.setUserId(userId);
        userService.updateUser(user);
        logger.info("User updated successfully with id: {}", userId);
        return ResponseEntity.ok("User updated successfully");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        logger.info("Received request to delete user by id: {}", userId);
        userService.deleteUser(userId);
        logger.info("User deleted successfully with id: {}", userId);
        return ResponseEntity.ok("User deleted successfully");
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("Received request to get all users");
        List<User> users = userService.getAllUsers();
        logger.info("Returning list of all users");
        return ResponseEntity.ok(users);
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyEmail(@RequestParam String token) {
        logger.info("Received request to verify email with token: {}", token);
        userService.verifyEmail(token);
        logger.info("Email verified successfully for token: {}", token);
        return ResponseEntity.ok("Email verified successfully");
    }
}
