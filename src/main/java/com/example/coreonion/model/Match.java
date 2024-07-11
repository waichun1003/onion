package com.example.coreonion.model;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class Match {
    private Long matchId;
    private Long coacheeId;
    private Long coachId;
    private Double score;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
