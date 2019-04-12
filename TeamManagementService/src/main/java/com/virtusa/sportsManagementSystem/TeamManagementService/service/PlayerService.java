package com.virtusa.sportsManagementSystem.TeamManagementService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.sportsManagementSystem.TeamManagementService.domain.Player;
import com.virtusa.sportsManagementSystem.TeamManagementService.domain.Team;
import com.virtusa.sportsManagementSystem.TeamManagementService.repository.PlayerRepository;
import com.virtusa.sportsManagementSystem.TeamManagementService.repository.TeamRepository;

@Service
public class PlayerService {
	@Autowired
	TeamRepository teamRepository;
	@Autowired
	PlayerRepository playerRepository;
	
	public Player registerPlayer(Player player) {
		Team team = teamRepository.getTeam(player.getTeam().getTeamName());
		if (team != null) {
			player.setTeam(team);
			teamRepository.save(team);
			return playerRepository.save(player);
		}
		 
		return new Player();
		
	}
	public List<Player> getPlayerListBasedOnRole(String playerRole){
		List<Player> playerList = playerRepository.getplayersBasedOnRole(playerRole);
		return playerList;
	}
	public List<Player> getPlayerListBasedOnTeam(int id){
		Team team = teamRepository.findById(id).get();
		List<Player> playerList = playerRepository.getplayersBasedOnteam(team);
		playerList.forEach((p)->System.out.println(p));
		return playerList;
	}

}
