package com.sms.scoreboardapi.resource;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sms.scoreboardapi.domain.BallScore;
import com.sms.scoreboardapi.domain.MatchScore;
import com.sms.scoreboardapi.domain.PlayerContestPerformance;
import com.sms.scoreboardapi.domain.PlayerMatchPerformance;
import com.sms.scoreboardapi.domain.TeamPerformance;
import com.sms.scoreboardapi.service.ScoreBoardServiceImpl;


@RestController
@RequestMapping(value = "/api/scoreboard/matchscore")
public class ScoreBoardResource {

	@Autowired
	private ScoreBoardServiceImpl service;

	private static Logger logger = Logger.getLogger(ScoreBoardResource.class);

	@Valid
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<String> updateScore(@Valid @RequestBody BallScore ballScore, Errors errors) {

		logger.info("updating match score");
		logger.debug("controller invoked for updating score");
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		try {
			service.updateScore(ballScore);
			logger.debug("updated score");
			logger.info("updated score successfully");
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("couldn't update score");
			logger.info("Error occured during updation-couldn't update score");
			return new ResponseEntity<String>(HttpStatus.METHOD_FAILURE);
		}
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public List<MatchScore> getMatchScore(@PathVariable(name="id") Long scheduleId){
		
		logger.info("getting match score");
		logger.debug("controller invoked for getting match score");
		
		return service.getMatchScore(scheduleId);
	}
	
	@RequestMapping(value="/player-match-performance/{playerId}/{scheduleId}",method=RequestMethod.GET)
	public PlayerMatchPerformance getPlayerMatchPerformance(@PathVariable(name="scheduleId") Long scheduleId,@PathVariable(name="playerId") Long playerId){
		
		logger.info("getting player match performance");
		logger.debug("controller invoked for getting player match performance");
		
		return service.getPlayerMatchPerformance(playerId, scheduleId);
	}
	
	@RequestMapping(value="/player-contest-performance/{playerId}/{contestId}",method=RequestMethod.GET)
	public PlayerContestPerformance getPlayerContestPerformance(@PathVariable(name="contestId") Long scheduleId,@PathVariable(name="playerId") Long playerId){
		
		logger.info("getting player contest performance");
		logger.debug("controller invoked for getting player contest performance");
		
		return service.getPlayerContestPerformance(playerId, scheduleId);
	}
	
	@RequestMapping(value="/team-performance/{teamId}",method=RequestMethod.GET)
	public TeamPerformance getTeamPerformance(@PathVariable(name="teamId") Long teamId){
		
		logger.info("getting team performance");
		logger.debug("controller invoked for getting team performance");
		
		return service.getTeamPerformance(teamId);
	}
	
}
