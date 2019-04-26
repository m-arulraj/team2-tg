package com.gamer.clientapp.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gamer.clientapp.domain.Player;
import com.gamer.clientapp.domain.Team;
import com.gamer.clientapp.domain.User;
import com.gamer.clientapp.domain.UserRole;
import com.gamer.clientapp.util.EndPointConstraint;

@Service
public class RegistrationService {

	RestTemplate template = new RestTemplate();
	
	public UserRole registerUser(UserRole userRole) {
		ResponseEntity<UserRole> reguser = template.postForEntity(EndPointConstraint.USERREGISTRATION_URL, userRole, UserRole.class);
		return  reguser.getBody();
	}
	public List<String> getUserRoles(){
		String uri = "/roles";
		ResponseEntity<List<String>> userRoles = template.exchange(EndPointConstraint.USERREGISTRATION_URL+uri, HttpMethod.GET, 
				null, new ParameterizedTypeReference<List<String>>() {
				});
		return userRoles.getBody()
				;
	}
	public Team registerTeam(Team team) {
		ResponseEntity<Team> registerTeam = template.postForEntity(EndPointConstraint.TEAMMANAGEMENT_URL, team, Team.class);
		return registerTeam.getBody();
	}
	public Player registerPlayer(Player player) {
		String uri = "/player";
		ResponseEntity<Player> registerPlayer = template.postForEntity(EndPointConstraint.TEAMMANAGEMENT_URL+ uri, player, Player.class);	
		return registerPlayer.getBody();
	}
	public void updateTeam(int id,Team team) {
		template.put(EndPointConstraint.TEAMMANAGEMENT_URL+"/"+id, team);
	}
	public void updateplayer(int id,Player player) {
		template.put(EndPointConstraint.TEAMMANAGEMENT_URL+"/player/"+id, player);
	}
	
	  public List<Team> getSearchedTeamList(String search){
		  System.out.println(search);
		  String uri = "/search/";
	  ResponseEntity<List<Team>> teamList =
	  template.exchange(EndPointConstraint.TEAMMANAGEMENT_URL+uri+search,
	  HttpMethod.GET, null, new ParameterizedTypeReference<List<Team>>() { }); 
	 return  teamList.getBody();
	  }
	 
	  public List<Player> getSearchedPlayerList(String search){
		  String uri = "/player/search/";
	  ResponseEntity<List<Player>> playerList =
	  template.exchange(EndPointConstraint.TEAMMANAGEMENT_URL+uri+search,
	  HttpMethod.GET, null, new ParameterizedTypeReference<List<Player>>() { }); 
	 return  playerList.getBody();
	  }
	 
	
}
