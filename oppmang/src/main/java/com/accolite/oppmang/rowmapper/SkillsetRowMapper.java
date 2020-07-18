package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.Skillset;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class SkillsetRowMapper implements RowMapper<Skillset> {
	
	private static Logger LOGGER = LogManager.getLogger(SkillsetRowMapper.class);

	@Override
	public Skillset mapRow(ResultSet rs, int rowNum) throws SQLException {
			
		Skillset skillset = new Skillset();
		skillset.setIdSkillset(rs.getInt("idSkillSet"));
		skillset.setName(rs.getString("name"));
		
		LOGGER.info("Object Of Class Created - SkillsetRowMapper");
		return skillset;
	}
	

}
