package com.gamer.clientapp.domain;


public class User {

	    long id;		
		String username;
        String password;

		public boolean isNew() {
			return (this.id == 0);
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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
}
