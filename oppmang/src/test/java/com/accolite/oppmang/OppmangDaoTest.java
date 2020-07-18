package com.accolite.oppmang;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.oppmang.dao.OppmangDaoImpl;
import com.accolite.oppmang.model.CountAttribute;
import com.accolite.oppmang.model.Location;
import com.accolite.oppmang.model.OppAndSkills;
import com.accolite.oppmang.model.Opportunity;
import com.accolite.oppmang.model.Position;
import com.accolite.oppmang.model.Skillset;
import com.accolite.oppmang.model.Status;
import com.accolite.oppmang.model.Team;
import com.accolite.oppmang.model.Trend;
import com.accolite.oppmang.model.User;
import com.accolite.oppmang.rowmapper.CountAttributeRowMapper;
import com.accolite.oppmang.rowmapper.LocationRowMapper;
import com.accolite.oppmang.rowmapper.OpportunityRowMapper;
import com.accolite.oppmang.rowmapper.PositionRowMapper;
import com.accolite.oppmang.rowmapper.SkillsetRowMapper;
import com.accolite.oppmang.rowmapper.StatusRowMapper;
import com.accolite.oppmang.rowmapper.TeamRowMapper;
import com.accolite.oppmang.rowmapper.UserRowMapper;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OppmangDaoTest {
	
	@Mock
	JdbcTemplate jdbcTemplate;

	@InjectMocks
	private OppmangDaoImpl oppmangDaoImpl;
	
	private Opportunity opportunity = new Opportunity(1, "sampleemail", new Timestamp(0), "updatedby", new Timestamp(0), 2, 1, 3, "description", "manager", 2);
	private List<Opportunity> opportunities = Arrays.asList(new Opportunity[] {opportunity});
	
	private List<Integer> skills = Arrays.asList(new Integer[] {1});
	private OppAndSkills oppAndSkills = new OppAndSkills(opportunity, skills);
	
	private List<OppAndSkills> oppAndSkillsList =  Arrays.asList(new OppAndSkills[] {oppAndSkills});
	
	private Skillset skillset = new Skillset(1, "C");
	private List<Skillset> skillsetList = Arrays.asList(new Skillset[] {skillset});
	
	private Location location = new Location(1, "mumbai");
	private List<Location> locationList = Arrays.asList(new Location[] {location});
	
	private Position position = new Position(1, "Intern");
	private List<Position> positionList = Arrays.asList(new Position[] {position});
	
	private Status status = new Status(1, "Active");
	private List<Status> statusList = Arrays.asList(new Status[] {status});
	
	private Team team = new Team(1, "MS");
	private List<Team> teamList = Arrays.asList(new Team[] {team});
	
	private User user = new User("kaushani@gmail.com", "Kaushani", "Admin");
	private List<User> userList = Arrays.asList(new User[] {user});
	
	private CountAttribute countAttribute = new CountAttribute("Java", 6);
	private List<CountAttribute> countAttributeList = Arrays.asList(new CountAttribute[] {countAttribute});
	
	private Map<Integer, String> map;
	private Map<String, String> userMap;
	
	
	@Test
	void shouldFetchOpportunities(){
		
		given(jdbcTemplate.query(Mockito.anyString(), Mockito.any(OpportunityRowMapper.class))).willReturn(opportunities);
		given(jdbcTemplate.query(Mockito.anyString(), Mockito.any(SkillsetRowMapper.class), Mockito.anyInt())).willReturn(skillsetList);
		
		assertEquals(oppAndSkillsList.get(0).getOpportunity(), oppmangDaoImpl.getOpportunities().get(0).getOpportunity());
	}
	
	@Test
	void shouldFetchLocations() {
		this.map = new HashMap<>();
		this.map.put(1, "mumbai");
		given(jdbcTemplate.query(Mockito.anyString(), Mockito.any(LocationRowMapper.class))).willReturn(locationList);
		
		assertEquals(map, oppmangDaoImpl.getLocations());	
	}
	
	@Test
	void shouldFetchPositions() {
		this.map = new HashMap<>();
		this.map.put(1, "Intern");
		given(jdbcTemplate.query(Mockito.anyString(), Mockito.any(PositionRowMapper.class))).willReturn(positionList);
		
		assertEquals(map, oppmangDaoImpl.getPositions());	
	} 
	
	@Test
	void shouldFetchSkillsets() {
		this.map = new HashMap<>();
		this.map.put(1, "C");
		given(jdbcTemplate.query(Mockito.anyString(), Mockito.any(SkillsetRowMapper.class))).willReturn(skillsetList);
		
		assertEquals(map, oppmangDaoImpl.getSkillsets());	
	} 
	
	@Test
	void shouldFetchSkillsetobjs() {
		
		given(jdbcTemplate.query(Mockito.anyString(), Mockito.any(SkillsetRowMapper.class))).willReturn(skillsetList);
		
		assertEquals(skillsetList, oppmangDaoImpl.getSkillsetsobj());	
	}
	
	@Test
	void shouldFetchStatuses() {
		this.map = new HashMap<>();
		this.map.put(1, "Active");
		given(jdbcTemplate.query(Mockito.anyString(), Mockito.any(StatusRowMapper.class))).willReturn(statusList);
		
		assertEquals(map, oppmangDaoImpl.getStatuses());	
	} 
	
	@Test
	void shouldFetchTeams() {
		this.map = new HashMap<>();
		this.map.put(1, "MS");
		given(jdbcTemplate.query(Mockito.anyString(), Mockito.any(TeamRowMapper.class))).willReturn(teamList);
		
		assertEquals(map, oppmangDaoImpl.getTeams());	
	} 
	
	@SuppressWarnings("unchecked")
	@Test
	void shouldAddOpportunity() {
		
		given(jdbcTemplate.update(Mockito.anyString(), Mockito.any(), Mockito.any(String.class),Mockito.any(),
				Mockito.any(), Mockito.any(), Mockito.any(Integer.class), Mockito.any(Integer.class), Mockito.any(Integer.class),
				Mockito.any(String.class), Mockito.any(String.class), Mockito.any(Integer.class))).willReturn(1);
		
		given(jdbcTemplate.queryForObject(Mockito.anyString(), Mockito.any(BeanPropertyRowMapper.class))).willReturn(opportunity);
		
		given(jdbcTemplate.update(Mockito.anyString(), Mockito.any(Integer.class), Mockito.any(Integer.class))).willReturn(1);
		
		assertEquals(1, oppmangDaoImpl.addOpportunity(oppAndSkills));
		
	}
	
	@Test
	void shouldupdateOpportunity() {
		
		given(jdbcTemplate.update(Mockito.anyString(), Mockito.any(String.class), Mockito.any() ,Mockito.any(Integer.class), Mockito.any(Integer.class),Mockito.any(Integer.class),
				Mockito.any(String.class), Mockito.any(String.class), Mockito.any(Integer.class), Mockito.any(Integer.class))).willReturn(1);
		
		given(jdbcTemplate.update(Mockito.anyString(), Mockito.any(Integer.class))).willReturn(1);
		
		given(jdbcTemplate.update(Mockito.anyString(), Mockito.any(Integer.class), Mockito.any(Integer.class))).willReturn(1);
		
		assertEquals(1, oppmangDaoImpl.updateOpportunity(oppAndSkills));
		
	}
	
	@Test
	void shouldDeleteOpportunity() {
		
		given(jdbcTemplate.update(Mockito.anyString(), Mockito.any(Integer.class))).willReturn(1);
		
		assertEquals(1, oppmangDaoImpl.deleteOpportunity(1));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void shouldFetchOpportunity() {
		
		given(jdbcTemplate.queryForObject(Mockito.anyString(), Mockito.any(BeanPropertyRowMapper.class), Mockito.any(Integer.class))).willReturn(opportunity);
		
		given(jdbcTemplate.query(Mockito.anyString(), Mockito.any(SkillsetRowMapper.class), Mockito.any(Integer.class))).willReturn(skillsetList);
		
		assertEquals(oppAndSkills.getOpportunity(), oppmangDaoImpl.getOpportunity(1).getOpportunity());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void shouldFetchUser() {
		
		given(jdbcTemplate.queryForObject(Mockito.anyString(), Mockito.any(BeanPropertyRowMapper.class), Mockito.anyString())).willReturn(user);
		
		assertEquals(user, oppmangDaoImpl.getUser("kaushani@gmail.com"));
	}
	
	@Test
	void shouldFetchUsers() {
		this.userMap = new HashMap<>();
		userMap.put("kaushani@gmail.com", "Kaushani");
		
		given(jdbcTemplate.query(Mockito.anyString(), Mockito.any(UserRowMapper.class))).willReturn(userList);
		
		assertEquals(userMap, oppmangDaoImpl.getUsers());
	}
	
	@Test
	void shouldFetchTrends() {
		List<String> name = new ArrayList<>();
		name.add("Java");
		List<Integer> count = new ArrayList<>();
		count.add(6);
		
		Trend trend = new Trend(name, count);
		
		given(jdbcTemplate.query(Mockito.anyString(), Mockito.any(CountAttributeRowMapper.class))).willReturn(countAttributeList);
		
		assertEquals(trend.getCount(), oppmangDaoImpl.getTrend("skill").getCount());
	}

}
