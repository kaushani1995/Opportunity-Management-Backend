package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.Team;

public class TeamRowMapper implements RowMapper<Team> {

	@Override
	public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Team team = new Team();
		team.setIdTeam(rs.getInt("idTeam"));
		team.setName(rs.getString("name"));
		
		return team;
	}

}
