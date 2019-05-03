package com.virtusa.sportsmanagementsystem.teammanagerapi.resources;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.sportsmanagementsystem.teammanagerapi.domain.Team;
import com.virtusa.sportsmanagementsystem.teammanagerapi.service.TeamService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",methods={RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.OPTIONS})
@RequestMapping("/api/team")
public class TeamResources {
	@Autowired
	TeamService teamService;
	private static Logger logger = Logger.getLogger(TeamResources.class);

	@PostMapping("")
	public ResponseEntity<Team> registerTeam(@Valid @RequestBody Team team, BindingResult bindResult) {
		logger.info("register team controller is started");
		logger.debug("Team Registration controller is invoked");
		logger.error(bindResult.getFieldError());
		if (bindResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		} else {
			Team t = teamService.registerTeam(team);
			return t != null ? new ResponseEntity<Team>(t, HttpStatus.CREATED)
					: new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@GetMapping("")
	public List<Team> getteamList() {
		List<Team> teamList = teamService.getteamlist();
		List<Team> sortedTeamList = teamList.stream().sorted(Comparator.comparing(Team::getTeamName)).collect(Collectors.toList());
		return sortedTeamList;
	}

	@GetMapping("/Team-Player")
	public Team getTeamBasedOnPlayer(@RequestParam("id") int id) {
		return teamService.getTeamBasedOnPlayer(id);
	}
	@GetMapping("/{contestId}")
	public List<Team> getteamListBasedonContestId(@PathVariable(name="contestId") int contestId) {
		List<Team> teamList= teamService.getteamlistBasedOnContestId(contestId);
		List<Team> sortedTeamList = teamList.stream().sorted(Comparator.comparing(Team::getTeamName)).collect(Collectors.toList());
		return sortedTeamList;
	}
	@PutMapping("/{id}")
	public ResponseEntity<Team> updateTeam(@PathVariable(name="id") int id, @RequestBody Team team){
		Team t = teamService.updateTeam(id, team);
		return t != null ? new ResponseEntity<Team>(t, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	@GetMapping("/team/{tId}")
	public ResponseEntity<Team>  getteam(@PathVariable(name="tId") int id) {
		Team t =teamService.getteam(id);
		return t != null ? new ResponseEntity<Team>(t, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/search/{search}")
	public List<Team> getSearchedTeamList(@PathVariable(name="search")  String search) {
		List<Team> teamList = teamService.getteamlist();
		List<Team> serchedTeams =teamList.stream().
				filter(t->(t.getTeamName().contains(search)||t.getTeamName().contains(search.toUpperCase())||t.getTeamName().contains(search.toLowerCase()))).
				collect(Collectors.toList());
		return serchedTeams;
	}
	@GetMapping("/sorted")
	public List<Team> getSortedTeams() {
		List<Team> teamList = teamService.getteamlist();
		List<Team> sortedTeamList = teamList.stream().sorted(Comparator.comparing(Team::getTeamName)).collect(Collectors.toList());
		return sortedTeamList;
	}


}
