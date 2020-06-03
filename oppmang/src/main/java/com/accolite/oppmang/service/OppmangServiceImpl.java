package com.accolite.oppmang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.oppmang.dao.OppmangDaoImpl;
import com.accolite.oppmang.model.Emptype;
import com.accolite.oppmang.model.Location;
import com.accolite.oppmang.model.OppAndSkills;
import com.accolite.oppmang.model.Position;
import com.accolite.oppmang.model.Role;
import com.accolite.oppmang.model.Skillset;
import com.accolite.oppmang.model.Status;
import com.accolite.oppmang.model.Team;

@Service
public class OppmangServiceImpl implements OppmangService{
	
	@Autowired
	private OppmangDaoImpl oppmangDao;

	@Override
	public List<OppAndSkills> getOpportunities() {

		return oppmangDao.getOpportunities();
		
	}

	@Override
	public List<Emptype> getEmptypes() {

		return oppmangDao.getEmptypes();
	}

	@Override
	public List<Location> getLocations() {

		return oppmangDao.getLocations();
	}

	@Override
	public List<Position> getPositions() {
		
		return oppmangDao.getPositions();
	}

	@Override
	public List<Role> getRoles() {

		return oppmangDao.getRoles();
	}

	@Override
	public List<Skillset> getSkillsets() {

		return oppmangDao.getSkillsets();
	}

	@Override
	public List<Status> getStatuses() {
	
		return oppmangDao.getStatuses();
	}

	@Override
	public List<Team> getTeams() {
		
		return oppmangDao.getTeams();
	}

	@Override
	public int addOpportunity(OppAndSkills oppAndSkills) {
		
		return oppmangDao.addOpportunity(oppAndSkills);
	}

	@Override
	public int updateOpportunity(OppAndSkills oppAndSkills) {
	
		return oppmangDao.updateOpportunity(oppAndSkills);
	}

	@Override
	public int deleteOpportunity(int id) {
		
		return oppmangDao.deleteOpportunity(id);
	}

	@Override
	public OppAndSkills getOpportunity(int id) {

		return oppmangDao.getOpportunity(id);
	}

}
