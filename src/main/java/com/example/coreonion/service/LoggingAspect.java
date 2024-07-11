package com.example.coreonion.service;

import com.example.coreonion.mapper.UserActivityMapper;
import com.example.coreonion.model.User;
import com.example.coreonion.model.UserActivity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Autowired
    private UserActivityMapper userActivityMapper;

    @AfterReturning(pointcut = "execution(* com.example.coreonion.service.UserService.registerUser(..))", returning = "user")
    public void logAfterRegisterUser(JoinPoint joinPoint, User user) {
        logger.info("logAfterRegisterUser called with user: {}", user);
        if (user != null) {
            UserActivity activity = new UserActivity();
            activity.setUserId(user.getUserId()); // Ensure the userId is correctly set
            activity.setActivity("User registered");
            activity.setTimestamp(new Date());
            userActivityMapper.insertActivity(activity);
            logger.info("User activity logged for user: {}", user.getUserId());
        }
    }
}
