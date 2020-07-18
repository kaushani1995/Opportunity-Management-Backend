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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class OppmangServiceImpl implements OppmangService{
	
	private static Logger LOGGER = LogManager.getLogger(OppmangServiceImpl.class);
	
	@Autowired
	private OppmangDaoImpl oppmangDao;

	@Override
	public List<OppAndSkills> getOpportunities() {

		LOGGER.info("Service - getOpportunities");
		return oppmangDao.getOpportunities();
		
	}

	@Override
	public Map<Integer, String> getLocations() {

		LOGGER.info("Service - getLocations");
		return oppmangDao.getLocations();
	}

	@Override
	public Map<Integer, String> getPositions() {
		
		LOGGER.info("Service - getPositions");
		return oppmangDao.getPositions();
	}

	@Override
	public Map<Integer, String> getSkillsets() {

		LOGGER.info("Service - getSkillsets");
		return oppmangDao.getSkillsets();
	}
	
	@Override
	public List<Skillset> getSkillsetsobj() {

		LOGGER.info("Service - getSkillsetsobj");
		return oppmangDao.getSkillsetsobj();
	}

	@Override
	public Map<Integer, String> getStatuses() {
	
		LOGGER.info("Service - getStatuses");
		return oppmangDao.getStatuses();
	}

	@Override
	public Map<Integer, String> getTeams() {
		
		LOGGER.info("Service - getTeams");
		return oppmangDao.getTeams();
	}

	@Override
	public int addOpportunity(OppAndSkills oppAndSkills) {
		
		LOGGER.info("Service - addOpportunity");
		return oppmangDao.addOpportunity(oppAndSkills);
	}

	@Override
	public int updateOpportunity(OppAndSkills oppAndSkills) {
	
		LOGGER.info("Service - updateOpportunity");
		return oppmangDao.updateOpportunity(oppAndSkills);
	}

	@Override
	public int deleteOpportunity(int id) {
		
		LOGGER.info("Service - deleteOpportunity");
		return oppmangDao.deleteOpportunity(id);
	}

	@Override
	public OppAndSkills getOpportunity(int id) {

		LOGGER.info("Service - getOpportunity");
		return oppmangDao.getOpportunity(id);
	}

	@Override
	public User getUser(String email) {
		
		LOGGER.info("Service - getUser");
		return oppmangDao.getUser(email);
	}
	
	@Override
	public Map<String, String> getUsers() {

		LOGGER.info("Service - getUsers");
		return oppmangDao.getUsers();
	}

	@Override
	public Trend getTrend(String trend) {

		LOGGER.info("Service - getTrend");
		return oppmangDao.getTrend(trend);
	}

}
