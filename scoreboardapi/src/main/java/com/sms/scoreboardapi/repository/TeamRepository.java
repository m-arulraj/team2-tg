package com.sms.scoreboardapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.scoreboardapi.domain.Contest;
import com.sms.scoreboardapi.domain.Player;
import com.sms.scoreboardapi.domain.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
