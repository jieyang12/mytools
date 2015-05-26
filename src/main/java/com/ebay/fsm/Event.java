package com.ebay.fsm;

import java.util.Date;

public interface Event {
	public Date getDate();
	public String getContent();
	public String getName();
	public String getType();
	public boolean isTerminate();
}
