package com.accolite.oppmang;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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
	
	private Map<Integer, String> testMap;
	private Map<String, String> userMap;
	
	@BeforeEach
	void setUp() {
		this.testMap = new HashMap<Integer, String>();
		this.testMap.put(1, "one");
		this.testMap.put(2, "two");
		this.testMap.put(3, "three");
		
		
		objectMapper.registerModule(new ProblemModule()); 
        objectMapper.registerModule(new ConstraintViolationProblemModule());
	}
	
	@Test
    void shouldFetchLocations() throws Exception {
		
		given(oppmangServiceImpl.getLocations()).willReturn(testMap);

        this.mockMvc.perform(get("/oppmang/locations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(testMap.size())));
        
    }
	
	
	@Test
    void shouldFetchPositions() throws Exception {
        
        given(oppmangServiceImpl.getPositions()).willReturn(testMap);
        
        this.mockMvc.perform(get("/oppmang/positions"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.size()", is(testMap.size())));

        
    }
	
	@Test
    void shouldFetchSkillsets() throws Exception {


		 given(oppmangServiceImpl.getSkillsets()).willReturn(testMap);
	        
	        this.mockMvc.perform(get("/oppmang/skillsets"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.size()", is(testMap.size())));
        
    }
	
	@Test
    void shouldFetchStatuses() throws Exception {
        
        given(oppmangServiceImpl.getStatuses()).willReturn(testMap);
        
        this.mockMvc.perform(get("/oppmang/statuses"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.size()", is(testMap.size())));
        
    }
	
	@Test
    void shouldFetchTeams() throws Exception {
        
        given(oppmangServiceImpl.getTeams()).willReturn(testMap);
        
        this.mockMvc.perform(get("/oppmang/teams"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.size()", is(testMap.size())));
        
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
		this.userMap = new HashMap<>();
		this.userMap.put("kaushani.ani@gmail.com", "Kaushani");
		this.userMap.put("kaushani@gmail.com", "Kaushani2");
		this.userMap.put("kaushani.chaudhuryi@gmail.com",  "Kaushani3");

		given(oppmangServiceImpl.getUsers()).willReturn(userMap);
        
        this.mockMvc.perform(get("/oppmang/users"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.size()", is(userMap.size())));
        
    }
	
	
	@Test
    void shouldFetchOpportunities() throws Exception {

        this.mockMvc.perform(get("/oppmang/opportunities"))
                .andExpect(status().isOk());
        
    }
	 
	@Test
    void shouldFetchOpportunity() throws Exception {
        final Integer idOpportunity = 1;
        final List<Integer> skills = new ArrayList<>();
        skills.add(1);skills.add(2);skills.add(3);
        final Opportunity opportunity = new Opportunity(1, "sampleemail", new Timestamp(0), "updatedby", new Timestamp(0), 2, 1, 3, "description", "manager", 2);
        final OppAndSkills oppAndSkills = new OppAndSkills(opportunity, skills);
        
        given(oppmangServiceImpl.getOpportunity(idOpportunity)).willReturn(oppAndSkills);
        
        this.mockMvc.perform(get("/oppmang/opportunities/{id}", idOpportunity))
        .andExpect(status().isOk());
        
    }
	
	
	@SuppressWarnings("deprecation")
	@Test
    void shouldUpdateOpportunity() throws Exception {
		final Integer idOpportunity = 1;
        final List<Integer> skills = new ArrayList<>();
        skills.add(1);skills.add(2);skills.add(3);
        final Opportunity opportunity = new Opportunity(1, "sampleemail", new Timestamp(0), "updatedby", new Timestamp(0), 2, 1, 3, "description", "manager", 2);
        final OppAndSkills oppAndSkills = new OppAndSkills(opportunity, skills);
       
		given(oppmangServiceImpl.updateOpportunity(oppAndSkills)).willReturn(1);
        
        this.mockMvc.perform(put("/oppmang/opportunities/{id}", idOpportunity)
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(oppAndSkills)))
        .andExpect(status().isOk());

   
        
    }
	
	@SuppressWarnings("deprecation")
	@Test
	void shouldAddOpportunity() throws Exception {
        final List<Integer> skills = new ArrayList<>();
        skills.add(1);skills.add(2);skills.add(3);
        final Opportunity opportunity = new Opportunity(1, "sampleemail", new Timestamp(0), "updatedby", new Timestamp(0), 2, 1, 3, "description", "manager", 2);
        final OppAndSkills oppAndSkills = new OppAndSkills(opportunity, skills);
       
		given(oppmangServiceImpl.addOpportunity(oppAndSkills)).willReturn(1);
        
        this.mockMvc.perform(post("/oppmang/opportunities")
        		.contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(oppAndSkills)))
                .andExpect(status().isOk());
   
        
    }
	
	@Test
    void shouldDeleteOpportunity() throws Exception {
        final Integer idOpportunity = 1;

        this.mockMvc.perform(delete("/oppmang/opportunities/{id}", idOpportunity))
                .andExpect(status().isOk());
        
    }
	
	
	
	
}
