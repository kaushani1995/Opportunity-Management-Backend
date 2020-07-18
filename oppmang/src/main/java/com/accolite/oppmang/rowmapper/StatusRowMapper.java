package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatusRowMapper implements RowMapper<Status> {
	
	private static Logger LOGGER = LogManager.getLogger(StatusRowMapper.class);

	@Override
	public Status mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Status status = new Status();
		status.setIdStatus(rs.getInt("idStatus"));
		status.setCurrStatus(rs.getString("currStatus"));
		
		LOGGER.info("Object Of Class Created - StatusRowMapper");
		return status;
	}

}
