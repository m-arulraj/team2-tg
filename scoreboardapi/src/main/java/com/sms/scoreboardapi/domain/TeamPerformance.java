package com.sms.scoreboardapi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="team_performance")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.StringIdGenerator.class,
        property="id")
public class TeamPerformance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Transient
	private String teamName;
	@Column(name="matches_played")
	private int matchesPlayed;
	@Column(name="matches_win")
	private int win;
	@Column(name="matches_loss")
	private int loss;
	@Column(name="no_result")
	private int noResult;
	@Column(name="points")
	private int points;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="team_id")
	private Team team;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLoss() {
		return loss;
	}

	public void setLoss(int loss) {
		this.loss = loss;
	}

	public int getNoResult() {
		return noResult;
	}

	public void setNoResult(int noResult) {
		this.noResult = noResult;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
