package com.infobip.dto;

import java.util.HashMap;
import java.util.Map;

public class StatisticDTO {
	
	private Map<String, Integer> stats = new HashMap<>();

	
	public StatisticDTO() {
		super();
	}

	public StatisticDTO(Map<String, Integer> stats) {
		super();
		this.stats = stats;
	}

	public Map<String, Integer> getStats() {
		return stats;
	}

	public void setStats(Map<String, Integer> stats) {
		this.stats = stats;
	}
	
	

}
