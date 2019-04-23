package com.sms.scoreboardapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.scoreboardapi.domain.Contest;
import com.sms.scoreboardapi.domain.Player;
import com.sms.scoreboardapi.domain.PlayerContestPerformance;

@Repository
public interface PlayerContestPerformanceRepository extends JpaRepository<PlayerContestPerformance, Long>{

	public Optional<PlayerContestPerformance> findByContestAndPlayer(Contest contest,Player player);
	public PlayerContestPerformance findByPlayerIdAndContestId(long playerId,Long contestId);
	public List<PlayerContestPerformance> findByContestId(Long contestId);
}
