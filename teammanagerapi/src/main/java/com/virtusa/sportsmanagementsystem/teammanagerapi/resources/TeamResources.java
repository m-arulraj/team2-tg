package com.virtusa.sportsmanagementsystem.teammanagerapi.resources;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.sportsmanagementsystem.teammanagerapi.domain.Team;
import com.virtusa.sportsmanagementsystem.teammanagerapi.service.TeamService;

@RestController
@RequestMapping("/api/team")
@CrossOrigin(origins = "*", allowedHeaders = "*",methods={RequestMethod.POST,RequestMethod.GET,RequestMethod.OPTIONS})

public class TeamResources {
	@Autowired
	TeamService teamService;
	private static Logger logger = Logger.getLogger(TeamResources.class);

	@PostMapping("")
	public ResponseEntity<Team> registerTeam(@Valid @RequestBody Team team, BindingResult bindResult) {
		logger.info("register team controller is started");
		logger.debug("Team Registration controller is invoked");
		logger.error(bindResult.getFieldError());
		System.out.println(bindResult.getFieldError());
		if (bindResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		} else {
			Team t = teamService.registerTeam(team);
			return t != null ? new ResponseEntity<Team>(t, HttpStatus.CREATED)
					: new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@GetMapping("")
	public List<String> getteamList() {
		return teamService.getteamlist();
	}

	@GetMapping("/Team-Player")
	public Team getTeamBasedOnPlayer(@RequestParam("id") int id) {
		System.out.println(id);
		return teamService.getTeamBasedOnPlayer(id);
	}
	@GetMapping("/{contestId}")
	public List<Team> getteamListBasedonContestId(@PathVariable(name="contestId") int contestId) {
		return teamService.getteamlistBasedOnContestId(contestId);
	}

}
