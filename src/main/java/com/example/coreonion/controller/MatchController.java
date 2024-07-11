package com.example.coreonion.controller;

import com.example.coreonion.model.Match;
import com.example.coreonion.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping
    public ResponseEntity<String> createMatch(@RequestBody Match match) {
        matchService.createMatch(match);
        return ResponseEntity.status(HttpStatus.CREATED).body("Match created successfully");
    }

    @GetMapping("/coachee/{coacheeId}")
    public ResponseEntity<List<Match>> getMatchesForCoachee(@PathVariable Long coacheeId) {
        List<Match> matches = matchService.getMatchesForCoachee(coacheeId);
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/recommendations/{coacheeId}")
    public ResponseEntity<List<Match>> getRecommendationsForCoachee(@PathVariable Long coacheeId) {
        List<Match> recommendations = matchService.getRecommendationsForCoachee(coacheeId);
        return ResponseEntity.ok(recommendations);
    }
}
