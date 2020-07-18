package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.Team;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TeamRowMapper implements RowMapper<Team> {
	
	private static Logger LOGGER = LogManager.getLogger(TeamRowMapper.class);

	@Override
	public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Team team = new Team();
		team.setIdTeam(rs.getInt("idTeam"));
		team.setName(rs.getString("name"));
		
		LOGGER.info("Object Of Class Created - TeamRowMapper");
		return team;
	}

}
