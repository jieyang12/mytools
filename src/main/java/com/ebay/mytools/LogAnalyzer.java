package com.ebay.mytools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;

import com.ebay.fsm.ActionTableServiceImpl;
import com.ebay.fsm.FSM;
import com.ebay.fsm.cilog.CIEvent;
import com.ebay.fsm.cilog.CIProfilingAction;
import com.ebay.utils.ImageUtils;
import com.google.common.io.CharStreams;

public class LogAnalyzer {
	CILogLineProcessor processor = new CILogLineProcessor();

	public LogAnalyzer() {
	}

	
	public void analyze(Readable input) throws Exception {
		CharStreams.readLines(input, processor);
		List<CIEvent> events = processor.getResult();
		System.out.println(events);
		handleEvents(events);
	}
	
	private void handleEvents(List<CIEvent> events) {
		FSM ciFSM = new FSM();
		ciFSM.setActionTableService(new ActionTableServiceImpl());
		for(CIEvent event:events) {
			ciFSM.handleEvent(event);
		}
		System.out.println(CIProfilingAction.getInstance().getPerfData());
		ImageUtils.createChart(CIProfilingAction.getInstance().getPerfData());
	}

	public static void main(String[] args) {
		String filePath = "C:\\Users\\jyang12\\Desktop\\trash\\config_merge.log";
		try {
			new LogAnalyzer().analyze(new InputStreamReader(new FileInputStream(new File(filePath))));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
