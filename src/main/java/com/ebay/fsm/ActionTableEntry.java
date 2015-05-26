package com.ebay.fsm;

public class ActionTableEntry {
	private State curState = null;
	private Event newEvent = null;
	private Action action = null;
	private State newState = null;
	public State getCurState() {
		return curState;
	}
	public void setCurState(State curState) {
		this.curState = curState;
	}
	public Event getNewEvent() {
		return newEvent;
	}
	public void setNewEvent(Event newEvent) {
		this.newEvent = newEvent;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	public State getNewState() {
		return newState;
	}
	public void setNewState(State newState) {
		this.newState = newState;
	}
	
	
}
