package com.ebay.fsm.cilog;

import java.util.Date;

import com.ebay.fsm.Event;
import com.google.gson.Gson;

public class CIEvent implements Event{
	private Date date = null;
	private String content = null;
	private String name = null;
	private String type = null;
	private boolean isTerminate = false;
	public Date getDate() {
		return date;
	}

	public String getContent() {
		return content;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setContent(String content) {
		this.content = content;
	}

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

	public boolean isTerminate() {
		return isTerminate;
	}

	public void setTerminate(boolean isTerminate) {
		this.isTerminate = isTerminate;
	}

	public String toString() {
		return new Gson().toJson(this);
	}
	
	public boolean equals(CIEvent event) {
		return this.getName().equals(event.getName());
	}
}
