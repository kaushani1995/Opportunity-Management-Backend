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
	public List<OppAndSkills> getOpportunities() {

		return oppmangService.getOpportunities();
	}
	
	@GetMapping(value = "/emptypes")
	public List<Emptype> getEmptypes() {

		return oppmangService.getEmptypes();
	}
	
	@GetMapping(value = "/locations")
	public List<Location> getLocations() {

		return oppmangService.getLocations();
	}
	
	@GetMapping(value = "/positions")
	public List<Position> getPositions() {
		
		return oppmangService.getPositions();
	}

	@GetMapping(value = "/roles")
	public List<Role> getRoles() {

		return oppmangService.getRoles();
	}

	@GetMapping(value = "/skillsets")
	public List<Skillset> getSkillsets() {

		return oppmangService.getSkillsets();
	}
	
	@GetMapping(value = "/statuses")
	public  List<Status> getStatues(){
		return oppmangService.getStatuses();
	}
	
	@GetMapping(value = "/teams")
	public List<Team> getTeams() {
		
		return oppmangService.getTeams();
	}

	@PostMapping(value = "/opportunities", consumes = "application/json", produces = "application/json")
	public int addOpportunity(@RequestBody OppAndSkills oppAndSkills) {
		
		return oppmangService.addOpportunity(oppAndSkills);
	}

	@PutMapping(value = "/opportunities/{id}")
	public int updateOpportunity(@RequestBody OppAndSkills oppAndSkills) {
	
		return oppmangService.updateOpportunity(oppAndSkills);
	}

	@DeleteMapping(value = "/opportunities/{id}")
	public int deleteOpportunity(@PathVariable int id) {
		
		return oppmangService.deleteOpportunity(id);
	}

	@GetMapping(value = "/opportunities/{id}")
	public OppAndSkills getOpportunity(@PathVariable int id) {

		return oppmangService.getOpportunity(id);
	}
	
	

}
