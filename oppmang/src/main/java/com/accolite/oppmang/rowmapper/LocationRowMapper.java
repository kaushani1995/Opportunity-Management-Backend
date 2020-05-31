package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.Location;

public class LocationRowMapper implements RowMapper<Location>{

	@Override
	public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
		Location location = new Location();
		location.setIdLocation(rs.getInt("idLocation"));
		location.setName(rs.getString("name"));
		return location;
	}
	
	

}
