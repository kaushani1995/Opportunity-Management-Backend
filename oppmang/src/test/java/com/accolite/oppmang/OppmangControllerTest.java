package com.accolite.oppmang;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.validation.ConstraintViolationProblemModule;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.BDDMockito.given;

import com.accolite.oppmang.controller.OppmangController;
import com.accolite.oppmang.model.*;
import com.accolite.oppmang.service.OppmangServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = OppmangController.class)
@ActiveProfiles("test")
class OppmangControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private OppmangServiceImpl oppmangServiceImpl;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private List<Location> locations;
	private List<Position> positions;
	private List<Skillset> skillset;
	private List<Status> statuses;
	private List<Team> teams;
	private List<User> users;
	
	@BeforeEach
	void setUp() {
		objectMapper.registerModule(new ProblemModule()); 
        objectMapper.registerModule(new ConstraintViolationProblemModule());
	}
	
	@Test
    void shouldFetchLocations() throws Exception {
		this.locations = new ArrayList<>();
		this.locations.add(new Location(1, "Bangalore"));
		this.locations.add(new Location(2, "Mumbai"));
		final Integer idLocation = 1;
		final Location location = new Location(1, "Bangalore");
		
		given(oppmangServiceImpl.getLocations()).willReturn(locations);

        this.mockMvc.perform(get("/oppmang/locations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(locations.size())));
        
        this.mockMvc.perform(get("/oppmang/locations/{id}", idLocation))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", is(location.getName()))); 
        
        this.mockMvc.perform(get("/oppmang/locations/{id}", 4))
        .andExpect(status().isOk());
    }
	
	
	@Test
    void shouldFetchPositions() throws Exception {
		this.positions = new ArrayList<>();
		this.positions.add(new Position(1, "Intern"));
		this.positions.add(new Position(2, "Senior SD"));
		this.positions.add(new Position(3, "Manager"));
        final Integer idPosition = 2;
        final Position position = new Position(2, "Senior SD");
        
        given(oppmangServiceImpl.getPositions()).willReturn(positions);
        
        this.mockMvc.perform(get("/oppmang/positions"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.size()", is(positions.size())));
        
        this.mockMvc.perform(get("/oppmang/positions/{id}", idPosition))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(position.getName())));
        
        this.mockMvc.perform(get("/oppmang/positions/{id}", 4))
        .andExpect(status().isOk());
        
    }
	
	@Test
    void shouldFetchSkillsets() throws Exception {
		this.skillset = new ArrayList<>();
		this.skillset.add(new Skillset(1, "Angular"));
		this.skillset.add(new Skillset(2, "C"));

		 given(oppmangServiceImpl.getSkillsets()).willReturn(skillset);
	        
	        this.mockMvc.perform(get("/oppmang/skillsets"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.size()", is(skillset.size())));
        
    }
	
	@Test
    void shouldFetchStatuses() throws Exception {
		this.statuses = new ArrayList<>();
		this.statuses.add(new Status(1, "Active"));
		this.statuses.add(new Status(2, "Inactive"));
		
        final Integer idStatus = 2;
        final Status status = new Status(2, "Inactive");
        
        given(oppmangServiceImpl.getStatuses()).willReturn(statuses);
        
        this.mockMvc.perform(get("/oppmang/statuses"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.size()", is(statuses.size())));
        
        this.mockMvc.perform(get("/oppmang/statuses/{id}", idStatus))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currStatus", is(status.getCurrStatus())));
        
        this.mockMvc.perform(get("/oppmang/statuses/{id}", 5))
        .andExpect(status().isOk());
        
    }
	
	@Test
    void shouldFetchTeams() throws Exception {
		this.teams = new ArrayList<>();
		this.teams.add(new Team(1, "Morgan Stanley"));
		this.teams.add(new Team(2, "Prudential"));
		this.teams.add(new Team(3, "FedEx"));
        final Integer idTeam = 3;
        final Team team = new Team(3, "FedEx");
        
        given(oppmangServiceImpl.getTeams()).willReturn(teams);
        
        this.mockMvc.perform(get("/oppmang/teams"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.size()", is(teams.size())));
        
        this.mockMvc.perform(get("/oppmang/teams/{id}", idTeam))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(team.getName())));
        
        this.mockMvc.perform(get("/oppmang/teams/{id}", 6))
        .andExpect(status().isOk());
    }
	
	@Test
    void shouldFetchUser() throws Exception {
        final String email = "kaushani.ani@gmail.com";
        final User user = new User("kaushani.ani@gmail.com", "Kaushani", "Admin");
        
        given(oppmangServiceImpl.getUser(email)).willReturn(user);

        this.mockMvc.perform(get("/oppmang/users/{email}", email))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is(user.getEmail())));
  
    }

	
	@Test
    void shouldFetchUsers() throws Exception {
		this.users = new ArrayList<>();
		this.users.add(new User("kaushani.ani@gmail.com", "Kaushani", "Admin"));
		this.users.add(new User("kaushani@gmail.com", "Kaushani2", "Admin"));
		this.users.add(new User("kaushani.chaudhuryi@gmail.com", "Kaushani3", "NotAdmin"));

		given(oppmangServiceImpl.getUsers()).willReturn(users);
        
        this.mockMvc.perform(get("/oppmang/users"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.size()", is(users.size())));
        
    }
	
	@Test
    void shouldFetchOpportunities() throws Exception {

        this.mockMvc.perform(get("/oppmang/opportunities"))
                .andExpect(status().isOk());
        
    }
	 
	@Test
    void shouldFetchOpportunity() throws Exception {
        final Integer idOpportunity = 1;
        final Opportunity opportunity = new Opportunity(1, "sampleemail", new Timestamp(0), "updatedby", new Timestamp(0), 2, 1, 3, "description", "manager", 2);

        given(oppmangServiceImpl.getOpportunity(idOpportunity)).willReturn(opportunity);
        
        this.mockMvc.perform(get("/oppmang/opportunities/{id}", idOpportunity))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.createdBy", is(opportunity.getCreatedBy())));
        
    }
	
	
	/*@Test
    void shouldUpdateOpportunity() throws Exception {
       
    
        ((MockHttpServletRequestBuilder) this.mockMvc.perform(put("/oppmang/opportunities/{id}"))
                .andExpect(status().isOk())).contentType(MediaType.APPLICATION_JSON_UTF8);
        
    }*/
	
	@Test
    void shouldDeleteOpportunity() throws Exception {
        final Integer idOpportunity = 1;

        this.mockMvc.perform(delete("/oppmang/opportunities/{id}", idOpportunity))
                .andExpect(status().isOk());
        
    }
	
	
	
	
}
