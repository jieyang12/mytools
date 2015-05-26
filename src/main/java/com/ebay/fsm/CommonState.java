package com.ebay.fsm;

import java.util.Date;

public class CommonState implements State {
	private Date date = null;	
	private String name = null;
	private boolean isTerminate = false;
	
	public CommonState() {
		
	}
	
	public CommonState(String name, boolean isTerminate) {
		this.name = name;
		this.isTerminate = isTerminate;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isTerminate() {
		return isTerminate;
	}
	public void setTerminate(boolean isTerminate) {
		this.isTerminate = isTerminate;
	}
	
	public boolean equals(CommonState state) {
		return this.name.equals(state.getName());
	}
}
