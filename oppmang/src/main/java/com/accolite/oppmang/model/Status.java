package com.accolite.oppmang.model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Status {
	
	private static Logger LOGGER = LogManager.getLogger(Status.class);
	
	public Status() {
		super();
		LOGGER.info("Object Of Class Created - Status");
	}
	private Integer idStatus;
	private String currStatus;
	public Status(Integer idStatus, String currStatus) {
		super();
		this.idStatus = idStatus;
		this.currStatus = currStatus;
		LOGGER.info("Object Of Class Created - Status");
	}
	public Integer getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
	public String getCurrStatus() {
		return currStatus;
	}
	public void setCurrStatus(String currStatus) {
		this.currStatus = currStatus;
	}
	
	

}
