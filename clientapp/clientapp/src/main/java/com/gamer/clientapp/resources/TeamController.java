package com.gamer.clientapp.resources;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gamer.clientapp.domain.Player;
import com.gamer.clientapp.domain.Team;
import com.gamer.clientapp.domain.User;
import com.gamer.clientapp.domain.UserRole;
import com.gamer.clientapp.service.RegistrationService;

@Controller
public class TeamController {

	@Autowired
	RegistrationService registrationService;
	@PostMapping("/signup")
	public ModelAndView registerUser(@ModelAttribute("userRole")
			UserRole userRole) {
		ModelAndView model = new ModelAndView();
		 UserRole user = registrationService.registerUser(userRole);
		 model.setViewName("home");
		 return model;
	}
	
	  @PostMapping("/create-team") 
	  public ModelAndView  registerTeam(@RequestBody Team team) { 
		  System.out.println(team);
		  ModelAndView model = new  ModelAndView();
		  Team registeredTeam = registrationService.registerTeam(team);
		  System.out.println("tcon" +registeredTeam);
		  model.addObject("registeredTeam", registeredTeam);
	  model.setViewName("home");
	  return model; 
	  }
	  @GetMapping(value="/teamplayer")
		public String getPlayerList(@RequestParam("tid")long id) {
			System.out.println("id");
			return "player-list";
		}
	  @PostMapping("/create-player") 
	  public ModelAndView  registerPlayer(@RequestBody Player player) { 
		  System.out.println(player);
		  ModelAndView model = new  ModelAndView();
		  Player registeredTeam = registrationService.registerPlayer(player);
		  System.out.println("tcon" +registeredTeam);
		  model.addObject("registeredTeam", registeredTeam);
	  model.setViewName("home");
	  return model; 
	  }
	  @GetMapping(value="/team")
		public String teamManager(Principal principal,HttpSession session) {
			String user = principal.getName();
			session.setAttribute("user", user);
			return "team";
		}
		@GetMapping(value="/team/creation")
		public String teamManagerC(@RequestParam("id") int id, Model model) {
			//ModelAndView model = new ModelAndView("teamCreation");
		model.addAttribute("id", id);
			return "teamCreation";
		}
		@GetMapping(value="/teamlist")
		public String getTeamList(@RequestParam("id")long id) {
			System.out.println("id");
			return "team-list";
		}
		@GetMapping(value="/team/player")
		public String PlayerRegistration(@RequestParam("id") int id, Model model) {
			//ModelAndView model = new ModelAndView("teamCreation");
		model.addAttribute("id", id);
			return "player-registration";
		}
		@GetMapping(value="/teamupdate")
		public String updateTeam(@RequestParam("tId")int tid,@RequestParam("cId") int cid, Model model) {
			
			model.addAttribute("tid", tid);

			model.addAttribute("cid", cid);

			return "team-update";
		}
		@GetMapping(value="/playerupdate")
		public String updatePlayer(@RequestParam("id")int id,@RequestParam("tId") int tid, Model model) {
			
			model.addAttribute("id", id);

		model.addAttribute("tid", tid);

			return "player-update";
		}
		 @PutMapping("/update-team/{id}") 
		  public ModelAndView  updateTeam(@PathVariable(name="id") int id,@RequestBody Team team) { 
			  ModelAndView model = new  ModelAndView();
			 registrationService.updateTeam(id, team);
		  model.setViewName("team-list");
		  return model; 
		 }
		 @PutMapping("/update-player/{id}") 
		  public ModelAndView  updateplayer(@PathVariable(name="id") int id,@RequestBody Player player) { 
			  ModelAndView model = new  ModelAndView();
			 registrationService.updateplayer(id, player);
		  model.setViewName("player-list");
		  return model; 
		 }
}
