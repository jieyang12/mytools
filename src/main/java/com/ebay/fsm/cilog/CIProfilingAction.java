package com.ebay.fsm.cilog;

import java.util.LinkedList;
import java.util.List;

import com.ebay.fsm.Action;
import com.ebay.fsm.Event;
import com.ebay.fsm.State;

public class CIProfilingAction implements Action {
	private static CIProfilingAction instance = new CIProfilingAction();
	
	private List<CIBuild> perfData = new LinkedList<CIBuild>();
	private CIBuild curCIBuild = null;
	
	private CIProfilingAction() {
		
	}
	
	public static CIProfilingAction getInstance() {
		return instance;
	}
	
	public void act(State curState, State newState, Event newEvent) {
		if (curState == null || curState.isTerminate()) {
			System.out.println("-----------event start--------");
			curCIBuild = new CIBuild();
			perfData.add(curCIBuild);
			return;
		}
		
		long duration = newState.getDate().getTime() - curState.getDate().getTime();
		String name = curState.getName();		
//		perfData.put(name, Double.valueOf(duration));
		curCIBuild.addPerfData(name, Double.valueOf(duration));
		if(newEvent.isTerminate()) {
			System.out.println("-----------event end--------");
			curCIBuild = null;
		}		
	}

	public List<CIBuild> getPerfData() {
		return perfData;
	}


	
	
}
