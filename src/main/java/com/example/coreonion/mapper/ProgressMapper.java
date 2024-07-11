package com.example.coreonion.mapper;

import com.example.coreonion.model.Journal;
import com.example.coreonion.model.Report;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ProgressMapper {
    void insertJournal(Journal journal);

    List<Journal> findJournalsByCoacheeId(Long coacheeId);

    void insertReport(Report report);

    List<Report> findReportsByCoacheeId(Long coacheeId);
}
