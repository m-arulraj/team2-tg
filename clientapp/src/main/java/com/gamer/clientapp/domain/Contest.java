package com.gamer.clientapp.domain;




public class Contest {


	private Long id;

	private String contestName;

	private String startingDate;

	private String completionDate;

	private String contestType;

	private Long numberOfTeams;

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
