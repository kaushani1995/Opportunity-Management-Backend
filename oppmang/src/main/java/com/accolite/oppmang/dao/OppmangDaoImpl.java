package com.accolite.oppmang.dao;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.oppmang.model.*;
import com.accolite.oppmang.rowmapper.LocationRowMapper;
import com.accolite.oppmang.rowmapper.OpportunityRowMapper;
import com.accolite.oppmang.rowmapper.PositionRowMapper;
import com.accolite.oppmang.rowmapper.SkillsetRowMapper;
import com.accolite.oppmang.rowmapper.StatusRowMapper;
import com.accolite.oppmang.rowmapper.TeamRowMapper;
import com.accolite.oppmang.rowmapper.UserRowMapper;

@Transactional
@Repository
public class OppmangDaoImpl implements OppmangDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Opportunity> getOpportunities() {
		 String query = "SELECT * from opportunity";
		 //String query2 = "SELECT s.idSkillset, s.name FROM oppskilljunction o JOIN skillset s ON s.idSkillSet = o.idSkillSet " + 
		 //		"WHERE idOpportunity = ?";
		 RowMapper<Opportunity> rowMapper = new OpportunityRowMapper();
		 List<Opportunity> list = jdbcTemplate.query(query, rowMapper);
		 
		 //List<OppAndSkills> oslist = new ArrayList<OppAndSkills>();
		
		 //list.forEach(opp -> {
		//	 RowMapper<Skillset> rowMapper2 = new SkillsetRowMapper();
		//	 List<Skillset> list2 = jdbcTemplate.query(query2, rowMapper2, opp.getIdOpportunity());
			 
		//	 oslist.add(new OppAndSkills(opp, list2));	 
		 //});
		 
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
		String query = "INSERT INTO opportunity(idOpportunity, createdBy, createdTS, updatedBy, updatedTS,"
				+ " idStatus, idLocation, idTeam, jobDesc, hiringManager, idPosition) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(query, opportunity.getIdOpportunity(), opportunity.getCreatedBy(),opportunity.getCreatedTS(),
				opportunity.getUpdatedBy(),opportunity.getUpdatedTS(),opportunity.getIdStatus(), opportunity.getIdLocation(),opportunity.getIdTeam(),
				opportunity.getJobDesc(), opportunity.getHiringManager(), opportunity.getIdPosition());
		
		/*String query2 = "SELECT * FROM opportunity WHERE idOpportunity =( SELECT MAX(idOpportunity) FROM opportunity);";
		RowMapper<Opportunity> rowMapper = new BeanPropertyRowMapper<Opportunity>(Opportunity.class);
		Opportunity opportunity = jdbcTemplate.queryForObject(query2, rowMapper);
		
		String query3 = "INSERT INTO oppskilljunction(idOpportunity, idSkillSet) VALUES(?,?)";
		oppAndSkills.getSkillset().forEach(skill -> {
			jdbcTemplate.update(query3, opportunity.getIdOpportunity(), skill.getIdSkillset());
		});*/

	}

	@Override
	public int updateOpportunity(Opportunity opportunity) {
		String query = "UPDATE opportunity SET createdBy=?, createdTS=?, updatedBy=?, updatedTS=?,"
				+ "idStatus=?, idLocation=?, idTeam=?, jobDesc=?, hiringManager=?, idPosition=? WHERE idOpportunity=?";
		return jdbcTemplate.update(query,opportunity.getCreatedBy(),opportunity.getCreatedTS(),
				opportunity.getUpdatedBy(),opportunity.getUpdatedTS(),opportunity.getIdStatus(), opportunity.getIdLocation(),opportunity.getIdTeam(),
				opportunity.getJobDesc(), opportunity.getHiringManager(), opportunity.getIdPosition(), opportunity.getIdOpportunity());
		
		/*String query2 = "DELETE FROM oppskilljunction WHERE idOpportunity = ?";
		jdbcTemplate.update(query2, oppAndSkills.getOpportunity().getIdOpportunity());
		
		String query3 = "INSERT INTO oppskilljunction(idOpportunity, idSkillSet) VALUES(?,?)";
		oppAndSkills.getSkillset().forEach(skill -> {
			jdbcTemplate.update(query3, oppAndSkills.getOpportunity().getIdOpportunity(), skill.getIdSkillset());
		});
		
		return 1;*/
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
		 
		 /*String query2 = "SELECT s.idSkillset, s.name FROM oppskilljunction o JOIN skillset s ON s.idSkillSet = o.idSkillSet " + 
			 		"WHERE idOpportunity = ?";
		 RowMapper<Skillset> rowMapper2 = new SkillsetRowMapper();
		 List<Skillset> list2 = jdbcTemplate.query(query2, rowMapper2, opportunity.getIdOpportunity());
		 
		 OppAndSkills oppAndSkills = new OppAndSkills(opportunity, list2);*/
		 
		 return opportunity;
	}

	@Override
	public User getUser(String email) {
		String query = "SELECT * FROM user WHERE email = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		User user = jdbcTemplate.queryForObject(query, rowMapper, email);
		return user;
	}

	@Override
	public List<User> getUsers() { 
		String query = "SELECT * from user";
		 RowMapper<User> rowMapper = new UserRowMapper();
		 List<User> list = jdbcTemplate.query(query, rowMapper);
		  
		 return list;
	}

}
