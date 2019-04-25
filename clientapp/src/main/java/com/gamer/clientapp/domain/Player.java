package com.gamer.clientapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="player")
public class Player {
@Id
@GeneratedValue
@Column(name="id")
private int id;

@NotEmpty(message="player name should not be empty")
@Pattern(regexp="[^0-9]*", message="Numbers are not accepted")
@Column(name="player_name")
private String playerName;

@Column(name="player_role")
private String playerRole;

@Column(name="player_dob")
private String playerDob;

@Column(name="birth_place")
private String birthPlace;

@Column(name="batting_style")
private String battingStyle;

@Column(name="bowling_style")
private String bowlingStyle;
@ManyToOne
@JoinColumn(name="team_id")
private Team team;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPlayerName() {
	return playerName;
}
public void setPlayerName(String playerName) {
	this.playerName = playerName;
}
public String getPlayerRole() {
	return playerRole;
}
public void setPlayerRole(String playerRole) {
	this.playerRole = playerRole;
}
public String getPlayerDob() {
	return playerDob;
}
public void setPlayerDob(String playerDob) {
	this.playerDob = playerDob;
}
public String getBirthPlace() {
	return birthPlace;
}
public void setBirthPlace(String birthPlace) {
	this.birthPlace = birthPlace;
}
public String getBattingStyle() {
	return battingStyle;
}
public void setBattingStyle(String battingStyle) {
	this.battingStyle = battingStyle;
}
public String getBowlingStyle() {
	return bowlingStyle;
}
public void setBowlingStyle(String bowlingStyle) {
	this.bowlingStyle = bowlingStyle;
}
public Team getTeam() {
	return team;
}
public void setTeam(Team team) {
	this.team = team;
}
@Override
public String toString() {
	return "Player [id=" + id + ", playerName=" + playerName + ", playerRole=" + playerRole + ", playerDob=" + playerDob
			+ ", birthPlace=" + birthPlace + ", battingStyle=" + battingStyle + ", bowlingStyle=" + bowlingStyle
			+ ", team=" + team + "]";
}



}
