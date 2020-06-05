package com.accolite.oppmang.dao;


import java.util.List;

import com.accolite.oppmang.model.*;


public interface OppmangDao {
	
	public List<Opportunity> getOpportunities();
	
	public List<Location> getLocations();
	
	public List<Position> getPositions();
	
	public List<Skillset> getSkillsets();
	
	public List<Status> getStatuses();
	
	public List<Team> getTeams();
	
	public int addOpportunity(Opportunity opportunity);
	
	public int updateOpportunity(Opportunity opportunity);
	
	public int deleteOpportunity(int id);
	
	public Opportunity getOpportunity(int id);
	
	public User getUser(String email);

	public List<User> getUsers();

}
