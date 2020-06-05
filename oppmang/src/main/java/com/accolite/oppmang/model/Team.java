package com.accolite.oppmang.model;

public class Team {
	
	public Team() {
		super();
	}
	private Integer idTeam;
	private String name;
	
	public Team(Integer idTeam, String name) {
		super();
		this.idTeam = idTeam;
		this.name = name;
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
