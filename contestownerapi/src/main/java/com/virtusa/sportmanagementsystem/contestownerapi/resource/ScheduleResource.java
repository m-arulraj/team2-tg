package com.virtusa.sportmanagementsystem.contestownerapi.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.sportmanagementsystem.contestownerapi.domain.ErrorResponse;
import com.virtusa.sportmanagementsystem.contestownerapi.domain.Schedule;
import com.virtusa.sportmanagementsystem.contestownerapi.service.ScheduleService;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleResource {
	
	final static Logger logger = Logger.getLogger(ScheduleResource.class);

	@Autowired
	ScheduleService scheduleService;
	
	private ErrorResponse populateErrorMessage() {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setError(true);
		errorResponse.setMessage("Match Date is not within Starting Date and Completion Date/Contest Not Found");
		return errorResponse;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> createSchedule(@RequestBody Schedule schedule) throws URISyntaxException, ParseException{
		logger.debug("Controller Invoked");
		Schedule schedule2 = scheduleService.createSchedule(schedule);
		if(schedule2!=null) {
			return ResponseEntity.created(new URI("/api/schedule/"+ schedule2.getId())).build();
		}else {
			return ResponseEntity.status(422).body(populateErrorMessage());
		}
		
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Schedule> getSchedule() {
		return scheduleService.getSchedule();
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Schedule updateSchedule(@RequestBody Schedule schedule) {
		return scheduleService.updateSchedule(schedule);
	}
}
