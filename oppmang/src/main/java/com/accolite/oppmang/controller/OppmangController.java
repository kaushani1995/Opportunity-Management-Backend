package com.accolite.oppmang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.accolite.oppmang.model.*;
import java.util.List;
import java.util.Map;

import com.accolite.oppmang.service.OppmangServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RestController
@RequestMapping(path = "/oppmang")
public class OppmangController {
	
	private static Logger LOGGER = LogManager.getLogger(OppmangController.class);

	@Autowired
	private OppmangServiceImpl oppmangService;
	
	@GetMapping(value = "/opportunities")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<OppAndSkills> getOpportunities() {
		
		LOGGER.info("Controller - getOpportunities");
		return oppmangService.getOpportunities();
	}

	@GetMapping(value = "/locations")
	@CrossOrigin(origins = "http://localhost:4200")
	public Map<Integer, String> getLocations() {

		LOGGER.info("Controller - getLocations");
		return oppmangService.getLocations();
	}
	
	/*@GetMapping(value = "/locations/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Location getLocation(@PathVariable int id) {
		for(Location location : this.getLocations()) {
			if(location.getIdLocation()==id) { return location;}
		}
		return null;
	}*/
	
	@GetMapping(value = "/positions")
	@CrossOrigin(origins = "http://localhost:4200")
	public Map<Integer, String> getPositions() {
		
		LOGGER.info("Controller - getPositions");
		return oppmangService.getPositions();
	}
	
	/*@GetMapping(value = "/positions/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Position getPosition(@PathVariable int id) {
		for(Position position : this.getPositions()) {
			if(position.getIdPosition()==id) { return position;}
		}
		return null;
	}*/
	
	@GetMapping(value = "/skillsets")
	@CrossOrigin(origins = "http://localhost:4200")
	public Map<Integer, String> getSkillsets() {
		
		LOGGER.info("Controller - getSkillsets");
		return oppmangService.getSkillsets();
	}
	
	@GetMapping(value = "/skillsetsobj")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Skillset> getSkillsetsobj() {

		LOGGER.info("Controller - getSkillsetsobj");
		return oppmangService.getSkillsetsobj();
	}
	
	@GetMapping(value = "/statuses")
	@CrossOrigin(origins = "http://localhost:4200")
	public  Map<Integer, String> getStatues(){
		
		LOGGER.info("Controller - getStatues");
		return oppmangService.getStatuses();
	}
	
	/*@GetMapping(value = "/statuses/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Status getStatus(@PathVariable int id) {
		for(Status status : this.getStatues()) {
			if(status.getIdStatus()==id) { return status;}
		}
		return null;
	}*/
	
	@GetMapping(value = "/teams")
	@CrossOrigin(origins = "http://localhost:4200")
	public Map<Integer, String> getTeams() {
		
		LOGGER.info("Controller - getTeams");
		return oppmangService.getTeams();
	}
	
	/*@GetMapping(value = "/teams/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Team getTeam(@PathVariable int id) {
		for(Team team : this.getTeams()) {
			if(team.getIdTeam()==id) { return team;}
		}
		return null; 
	}*/
	
	
	@GetMapping(value = "/users")
	@CrossOrigin(origins = "http://localhost:4200")
	public Map<String, String> getUsers() {
		
		LOGGER.info("Controller - getUsers");
		return oppmangService.getUsers();
	}
	
	@GetMapping(value = "/users/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public User getUser(@PathVariable String email) {
		
		LOGGER.info("Controller - getUsers");
		return oppmangService.getUser(email);
	}

	@PostMapping(value = "/opportunities", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200")
	public int addOpportunity(@RequestBody OppAndSkills oppAndSkills) {
		
		LOGGER.info("Controller - addOpportunity");
		return oppmangService.addOpportunity(oppAndSkills);
	}

	@PutMapping(value = "/opportunities/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public int updateOpportunity(@RequestBody OppAndSkills oppAndSkills) {
	
		LOGGER.info("Controller - updateOpportunity");
		return oppmangService.updateOpportunity(oppAndSkills);
	}

	@DeleteMapping(value = "/opportunities/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public int deleteOpportunity(@PathVariable int id) {
		
		LOGGER.info("Controller - deleteOpportunity");
		return oppmangService.deleteOpportunity(id);
	}

	@GetMapping(value = "/opportunities/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public OppAndSkills getOpportunity(@PathVariable int id) {

		LOGGER.info("Controller - getOpportunity");
		return oppmangService.getOpportunity(id);
	}
	
	@GetMapping(value = "/trends/{type}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Trend getTrend(@PathVariable String type) {
		
		LOGGER.info("Controller - getTrend");
		return oppmangService.getTrend(type);
	}

}
