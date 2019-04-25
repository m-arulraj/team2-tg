package com.gamer.clientapp.resources;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gamer.clientapp.domain.User;
import com.gamer.clientapp.domain.UserRole;
import com.gamer.clientapp.service.RegistrationService;

@Controller
public class ClientControler {

	@Autowired
	RegistrationService regservices;
	
	@GetMapping(value="/")
	public String getHome() {
		return "home";
	}
	
	@GetMapping(value="/register")
	public ModelAndView getRegistration() {
	
			ModelAndView model = new  ModelAndView("signup");
			List<String> userRoleList=regservices.getUserRoles();
			model.addObject("userRoleList",userRoleList);
				
		return model;
	}
	
	@ModelAttribute("userRole")
	public UserRole setmodelattribute() {
		return new UserRole();
	}
	
	@GetMapping(value="/contest/create")
	public String getContestCreation() {
		return "contestCreation";
	}
	
	@GetMapping(value="/player")
	public String getPlayerDetails(@RequestParam("pid")long id) {
		
		return "playerProfile";
	}
	
	@GetMapping(value="/schedule")
	public String getSchedule(@RequestParam("id")long id) {
	
		return "schedule";
	}
	
	@GetMapping(value="/contest")
	public String getContestDetails(@RequestParam("id")long id) {
	
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
			User userDetail = (User) auth.getPrincipal();
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
	      System.out.println(name);
		   HttpHeaders responseHeaders = new HttpHeaders();
		   responseHeaders.set("MyResponseHeader", "MyValue");
		   return new ResponseEntity<String>(name, responseHeaders, HttpStatus.CREATED);
		 
		}
}
