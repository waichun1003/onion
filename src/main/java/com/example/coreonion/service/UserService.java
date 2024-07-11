package com.example.coreonion.service;

import com.example.coreonion.mapper.UserMapper;
import com.example.coreonion.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        logger.info("Starting user registration for email: {}", user.getEmail());
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        user.setEmailVerified(false);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        if (user.getRole() == null || (!user.getRole().equals("COACH") && !user.getRole().equals("COACHEE"))) {
            user.setRole("COACHEE"); // Default to COACHEE if role is not provided or invalid
        }
        logger.info("Inserting user with email: {}", user.getEmail());
        userMapper.insertUser(user);
        logger.info("User registered successfully with email: {}", user.getEmail());
        sendVerificationEmail(user);
    }

    public User getUserById(Long userId) {
        logger.info("Fetching user with ID: {}", userId);
        return userMapper.findUserById(userId);
    }

    public void updateUser(User user) {
        logger.info("Updating user with ID: {}", user.getUserId());
        user.setUpdatedAt(new Date());
        userMapper.updateUser(user);
        logger.info("User updated successfully with ID: {}", user.getUserId());
    }

    public void deleteUser(Long userId) {
        logger.info("Deleting user with ID: {}", userId);
        userMapper.deleteUser(userId);
        logger.info("User deleted successfully with ID: {}", userId);
    }

    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return userMapper.findAllUsers();
    }

    public void verifyEmail(String token) {
        logger.info("Verifying email with token: {}", token);
        User user = userMapper.findUserByVerificationToken(token);
        if (user != null) {
            user.setEmailVerified(true);
            user.setVerificationToken(null); // Clear the token after verification
            userMapper.updateUser(user);
            logger.info("Email verified successfully for user with email: {}", user.getEmail());
        } else {
            logger.warn("No user found with token: {}", token);
        }
    }

    private void sendVerificationEmail(User user) {
        // Implementation for sending a verification email
        logger.info("Sending verification email to: {}", user.getEmail());
    }
}
