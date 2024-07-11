package com.example.coreonion.controller;

import com.example.coreonion.model.Journal;
import com.example.coreonion.model.Report;
import com.example.coreonion.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @PostMapping("/journal")
    public ResponseEntity<String> createJournal(@RequestBody Journal journal) {
        progressService.createJournal(journal);
        return ResponseEntity.status(HttpStatus.CREATED).body("Journal entry created successfully");
    }

    @GetMapping("/journal/{coacheeId}")
    public ResponseEntity<List<Journal>> getJournalsForCoachee(@PathVariable Long coacheeId) {
        List<Journal> journals = progressService.getJournalsForCoachee(coacheeId);
        return ResponseEntity.ok(journals);
    }

    @PostMapping("/report")
    public ResponseEntity<String> createReport(@RequestBody Report report) {
        progressService.createReport(report);
        return ResponseEntity.status(HttpStatus.CREATED).body("Report created successfully");
    }

    @GetMapping("/report/{coacheeId}")
    public ResponseEntity<List<Report>> getReportsForCoachee(@PathVariable Long coacheeId) {
        List<Report> reports = progressService.getReportsForCoachee(coacheeId);
        return ResponseEntity.ok(reports);
    }
}
