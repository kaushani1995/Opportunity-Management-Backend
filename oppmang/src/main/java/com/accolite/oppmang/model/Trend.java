package com.accolite.oppmang.model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Trend {
	
	private static Logger LOGGER = LogManager.getLogger(Trend.class);
	
	private List<String> name;
	private List<Integer> count;
	
	
	public Trend() {
		super();
		LOGGER.info("Object Of Class Created - Trend");
	}


	public Trend(List<String> name, List<Integer> count) {
		super();
		this.name = name;
		this.count = count;
		LOGGER.info("Object Of Class Created - Trend");
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
