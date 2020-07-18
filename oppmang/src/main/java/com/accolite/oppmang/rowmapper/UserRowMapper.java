package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserRowMapper implements RowMapper<User> {
	
	private static Logger LOGGER = LogManager.getLogger(UserRowMapper.class);

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setEmail(rs.getString("email"));
		user.setName(rs.getString("name"));
		user.setRole(rs.getString("role"));
		
		LOGGER.info("Object Of Class Created - UserRowMapper");
		return user;
	}
	
	 
}
