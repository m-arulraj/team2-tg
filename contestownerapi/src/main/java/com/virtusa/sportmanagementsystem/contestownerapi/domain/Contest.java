package com.virtusa.sportmanagementsystem.contestownerapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "contest")
public class Contest {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@NotEmpty(message="Contest name should not be empty")
	@Pattern(regexp="[^0-9]*", message="Numbers are not accepted")
	@Column(name = "contest_name")
	private String contestName;

	@Column(name = "starting_date")
	private String startingDate;

	@Column(name = "completion_date")
	private String completionDate;

	@Column(name = "contest_type")
	private String contestType;

	@Column(name = "no_of_teams")
	private Long numberOfTeams;

	@Column(name = "user_id")
	private Long userId;

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

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public String getContestType() {
		return contestType;
	}

	public void setContestType(String contestType) {
		this.contestType = contestType;
	}

	public Long getNumberOfTeams() {
		return numberOfTeams;
	}

	public void setNumberOfTeams(Long numberOfTeams) {
		this.numberOfTeams = numberOfTeams;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
