package com.accolite.oppmang.model;

public class Location {
	
	public Location() {
		super();
	}
	public Location(Integer idLocation, String name) {
		super();
		this.idLocation = idLocation;
		this.name = name;
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
