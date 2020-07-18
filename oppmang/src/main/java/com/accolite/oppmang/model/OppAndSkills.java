package com.accolite.oppmang.model;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OppAndSkills {
	
	private static Logger LOGGER = LogManager.getLogger(OppAndSkills.class);
	
	private Opportunity opportunity;
	private List<Integer> skillset;
	
	public OppAndSkills() {
		super();
		LOGGER.info("Object Of Class Created - OppAndSkills");
	}

	public OppAndSkills(Opportunity opportunity, List<Integer> skillset) {
		super();
		this.opportunity = opportunity;
		this.skillset = skillset;
		LOGGER.info("Object Of Class Created - OppAndSkills");
	}

	public Opportunity getOpportunity() {
		return opportunity;
	}
	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
	}
	public List<Integer> getSkillset() {
		return skillset;
	}
	public void setSkillset(List<Integer> skillset) {
		this.skillset = skillset;
	}
	
}
