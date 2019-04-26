package com.virtusa.sportsmanagementsystem.userapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@NotEmpty(message="player name should not be empty")
	@Pattern(regexp="[^0-9]*", message="Numbers are not accepted")
	@Column(name="user_name")
	private String userName;
	
	@NotEmpty(message="User name should not be empty")
	@Column(name="user_address")
	private String address;
	 
	@Column(name="user_mobile")
	private Long mobileNumber;
	
	@NotEmpty(message="User name should not be empty")
	@Column(name="user_dob")
	private String userDob;
	
	@NotNull(message="email id should not be null")
	@Email
	@Column(name="email")
	private String email;
	
	@NotEmpty(message="User name should not be empty")
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private int enabled;
	
	private String username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getUserDob() {
		return userDob;
	}
	public void setUserDob(String userDob) {
		this.userDob = userDob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", address=" + address + ", mobileNumber=" + mobileNumber
				+ ", userDob=" + userDob + ", email=" + email + ", password=" + password + ", enabled=" + enabled + "]";
	}
	
	
	
	

}
