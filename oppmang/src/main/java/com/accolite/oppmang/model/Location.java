package com.accolite.oppmang.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Location {
	
	private static Logger LOGGER = LogManager.getLogger(Location.class);
	
	public Location() {
		super();
		LOGGER.info("Object Of Class Created - Location");
	}
	public Location(Integer idLocation, String name) {
		super();
		this.idLocation = idLocation;
		this.name = name;
		LOGGER.info("Object Of Class Created - Location");
	}
	
	private Integer idLocation;
	private String name;
	
	public Integer getIdLocation() {
		return idLocation;
	}
	public void setIdLocation(Integer idLocation) {
		this.idLocation = idLocation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	

}
