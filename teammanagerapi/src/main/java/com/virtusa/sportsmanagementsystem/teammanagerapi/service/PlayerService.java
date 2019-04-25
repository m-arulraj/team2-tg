package com.virtusa.sportsmanagementsystem.teammanagerapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.sportsmanagementsystem.teammanagerapi.domain.Player;
import com.virtusa.sportsmanagementsystem.teammanagerapi.domain.Team;
import com.virtusa.sportsmanagementsystem.teammanagerapi.repository.PlayerRepository;
import com.virtusa.sportsmanagementsystem.teammanagerapi.repository.TeamRepository;


@Service
public class PlayerService {
	@Autowired
	TeamRepository teamRepository;
	@Autowired
	PlayerRepository playerRepository;
	
	public Player registerPlayer(Player player) {
		Team team = teamRepository.findById(player.getTeam().getId()).get();
		Team t = teamRepository.getTeam(player.getTeam().getTeamName());
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
		return playerList;
	}
	public Player getPlayerListBasedPlayerId(int id) {
		return playerRepository.findById(id).get();
	}
	public Player updateplayer(int id, Player player) {
		player.setId(id);
			return playerRepository.save(player);
	}

}
