package com.virtusa.sportsManagementSystem.TeamManagementService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.sportsManagementSystem.TeamManagementService.TeamManagementApplication;
import com.virtusa.sportsManagementSystem.TeamManagementService.domain.Player;
import com.virtusa.sportsManagementSystem.TeamManagementService.domain.Team;
import com.virtusa.sportsManagementSystem.TeamManagementService.repository.PlayerRepository;
import com.virtusa.sportsManagementSystem.TeamManagementService.repository.TeamRepository;

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

	public List<String> getteamlist() {
		return teamRepository.getListOfTeams();
	}

	
	public Team getTeamBasedOnPlayer(int id) {
		Player player= playerRepository.getTeamBasedOnPlayer(id);
		System.out.println(player.getTeam());
		return player.getTeam();
	}
}
