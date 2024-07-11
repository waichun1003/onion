package com.example.coreonion.model;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class Session {
    private Long sessionId;
    private Long coachId;
    private Long coacheeId;
    private Timestamp startTime;
    private Timestamp endTime;
    private String status;
    private String paymentStatus;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
