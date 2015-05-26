package com.ebay.fsm.cilog;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;

public class CIEventDefinitionReaderTest {
	@Test
	public void testRead() {
		try {
			List<CIEventDefinition> eventDef = CIEventDefinitionReader.read("C:\\studio\\workspaces\\mytools\\mytools\\src\\main\\resources\\events.json");
			System.out.println(eventDef);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
