package com.virtusa.sportmanagementsystem.contestownerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.sportmanagementsystem.contestownerapi.domain.Contest;

@Repository
public interface ContestRepository extends JpaRepository<Contest, Long> {

	@Query("select c from Contest c where c.id=:id")
	Contest getContest(@Param("id") Long id);

}
