package com.sms.scoreboardapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sms.scoreboardapi.domain.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

	@Query("select t.teamName from Team t where t.id=:teamId")
	public String findByid(@Param("teamId") Long teamId);
	
/*	public Set<Player> findAll(Long teamId);*/
}
