package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.CountAttribute;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountAttributeRowMapper implements RowMapper<CountAttribute> {

	private static Logger LOGGER = LogManager.getLogger(CountAttributeRowMapper.class);
	
	@Override
	public CountAttribute mapRow(ResultSet rs, int rowNum) throws SQLException {

		CountAttribute countAttribute = new CountAttribute();
		countAttribute.setName(rs.getString("name"));
		countAttribute.setCount(rs.getInt("count"));
		
		LOGGER.info("Object Of Class Created - CountAttributeRowMapper");
		return countAttribute;
	}
	
	

}
