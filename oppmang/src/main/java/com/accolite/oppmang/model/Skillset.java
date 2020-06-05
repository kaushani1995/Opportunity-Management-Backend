package com.accolite.oppmang.model;

public class Skillset {
	
	public Skillset() {
		super();
	}
	private Integer idSkillset;
	private String name;
	
	public Skillset(Integer idSkillset, String name) {
		super();
		this.idSkillset = idSkillset;
		this.name = name;
	}
	public Integer getIdSkillset() {
		return idSkillset;
	}
	public void setIdSkillset(Integer idSkillset) {
		this.idSkillset = idSkillset;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
