package com.example.coreonion.service;

import com.example.coreonion.mapper.UserActivityMapper;
import com.example.coreonion.mapper.UserMapper;
import com.example.coreonion.model.User;
import com.example.coreonion.model.UserActivity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestExecutionListeners(listeners = {
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class
})
public class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserActivityMapper userActivityMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Autowired
    private LoggingAspect loggingAspect;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterUserAsCoachee() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPasswordHash("password");
        user.setRole("COACHEE"); // Set role to COACHEE
        when(passwordEncoder.encode(any(String.class))).thenReturn("encodedPassword");

        userService.registerUser(user);

        verify(userMapper, times(1)).insertUser(any(User.class));
        verify(passwordEncoder, times(1)).encode("password");
        verify(userActivityMapper, times(1)).insertActivity(any(UserActivity.class));
        assertEquals("encodedPassword", user.getPasswordHash());
        assertEquals("COACHEE", user.getRole());
    }
}
