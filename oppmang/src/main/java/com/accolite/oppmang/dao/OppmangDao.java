package com.accolite.oppmang.dao;


import java.util.List;

import com.accolite.oppmang.model.*;


public interface OppmangDao {
	
	public List<OppAndSkills> getOpportunities();
	
	public List<Emptype> getEmptypes();
	
	public List<Location> getLocations();
	
	public List<Position> getPositions();
	
	public List<Role> getRoles();
	
	public List<Skillset> getSkillsets();
	
	public List<Status> getStatuses();
	
	public List<Team> getTeams();
	
	public int addOpportunity(OppAndSkills oppAndSkills);
	
	public int updateOpportunity(OppAndSkills oppAndSkills);
	
	public int deleteOpportunity(int id);
	
	public OppAndSkills getOpportunity(int id);
	

}
