package com.accolite.oppmang.dao;

import java.util.ArrayList;
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
	public List<OppAndSkills> getOpportunities() {
		 String query = "SELECT * from opportunity";
		 String query2 = "SELECT s.idSkillset, s.name FROM oppskilljunction o JOIN skillset s ON s.idSkillSet = o.idSkillSet " + 
		 		"WHERE idOpportunity = ?";
		 RowMapper<Opportunity> rowMapper = new OpportunityRowMapper();
		 List<Opportunity> list = jdbcTemplate.query(query, rowMapper);
		 
		 List<OppAndSkills> oslist = new ArrayList<OppAndSkills>();
		
		 list.forEach(opp -> {
			 RowMapper<Skillset> rowMapper2 = new SkillsetRowMapper();
			 List<Skillset> list2 = jdbcTemplate.query(query2, rowMapper2, opp.getIdOpportunity());
			 
			 oslist.add(new OppAndSkills(opp, list2));	 
		 });
		 
		 return oslist;
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
	public int addOpportunity(OppAndSkills oppAndSkills) {
		String query = "INSERT INTO opportunity(idOpportunity, title, createdBy, createdTS, updatedBy, updatedTS,"
				+ " idStatus, idLocation, idTeam, jobDesc, idEmpType, hiringManager, idPosition) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query, oppAndSkills.getOpportunity().getIdOpportunity(), oppAndSkills.getOpportunity().getTitle(), oppAndSkills.getOpportunity().getCreatedBy(),oppAndSkills.getOpportunity().getCreatedTS(),
				oppAndSkills.getOpportunity().getUpdatedBy(),oppAndSkills.getOpportunity().getUpdatedTS(),oppAndSkills.getOpportunity().getIdStatus(), oppAndSkills.getOpportunity().getIdLocation(),oppAndSkills.getOpportunity().getIdTeam(),
				oppAndSkills.getOpportunity().getJobDesc(),oppAndSkills.getOpportunity().getIdEmpType(), oppAndSkills.getOpportunity().getHiringManager(), oppAndSkills.getOpportunity().getIdPosition());
		
		String query2 = "SELECT * FROM opportunity WHERE idOpportunity =( SELECT MAX(idOpportunity) FROM opportunity);";
		RowMapper<Opportunity> rowMapper = new BeanPropertyRowMapper<Opportunity>(Opportunity.class);
		Opportunity opportunity = jdbcTemplate.queryForObject(query2, rowMapper);
		
		String query3 = "INSERT INTO oppskilljunction(idOpportunity, idSkillSet) VALUES(?,?)";
		oppAndSkills.getSkillset().forEach(skill -> {
			jdbcTemplate.update(query3, opportunity.getIdOpportunity(), skill.getIdSkillset());
		});
		
		return 1;
	}

	@Override
	public int updateOpportunity(OppAndSkills oppAndSkills) {
		String query = "UPDATE opportunity SET title=?, createdBy=?, createdTS=?, updatedBy=?, updatedTS=?,"
				+ "idStatus=?, idLocation=?, idTeam=?, jobDesc=?, idEmpType=?, hiringManager=?, idPosition=? WHERE idOpportunity=?";
		jdbcTemplate.update(query, oppAndSkills.getOpportunity().getTitle(), oppAndSkills.getOpportunity().getCreatedBy(),oppAndSkills.getOpportunity().getCreatedTS(),
				oppAndSkills.getOpportunity().getUpdatedBy(),oppAndSkills.getOpportunity().getUpdatedTS(),oppAndSkills.getOpportunity().getIdStatus(), oppAndSkills.getOpportunity().getIdLocation(),oppAndSkills.getOpportunity().getIdTeam(),
				oppAndSkills.getOpportunity().getJobDesc(),oppAndSkills.getOpportunity().getIdEmpType(), oppAndSkills.getOpportunity().getHiringManager(), oppAndSkills.getOpportunity().getIdPosition(), oppAndSkills.getOpportunity().getIdOpportunity());
		
		String query2 = "DELETE FROM oppskilljunction WHERE idOpportunity = ?";
		jdbcTemplate.update(query2, oppAndSkills.getOpportunity().getIdOpportunity());
		
		String query3 = "INSERT INTO oppskilljunction(idOpportunity, idSkillSet) VALUES(?,?)";
		oppAndSkills.getSkillset().forEach(skill -> {
			jdbcTemplate.update(query3, oppAndSkills.getOpportunity().getIdOpportunity(), skill.getIdSkillset());
		});
		
		return 1;
	}

	@Override
	public int deleteOpportunity(int id) {
		String query = "DELETE FROM opportunity WHERE idOpportunity=?";
		return jdbcTemplate.update(query, id);
	}

	@Override
	public OppAndSkills getOpportunity(int id) {
		 String query = "SELECT * FROM opportunity WHERE idOpportunity= ?";
		 RowMapper<Opportunity> rowMapper = new BeanPropertyRowMapper<Opportunity>(Opportunity.class);
		 Opportunity opportunity = jdbcTemplate.queryForObject(query, rowMapper, id);
		 
		 String query2 = "SELECT s.idSkillset, s.name FROM oppskilljunction o JOIN skillset s ON s.idSkillSet = o.idSkillSet " + 
			 		"WHERE idOpportunity = ?";
		 RowMapper<Skillset> rowMapper2 = new SkillsetRowMapper();
		 List<Skillset> list2 = jdbcTemplate.query(query2, rowMapper2, opportunity.getIdOpportunity());
		 
		 OppAndSkills oppAndSkills = new OppAndSkills(opportunity, list2);
		 
		 return oppAndSkills;
	}

}
