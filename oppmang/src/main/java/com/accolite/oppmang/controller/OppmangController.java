package com.accolite.oppmang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.accolite.oppmang.model.*;
import java.util.List;

import com.accolite.oppmang.service.OppmangServiceImpl;


@RestController
@RequestMapping(path = "/oppmang")
public class OppmangController {
	
	@Autowired
	private OppmangServiceImpl oppmangService;
	
	@GetMapping(value = "/opportunities")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Opportunity> getOpportunities() {

		return oppmangService.getOpportunities();
	}

	@GetMapping(value = "/locations")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Location> getLocations() {

		return oppmangService.getLocations();
	}
	
	@GetMapping(value = "/locations/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Location getLocation(@PathVariable int id) {
		for(Location location : this.getLocations()) {
			if(location.getIdLocation()==id) { return location;}
		}
		return null;
	}
	
	@GetMapping(value = "/positions")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Position> getPositions() {
		
		return oppmangService.getPositions();
	}
	
	@GetMapping(value = "/positions/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Position getPosition(@PathVariable int id) {
		for(Position position : this.getPositions()) {
			if(position.getIdPosition()==id) { return position;}
		}
		return null;
	}
	
	@GetMapping(value = "/skillsets")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Skillset> getSkillsets() {

		return oppmangService.getSkillsets();
	}
	
	@GetMapping(value = "/statuses")
	@CrossOrigin(origins = "http://localhost:4200")
	public  List<Status> getStatues(){
		return oppmangService.getStatuses();
	}
	
	@GetMapping(value = "/statuses/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Status getStatus(@PathVariable int id) {
		for(Status status : this.getStatues()) {
			if(status.getIdStatus()==id) { return status;}
		}
		return null;
	}
	
	@GetMapping(value = "/teams")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Team> getTeams() {
		
		return oppmangService.getTeams();
	}
	
	@GetMapping(value = "/teams/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Team geTeam(@PathVariable int id) {
		for(Team team : this.getTeams()) {
			if(team.getIdTeam()==id) { return team;}
		}
		return null;
	}
	
	
	@GetMapping(value = "/users")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<User> getUsers() {
		
		return oppmangService.getUsers();
	}
	
	@GetMapping(value = "/users/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public User getUser(@PathVariable String email) {
		
		return oppmangService.getUser(email);
	}

	@PostMapping(value = "/opportunities", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200")
	public int addOpportunity(@RequestBody OppAndSkills oppAndSkills) {
		
		return oppmangService.addOpportunity(oppAndSkills);
	}

	@PutMapping(value = "/opportunities/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public int updateOpportunity(@RequestBody OppAndSkills oppAndSkills) {
	
		return oppmangService.updateOpportunity(oppAndSkills);
	}

	@DeleteMapping(value = "/opportunities/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public int deleteOpportunity(@PathVariable int id) {
		
		return oppmangService.deleteOpportunity(id);
	}

	@GetMapping(value = "/opportunities/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public OppAndSkills getOpportunity(@PathVariable int id) {

		return oppmangService.getOpportunity(id);
	}
	
	

}
