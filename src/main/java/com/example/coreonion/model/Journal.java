package com.example.coreonion.model;

import lombok.Data;
import java.sql.Date;
import java.sql.Timestamp;

@Data
public class Journal {
    private Long journalId;
    private Long coacheeId;
    private Date entryDate;
    private String content;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
