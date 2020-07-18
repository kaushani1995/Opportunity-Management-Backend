package com.accolite.oppmang.model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Team {
	
	private static Logger LOGGER = LogManager.getLogger(Team.class);
	
	public Team() {
		super();
		LOGGER.info("Object Of Class Created - Team");
	}
	private Integer idTeam;
	private String name;
	
	public Team(Integer idTeam, String name) {
		super();
		this.idTeam = idTeam;
		this.name = name;
		LOGGER.info("Object Of Class Created - Team");
	}
	public Integer getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
