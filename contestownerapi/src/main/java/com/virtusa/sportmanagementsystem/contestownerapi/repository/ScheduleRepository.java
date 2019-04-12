package com.virtusa.sportmanagementsystem.contestownerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.sportmanagementsystem.contestownerapi.domain.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

}
