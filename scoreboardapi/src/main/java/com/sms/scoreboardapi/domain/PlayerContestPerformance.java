package com.sms.scoreboardapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="player_contest_performance")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.StringIdGenerator.class,
        property="id")
public class PlayerContestPerformance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="matches")
	@NotNull(message="matches name cant be null")
	private int matches;
	@NotNull(message="runs name cant be null")
	@Column(name="runs_scored")
	private int runsScored;
	@Column(name="fours")
	@NotNull(message="fours name cant be null")
	private int fours;
	@Column(name="sixes")
	@NotNull(message="sixes name cant be null")
	private int sixes;
	@Column(name="balls_faced")
	@NotNull(message="balls name cant be null")
	private int ballsFaced;
	@Column(name="strike_rate")
	private double strikeRate;
	@Column(name="average")
	private double average;
	@Column(name="highest_score")
	@NotNull(message="highest score name cant be null")
	private int highestScore;
	@Column(name="fifty")
	@NotNull(message="fifty name cant be null")
	private int fifty;
	@Column(name="century")
	@NotNull(message="century name cant be null")
	private int century;
	@Column(name="overs_bowled")
	@NotNull(message="overs name cant be null")
	private double oversBowled;
	@Column(name="wickets")
	@NotNull(message="wickets name cant be null")
	private int wickets;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="player_id")
	private Player player;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="contest_id")
	private Contest contest;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
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

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public int getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}

	public int getFifty() {
		return fifty;
	}

	public void setFifty(int fifty) {
		this.fifty = fifty;
	}

	public int getCentury() {
		return century;
	}

	public void setCentury(int century) {
		this.century = century;
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Contest getContest() {
		return contest;
	}

	public void setContest(Contest contest) {
		this.contest = contest;
	}
}
