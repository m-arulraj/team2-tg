package com.virtusa.sportsManagementSystem.teammanagement_service.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="team")
public class Team {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@NotEmpty(message = "Team name should not be empty")
	@Column(name="team_name")
	private String teamName;
	
	@NotEmpty(message = "introduced year should not be empty")
	@Pattern(regexp="[^a-z]*", message ="it should be in numberformat")
	@Size(min=4,max=4)
	@Column(name="introduced_on")
	private String  introducedOn;

	@Column(name="team_manager_id")
	private int teamManagerId;
	
	public int getTeamManagerId() {
		return teamManagerId; 
	}
	public void setTeamManagerId(int teamManagerId) {
		this.teamManagerId = teamManagerId;
	}
	@Column(name="contest_id")
	private int contestId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" + teamName + ", introducedOn=" + introducedOn + ", teamManagerId=" + teamManagerId
				+ ", contestId=" + contestId + "]";
	}
}
