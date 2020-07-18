package com.accolite.oppmang;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;

import com.accolite.oppmang.dao.OppmangDaoImpl;
import com.accolite.oppmang.model.OppAndSkills;
import com.accolite.oppmang.model.Opportunity;
import com.accolite.oppmang.model.Skillset;
import com.accolite.oppmang.model.Trend;
import com.accolite.oppmang.model.User;
import com.accolite.oppmang.service.OppmangServiceImpl;

@ExtendWith(MockitoExtension.class)
class OppmangServiceTest {
	
	 @Mock
	 private OppmangDaoImpl oppmangDaoImpl;

	 @InjectMocks
	 private OppmangServiceImpl oppmangServiceImpl;
	 
	 private Map<Integer, String> testMap;
	 
	 private Opportunity opportunity = new Opportunity(1, "sampleemail", new Timestamp(0), "updatedby", new Timestamp(0), 2, 1, 3, "description", "manager", 2);
			
	 private List<Integer> skills = Arrays.asList(new Integer[] {1});
	 private OppAndSkills oppAndSkills = new OppAndSkills(opportunity, skills);
			
	 private List<OppAndSkills> oppAndSkillsList =  Arrays.asList(new OppAndSkills[] {oppAndSkills});
	 
	 @BeforeEach
	 void setUp() {
		 this.testMap = new HashMap<Integer, String>();
		 this.testMap.put(1, "one");
		 this.testMap.put(2, "two");
		 this.testMap.put(3, "three");
	 }
	 
	 @Test
	 void shouldFetchOpportunities() {
		 given(oppmangDaoImpl.getOpportunities()).willReturn(oppAndSkillsList);
		 
		 assertEquals(oppAndSkillsList, oppmangServiceImpl.getOpportunities());
	 }
	 
	 @Test
	 void shouldFetchLocations() {
		 
		 given(oppmangDaoImpl.getLocations()).willReturn(this.testMap);

		 Map<Integer, String> expected = oppmangServiceImpl.getLocations();

	     assertEquals(expected, this.testMap);
	 }
	 
	 @Test
	    void shouldFetchPositions() {
		 
		 given(oppmangDaoImpl.getPositions()).willReturn(this.testMap);

		 Map<Integer, String> expected = oppmangServiceImpl.getPositions();

	     assertEquals(expected, this.testMap);
		 
	 }
	 
	 @Test
	    void shouldFetchSkillsets() {
		 
		 given(oppmangDaoImpl.getSkillsets()).willReturn(this.testMap);

		 Map<Integer, String> expected = oppmangServiceImpl.getSkillsets();

	     assertEquals(expected, this.testMap);
	 }
	 
	 @Test
	    void shouldFetchStatuses() {
		 
		 given(oppmangDaoImpl.getStatuses()).willReturn(this.testMap);

		 Map<Integer, String> expected = oppmangServiceImpl.getStatuses();

	     assertEquals(expected, this.testMap);
	 }
	 
	 @Test
	    void shouldFetchTeams() {
		 
		 given(oppmangDaoImpl.getTeams()).willReturn(this.testMap);

		 Map<Integer, String> expected = oppmangServiceImpl.getTeams();

	     assertEquals(expected, this.testMap); 
	 }
	 
	 @Test
	    void shouldFetchUser() throws Exception {
	        final String email = "kaushani.ani@gmail.com";
	        final User user = new User("kaushani.ani@gmail.com", "Kaushani", "Admin");
	        
	        given(oppmangDaoImpl.getUser(email)).willReturn(user);
	        
	        User expected = oppmangServiceImpl.getUser(email);
	        
	        assertEquals(expected, user);
	 
	 }
	 
	 @Test
	    void shouldFetchUsers() {
		 	Map<String, String> userMap = new HashMap<>();
			userMap.put("kaushani.ani@gmail.com", "Kaushani");
			userMap.put("kaushani@gmail.com", "Kaushani2");
			userMap.put("kaushani.chaudhuryi@gmail.com",  "Kaushani3");

			given(oppmangDaoImpl.getUsers()).willReturn(userMap);
	        
			Map<String, String> expected = oppmangServiceImpl.getUsers();
			
			assertEquals(expected, userMap);
	        
	    }
	 
	 @Test
	    void shouldFetchOpportunity() {
	        final Integer idOpportunity = 1;
	        final List<Integer> skills = new ArrayList<>();
	        skills.add(1);skills.add(2);skills.add(3);
	        final Opportunity opportunity = new Opportunity(1, "sampleemail", new Timestamp(0), "updatedby", new Timestamp(0), 2, 1, 3, "description", "manager", 2);
	        final OppAndSkills oppAndSkills = new OppAndSkills(opportunity, skills);
	        
	        given(oppmangDaoImpl.getOpportunity(idOpportunity)).willReturn(oppAndSkills);
	        
	        OppAndSkills expected = oppmangServiceImpl.getOpportunity(idOpportunity);
	        
	        assertEquals(expected, oppAndSkills);
	        
	 }
	 
	 @Test
	    void shouldUpdateOpportunity() {
	        final List<Integer> skills = new ArrayList<>();
	        skills.add(1);skills.add(2);skills.add(3);
	        final Opportunity opportunity = new Opportunity(1, "sampleemail", new Timestamp(0), "updatedby", new Timestamp(0), 2, 1, 3, "description", "manager", 2);
	        final OppAndSkills oppAndSkills = new OppAndSkills(opportunity, skills);
	       
			given(oppmangDaoImpl.updateOpportunity(oppAndSkills)).willReturn(1);
			
			assertEquals(1, oppmangServiceImpl.updateOpportunity(oppAndSkills));
	 }
	 

	 @Test
	    void shouldDeleteOpportunity() throws Exception {
	        
	       
			given(oppmangDaoImpl.deleteOpportunity(2)).willReturn(1);
			
			assertEquals(1, oppmangServiceImpl.deleteOpportunity(2));
	 }
	 
	 @Test
		void shouldAddOpportunity() throws Exception {
	        final List<Integer> skills = new ArrayList<>();
	        skills.add(1);skills.add(2);skills.add(3);
	        final Opportunity opportunity = new Opportunity(1, "sampleemail", new Timestamp(0), "updatedby", new Timestamp(0), 2, 1, 3, "description", "manager", 2);
	        final OppAndSkills oppAndSkills = new OppAndSkills(opportunity, skills);
	       
			given(oppmangDaoImpl.addOpportunity(oppAndSkills)).willReturn(1);
			
			assertEquals(1, oppmangServiceImpl.addOpportunity(oppAndSkills));
			
	 }
	 
	 @Test
	    void shouldFetchTrend() throws Exception {
		 	Trend trend;
			final List<String> name = new ArrayList<>();
			name.add("One");name.add("two");name.add("Three");
			final List<Integer> count = new ArrayList<>();
			count.add(1);count.add(2);count.add(3);
			trend = new Trend(name, count);

			given(oppmangDaoImpl.getTrend("location")).willReturn(trend);
			
			Trend expected = oppmangServiceImpl.getTrend("location");
			
			assertEquals(expected, trend);
			
	 }
	 
	 @Test
	    void shouldFetchSkillSetObj() throws Exception {
		 	List<Skillset> skills;
			skills = new ArrayList<>();
			skills.add(new Skillset(1, "C"));
			skills.add(new Skillset(2, "Java"));
			
			given(oppmangDaoImpl.getSkillsetsobj()).willReturn(skills);
			
			List<Skillset> expected = oppmangServiceImpl.getSkillsetsobj();
			
			assertEquals(expected, skills);
	 }
	 
	 

}
