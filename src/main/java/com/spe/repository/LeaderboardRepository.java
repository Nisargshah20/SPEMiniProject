package com.spe.repository;

import com.spe.model.Leaderboard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LeaderboardRepository extends CrudRepository<Leaderboard,Long> {
    List<Leaderboard> findByOrderByPointsDesc();

}
