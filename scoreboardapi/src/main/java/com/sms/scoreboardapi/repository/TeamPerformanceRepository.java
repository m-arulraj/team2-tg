package com.sms.scoreboardapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.scoreboardapi.domain.TeamPerformance;

@Repository
public interface TeamPerformanceRepository extends JpaRepository<TeamPerformance, Long> {

	TeamPerformance findByTeamId(Long teamId);
}
