package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.CountAttribute;

public class CountAttributeRowMapper implements RowMapper<CountAttribute> {

	@Override
	public CountAttribute mapRow(ResultSet rs, int rowNum) throws SQLException {

		CountAttribute countAttribute = new CountAttribute();
		countAttribute.setName(rs.getString("name"));
		countAttribute.setCount(rs.getInt("count"));
		
		return countAttribute;
	}
	
	

}
