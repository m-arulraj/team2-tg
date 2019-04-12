package com.virtusa.sportmanagementsystem.contestownerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.sportmanagementsystem.contestownerapi.domain.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

	@Query("select t.teamName from Team t where t.id=:teamOneId")
	String getTeamOneName(@Param("teamOneId")Long teamOneId);
	
	@Query("select t.teamName from Team t where t.id=:teamTwoId")
	String getTeamTwoName(@Param("teamTwoId")Long teamTwoId);

}
