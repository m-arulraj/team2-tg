package com.virtusa.sportsmanagementsystem.teammanagerapi.resources;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.virtusa.sportsmanagementsystem.teammanagerapi.domain.Player;
import com.virtusa.sportsmanagementsystem.teammanagerapi.domain.Team;
import com.virtusa.sportsmanagementsystem.teammanagerapi.service.PlayerService;
import com.virtusa.sportsmanagementsystem.teammanagerapi.service.TeamService;


@RestController
@RequestMapping("/api/team")
@CrossOrigin(origins = "*", allowedHeaders = "*",methods={RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.OPTIONS})
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
		return new ResponseEntity<Player>(p,HttpStatus.CREATED);
		}
		 
	}
	@GetMapping("/players")
	public List<Player> playerList(@RequestParam("playerRole") String playerRole){
		List<Player> playerList = playerservice.getPlayerListBasedOnRole(playerRole);
		List<Player> sortedTeamList = playerList.stream().sorted(Comparator.comparing(Player::getPlayerName)).collect(Collectors.toList());
		return sortedTeamList;
		
	}
	
	@GetMapping("/playersBasedOnTeam")
	public List<Player> playerListBasedOnTeam(@RequestParam("id") int id){
		List<Player> playerList = playerservice.getPlayerListBasedOnTeam(id);
		List<Player> sortedTeamList = playerList.stream().sorted(Comparator.comparing(Player::getPlayerName)).collect(Collectors.toList());
		return sortedTeamList;
	}
	@GetMapping("/player/{id}")
	public Player getplayer(@PathVariable(name="id") int id){
		Player player = playerservice.getPlayerListBasedPlayerId(id);
		return player;
	}
	@PutMapping("/player/{id}")
	public ResponseEntity<Player> updateplayer(@PathVariable(name="id") int id,@RequestBody Player player){
		Player p = playerservice.updateplayer(id,player);
		return p != null ? new ResponseEntity<Player>(p, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/player/search/{search}")
	public List<Player> getSearchedTeamList(@PathVariable(name="search")  String search) {
		List<Player> playerList = playerservice.getPlayerList();
		List<Player> serchedTeams =playerList.stream().
				filter(p->(p.getPlayerName().contains(search)||p.getPlayerName().contains(search.toUpperCase())||p.getPlayerName().toLowerCase().contains(search)||p.getPlayerName().contains(search.toLowerCase()))).
				collect(Collectors.toList());
		List<Player> searchedSortedTeamList = serchedTeams.stream().sorted(Comparator.comparing(Player::getPlayerName)).collect(Collectors.toList());
		return searchedSortedTeamList;
	}
	@GetMapping("/palyer/sorted")
	public List<Player> getSortedPlayers() {
		List<Player> playerList = playerservice.getPlayerList();
		List<Player> sortedTeamList = playerList.stream().sorted(Comparator.comparing(Player::getPlayerName)).collect(Collectors.toList());
		return sortedTeamList;
	}

}
