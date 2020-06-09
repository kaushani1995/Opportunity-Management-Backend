package com.accolite.oppmang.model;

import java.util.List;

public class OppAndSkills {
	
	private Opportunity opportunity;
	private List<Integer> skillset;
	
	public OppAndSkills() {
		super();
	}

	public OppAndSkills(Opportunity opportunity, List<Integer> skillset) {
		super();
		this.opportunity = opportunity;
		this.skillset = skillset;
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
