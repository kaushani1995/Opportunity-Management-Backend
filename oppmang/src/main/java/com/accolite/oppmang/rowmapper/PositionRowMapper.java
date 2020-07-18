package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.Position;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PositionRowMapper implements RowMapper<Position> {
	
	private static Logger LOGGER = LogManager.getLogger(PositionRowMapper.class);

	@Override
	public Position mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Position position = new Position();
		position.setIdPosition(rs.getInt("idPosition"));
		position.setName(rs.getString("name"));
		
		LOGGER.info("Object Of Class Created - PositionRowMapper");
		return position;
	}
	
	

}
