package com.sms.scoreboardapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="player_match_performance")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.StringIdGenerator.class,
        property="id")
public class PlayerMatchPerformance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="schedule_id")
	private Long scheduleId;
	@Column(name="runs_scored")
	private int runsScored;
	@Column(name="fours")
	private int fours;
	@Column(name="sixes")
	private int sixes;
	@Column(name="balls_faced")
	private int ballsFaced;
	@Column(name="strike_rate")
	private double strikeRate;
	@Column(name="overs_Bowled")
	private double oversBowled;
	@Column(name="wickets")
	private int wickets;
	@Column(name="runs_concided")
	private int runsConcided;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="player_id")
	private Player player;

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

	public int getBallsFaced() {
		return ballsFaced;
	}

	public void setBallsFaced(int ballsFaced) {
		this.ballsFaced = ballsFaced;
	}

	public double getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
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

	public int getRunsConcided() {
		return runsConcided;
	}

	public void setRunsConcided(int runsConcided) {
		this.runsConcided = runsConcided;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
}
