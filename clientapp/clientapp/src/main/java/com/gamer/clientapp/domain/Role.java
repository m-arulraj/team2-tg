package com.gamer.clientapp.domain;


import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	private long id;
	private String username;
	private String role;

	

	@Override
	public String toString() {
		return "Role [id=" + id + ", username=" + username + ", role=" + role + "]";
	}



	public String getAuthority() {
		return this.role;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}