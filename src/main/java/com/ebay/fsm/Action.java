package com.ebay.fsm;

public interface Action {
	public void act(State curState, State newState, Event newEvent);
}
