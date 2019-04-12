package com.sms.scoreboardapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sms.scoreboardapi.domain.MatchScore;

@Repository
public interface MatchScoreRepository extends JpaRepository<MatchScore, Long> {

	public Optional<MatchScore> findByTeamIdAndScheduleId(Long tId,Long sId);
	public int countByTeamId(Long id);
	 @Query("select count(ms) from MatchScore ms where ms.teamId=?1 and matchStatus=?2")
	 public int countByTeamIdAndMatchStatus(Long id,String status);
	 
	 public List<MatchScore> findByScheduleId(Long scheduleId);
}
