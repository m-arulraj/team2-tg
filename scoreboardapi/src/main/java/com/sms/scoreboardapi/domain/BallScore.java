package com.sms.scoreboardapi.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BallScore {

	@NotNull
	private Long scheduleId;
	@NotNull
	private Long battingPlayerId;
	@NotNull
	private Long bowlingPlayerId;
	@NotNull
	private int runs;
	@NotNull
	private Boolean wicket;
	@NotNull
	private int ballNumber;
	@NotNull
	@NotEmpty
	private String matchStatus;
	
	public Long getBattingPlayerId() {
		return battingPlayerId;
	}
	public void setBattingPlayerId(Long battingPlayerId) {
		this.battingPlayerId = battingPlayerId;
	}
	public Long getBowlingPlayerId() {
		return bowlingPlayerId;
	}
	public void setBowlingPlayerId(Long bowlingPlayerId) {
		this.bowlingPlayerId = bowlingPlayerId;
	}
	public Integer getRuns() {
		return runs;
	}
	public void setRuns(Integer runs) {
		this.runs = runs;
	}
	public Boolean getWicket() {
		return wicket;
	}
	public void setWicket(Boolean wicket) {
		this.wicket = wicket;
	}
	public Integer getBallNumber() {
		return ballNumber;
	}
	public void setBallNumber(Integer ballNumber) {
		this.ballNumber = ballNumber;
	}
	public Long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getMatchStatus() {
		return matchStatus;
	}
	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}
}
