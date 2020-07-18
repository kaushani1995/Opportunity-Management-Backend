package com.accolite.oppmang.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CountAttribute {
	
	private String name;
	private Integer count;
	
	private static Logger LOGGER = LogManager.getLogger(CountAttribute.class);
	
	public CountAttribute(String name, Integer count) {
		super();
		LOGGER.info("Object Of Class Created - CountAttribute");
		this.name = name;
		this.count = count;
	}
	
	public CountAttribute() {
		super();
		LOGGER.info("Object Of Class Created - CountAttribute");
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
