package com.sms.scoreboardapi.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="contest")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.StringIdGenerator.class,
        property="id")
public class Contest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="contest_name")
	private String contestName;
	@Column(name="starting_date")
	private String startingDate;
	@Column(name="completion_date")
	private String endingDate;
	@Column(name="contest_type")
	private String contestType;
	@Column(name="no_of_teams")
	private Integer noOfTeams;
	
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")	
	private Users owner;
	
	@OneToMany(mappedBy="contest",fetch=FetchType.EAGER)
    private Set<Team> teams;
	
	@OneToMany(mappedBy="contest",fetch=FetchType.EAGER)
	private Set<PlayerContestPerformance> playerContestPerformances;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContestName() {
		return contestName;
	}

	public void setContestName(String contestName) {
		this.contestName = contestName;
	}

	public String getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}

	public String getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(String endingDate) {
		this.endingDate = endingDate;
	}

	public String getContestType() {
		return contestType;
	}

	public void setContestType(String contestType) {
		this.contestType = contestType;
	}

	public Integer getNoOfTeams() {
		return noOfTeams;
	}

	public void setNoOfTeams(Integer noOfTeams) {
		this.noOfTeams = noOfTeams;
	}

	public Users getOwner() {
		return owner;
	}

	public void setOwner(Users owner) {
		this.owner = owner;
	}
}
