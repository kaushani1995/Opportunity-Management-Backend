package com.accolite.oppmang.model;

import java.util.List;

public class OppAndSkills {
	
	private Opportunity opportunity;
	private List<Skillset> skillset;
	
	public OppAndSkills() {
		super();
	}

	public OppAndSkills(Opportunity opportunity, List<Skillset> skillset) {
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
	public List<Skillset> getSkillset() {
		return skillset;
	}
	public void setSkillset(List<Skillset> skillset) {
		this.skillset = skillset;
	}
	
}
