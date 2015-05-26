package com.ebay.fsm.cilog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.Ordering;

public class CIBuild {
	private Map<String, Double> perfData = new HashMap<String, Double>();

	public void addPerfData(String name, Double perf) {
		perfData.put(name, perf);
	}
	
	public String toString() {
		return Joiner.on("|").withKeyValueSeparator(":").join(perfData);
	}
	
	public int getPluginNum(){
		return perfData.size();
	}
	
	public List<String> getOrderedPluginNames() {
		Ordering<String> ordering = Ordering.natural();
		return ordering.sortedCopy(perfData.keySet());
	}
	
	public Double getPerfData(String pluginName) {
		return perfData.get(pluginName);
	}
	
}
