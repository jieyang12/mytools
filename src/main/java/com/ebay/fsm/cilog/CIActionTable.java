package com.ebay.fsm.cilog;

import com.ebay.fsm.Action;
import com.ebay.fsm.ActionTable;
import com.ebay.fsm.CommonState;
import com.ebay.fsm.Event;
import com.ebay.fsm.State;

public class CIActionTable implements ActionTable {
	public Action getAction(State curState, Event newEvent) {
		return CIProfilingAction.getInstance();
	}

	public State transit(final State curState, Event newEvent) {
		State state = new CommonState();
		state.setDate(newEvent.getDate());
		state.setName(newEvent.getName());
		state.setTerminate(newEvent.isTerminate());

		return state;
	}

}
