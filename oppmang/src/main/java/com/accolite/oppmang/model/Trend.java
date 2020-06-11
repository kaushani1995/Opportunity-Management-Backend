package com.accolite.oppmang.model;

import java.util.List;

public class Trend {
	
	private List<String> name;
	private List<Integer> count;
	
	
	public Trend() {
		super();
	}


	public Trend(List<String> name, List<Integer> count) {
		super();
		this.name = name;
		this.count = count;
	}


	public List<String> getName() {
		return name;
	}


	public void setName(List<String> name) {
		this.name = name;
	}


	public List<Integer> getCount() {
		return count;
	}


	public void setCount(List<Integer> count) {
		this.count = count;
	}
	
	

}
