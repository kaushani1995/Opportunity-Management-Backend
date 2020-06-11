package com.accolite.oppmang.dao;


import java.util.List;
import java.util.Map;

import com.accolite.oppmang.model.*;


public interface OppmangDao {
	
	public List<OppAndSkills> getOpportunities();
	
	public Map<Integer, String> getLocations();
	
	public Map<Integer, String> getPositions();
	
	public Map<Integer, String> getSkillsets();
	
	public List<Skillset> getSkillsetsobj();
	
	public Map<Integer, String> getStatuses();
	
	public Map<Integer, String> getTeams();
	
	public int addOpportunity(OppAndSkills oppAndSkills);
	
	public int updateOpportunity(OppAndSkills oppAndSkills);
	
	public int deleteOpportunity(int id);
	
	public OppAndSkills getOpportunity(int id);
	
	public User getUser(String email);

	public Map<String, String> getUsers();
	
	public Trend getTrend(String trend);

}
