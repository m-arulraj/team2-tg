package com.virtusa.sportsmanagementsystem.teammanagerapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.sportsmanagementsystem.teammanagerapi.domain.Team;



@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	@Query("select t from Team t")
	List<Team> getListOfTeams();
	
	@Query("select t from Team t where t.teamName=:teamName")
	Team getTeam(@Param("teamName") String teamName);
	
	@Query("select t from Team t where t.contestId=:contestId")
	List<Team> getListOfTeamsbasedonContestId(@Param("contestId") int contestId);
	@Query("select t from Team t where t.id=:id")
	Team getTeambasedonId(@Param("id") int id);
	
}
