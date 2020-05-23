package com.spe.service;

import com.spe.model.Leaderboard;
import com.spe.repository.LeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {
    @Autowired
    LeaderboardRepository leaderboardRepository;

    public List<Leaderboard> getLeaderboard(){
        return leaderboardRepository.findByOrderByPointsDesc();
    }
}
