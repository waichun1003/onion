package com.example.coreonion.service;

import com.example.coreonion.mapper.SessionMapper;
import com.example.coreonion.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    @Autowired
    private SessionMapper sessionMapper;

    public void createSession(Session session) {
        sessionMapper.insertSession(session);
    }

    public Session getSessionById(Long sessionId) {
        return sessionMapper.findSessionById(sessionId);
    }

    public void updateSession(Session session) {
        sessionMapper.updateSession(session);
    }

    public void deleteSession(Long sessionId) {
        sessionMapper.deleteSession(sessionId);
    }
}
