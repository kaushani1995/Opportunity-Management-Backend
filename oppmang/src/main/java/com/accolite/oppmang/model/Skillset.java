package com.accolite.oppmang.model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Skillset {
	
	private static Logger LOGGER = LogManager.getLogger(Skillset.class);
	
	public Skillset() {
		super();
		LOGGER.info("Object Of Class Created - Skillset");
	}
	private Integer idSkillset;
	private String name;
	
	public Skillset(Integer idSkillset, String name) {
		super();
		this.idSkillset = idSkillset;
		this.name = name;
		LOGGER.info("Object Of Class Created - Skillset");
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
