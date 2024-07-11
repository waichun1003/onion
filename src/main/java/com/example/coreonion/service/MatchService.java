package com.example.coreonion.service;

import com.example.coreonion.mapper.MatchMapper;
import com.example.coreonion.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    @Autowired
    private MatchMapper matchMapper;

    public void createMatch(Match match) {
        matchMapper.insertMatch(match);
    }

    public List<Match> getMatchesForCoachee(Long coacheeId) {
        return matchMapper.findMatchesByCoacheeId(coacheeId);
    }

    public List<Match> getRecommendationsForCoachee(Long coacheeId) {
        return matchMapper.findRecommendationsByCoacheeId(coacheeId);
    }
}
