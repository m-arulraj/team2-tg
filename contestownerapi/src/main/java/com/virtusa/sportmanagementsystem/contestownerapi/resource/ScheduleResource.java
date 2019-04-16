package com.virtusa.sportmanagementsystem.contestownerapi.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.sportmanagementsystem.contestownerapi.domain.Schedule;
import com.virtusa.sportmanagementsystem.contestownerapi.service.ScheduleService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.OPTIONS })
@RequestMapping("/api/schedule")
public class ScheduleResource {

	final static Logger logger = Logger.getLogger(ScheduleResource.class);

	@Autowired
	ScheduleService scheduleService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> createSchedule(@Valid @RequestBody Schedule schedule, BindingResult bindingResult)
			throws URISyntaxException, ParseException {
		logger.debug("Controller Invoked");
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(bindingResult.getAllErrors());
		} else {
			return ResponseEntity.created(new URI("/api/schedule/" + scheduleService.createSchedule(schedule).getId()))
					.build();
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
