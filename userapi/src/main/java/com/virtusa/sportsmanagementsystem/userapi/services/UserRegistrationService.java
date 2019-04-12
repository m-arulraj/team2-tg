package com.virtusa.sportsmanagementsystem.userapi.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.sportsmanagementsystem.userapi.domain.User;
import com.virtusa.sportsmanagementsystem.userapi.domain.UserRole;
import com.virtusa.sportsmanagementsystem.userapi.repository.UserRepository;
import com.virtusa.sportsmanagementsystem.userapi.repository.UserRoleRepository;



@Service
public class UserRegistrationService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserRoleRepository userRoleRepository;
	private static Logger logger =Logger.getLogger(UserRegistrationService.class);
	
	UserRole userRole;
	User user1;
	@Transactional
	public User registerUser(UserRole userRole) {
		logger.info("loggerServices for registering user is started");
		logger.debug("userServices for registering user is invoked");
		User user =userRole.getUser();
		user.setUsername(user.getEmail());
	
		Optional<UserRole> ur = userRoleRepository.findById(userRole.getId());
		if(ur.isPresent()) {
			this.userRole=ur.get();
			if(this.userRole.getUser()==null) {
				user=userRepository.save(userRole.getUser());
				this.userRole.setUser(user);
				userRoleRepository.save(this.userRole);
			}
		}		
		return user;
		
		
	}
	public User deleteUser(int id) {
		logger.info("Service for deleting user is started");
		logger.debug("Service for deleting user is invoked");
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			//this.userRole.setUser(user.get());
			UserRole ur = userRoleRepository.findUserRole(user.get());
			ur.setUser(null);
			userRoleRepository.save(ur);
			userRepository.deleteById(id);
			return user.get();
		}
		else
		return null;
	}
	 
	public User updateUser(int id , User user) {
		logger.info("loggerServices for updating user is started");
		logger.debug("userServices for updating user is invoked");
		Optional<User> user1 = userRepository.findById(id);
		if(user1.isPresent()) {
			this.user1 = user1.get();
			this.user1.setUserName(user.getUserName());
			this.user1.setUserDob(user.getUserDob());
			this.user1.setPassword(user.getPassword());
			this.user1.setMobileNumber(user.getMobileNumber());
			this.user1.setEnabled(user.getEnabled());
			this.user1.setEmail(user.getEmail());
			this.user1.setAddress(user.getAddress());
			return userRepository.save(this.user1);
		}
		else
			return user1.get();
	}
	
	public User getUser(String username) {
		logger.info("loggerServices for getting  user based on username is started");
		logger.debug("userServices for getting  user based on username user is invoked");
		User user = userRepository.getUsesr(username);
		return user;
	}
	public UserRole getUserRole(String username) {
		User user = userRepository.getUsesr(username);
		UserRole userRole = userRoleRepository.findUserRole(user);
		return userRole; 
	}
	
	

}
