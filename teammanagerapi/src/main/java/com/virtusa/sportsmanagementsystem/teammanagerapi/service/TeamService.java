package com.virtusa.sportsmanagementsystem.teammanagerapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.sportsmanagementsystem.teammanagerapi.domain.Player;
import com.virtusa.sportsmanagementsystem.teammanagerapi.domain.Team;
import com.virtusa.sportsmanagementsystem.teammanagerapi.repository.PlayerRepository;
import com.virtusa.sportsmanagementsystem.teammanagerapi.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	TeamRepository teamRepository;
	@Autowired
	PlayerRepository playerRepository;
	
	private static Logger logger = Logger.getLogger(TeamService.class.getClass());

	@Transactional
	public Team registerTeam(Team team) {
		logger.info("register team service is started");
		logger.debug("Team Registration service is invoked");
		Team t = teamRepository.getTeam(team.getTeamName());
		if(t==null)
		return teamRepository.save(team);
		else
			return null;
	}

	public List<Team> getteamlist() {
		return teamRepository.getListOfTeams();
	}

	
	public Team getTeamBasedOnPlayer(int id) {
		Player player= playerRepository.getTeamBasedOnPlayer(id);
		return player.getTeam();
	}
	public List<Team> getteamlistBasedOnContestId(int contestId) {
		return teamRepository.getListOfTeamsbasedonContestId(contestId);
	}
	public Team updateTeam(int id,Team team) {
			team.setId(id);
			return teamRepository.save(team);
		
	}

	public Team getteam(int id) {
		Team team = teamRepository.findById(id).get();
		
		return team;
	}

}
