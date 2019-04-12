package com.virtusa.sportmanagementsystem.contestownerapi.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.sportmanagementsystem.contestownerapi.domain.Contest;
import com.virtusa.sportmanagementsystem.contestownerapi.domain.Schedule;
import com.virtusa.sportmanagementsystem.contestownerapi.repository.ContestRepository;
import com.virtusa.sportmanagementsystem.contestownerapi.repository.ScheduleRepository;
import com.virtusa.sportmanagementsystem.contestownerapi.repository.TeamRepository;

@Service
public class ScheduleService {

	final static Logger logger = Logger.getLogger(ScheduleService.class);

	@Autowired
	ScheduleRepository scheduleRepository;

	@Autowired
	ContestRepository contestRepository;
	
	@Autowired
	TeamRepository teamRepository;

	public boolean dateComparison(String startDate, String completionDate, String matchDate) throws ParseException {
		logger.debug("Comparing MatchDate with Starting and Completion Dates");
		Date javaStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date javaCompletionDate = new SimpleDateFormat("yyyy-MM-dd").parse(completionDate);
		Date javaMatchDate = new SimpleDateFormat("yyyy-MM-dd").parse(matchDate);
		if (javaStartDate.compareTo(javaMatchDate) <= 0) {
			logger.debug("Starting Date is Same/Before Match Date");
			if (javaCompletionDate.compareTo(javaMatchDate) >= 0) {
				logger.debug("Completion Date is Same/After Match Date");
				logger.debug("Match Date is Within Starting Date and Completion Date");
				return false;
			} else {
				logger.debug("Match Date has to be within Starting and Completion Date");
				return true;
			}
		}
		logger.debug("Match Date has to be within Starting and Completion Date");
		return true;
	}

	public String dateConvertion(String date) throws ParseException {
		logger.debug("Date Convertion Method Invoked");
		Date javaDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = dateFormat.format(javaDate);
		return sqlDate;
	}

	public Schedule createSchedule(Schedule schedule) throws ParseException {
		logger.debug("Creating Schedule");
		Contest contest = contestRepository.getContest(schedule.getContestId());
		String matchDate = dateConvertion(schedule.getMatchDate());
		String startDate = null;
		String completionDate = null;
		if (contest != null) {
			startDate = contest.getStartingDate();
			completionDate = contest.getCompletionDate();
			if (dateComparison(startDate, completionDate, matchDate)) {
				return null;
			} else {
				schedule.setMatchDate(matchDate);
				logger.debug("Schedule Successfully Created");
				return scheduleRepository.save(schedule);
			}
		} else {
			logger.debug("Contest Not Found");
			return null;
		}
	}
	
	public List<Schedule> getSchedule() {
		logger.debug("Getting Schedule Details");
		Schedule schedule = null;
		List<Schedule> schedules2 = new ArrayList<>();
		List<Schedule> schedules = scheduleRepository.findAll();
		Iterator<Schedule> iterator = schedules.iterator();
		while(iterator.hasNext()) {
			schedule = iterator.next();
			Long teamOneId = schedule.getTeamOne();
			Long teamTwoId = schedule.getTeamTwo();
			schedule.setTeamOneName(teamRepository.getTeamOneName(teamOneId));
			schedule.setTeamTwoName(teamRepository.getTeamTwoName(teamTwoId));
			schedules2.add(schedule);
		}
		return schedules2;
	}
	
	public Schedule updateSchedule(Schedule schedule) {
		logger.debug("Updating Schedule");
		logger.debug("Schedule Updated Successfully");
		return scheduleRepository.save(schedule);
	}

}
