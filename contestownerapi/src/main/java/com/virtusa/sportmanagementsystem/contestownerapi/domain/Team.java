package com.virtusa.sportmanagementsystem.contestownerapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "team_name")
	private String teamName;

	@Column(name = "introduced_on")
	private String introducedOn;

	@Column(name = "team_manager_id")
	private int teamManagerId;

	@Column(name = "contest_id")
	private int contestId;
}