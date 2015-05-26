package com.ebay.fsm;

public class FSM {
	private ActionTableService actionTableService = null;
	private State curState = null;
	
	public void handleEvent(Event newEvent) {
		ActionTable actionTable = actionTableService.getActionTable(newEvent);
		Action action = actionTable.getAction(curState, newEvent);
		State oldState = curState;
		curState = actionTable.transit(curState, newEvent);
		action.act(oldState, curState, newEvent);
	}

	public ActionTableService getActionTableService() {
		return actionTableService;
	}

	public void setActionTableService(ActionTableService actionTableService) {
		this.actionTableService = actionTableService;
	}

	public State getCurState() {
		return curState;
	}

	public void setCurState(State curState) {
		this.curState = curState;
	}
	
	
}
