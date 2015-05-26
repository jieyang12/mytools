package com.ebay.fsm;

import java.util.HashMap;
import java.util.Map;

import com.ebay.fsm.cilog.CIActionTable;

public class ActionTableServiceImpl implements ActionTableService{
	private Map<String, ActionTable> actionTables = new HashMap<String, ActionTable>(); 
	
	public ActionTableServiceImpl() {
		init();
	}
	
	
	public ActionTable getActionTable(Event event) {
		return actionTables.get(event.getType());
	}

	public void registerActionTable(String eventType, ActionTable actionTable) {
		actionTables.put(eventType, actionTable);
	}
	
	private void init() {
		ActionTable ciActionTable = new CIActionTable();
		actionTables.put("CIBuild", ciActionTable);
	}

}
