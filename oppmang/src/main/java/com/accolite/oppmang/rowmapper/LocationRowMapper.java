package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.Location;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LocationRowMapper implements RowMapper<Location>{
	
	private static Logger LOGGER = LogManager.getLogger(LocationRowMapper.class);

	@Override
	public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
		Location location = new Location();
		location.setIdLocation(rs.getInt("idLocation"));
		location.setName(rs.getString("name"));
		
		LOGGER.info("Object Of Class Created - LocationRowMapper");
		return location;
	}
	
	

}
