package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.model.Emptype;

public class EmptypeRowMapper implements RowMapper<Emptype> {

	
	@Override
	public Emptype mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Emptype emptype = new Emptype();
		emptype.setIdEmpType(rs.getInt("idEmpType"));
		emptype.setType(rs.getString("type"));
		
		return emptype;
	}

}
