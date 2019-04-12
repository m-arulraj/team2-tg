package com.sms.scoreboardapi.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="team")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.StringIdGenerator.class,
        property="id")
public class Team {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="team_name")
	@NotEmpty(message="tem name cant be empty")
	@NotBlank(message="team name cant be null")
	private String teamName;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="contest_id")
	private Contest contest;
	
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="team_manager_id")	
	private User manager;
	
	@OneToMany(mappedBy="team",fetch=FetchType.EAGER)
    private Set<Player> players;
	
	@OneToOne(mappedBy="team",fetch=FetchType.EAGER)
	private TeamPerformance teamPerformance;
	
	/*@OneToMany(mappedBy="team")*/
	/*private Set<MatchScore> matchScores;*/
	
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
	public Contest getContest() {
		return contest;
	}
	public void setContest(Contest contest) {
		this.contest = contest;
	}
	public User getManager() {
		return manager;
	}
	public void setManager(User manager) {
		this.manager = manager;
	}
	public Set<Player> getPlayers() {
		return players;
	}
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	public TeamPerformance getTeamPerformance() {
		return teamPerformance;
	}
	public void setTeamPerformance(TeamPerformance teamPerformance) {
		this.teamPerformance = teamPerformance;
	}

}
