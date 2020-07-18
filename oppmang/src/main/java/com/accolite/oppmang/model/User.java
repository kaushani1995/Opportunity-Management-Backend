package com.accolite.oppmang.model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class User {
	
	private static Logger LOGGER = LogManager.getLogger(User.class);
	
	public User() {
		super();
		LOGGER.info("Object Of Class Created - User");
	}
	private String email;
	private String name;
	private String role;
	public User(String email, String name, String role) {
		super();
		this.email = email;
		this.name = name;
		this.role = role;
		LOGGER.info("Object Of Class Created - User");
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
