package com.ebay.fsm.cilog;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import com.ebay.utils.DateUtils;

public class CIEventParserTest {
	@Test
	public void testParse() {
		String log = "18:47:20 [INFO] --- assembler-maven-plugin:1.1.5:config-merge (generate-configuration) @ raptor4yjweb ---";
		CIEventDefinition eventDef = new CIEventDefinition();
		eventDef.setName("start");
		eventDef.setTerminate(false);
		eventDef.setType("CIBuild");
		eventDef.setMatcher("(?<date>.*)\\[INFO] --- assembler-maven-plugin.*?---");
		try {
			CIEvent event = CIEventParser.parse(eventDef, log);
			assertEquals("start", event.getName());
			assertEquals("CIBuild", event.getType());
			assertEquals("18:47:20", DateUtils.format(event.getDate(), "HH:mm:ss"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
}
