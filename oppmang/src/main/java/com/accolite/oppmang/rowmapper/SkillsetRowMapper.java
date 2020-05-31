package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.Skillset;

public class SkillsetRowMapper implements RowMapper<Skillset> {

	@Override
	public Skillset mapRow(ResultSet rs, int rowNum) throws SQLException {
			
		Skillset skillset = new Skillset();
		skillset.setIdSkillset(rs.getInt("idSkillSet"));
		skillset.setName(rs.getString("name"));
		
		return skillset;
	}
	

}
