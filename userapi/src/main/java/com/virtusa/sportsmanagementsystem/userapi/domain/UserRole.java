package com.virtusa.sportsmanagementsystem.userapi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity
@Table(name="authorities")
public class UserRole {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="authority")
	private String authority;
	@Valid
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	@Column(name="username")
	private String username;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String role) {
		this.authority = role;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "UserRoles [id=" + id + ", Authority=" + authority + ", user=" + user + "]";
	}
	
	

}
