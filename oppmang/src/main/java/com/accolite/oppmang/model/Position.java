package com.accolite.oppmang.model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Position {
	
	private static Logger LOGGER = LogManager.getLogger(Position.class);
	
	public Position() {
		super();
		LOGGER.info("Object Of Class Created - Position");
	}
	private Integer idPosition;
	private String name;
	
	public Position(Integer idPosition, String name) {
		super();
		this.idPosition = idPosition;
		this.name = name;
		LOGGER.info("Object Of Class Created - Position");
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
