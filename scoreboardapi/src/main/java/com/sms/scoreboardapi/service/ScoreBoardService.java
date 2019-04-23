package com.sms.scoreboardapi.service;

import java.util.List;

import com.sms.scoreboardapi.domain.BallScore;
import com.sms.scoreboardapi.domain.MatchScore;
import com.sms.scoreboardapi.domain.Player;
import com.sms.scoreboardapi.domain.PlayerContestPerformance;
import com.sms.scoreboardapi.domain.PlayerMatchPerformance;
import com.sms.scoreboardapi.domain.TeamPerformance;

public interface ScoreBoardService {

	void updateScore(BallScore ballScore);
	void updateMatchScore(BallScore ballScore);
	void updatePlayerMatchPerformance(BallScore ballScore);
	void updatePlayerContestPerformance(BallScore ballScore);
	void updateTeamPerformance(BallScore ballScore);
	List<MatchScore> getMatchScore(Long scheduleId);
	PlayerMatchPerformance getPlayerMatchPerformance(Long playerId,Long scheduleId);
	PlayerContestPerformance getPlayerContestPerformance(Long PlayerId, Long contestId);
	TeamPerformance getTeamPerformance(Long teamId);
	Player getHighestScorer(Long contestId);
}
