package com.ebay.fsm;

import java.util.Date;

public interface State {
	public Date getDate(); //the date changed to this state
	public String getName();
	public void setDate(Date date);
	public void setName(String name);
	public boolean isTerminate();
	public void setTerminate(boolean terminate);
}
