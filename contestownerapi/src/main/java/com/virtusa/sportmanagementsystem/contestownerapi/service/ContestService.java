package com.virtusa.sportmanagementsystem.contestownerapi.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.sportmanagementsystem.contestownerapi.domain.Contest;
import com.virtusa.sportmanagementsystem.contestownerapi.repository.ContestRepository;

@Service
public class ContestService {

	final static Logger logger = Logger.getLogger(ContestService.class);

	@Autowired
	ContestRepository contestRepository;

	public String dateConvertion(String date) throws ParseException {
		logger.debug("Date Convertion Method Invoked");
		Date javaDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = dateFormat.format(javaDate);
		return sqlDate;
	}

	public boolean dateComparison(String startDate, String completionDate) throws ParseException {
		logger.debug("Comparing Starting and Completion Dates");
		Date javaStartDate = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
		Date javaCompletionDate = new SimpleDateFormat("dd/MM/yyyy").parse(completionDate);
		int status = javaStartDate.compareTo(javaCompletionDate);
		if (status < 0) {
			logger.debug("Starting Date is Before Completion Date");
			return false;
		} else if (status == 0) {
			logger.debug("Starting Date is Equal to Completion Date");
			return false;
		} else {
			logger.debug("Starting Date is Greater than Completion Date");
			return true;
		}
	}

	public Contest createContest(Contest contest) throws ParseException {
		logger.debug("Contest Service Invoked");
		if (dateComparison(contest.getStartingDate(), contest.getCompletionDate())) {
			logger.debug("Starting date Connot be Greater than Completion Date");
			return null;
		}
		String startDate = dateConvertion(contest.getStartingDate());
		logger.debug("Starting Date Converted");
		String completionDate = dateConvertion(contest.getCompletionDate());
		logger.debug("Completion Date Converted");
		contest.setStartingDate(startDate);
		contest.setCompletionDate(completionDate);
		logger.debug("Contest Created Successfully");
		return contestRepository.save(contest);
	}

	public Contest updateContest(Contest contest) {
		logger.debug("Updating Contest");
		logger.debug("Contest Updated Successfully");
		return contestRepository.save(contest);
	}

	public List<Contest> getContest() {
		logger.debug("Getting Contest Details");
		return contestRepository.findAll();
	}
}
