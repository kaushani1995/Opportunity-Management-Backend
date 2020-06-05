package com.accolite.oppmang.model;

public class Position {
	
	public Position() {
		super();
	}
	private Integer idPosition;
	private String name;
	
	public Position(Integer idPosition, String name) {
		super();
		this.idPosition = idPosition;
		this.name = name;
	}
	
	public Integer getIdPosition() {
		return idPosition;
	}
	public void setIdPosition(Integer idPosition) {
		this.idPosition = idPosition;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
