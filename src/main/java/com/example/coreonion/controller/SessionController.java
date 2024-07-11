package com.example.coreonion.controller;

import com.example.coreonion.model.Session;
import com.example.coreonion.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping
    public ResponseEntity<String> createSession(@RequestBody Session session) {
        sessionService.createSession(session);
        return ResponseEntity.status(HttpStatus.CREATED).body("Session created successfully");
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<Session> getSessionById(@PathVariable Long sessionId) {
        Session session = sessionService.getSessionById(sessionId);
        return ResponseEntity.ok(session);
    }

    @PutMapping("/{sessionId}")
    public ResponseEntity<String> updateSession(@PathVariable Long sessionId, @RequestBody Session session) {
        session.setSessionId(sessionId);
        sessionService.updateSession(session);
        return ResponseEntity.ok("Session updated successfully");
    }

    @DeleteMapping("/{sessionId}")
    public ResponseEntity<String> deleteSession(@PathVariable Long sessionId) {
        sessionService.deleteSession(sessionId);
        return ResponseEntity.ok("Session deleted successfully");
    }
}
