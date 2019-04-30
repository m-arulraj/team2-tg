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
		System.out.println("regt" +registerTeam.getBody());
		System.out.println("regt" +registerTeam.getStatusCodeValue());

		return registerTeam.getBody();
	}
	public Player registerPlayer(Player player) {
		String uri = "/player";
		ResponseEntity<Player> registerPlayer = template.postForEntity(EndPointConstraint.TEAMMANAGEMENT_URL+ uri, player, Player.class);
		System.out.println("regt" +registerPlayer.getBody());
		System.out.println("regt" +registerPlayer.getStatusCodeValue());

		return registerPlayer.getBody();
	}
	public void updateTeam(int id,Team team) {
		System.out.println("upteam" + EndPointConstraint.TEAMMANAGEMENT_URL+"/"+id);
		template.put(EndPointConstraint.TEAMMANAGEMENT_URL+"/"+id, team);
	}
	public void updateplayer(int id,Player player) {
		System.out.println("upteam" + EndPointConstraint.TEAMMANAGEMENT_URL+"/player/"+id);
		template.put(EndPointConstraint.TEAMMANAGEMENT_URL+"/player/"+id, player);
	}
}
