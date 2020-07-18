package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.Opportunity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OpportunityRowMapper implements RowMapper<Opportunity> {
	
	private static Logger LOGGER = LogManager.getLogger(OpportunityRowMapper.class);

	@Override
	public Opportunity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Opportunity opportunity = new Opportunity();
		opportunity.setCreatedBy(rs.getString("createdBy"));
		opportunity.setCreatedTS(rs.getTimestamp("createdTS"));
		opportunity.setHiringManager(rs.getString("hiringManager"));
		opportunity.setIdLocation(rs.getInt("idLocation"));
		opportunity.setIdOpportunity(rs.getInt("idOpportunity"));
		opportunity.setIdPosition(rs.getInt("idPosition"));
		opportunity.setIdStatus(rs.getInt("idStatus"));
		opportunity.setIdTeam(rs.getInt("idTeam"));
		opportunity.setJobDesc(rs.getString("jobDesc"));
		opportunity.setUpdatedBy(rs.getString("updatedBy"));
		opportunity.setUpdatedTS(rs.getTimestamp("updatedTS"));
		
		LOGGER.info("Object Of Class Created - OpportunityRowMapper");
		return opportunity;
	}

}
