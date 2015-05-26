package com.ebay.fsm.cilog;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ebay.utils.DateUtils;

public class CIEventParser {
	public static List<CIEvent> parse(List<CIEventDefinition> eventDefs, String log) throws ParseException {
		List<CIEvent> events = new LinkedList<CIEvent>();
		for(CIEventDefinition eventDef : eventDefs) {
			CIEvent event = parse(eventDef, log);
			if(event != null) {
				events.add(event);
			}
		}
		return events;
	}
	
	public static CIEvent parse(CIEventDefinition eventDef, String log) throws ParseException {
		if(eventDef == null) {
			return null;
		}
		Pattern p = Pattern.compile(eventDef.getMatcher());
		Matcher m = p.matcher(log);
		if(m.matches()) {
			CIEvent event = new CIEvent();
			String date = m.replaceFirst("${date}");
			event.setDate(DateUtils.parse(date, "HH:mm:ss"));
			event.setContent(log);
			event.setName(eventDef.getName());
			event.setType(eventDef.getType());
			event.setTerminate(eventDef.isTerminate());
			return event;
		}
		return null;
	}
}
