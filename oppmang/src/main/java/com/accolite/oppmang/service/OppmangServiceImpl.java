package com.accolite.oppmang.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.oppmang.dao.OppmangDaoImpl;
import com.accolite.oppmang.model.OppAndSkills;
import com.accolite.oppmang.model.Skillset;
import com.accolite.oppmang.model.Trend;
import com.accolite.oppmang.model.User;

@Service
public class OppmangServiceImpl implements OppmangService{
	
	@Autowired
	private OppmangDaoImpl oppmangDao;

	@Override
	public List<OppAndSkills> getOpportunities() {

		return oppmangDao.getOpportunities();
		
	}

	@Override
	public Map<Integer, String> getLocations() {

		return oppmangDao.getLocations();
	}

	@Override
	public Map<Integer, String> getPositions() {
		
		return oppmangDao.getPositions();
	}

	@Override
	public Map<Integer, String> getSkillsets() {

		return oppmangDao.getSkillsets();
	}
	
	@Override
	public List<Skillset> getSkillsetsobj() {

		return oppmangDao.getSkillsetsobj();
	}

	@Override
	public Map<Integer, String> getStatuses() {
	
		return oppmangDao.getStatuses();
	}

	@Override
	public Map<Integer, String> getTeams() {
		
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

	@Override
	public User getUser(String email) {
		
		return oppmangDao.getUser(email);
	}
	
	@Override
	public Map<String, String> getUsers() {

		return oppmangDao.getUsers();
	}

	@Override
	public Trend getTrend(String trend) {

		return oppmangDao.getTrend(trend);
	}

}
