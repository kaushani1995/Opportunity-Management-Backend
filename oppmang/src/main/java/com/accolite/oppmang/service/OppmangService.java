package com.accolite.oppmang.service;

import java.util.List;
import java.util.Map;

import com.accolite.oppmang.model.OppAndSkills;
import com.accolite.oppmang.model.Skillset;
import com.accolite.oppmang.model.Trend;
import com.accolite.oppmang.model.User;

public interface OppmangService {
	
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
	
	public Map<String, String> getUsers();
	
	public User getUser(String email);
	
	public Trend getTrend(String trend);
}
