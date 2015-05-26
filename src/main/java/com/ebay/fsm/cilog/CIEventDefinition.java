package com.ebay.fsm.cilog;

import com.google.gson.Gson;

public class CIEventDefinition {
	private String name;
	private String type;
	private String matcher;
	private boolean isTerminate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMatcher() {
		return matcher;
	}
	public void setMatcher(String matcher) {
		this.matcher = matcher;
	}
	public boolean isTerminate() {
		return isTerminate;
	}
	public void setTerminate(boolean isTerminate) {
		this.isTerminate = isTerminate;
	}
	
	public String toString() {
//		return "name:" + name + ",type:" + type + ", isTerminate:" + isTerminate +  ",matcher:" + matcher;
		return new Gson().toJson(this);
	}
}
