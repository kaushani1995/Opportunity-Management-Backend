package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.Opportunity;

public class OpportunityRowMapper implements RowMapper<Opportunity> {

	@Override
	public Opportunity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Opportunity opportunity = new Opportunity();
		opportunity.setCreatedBy(rs.getInt("createdBy"));
		opportunity.setCreatedTS(rs.getTimestamp("createdTS"));
		opportunity.setHiringManager(rs.getInt("hiringManager"));
		opportunity.setIdEmpType(rs.getInt("idEmpType"));
		opportunity.setIdLocation(rs.getInt("idLocation"));
		opportunity.setIdOpportunity(rs.getInt("idOpportunity"));
		opportunity.setIdPosition(rs.getInt("idPosition"));
		opportunity.setIdStatus(rs.getInt("idStatus"));
		opportunity.setIdTeam(rs.getInt("idTeam"));
		opportunity.setJobDesc(rs.getString("jobDesc"));
		opportunity.setTitle(rs.getString("title"));
		opportunity.setUpdatedBy(rs.getInt("updatedBy"));
		opportunity.setUpdatedTS(rs.getTimestamp("updatedTS"));
		
		return opportunity;
	}

}
