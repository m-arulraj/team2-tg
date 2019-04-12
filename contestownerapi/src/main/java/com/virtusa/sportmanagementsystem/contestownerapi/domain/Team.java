package com.virtusa.sportmanagementsystem.contestownerapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="team")
public class Team {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="team_name")
	private String teamName;

	@Column(name="introduced_on")
	private String  introducedOn;

	@Column(name="team_manager_id")
	private int teamManagerId;
	
	@Column(name="contest_id")
	private int contestId;
	
	public int getTeamManagerId() {
		return teamManagerId; 
	}
	public void setTeamManagerId(int teamManagerId) {
		this.teamManagerId = teamManagerId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getIntroducedOn() {
		return introducedOn;
	}
	public void setIntroducedOn(String introducedOn) {
		this.introducedOn = introducedOn;
	}

	public int getContestId() {
		return contestId;
	}
	public void setContestId(int contestId) {
		this.contestId = contestId;
	}
}