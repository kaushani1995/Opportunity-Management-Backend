package com.accolite.oppmang.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.oppmang.model.*;
import com.accolite.oppmang.rowmapper.CountAttributeRowMapper;
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
		 
		 List<Integer> list3 = new ArrayList<>();
		 list2.forEach(ele -> {
			 list3.add(ele.getIdSkillset());
		 });
			 
		 oslist.add(new OppAndSkills(opp, list3));	 
		 });
		 
		 return oslist;
	}

	@Override
	public Map<Integer, String> getLocations() {
		 String query = "SELECT * from location";
		 RowMapper<Location> rowMapper = new LocationRowMapper();
		 List<Location> list = jdbcTemplate.query(query, rowMapper);
		 
		 Map<Integer, String> locMap = new HashMap<>();
		 list.forEach(ele -> { locMap.put(ele.getIdLocation(), ele.getName());});
		  
		 return locMap;
	}

	@Override
	public Map<Integer, String> getPositions() {
		 String query = "SELECT * from position";
		 RowMapper<Position> rowMapper = new PositionRowMapper();
		 List<Position> list = jdbcTemplate.query(query, rowMapper);
		 
		 Map<Integer, String> posMap = new HashMap<>();
		 list.forEach(ele -> { posMap.put(ele.getIdPosition(), ele.getName());});
		  
		 return posMap;
	}

	@Override
	public Map<Integer, String> getSkillsets() {
		 String query = "SELECT * from skillset";
		 RowMapper<Skillset> rowMapper = new SkillsetRowMapper();
		 List<Skillset> list = jdbcTemplate.query(query, rowMapper);
		 
		 Map<Integer, String> skiMap = new HashMap<>();
		 list.forEach(ele -> { skiMap.put(ele.getIdSkillset(), ele.getName());});
		  
		 return skiMap;
	}
	
	@Override
	public List<Skillset> getSkillsetsobj() {
		 String query = "SELECT * from skillset";
		 RowMapper<Skillset> rowMapper = new SkillsetRowMapper();
		 List<Skillset> list = jdbcTemplate.query(query, rowMapper);
		  
		 return list;
	}

	@Override
	public Map<Integer, String> getStatuses() {
		 String query = "SELECT * from status";
		 RowMapper<Status> rowMapper = new StatusRowMapper();
		 List<Status> list = jdbcTemplate.query(query, rowMapper);
		 
		 Map<Integer, String> staMap = new HashMap<>();
		 list.forEach(ele -> { staMap.put(ele.getIdStatus(), ele.getCurrStatus());});
		  
		 return staMap;
	}

	@Override
	public Map<Integer, String> getTeams() {
		 String query = "SELECT * from team";
		 RowMapper<Team> rowMapper = new TeamRowMapper();
		 List<Team> list = jdbcTemplate.query(query, rowMapper);
		 
		 Map<Integer, String> teaMap = new HashMap<>();
		 list.forEach(ele -> { teaMap.put(ele.getIdTeam(), ele.getName());});
		  
		 return teaMap;
	}

	@Override
	public int addOpportunity(OppAndSkills oppAndSkills) {
		String query = "INSERT INTO opportunity(idOpportunity, createdBy, createdTS, updatedBy, updatedTS,"
				+ " idStatus, idLocation, idTeam, jobDesc, hiringManager, idPosition) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query, null, oppAndSkills.getOpportunity().getCreatedBy(),new Timestamp(System.currentTimeMillis()),
				null , null ,oppAndSkills.getOpportunity().getIdStatus(), oppAndSkills.getOpportunity().getIdLocation(),oppAndSkills.getOpportunity().getIdTeam(),
				oppAndSkills.getOpportunity().getJobDesc(), oppAndSkills.getOpportunity().getHiringManager(), oppAndSkills.getOpportunity().getIdPosition());
		
		String query2 = "SELECT * FROM opportunity WHERE idOpportunity =( SELECT MAX(idOpportunity) FROM opportunity);";
		RowMapper<Opportunity> rowMapper = new BeanPropertyRowMapper<Opportunity>(Opportunity.class);
		Opportunity opportunity = jdbcTemplate.queryForObject(query2, rowMapper);
		
		String query3 = "INSERT INTO oppskilljunction(idOpportunity, idSkillSet) VALUES(?,?)";
		oppAndSkills.getSkillset().forEach(skill -> {
		jdbcTemplate.update(query3, opportunity.getIdOpportunity(), skill);
		});
		
		return 1;

	}

	@Override
	public int updateOpportunity(OppAndSkills oppAndSkills) {
		String query = "UPDATE opportunity SET updatedBy=?, updatedTS=?,"
				+ "idStatus=?, idLocation=?, idTeam=?, jobDesc=?, hiringManager=?, idPosition=? WHERE idOpportunity=?";
		jdbcTemplate.update(query, oppAndSkills.getOpportunity().getUpdatedBy(), new Timestamp(System.currentTimeMillis()) ,oppAndSkills.getOpportunity().getIdStatus(), oppAndSkills.getOpportunity().getIdLocation(),oppAndSkills.getOpportunity().getIdTeam(),
				oppAndSkills.getOpportunity().getJobDesc(), oppAndSkills.getOpportunity().getHiringManager(), oppAndSkills.getOpportunity().getIdPosition(), oppAndSkills.getOpportunity().getIdOpportunity());
		
		String query2 = "DELETE FROM oppskilljunction WHERE idOpportunity = ?";
		jdbcTemplate.update(query2, oppAndSkills.getOpportunity().getIdOpportunity());
		
		String query3 = "INSERT INTO oppskilljunction(idOpportunity, idSkillSet) VALUES(?,?)";
		oppAndSkills.getSkillset().forEach(skill -> {
			jdbcTemplate.update(query3, oppAndSkills.getOpportunity().getIdOpportunity(), skill);
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
		 
		 List<Integer> list3 = new ArrayList<>();
		 list2.forEach(ele -> {
			 list3.add(ele.getIdSkillset());});
		 
		 OppAndSkills oppAndSkills = new OppAndSkills(opportunity, list3);
		 
		 return oppAndSkills;
	}

	@Override
	public User getUser(String email) {
		String query = "SELECT * FROM user WHERE email = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		User user = jdbcTemplate.queryForObject(query, rowMapper, email);
		return user;
	}

	@Override
	public Map<String, String> getUsers() { 
		String query = "SELECT * from user";
		 RowMapper<User> rowMapper = new UserRowMapper();
		 List<User> list = jdbcTemplate.query(query, rowMapper);
		 
		 Map<String, String> useMap = new HashMap<>();
		 list.forEach(ele -> { useMap.put(ele.getEmail(), ele.getName());});
		  
		 return useMap;
	}

	@Override
	public Trend getTrend(String trend) {
		String query = new String();
		if(trend.equals("location")) {
			query = "SELECT l.name, COUNT(l.name) as count FROM opportunity o JOIN location l ON o.idLocation = l.idLocation GROUP BY l.name;";
		}
		else if(trend.equals("team")) {
			query = "SELECT t.name, COUNT(t.name) AS count FROM opportunity o JOIN team t ON o.idTeam = t.idTeam GROUP BY t.name;";
		}
		else if(trend.equals("skill")) {
			query = "SELECT s.name, COUNT(s.name) AS count FROM oppskilljunction o JOIN skillset s ON o.idSkillSet = s.idSkillSet GROUP BY s.name;";
		}
		
		RowMapper<CountAttribute> rowMapper = new CountAttributeRowMapper();
		List<CountAttribute> list = jdbcTemplate.query(query, rowMapper);
		
		List<String> name = new ArrayList<>();
		List<Integer> count = new ArrayList<>();
		list.forEach(ele -> { 
			name.add(ele.getName());
			count.add(ele.getCount());
		});
		
		Trend trend2 = new Trend(name, count);
		return trend2;
	}

}
