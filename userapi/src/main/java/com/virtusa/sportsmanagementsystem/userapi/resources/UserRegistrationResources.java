package com.virtusa.sportsmanagementsystem.userapi.resources;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.sportsmanagementsystem.userapi.domain.User;
import com.virtusa.sportsmanagementsystem.userapi.domain.UserRole;
import com.virtusa.sportsmanagementsystem.userapi.services.UserRegistrationService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*",methods={RequestMethod.POST,RequestMethod.GET,RequestMethod.OPTIONS})
public class UserRegistrationResources {
	@Autowired
	UserRegistrationService userService;
	private static  Logger logger = Logger.getLogger(UserRegistrationResources.class);
	
	@PostMapping(value="")
	public ResponseEntity<?> registeruser(@Valid@RequestBody UserRole userRole,BindingResult bindingResult) throws URISyntaxException{	
		logger.info("userRegistration controller is started");
		logger.debug("registerUser controller is invoked");
		System.out.println(bindingResult.getErrorCount()+"errors");
		System.out.println(bindingResult.getAllErrors());
		if(bindingResult.hasErrors()) {
			return  ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(bindingResult.getAllErrors());
		}
		else {
		UserRole user1= userService.registerUser(userRole);	
		
		return new ResponseEntity<UserRole>(user1,HttpStatus.CREATED);
		}
	}
	@DeleteMapping(value ="")	
	public ResponseEntity<String> deleteUser(@RequestParam("id") int id) {
	logger.info("controller for deleting user is started");
		User user = userService.deleteUser(id);
		if(user!= null) {
			return new ResponseEntity<String>("Deleted",HttpStatus.OK);
		}
		else 
			return new ResponseEntity<String>("User with id is not found, Can't delete user", HttpStatus.NOT_FOUND);
	}
	@PutMapping(value ="")
	public User updateuser(@RequestParam("id") int id, @RequestBody User user) {
		return userService.updateUser(id, user);
		
	}
	@GetMapping(value="/{username}")
	public ResponseEntity<User> getUser(@PathVariable(name="username")  String username){
		System.out.println("user " +username);
		System.out.println(userService.getUser(username));
		return new ResponseEntity<User>(userService.getUser(username),HttpStatus.OK);
	}
	

	@GetMapping(value="/{username}/userrole")
	public ResponseEntity<UserRole> getUserRole(@PathVariable(name="username")  String username){
		System.out.println(username);
		System.out.println(userService.getUserRole(username));
		return new ResponseEntity<UserRole>(userService.getUserRole(username),HttpStatus.OK);
	}
	@GetMapping(value="/roles")
	public ResponseEntity<List<String>> getUserRoles(){
		return new ResponseEntity<List<String>>(userService.getUserRoles(),HttpStatus.OK);
}
}
