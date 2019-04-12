package com.sms.scoreboardapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.scoreboardapi.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
	

}
