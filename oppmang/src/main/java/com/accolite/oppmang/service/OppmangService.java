package com.accolite.oppmang.service;

import java.util.List;

import com.accolite.oppmang.model.Location;
import com.accolite.oppmang.model.OppAndSkills;
import com.accolite.oppmang.model.Opportunity;
import com.accolite.oppmang.model.Position;
import com.accolite.oppmang.model.Skillset;
import com.accolite.oppmang.model.Status;
import com.accolite.oppmang.model.Team;
import com.accolite.oppmang.model.User;

public interface OppmangService {
	
	public List<Opportunity> getOpportunities();
	
	public List<Location> getLocations();
	
	public List<Position> getPositions();
	
	public List<Skillset> getSkillsets();
	
	public List<Status> getStatuses();
	
	public List<Team> getTeams();
	
	public int addOpportunity(OppAndSkills oppAndSkills);
	
	public int updateOpportunity(OppAndSkills oppAndSkills);
	
	public int deleteOpportunity(int id);
	
	public OppAndSkills getOpportunity(int id);
	
	public List<User> getUsers();
	
	public User getUser(String email);
}
