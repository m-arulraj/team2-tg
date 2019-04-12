package com.virtusa.sportsmanagementsystem.teammanagerapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.sportsmanagementsystem.teammanagerapi.domain.Player;
import com.virtusa.sportsmanagementsystem.teammanagerapi.domain.Team;




@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {

	@Query("select p from Player p where p.playerRole =:playerRole")
	 public List<Player> getplayersBasedOnRole(@Param("playerRole") String playerRole);
	
	@Query("select p from Player p where p.team =:team")
	 public List<Player> getplayersBasedOnteam(@Param("team") Team team);
	@Query("select p from Player p where p.id =:id")
	 public Player getTeamBasedOnPlayer(@Param("id") int id);

}
