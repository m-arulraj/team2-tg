package com.virtusa.sportsmanagementsystem.teammanagerapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.sportsmanagementsystem.teammanagerapi.domain.Team;



@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	@Query("select t.teamName from Team t")
	List<String> getListOfTeams();
	
	@Query("select t from Team t where t.teamName=:teamName")
	Team getTeam(@Param("teamName") String teamName);
	
	
}
