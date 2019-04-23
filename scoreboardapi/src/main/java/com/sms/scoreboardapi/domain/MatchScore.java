package com.sms.scoreboardapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="match_score")
public class MatchScore {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	private Long scheduleId;
	
	@Transient
	private String teamName;
	@Column(name="runs_scored")
	private int runsScored;
	@Column(name="overs_faced")
	private double oversFaced;
	@Column(name="loss_of_wickets")
	private int lossOfWickets;
	@Column(name="fours")
	@NotNull
	@Digits(message="mathces can be number only", fraction = 0, integer =4)
	/*@Pattern(regexp="[^a-z]*",message="fours can only be number")*/
	private int fours;
	@Column(name="sixes")
	@NotNull
	@Digits(message="mathces can be number only", fraction = 0, integer =4)
	private int sixes;
	@Column(name="run_rate")
	@NotNull
	private double runRate;
	@Column(name="overs_bowled")
	@NotNull
	private double oversBowled;
	@Column(name="wickets")
	@NotNull
	private int wickets;
	@Column(name="match_status")
	@NotEmpty
	@NotNull
	private String matchStatus;
	
	/*@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="team_id")*/
	private Long teamId;

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

	public double getOversFaced() {
		return oversFaced;
	}

	public void setOversFaced(double oversFaced) {
		this.oversFaced = oversFaced;
	}

	public int getLossOfWickets() {
		return lossOfWickets;
	}

	public void setLossOfWickets(int lossOfWickets) {
		this.lossOfWickets = lossOfWickets;
	}

	public int getFours() {
		return fours;
	}

	public void setFours(int fours) {
		this.fours = fours;
	}

	public int getSixes() {
		return sixes;
	}

	public void setSixes(int sixes) {
		this.sixes = sixes;
	}

	public double getRunRate() {
		return runRate;
	}

	public void setRunRate(double runRate) {
		this.runRate = runRate;
	}
	
	public double getOversBowled() {
		return oversBowled;
	}

	public void setOversBowled(double oversBowled) {
		this.oversBowled = oversBowled;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public String getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
