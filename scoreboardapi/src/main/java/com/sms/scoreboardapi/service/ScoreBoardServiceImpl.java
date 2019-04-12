package com.sms.scoreboardapi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.scoreboardapi.domain.BallScore;
import com.sms.scoreboardapi.domain.Contest;
import com.sms.scoreboardapi.domain.MatchScore;
import com.sms.scoreboardapi.domain.Player;
import com.sms.scoreboardapi.domain.PlayerContestPerformance;
import com.sms.scoreboardapi.domain.PlayerMatchPerformance;
import com.sms.scoreboardapi.domain.Team;
import com.sms.scoreboardapi.domain.TeamPerformance;
import com.sms.scoreboardapi.repository.MatchScoreRepository;
import com.sms.scoreboardapi.repository.PlayerContestPerformanceRepository;
import com.sms.scoreboardapi.repository.PlayerMatchPerformanceRepository;
import com.sms.scoreboardapi.repository.PlayerRepository;
import com.sms.scoreboardapi.repository.TeamPerformanceRepository;

@Service
public class ScoreBoardServiceImpl implements ScoreBoardService {

	@Autowired
	private MatchScoreRepository matchScoreRepository;
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private TeamPerformanceRepository teamPerformanceRepository;
	@Autowired
	private PlayerMatchPerformanceRepository playerMatchPerformanceRepository;
	@Autowired
	private PlayerContestPerformanceRepository playerContestPerformanceRepository;
	
	private Player batsman,bowler;
	private Team battingTeam,bowlingTeam;
	private Contest contest;
	private PlayerMatchPerformance battingPlayerMatchPerformance,bowlingPlayerMatchPerformance;
	private PlayerContestPerformance battingPlayerContestPerformance,bowlingPlayerContestPerformance;
	private MatchScore battingMatchScore,bowlingMatchScore;
	private TeamPerformance battingTeamPerformance,bowlingTeamPerformance;
	private Optional<Player> optBowl,optBat;
	private Optional<MatchScore> optBatMatchScore,optBowlMatchScore;
	private Optional<PlayerMatchPerformance> optBatPlayerMatchPerformance,optBowlPlayerMatchPerformance;
	private Optional<PlayerContestPerformance> optBatPlayerContestPerformance,optBowlPlayerContestPerformance;
	
	private static Logger logger= Logger.getLogger(ScoreBoardServiceImpl.class);	
	
	//update score
	@Transactional
	public void updateScore(BallScore ballScore) {
		
		logger.debug("service invoked for updating scores");
		
		
		//get PLayer based on player id
		getPlayer(ballScore);		
		//get team based on player
		getTeam();
		
		updateMatchScore(ballScore);
		updatePlayerMatchPerformance(ballScore);
		updatePlayerContestPerformance(ballScore);
		updateTeamPerformance(ballScore);
		
	}

	//update match score
	@Transactional
	public void updateMatchScore(BallScore ballScore) {
		int currentRuns=0;
		
		logger.debug("updating match score");
		
		/*logger.info("object details");
		logger.debug(ballScore.getBallNumber());
		logger.debug(ballScore.getBattingPlayerId());
		logger.debug(ballScore.getBowlingPlayerId());
		logger.debug(ballScore.getMatchStatus());
		logger.debug(ballScore.getRuns());
		logger.debug(ballScore.getScheduleId());
		logger.debug(ballScore.getWicket());*/
		
		logger.debug("batting team------>"+battingTeam.getTeamName());
		logger.debug("bowling team------>"+bowlingTeam.getTeamName());
		
		//get match score based on team id
		optBatMatchScore=matchScoreRepository.findByTeamIdAndScheduleId(battingTeam.getId(),ballScore.getScheduleId());
		if(optBatMatchScore.isPresent()) {
			logger.debug("match is existng");
			battingMatchScore=optBatMatchScore.get();
		}else {
			battingMatchScore= new MatchScore();
			logger.debug("match is started");
			battingMatchScore.setTeamId(battingTeam.getId());
		}
		
		optBowlMatchScore=matchScoreRepository.findByTeamIdAndScheduleId(bowlingTeam.getId(),ballScore.getScheduleId());
		if(optBowlMatchScore.isPresent()) {
			logger.debug("match is already started");
			bowlingMatchScore=optBowlMatchScore.get();
		}else {
			bowlingMatchScore= new MatchScore();
			logger.debug("starting new match");
			bowlingMatchScore.setTeamId(bowlingTeam.getId());
		}
		
		//set data for batting team
		battingMatchScore.setScheduleId(ballScore.getScheduleId());
		currentRuns= battingMatchScore.getRunsScored();
		
		battingMatchScore.setRunsScored(currentRuns+ballScore.getRuns());
	
		if(ballScore.getRuns()==4) {
			int fours= battingMatchScore.getFours();
			fours=fours+1;
			battingMatchScore.setFours(fours);
		}else if(ballScore.getRuns()==6) {
			int sixes= battingMatchScore.getSixes();
			sixes=sixes+1;
			battingMatchScore.setSixes(sixes);
		}
		if(ballScore.getWicket()==true) {
			int lossOfWickets=battingMatchScore.getLossOfWickets();
			lossOfWickets=lossOfWickets+1;
			battingMatchScore.setLossOfWickets(lossOfWickets);
		}
		if(ballScore.getBallNumber()!=6) {
			double oversFaced= battingMatchScore.getOversFaced();
			oversFaced=oversFaced+0.1;
			battingMatchScore.setOversFaced(oversFaced);
		}else if(ballScore.getBallNumber()==6) {
			double oversFaced= battingMatchScore.getOversFaced();
			oversFaced=oversFaced+1.0-0.5;
			battingMatchScore.setOversFaced(oversFaced);
		}
		
		battingMatchScore.setRunRate(battingMatchScore.getRunsScored()/battingMatchScore.getOversFaced());
		
		if(ballScore.getMatchStatus().equalsIgnoreCase("on-going")) {
			battingMatchScore.setMatchStatus(ballScore.getMatchStatus());
		}else if(ballScore.getMatchStatus().equalsIgnoreCase("batting team wins")) {
			battingMatchScore.setMatchStatus("won");
		}else if(ballScore.getMatchStatus().equalsIgnoreCase("batting team looses")){
			battingMatchScore.setMatchStatus("loss");
		}else {
			battingMatchScore.setMatchStatus("tied");
		}
		
		battingMatchScore.setTeamId(battingTeam.getId());
		
		
		//set data for bowling team
		if(ballScore.getBallNumber()!=6) {
			double oversBowled= bowlingMatchScore.getOversBowled();
			oversBowled=oversBowled+0.1;
			bowlingMatchScore.setOversBowled(oversBowled);
			logger.debug("overs bowled------>"+bowlingMatchScore.getOversBowled());
		}else if(ballScore.getBallNumber()==6) {
			double oversBowled= bowlingMatchScore.getOversBowled();
			oversBowled=oversBowled+1.0-0.5;
			bowlingMatchScore.setOversBowled(oversBowled);
			logger.debug("overs bowled------>"+bowlingMatchScore.getOversBowled());
		}
		if(ballScore.getWicket()==true) {
			bowlingMatchScore.setWickets(bowlingMatchScore.getWickets()+1);
			logger.debug("wickets taken------>"+bowlingMatchScore.getWickets());
		}
		
		
		if(ballScore.getMatchStatus().equalsIgnoreCase("on-going")) {
			bowlingMatchScore.setMatchStatus(ballScore.getMatchStatus());
		}else if(ballScore.getMatchStatus().equalsIgnoreCase("batting team wins")) {
			bowlingMatchScore.setMatchStatus("loss");
		}else if(ballScore.getMatchStatus().equalsIgnoreCase("batting team looses")){
			bowlingMatchScore.setMatchStatus("win");
		}else {
			bowlingMatchScore.setMatchStatus("tied");
		}
		
		
		
		bowlingMatchScore.setTeamId(bowlingTeam.getId());
		bowlingMatchScore.setScheduleId(ballScore.getScheduleId());
		
		matchScoreRepository.save(battingMatchScore);
		matchScoreRepository.save(bowlingMatchScore);
		logger.debug("match score updated");
		
	}

	//update player match performance
	@Transactional
	public void updatePlayerMatchPerformance(BallScore ballScore) {
		
		logger.debug("updating player match performance");
	
		optBatPlayerMatchPerformance=playerMatchPerformanceRepository.findByScheduleIdAndPlayer(ballScore.getScheduleId(),batsman);
		
		if(optBatPlayerMatchPerformance.isPresent()) {
			battingPlayerMatchPerformance=optBatPlayerMatchPerformance.get();
		}else {
			battingPlayerMatchPerformance= new PlayerMatchPerformance();
			battingPlayerMatchPerformance.setScheduleId(ballScore.getScheduleId());
			battingPlayerMatchPerformance.setPlayer(batsman);
			
		}
		optBowlPlayerMatchPerformance=playerMatchPerformanceRepository.findByScheduleIdAndPlayer(ballScore.getScheduleId(),bowler);
		
		if(optBowlPlayerMatchPerformance.isPresent()) {
			bowlingPlayerMatchPerformance=optBowlPlayerMatchPerformance.get();
		}else {
			bowlingPlayerMatchPerformance= new PlayerMatchPerformance();
			bowlingPlayerMatchPerformance.setScheduleId(ballScore.getScheduleId());
			bowlingPlayerMatchPerformance.setPlayer(batsman);
		}
		
		battingPlayerMatchPerformance.setBallsFaced(battingPlayerMatchPerformance.getBallsFaced()+1);
		
		if(ballScore.getRuns()==4) {
			int fours= battingPlayerMatchPerformance.getFours();
			fours=fours+1;
			battingPlayerMatchPerformance.setFours(fours);
		}else if(ballScore.getRuns()==6) {
			int sixes= battingPlayerMatchPerformance.getSixes();
			sixes=sixes+1;
			battingPlayerMatchPerformance.setSixes(sixes);
		}
		
		battingPlayerMatchPerformance.setRunsScored(battingPlayerMatchPerformance.getRunsScored()+ballScore.getRuns());
		battingPlayerMatchPerformance.setStrikeRate(battingPlayerMatchPerformance.getRunsScored()*100/battingPlayerMatchPerformance.getBallsFaced());
		
		//set bowling player data
		if(ballScore.getBallNumber()!=6) {
			double oversBowled= bowlingPlayerMatchPerformance.getOversBowled();
			oversBowled=oversBowled+0.1;
			bowlingPlayerMatchPerformance.setOversBowled(oversBowled);
		}else if(ballScore.getBallNumber()==6) {
			double oversBowled= bowlingPlayerMatchPerformance.getOversBowled();
			oversBowled=oversBowled+1.0-0.5;
			bowlingPlayerMatchPerformance.setOversBowled(oversBowled);
		}
		bowlingPlayerMatchPerformance.setRunsConcided(bowlingPlayerMatchPerformance.getRunsConcided()+ballScore.getRuns());
		if(ballScore.getWicket()==true) {
			bowlingPlayerMatchPerformance.setWickets(bowlingPlayerMatchPerformance.getWickets()+1);
		}
		bowlingPlayerMatchPerformance.setPlayer(bowler);
		
		playerMatchPerformanceRepository.save(battingPlayerMatchPerformance);
		playerMatchPerformanceRepository.save(bowlingPlayerMatchPerformance);
	}

	//update player contest performance
	@Transactional
	public void updatePlayerContestPerformance(BallScore ballScore) {
		
		logger.debug("updating player contest performance");
		
		//get contest object
		contest=battingTeam.getContest();
		logger.debug("contest object and its id --->"+contest+contest.getId());
		optBatPlayerContestPerformance=playerContestPerformanceRepository.findByContestAndPlayer(contest, batsman);
		optBowlPlayerContestPerformance=playerContestPerformanceRepository.findByContestAndPlayer(contest, bowler);
		
		if(optBatPlayerContestPerformance.isPresent()) {
			battingPlayerContestPerformance=optBatPlayerContestPerformance.get();
		}else {
			battingPlayerContestPerformance= new PlayerContestPerformance();
			battingPlayerContestPerformance.setPlayer(batsman);
			battingPlayerContestPerformance.setContest(contest);
		}
		
		if(optBowlPlayerContestPerformance.isPresent()) {
			bowlingPlayerContestPerformance=optBowlPlayerContestPerformance.get();
		}else {
			bowlingPlayerContestPerformance= new PlayerContestPerformance();
			bowlingPlayerContestPerformance.setPlayer(batsman);
			bowlingPlayerContestPerformance.setContest(contest);
		}
		
		//set battsman data
		battingPlayerContestPerformance.setPlayer(batsman);
		battingPlayerContestPerformance.setRunsScored(battingPlayerContestPerformance.getRunsScored()+ballScore.getRuns());
		battingPlayerContestPerformance.setBallsFaced(battingPlayerContestPerformance.getBallsFaced()+1);
		if(battingPlayerContestPerformance.getMatches()==0) {
			battingPlayerContestPerformance.setAverage(battingPlayerContestPerformance.getRunsScored());
		}else {
			battingPlayerContestPerformance.setAverage(battingPlayerContestPerformance.getRunsScored()/battingPlayerContestPerformance.getMatches());
		}
		
		if(battingPlayerMatchPerformance.getRunsScored()>=100) {
			battingPlayerContestPerformance.setCentury(battingPlayerContestPerformance.getCentury()+1);
		}else if(battingPlayerMatchPerformance.getRunsScored()>=50) {
			battingPlayerContestPerformance.setFifty(battingPlayerContestPerformance.getFifty()+1);
		}
		
		if(ballScore.getRuns()==4) {
			int fours= battingPlayerContestPerformance.getFours();
			fours=fours+1;
			battingPlayerContestPerformance.setFours(fours);
		}else if(ballScore.getRuns()==6) {
			int sixes= battingPlayerContestPerformance.getSixes();
			sixes=sixes+1;
			battingPlayerContestPerformance.setSixes(sixes);
		}
		
		if(battingPlayerContestPerformance.getHighestScore()<battingPlayerMatchPerformance.getRunsScored()) {
			battingPlayerContestPerformance.setHighestScore(battingPlayerMatchPerformance.getRunsScored());
		}
		

			battingPlayerContestPerformance.setMatches(playerMatchPerformanceRepository.countByPlayerId(batsman.getId()));
		battingPlayerContestPerformance.setStrikeRate(battingPlayerContestPerformance.getRunsScored()*100/battingPlayerContestPerformance.getBallsFaced());
		
		//set bowler data
		bowlingPlayerContestPerformance.setPlayer(bowler);
		
			bowlingPlayerContestPerformance.setMatches(playerMatchPerformanceRepository.countByPlayerId(bowler.getId()));
		if(ballScore.getBallNumber()!=6) {
			double oversBowled= bowlingPlayerContestPerformance.getOversBowled();
			oversBowled=oversBowled+0.1;
			bowlingPlayerContestPerformance.setOversBowled(oversBowled);
		}else if(ballScore.getBallNumber()==6) {
			double oversBowled= bowlingPlayerContestPerformance.getOversBowled();
			oversBowled=oversBowled+1.0-0.5;
			bowlingPlayerContestPerformance.setOversBowled(oversBowled);
		}
		if(ballScore.getWicket()==true) {
			bowlingPlayerContestPerformance.setWickets(bowlingPlayerContestPerformance.getWickets()+1);
		}
		
		playerContestPerformanceRepository.save(battingPlayerContestPerformance);
		playerContestPerformanceRepository.save(bowlingPlayerContestPerformance);
	}

	//update team performance
	@Transactional
	public void updateTeamPerformance(BallScore ballScore) {
		
		logger.debug("updating team performance");
		
		//get batting team performance
		if(battingTeam.getTeamPerformance()!=null) {
			battingTeamPerformance=battingTeam.getTeamPerformance();
		}else {
			battingTeamPerformance= new TeamPerformance();
			battingTeamPerformance.setTeam(battingTeam);
		}
		
		if(bowlingTeam.getTeamPerformance()!=null) {
			bowlingTeamPerformance=bowlingTeam.getTeamPerformance();
		}else {
			bowlingTeamPerformance= new TeamPerformance();
			bowlingTeamPerformance.setTeam(bowlingTeam);
		}
		
		
		//set data to batting team performance
		battingTeamPerformance.setMatchesPlayed(matchScoreRepository.countByTeamId(battingTeam.getId()));
		battingTeamPerformance.setLoss(matchScoreRepository.countByTeamIdAndMatchStatus(battingTeam.getId(), "loss"));
		battingTeamPerformance.setWin(matchScoreRepository.countByTeamIdAndMatchStatus(battingTeam.getId(), "won"));
		logger.debug("bating team points ------------------------------------>>>>>>>>>>>>"+battingTeamPerformance.getWin()*2+battingTeamPerformance.getNoResult());
		battingTeamPerformance.setPoints((int)(battingTeamPerformance.getWin()*2+battingTeamPerformance.getNoResult()));
		battingTeamPerformance.setNoResult(matchScoreRepository.countByTeamIdAndMatchStatus(battingTeam.getId(), "tied"));
		
		//set data to bowling Team
		bowlingTeamPerformance.setMatchesPlayed(matchScoreRepository.countByTeamId(bowlingTeam.getId()));
		bowlingTeamPerformance.setLoss(matchScoreRepository.countByTeamIdAndMatchStatus(bowlingTeam.getId(), "loss"));
		bowlingTeamPerformance.setWin(matchScoreRepository.countByTeamIdAndMatchStatus(bowlingTeam.getId(), "won"));
		logger.debug("bowling team points ------------------------------------>>>>>>>>>>>>"+bowlingTeamPerformance.getWin()*2+bowlingTeamPerformance.getNoResult());
		bowlingTeamPerformance.setPoints(bowlingTeamPerformance.getWin()*2+bowlingTeamPerformance.getNoResult());
		bowlingTeamPerformance.setNoResult(matchScoreRepository.countByTeamIdAndMatchStatus(bowlingTeam.getId(), "tied"));
		
		teamPerformanceRepository.save(battingTeamPerformance);
		teamPerformanceRepository.save(bowlingTeamPerformance);
	}

	@Transactional
	private void getPlayer(BallScore ballScore) {
		logger.debug("getting optional player");
		optBat= playerRepository.findById(ballScore.getBattingPlayerId());
		logger.debug("got optional player");
		if(optBat.isPresent()) {
			logger.debug("getting player");
			batsman=optBat.get();
			logger.debug("got player");
		}
		
		optBowl= playerRepository.findById(ballScore.getBowlingPlayerId());
		if(optBowl.isPresent()) {
			bowler=optBowl.get();
		}
	}
	@Transactional
	private void getTeam() {
		logger.debug("getting teams");
		battingTeam=batsman.getTeam();
		bowlingTeam=bowler.getTeam();
		logger.debug("got teams");
	}

	public List<MatchScore> getMatchScore(Long scheduleId) {
		
		logger.debug("service invoked for getting Match Score");
		
		return matchScoreRepository.findByScheduleId(scheduleId);
		
	}

	public PlayerMatchPerformance getPlayerMatchPerformance(Long playerId, Long scheduleId) {
		
		logger.debug("service invoked for getting player match performance");
		
		return playerMatchPerformanceRepository.findByPlayerIdAndScheduleId(playerId, scheduleId);
	}

	public PlayerContestPerformance getPlayerContestPerformance(Long playerId, Long contestId) {
		
		logger.debug("service invoked for getting player contest performance");
		
		return playerContestPerformanceRepository.findByPlayerIdAndContestId(playerId, contestId);
	}

	public TeamPerformance getTeamPerformance(Long teamId) {
		
		logger.debug("service invoked for getting team performance");
		
		return teamPerformanceRepository.findByTeamId(teamId);
	}

	
	
	
}
