package com.gamer.clientapp.resources;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientControler {

	@GetMapping(value="/")
	public String getHome() {
		return "teamManager";
	}
	
	@GetMapping(value="/register")
	public String getRegistration() {
		return "registration";
	}
	
	@GetMapping(value="/contest/create")
	public String getContestCreation() {
		return "contestCreation";
	}
	
	@GetMapping(value="/player")
	public String getPlayerDetails(@RequestParam("id")long id) {
		System.out.println("id");
		return "playerProfile";
	}
	
	@GetMapping(value="/schedule")
	public String getSchedule(@RequestParam("id")long id) {
		System.out.println("id");
		return "schedule";
	}
	
	@GetMapping(value="/contest")
	public String getContestDetails(@RequestParam("id")long id) {
		System.out.println("id");
		return "contest";
	}
	@GetMapping(value="/contest/team")
	public String getTeamProfile(/* @RequestParam("cId")long cId,@RequestParam("tId")long tId */) {
		return "teamProfile";
	}
	
	@GetMapping(value="/schedule/live")
	public String getLiveMatch(@RequestParam("sId")long sId) {
		return "liveMatch";
	}
	
	
	
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		
		String errorMessge = null;
		if (error != null) {
			errorMessge = "Username or Password is incorrect !!";
		}
		if (logout != null) {
			errorMessge = "You have been successfully logged out !!";
		}
		model.addAttribute("errorMessge", errorMessge);
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		System.out.println("in logout controller");
		return "redirect:/login?logout=true";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
	ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName("403");
		return model;

	}
	@RequestMapping(value="/fgx", method = RequestMethod.GET)
	  public String printWelcome(Model model, Principal principal ) {
	 
	      String name = principal.getName();
	      model.addAttribute("username", name);
	      return "contestCreation";
	 
	  }

	@GetMapping(value="user")
	public ResponseEntity<String> getUser(){
		User user=null;
		 Object object=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 if(object!=null) {
			 user=(User) object;
		 }
	      String name = user.getUsername();
		   HttpHeaders responseHeaders = new HttpHeaders();
		   responseHeaders.set("MyResponseHeader", "MyValue");
		   return new ResponseEntity<String>(name, responseHeaders, HttpStatus.CREATED);
		 
		}
}
