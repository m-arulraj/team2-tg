package com.gamer.clientapp.domain;

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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserRole [id=" + id + ", authority=" + authority + ", user=" + user + "]";
	}
	
	
	

}
