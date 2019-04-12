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

import com.virtusa.sportmanagementsystem.contestownerapi.domain.Contest;
import com.virtusa.sportmanagementsystem.contestownerapi.domain.ErrorResponse;
import com.virtusa.sportmanagementsystem.contestownerapi.service.ContestService;

@RestController
@RequestMapping(value = "/api/contest")
public class ContestResource {

	final static Logger logger = Logger.getLogger(ContestResource.class);

	@Autowired
	ContestService contestService;

	private ErrorResponse populateErrorMessage() {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setError(true);
		errorResponse.setMessage("Starting date Connot be Greater than Completion Date");
		return errorResponse;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> createContest(@RequestBody Contest contest) throws URISyntaxException, ParseException {
		logger.info("Controller Invoked");
		Contest con = contestService.createContest(contest);
		if (con != null) {
			return ResponseEntity.created(new URI("/api/contest/" + con.getId())).build();
		} else {
			return ResponseEntity.status(422).body(populateErrorMessage());
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
