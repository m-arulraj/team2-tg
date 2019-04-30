package com.sms.scoreboardapi.resource;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sms.scoreboardapi.domain.BallScore;
import com.sms.scoreboardapi.domain.MatchScore;
import com.sms.scoreboardapi.domain.Player;
import com.sms.scoreboardapi.domain.PlayerContestPerformance;
import com.sms.scoreboardapi.domain.PlayerMatchPerformance;
import com.sms.scoreboardapi.domain.TeamPerformance;
import com.sms.scoreboardapi.service.ScoreBoardServiceImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET,RequestMethod.PUT,
RequestMethod.OPTIONS })
@RequestMapping(value = "/api/scoreboard/matchscore")
public class ScoreBoardResource {

	@Autowired
	private ScoreBoardServiceImpl service;

	private static Logger logger = Logger.getLogger(ScoreBoardResource.class);

	/*@Valid
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
	}*/
	
	@Valid
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<String> updateScore(@Valid @RequestBody BallScore ballScore, Errors errors) {

		logger.info("updating match score");
		logger.debug("controller invoked for updating score");
		try {
			if(errors.hasErrors()) {
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
			else {
				service.updateScore(ballScore);
				logger.debug("updated score");
				logger.info("updated score successfully");
				return new ResponseEntity<String>(HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			logger.info("something went wrong..plz try again later--->"+e.getMessage());
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
	public PlayerContestPerformance getPlayerContestPerformance(@PathVariable(name="contestId") Long contestId,@PathVariable(name="playerId") Long playerId){
		
		logger.info("getting player contest performance");
		logger.debug("controller invoked for getting player contest performance");
		
		return service.getPlayerContestPerformance(playerId, contestId);
	}
	
	@RequestMapping(value="/team-performance/{teamId}",method=RequestMethod.GET)
	public TeamPerformance getTeamPerformance(@PathVariable(name="teamId") Long teamId){
		
		logger.info("getting team performance");
		logger.debug("controller invoked for getting team performance");
		
		return service.getTeamPerformance(teamId);
	}
	
	@RequestMapping(value="/highest-scorer/{contestId}",method=RequestMethod.GET)
	public Player getHighestScorer(@PathVariable(name="contestId") Long contestId) {
		
		logger.info("get highest scorer");
		return service.getHighestScorer(contestId);
	}
	
	@RequestMapping(value="team-performance",method=RequestMethod.GET)
	public List<TeamPerformance> getAllTeamPerformance(){
		logger.info("getting all teams performance");
		return service.getAllTeamPerformance();
	}
	@RequestMapping(value="team-match-performance/{teamId}/{scheduleId}",method=RequestMethod.GET)
	public MatchScore getTeamMatchPerformance(@PathVariable(name="teamId")Long teamId,@PathVariable(name="scheduleId")Long scheduleId) {
		logger.info("getting team match performance");
		logger.debug(service.getTeamMatchPerformance(teamId, scheduleId));
		return service.getTeamMatchPerformance(teamId, scheduleId);
	}
}
