package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.Position;

public class PositionRowMapper implements RowMapper<Position> {

	@Override
	public Position mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Position position = new Position();
		position.setIdPosition(rs.getInt("idPosition"));
		position.setName(rs.getString("name"));
		
		return position;
	}
	
	

}
