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

import com.virtusa.sportmanagementsystem.contestownerapi.domain.Contest;
import com.virtusa.sportmanagementsystem.contestownerapi.service.ContestService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.OPTIONS })
@RequestMapping(value = "/api/contest")
public class ContestResource {

	final static Logger logger = Logger.getLogger(ContestResource.class);

	@Autowired
	ContestService contestService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> createContest(@Valid @RequestBody Contest contest, BindingResult bindingResult)
			throws URISyntaxException, ParseException {
		logger.info("Controller Invoked");
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(bindingResult.getAllErrors());
		} else {
			return ResponseEntity.created(new URI("/api/contest/" + contestService.createContest(contest).getId()))
					.build();
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Contest updateContest(@RequestBody Contest contest) {
		return contestService.updateContest(contest);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Contest> getContest() {
		return contestService.getContest();
	}
}
