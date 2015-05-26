package com.ebay.mytools;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import com.ebay.fsm.cilog.CIEvent;
import com.ebay.fsm.cilog.CIEventDefinition;
import com.ebay.fsm.cilog.CIEventDefinitionReader;
import com.ebay.fsm.cilog.CIEventParser;
import com.google.common.io.LineProcessor;

public class CILogLineProcessor implements LineProcessor<List<CIEvent>> {
	List<CIEventDefinition> eventDefs = null;
//	List<EventParser> eventParserList = new LinkedList<EventParser>();

	public CILogLineProcessor() {
		loadEventDef();
	}
	
	private void loadEventDef() {
		try {
			eventDefs = CIEventDefinitionReader.read("C:\\studio\\workspaces\\mytools\\mytools\\src\\main\\resources\\events.json");
			System.out.println(eventDefs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private List<CIEvent> result = new LinkedList<CIEvent>();
	public List<CIEvent> getResult() {
		return result;
	}

	public boolean processLine(String line) throws IOException {
		try {
			result.addAll(CIEventParser.parse(eventDefs, line));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return true;
	}
	
//	public List<Event> lineToEvents(String line) {
//		List<Event> retval = new LinkedList<Event>();
//		for(EventParser parser: eventParserList) {
//			Event event = parser.parse(line);
//			if(event != null) {
//				retval.add(event);	
//			}
//		}
//		 
//		return retval;
//	}
//	
//	public void registerEventParser(EventParser parser) {
//		eventParserList.add(parser);
//	}
	
}
