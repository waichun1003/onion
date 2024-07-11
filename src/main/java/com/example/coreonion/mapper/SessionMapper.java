package com.example.coreonion.mapper;

import com.example.coreonion.model.Session;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SessionMapper {
    void insertSession(Session session);

    Session findSessionById(Long sessionId);

    void updateSession(Session session);

    void deleteSession(Long sessionId);
}
