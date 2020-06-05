package com.accolite.oppmang.model;

public class Status {
	
	public Status() {
		super();
	}
	private Integer idStatus;
	private String currStatus;
	public Status(Integer idStatus, String currStatus) {
		super();
		this.idStatus = idStatus;
		this.currStatus = currStatus;
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
