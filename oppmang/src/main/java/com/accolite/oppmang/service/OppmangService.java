package com.accolite.oppmang.service;

import java.util.List;

import com.accolite.oppmang.model.Emptype;
import com.accolite.oppmang.model.Location;
import com.accolite.oppmang.model.OppAndSkills;
import com.accolite.oppmang.model.Position;
import com.accolite.oppmang.model.Role;
import com.accolite.oppmang.model.Skillset;
import com.accolite.oppmang.model.Status;
import com.accolite.oppmang.model.Team;

public interface OppmangService {
	
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
