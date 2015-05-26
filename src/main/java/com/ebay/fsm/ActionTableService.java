package com.ebay.fsm;

public interface ActionTableService {
	public ActionTable getActionTable(Event event);
	public void registerActionTable(String eventType, ActionTable actionTable);	
}
