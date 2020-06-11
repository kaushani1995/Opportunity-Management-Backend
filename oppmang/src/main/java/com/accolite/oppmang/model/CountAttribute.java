package com.accolite.oppmang.model;

public class CountAttribute {
	
	private String name;
	private Integer count;
	
	public CountAttribute(String name, Integer count) {
		super();
		this.name = name;
		this.count = count;
	}
	
	public CountAttribute() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	

}
