package com.example.coreonion.mapper;

import com.example.coreonion.model.Match;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface MatchMapper {
    void insertMatch(Match match);

    List<Match> findMatchesByCoacheeId(Long coacheeId);

    List<Match> findRecommendationsByCoacheeId(Long coacheeId);
}
