package com.ebay.fsm;

public interface ActionTable {
	public Action getAction(State curState, Event newEvent);
	public State transit(final State curState, Event newEvent);
}
