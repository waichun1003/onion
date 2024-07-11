package com.example.coreonion.model;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class Report {
    private Long reportId;
    private Long coacheeId;
    private String reportType;
    private String content;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
