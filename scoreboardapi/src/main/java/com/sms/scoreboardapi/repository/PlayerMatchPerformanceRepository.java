package com.sms.scoreboardapi.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.scoreboardapi.domain.Player;
import com.sms.scoreboardapi.domain.PlayerMatchPerformance;

@Repository
public interface PlayerMatchPerformanceRepository extends JpaRepository<PlayerMatchPerformance, Long> {

	public Optional<PlayerMatchPerformance> findByScheduleIdAndPlayer(Long sid,Player player);
	
	public int countByPlayerId(Long playerId);
	
	public PlayerMatchPerformance findByPlayerIdAndScheduleId(Long playerId, Long scheduleId);
	public Set<PlayerMatchPerformance> findByPlayerId(Long playerId);
}
