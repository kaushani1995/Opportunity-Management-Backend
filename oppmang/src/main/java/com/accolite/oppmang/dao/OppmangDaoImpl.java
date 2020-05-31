package com.accolite.oppmang.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.oppmang.model.*;
import com.accolite.oppmang.rowmapper.EmptypeRowMapper;
import com.accolite.oppmang.rowmapper.LocationRowMapper;
import com.accolite.oppmang.rowmapper.OpportunityRowMapper;
import com.accolite.oppmang.rowmapper.PositionRowMapper;
import com.accolite.oppmang.rowmapper.RoleRowMapper;
import com.accolite.oppmang.rowmapper.SkillsetRowMapper;
import com.accolite.oppmang.rowmapper.StatusRowMapper;
import com.accolite.oppmang.rowmapper.TeamRowMapper;

@Transactional
@Repository
public class OppmangDaoImpl implements OppmangDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Opportunity> getOpportunities() {
		 String query = "SELECT * from opportunity";
		 RowMapper<Opportunity> rowMapper = new OpportunityRowMapper();
		 List<Opportunity> list = jdbcTemplate.query(query, rowMapper);
		  
		 return list;
	}

	@Override
	public List<Emptype> getEmptypes() {
		 String query = "SELECT * from emptype";
		 RowMapper<Emptype> rowMapper = new EmptypeRowMapper();
		 List<Emptype> list = jdbcTemplate.query(query, rowMapper);
		  
		 return list;
	}

	@Override
	public List<Location> getLocations() {
		 String query = "SELECT * from location";
		 RowMapper<Location> rowMapper = new LocationRowMapper();
		 List<Location> list = jdbcTemplate.query(query, rowMapper);
		  
		 return list;
	}

	@Override
	public List<Position> getPositions() {
		 String query = "SELECT * from position";
		 RowMapper<Position> rowMapper = new PositionRowMapper();
		 List<Position> list = jdbcTemplate.query(query, rowMapper);
		  
		 return list;
	}

	@Override
	public List<Role> getRoles() {
		 String query = "SELECT * from role";
		 RowMapper<Role> rowMapper = new RoleRowMapper();
		 List<Role> list = jdbcTemplate.query(query, rowMapper);
		  
		 return list;
	}

	@Override
	public List<Skillset> getSkillsets() {
		 String query = "SELECT * from skillset";
		 RowMapper<Skillset> rowMapper = new SkillsetRowMapper();
		 List<Skillset> list = jdbcTemplate.query(query, rowMapper);
		  
		 return list;
	}

	@Override
	public List<Status> getStatuses() {
		 String query = "SELECT * from status";
		 RowMapper<Status> rowMapper = new StatusRowMapper();
		 List<Status> list = jdbcTemplate.query(query, rowMapper);
		  
		 return list;
	}

	@Override
	public List<Team> getTeams() {
		 String query = "SELECT * from team";
		 RowMapper<Team> rowMapper = new TeamRowMapper();
		 List<Team> list = jdbcTemplate.query(query, rowMapper);
		  
		 return list;
	}

	@Override
	public int addOpportunity(Opportunity opportunity) {
		String query = "INSERT INTO opportunity(idOpportunity, title, createdBy, createdTS, updatedBy, updatedTS,"
				+ " idStatus, idLocation, idTeam, jobDesc, idEmpType, hiringManager, idPosition) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(query, opportunity.getIdOpportunity(), opportunity.getTitle(), opportunity.getCreatedBy(),opportunity.getCreatedTS(),
				opportunity.getUpdatedBy(),opportunity.getUpdatedTS(),opportunity.getIdStatus(), opportunity.getIdLocation(),opportunity.getIdTeam(),
				opportunity.getJobDesc(),opportunity.getIdEmpType(), opportunity.getHiringManager(), opportunity.getIdPosition());
		
	}

	@Override
	public int updateOpportunity(Opportunity opportunity) {
		String query = "UPDATE opportunity SET title=?, createdBy=?, createdTS=?, updatedBy=?, updatedTS=?,"
				+ "idStatus=?, idLocation=?, idTeam=?, jobDesc=?, idEmpType=?, hiringManager=?, idPosition=? WHERE idOpportunity=?";
		return jdbcTemplate.update(query, opportunity.getTitle(), opportunity.getCreatedBy(),opportunity.getCreatedTS(),
				opportunity.getUpdatedBy(),opportunity.getUpdatedTS(),opportunity.getIdStatus(), opportunity.getIdLocation(),opportunity.getIdTeam(),
				opportunity.getJobDesc(),opportunity.getIdEmpType(), opportunity.getHiringManager(), opportunity.getIdPosition(), opportunity.getIdOpportunity());
	}

	@Override
	public int deleteOpportunity(int id) {
		String query = "DELETE FROM opportunity WHERE idOpportunity=?";
		return jdbcTemplate.update(query, id);
	}

	@Override
	public Opportunity getOpportunity(int id) {
		 String query = "SELECT * FROM opportunity WHERE idOpportunity= ?";
		 RowMapper<Opportunity> rowMapper = new BeanPropertyRowMapper<Opportunity>(Opportunity.class);
		 Opportunity opportunity = jdbcTemplate.queryForObject(query, rowMapper, id);
		  
		 return opportunity;
	}

}