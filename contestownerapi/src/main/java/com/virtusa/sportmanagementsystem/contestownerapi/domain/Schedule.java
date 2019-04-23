package com.virtusa.sportmanagementsystem.contestownerapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "schedule")
public class Schedule {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@NotEmpty(message="Venue should not be empty")
	@Pattern(regexp="[^0-9]*", message="Numbers are not accepted")
	@Column(name = "venue")
	private String venue;
	
	@Column(name = "match_date")
	private String matchDate;
	
	@Column(name = "contest_id")
	private Long contestId;
	
	@Column(name = "team_one")
	private Long teamOne;
	
	@Column(name = "team_two")
	private Long teamTwo;
	
	@Transient
	private String teamOneName;
	
	@Transient
	private String teamTwoName;
	
	public String getTeamOneName() {
		return teamOneName;
	}

	public void setTeamOneName(String teamOneName) {
		this.teamOneName = teamOneName;
	}

	public String getTeamTwoName() {
		return teamTwoName;
	}

	public void setTeamTwoName(String teamTwoName) {
		this.teamTwoName = teamTwoName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public Long getContestId() {
		return contestId;
	}

	public void setContestId(Long contestId) {
		this.contestId = contestId;
	}

	public Long getTeamOne() {
		return teamOne;
	}

	public void setTeamOne(Long teamOne) {
		this.teamOne = teamOne;
	}

	public Long getTeamTwo() {
		return teamTwo;
	}

	public void setTeamTwo(Long teamTwo) {
		this.teamTwo = teamTwo;
	}

}
