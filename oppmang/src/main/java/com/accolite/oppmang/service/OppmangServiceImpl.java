package com.accolite.oppmang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.oppmang.dao.OppmangDaoImpl;
import com.accolite.oppmang.model.Location;
import com.accolite.oppmang.model.Opportunity;
import com.accolite.oppmang.model.Position;
import com.accolite.oppmang.model.Skillset;
import com.accolite.oppmang.model.Status;
import com.accolite.oppmang.model.Team;
import com.accolite.oppmang.model.User;

@Service
public class OppmangServiceImpl implements OppmangService{
	
	@Autowired
	private OppmangDaoImpl oppmangDao;

	@Override
	public List<Opportunity> getOpportunities() {

		return oppmangDao.getOpportunities();
		
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
	public int addOpportunity(Opportunity opportunity) {
		
		return oppmangDao.addOpportunity(opportunity);
	}

	@Override
	public int updateOpportunity(Opportunity opportunity) {
	
		return oppmangDao.updateOpportunity(opportunity);
	}

	@Override
	public int deleteOpportunity(int id) {
		
		return oppmangDao.deleteOpportunity(id);
	}

	@Override
	public Opportunity getOpportunity(int id) {

		return oppmangDao.getOpportunity(id);
	}

	@Override
	public User getUser(String email) {
		
		return oppmangDao.getUser(email);
	}
	
	@Override
	public List<User> getUsers() {

		return oppmangDao.getUsers();
	}

}
