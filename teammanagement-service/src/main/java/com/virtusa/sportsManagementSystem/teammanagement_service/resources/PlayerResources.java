package com.virtusa.sportsManagementSystem.teammanagement_service.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.sportsManagementSystem.teammanagement_service.domain.Player;
import com.virtusa.sportsManagementSystem.teammanagement_service.service.PlayerService;
import com.virtusa.sportsManagementSystem.teammanagement_service.service.TeamService;



@RestController
@RequestMapping("/api/team")
public class PlayerResources {
	@Autowired
	PlayerService playerservice;
	@Autowired
	TeamService teamService;
	
	@PostMapping("/player")
	public ResponseEntity<?> registerPlayer(@Valid@RequestBody Player player,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(bindingResult.getAllErrors());
		}
		else {
		Player p = playerservice.registerPlayer(player);
		System.out.println(p);
		return new ResponseEntity<Player>(p,HttpStatus.CREATED);
		}
		 
	}
	@GetMapping("/players")
	public List<Player> playerList(@RequestParam("playerRole") String playerRole){
		List<Player> playerList = playerservice.getPlayerListBasedOnRole(playerRole);
		return playerList;
	}
	
	@GetMapping("/playersBasedOnTeam")
	public List<Player> playerListBasedOnTeam(@RequestParam("id") int id){
		List<Player> playerList = playerservice.getPlayerListBasedOnTeam(id);
		return playerList;
	}

}
