package com.example.coreonion.model;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class Content {
    private Long contentId;
    private String type;
    private String title;
    private String description;
    private String url;
    private Long coachId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
