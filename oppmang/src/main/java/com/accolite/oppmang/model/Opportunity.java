package com.accolite.oppmang.model;

import java.sql.Timestamp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Opportunity {
	
	private Integer idOpportunity;
	private String createdBy;
	private Timestamp createdTS;
	private String updatedBy;
	private Timestamp updatedTS;
	private Integer idStatus;
	private Integer idTeam;
	private Integer idLocation;
	private String jobDesc;
	private String hiringManager;
	private Integer idPosition;
	
	private static Logger LOGGER = LogManager.getLogger(Opportunity.class);
	
	public Opportunity() {
		super();
		LOGGER.info("Object Of Class Created - Opportunity");
	}
	public Opportunity(Integer idOpportunity, String createdBy, Timestamp createdTS, String updatedBy,
			Timestamp updatedTS, Integer idStatus, Integer idTeam, Integer idLocation, String jobDesc,
			String hiringManager, Integer idPosition) {
		super();
		this.idOpportunity = idOpportunity;
		this.createdBy = createdBy;
		this.createdTS = createdTS;
		this.updatedBy = updatedBy;
		this.updatedTS = updatedTS;
		this.idStatus = idStatus;
		this.idTeam = idTeam;
		this.idLocation = idLocation;
		this.jobDesc = jobDesc;
		this.hiringManager = hiringManager;
		this.idPosition = idPosition;
		LOGGER.info("Object Of Class Created - Opportunity");
	}
	public Integer getIdOpportunity() {
		return idOpportunity;
	}
	public void setIdOpportunity(Integer idOpportunity) {
		this.idOpportunity = idOpportunity;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
	public Integer getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}
	public Integer getIdLocation() {
		return idLocation;
	}
	public void setIdLocation(Integer idLocation) {
		this.idLocation = idLocation;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public String getHiringManager() {
		return hiringManager;
	}
	public void setHiringManager(String hiringManager) {
		this.hiringManager = hiringManager;
	}
	public Integer getIdPosition() {
		return idPosition;
	}
	public void setIdPosition(Integer idPosition) {
		this.idPosition = idPosition;
	}
	public Timestamp getCreatedTS() {
		return createdTS;
	}
	public void setCreatedTS(Timestamp createdTS) {
		this.createdTS = createdTS;
	}
	public Timestamp getUpdatedTS() {
		return updatedTS;
	}
	public void setUpdatedTS(Timestamp updatedTS) {
		this.updatedTS = updatedTS;
	}
	
	

}
