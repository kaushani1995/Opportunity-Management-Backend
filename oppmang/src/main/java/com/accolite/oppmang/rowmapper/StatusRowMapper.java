package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.Status;

public class StatusRowMapper implements RowMapper<Status> {

	@Override
	public Status mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Status status = new Status();
		status.setIdStatus(rs.getInt("idStatus"));
		status.setCurrStatus(rs.getString("currStatus"));
		
		return status;
	}

}
