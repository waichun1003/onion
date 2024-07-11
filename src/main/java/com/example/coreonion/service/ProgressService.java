package com.example.coreonion.service;

import com.example.coreonion.mapper.ProgressMapper;
import com.example.coreonion.model.Journal;
import com.example.coreonion.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService {
    @Autowired
    private ProgressMapper progressMapper;

    public void createJournal(Journal journal) {
        progressMapper.insertJournal(journal);
    }

    public List<Journal> getJournalsForCoachee(Long coacheeId) {
        return progressMapper.findJournalsByCoacheeId(coacheeId);
    }

    public void createReport(Report report) {
        progressMapper.insertReport(report);
    }

    public List<Report> getReportsForCoachee(Long coacheeId) {
        return progressMapper.findReportsByCoacheeId(coacheeId);
    }
}
