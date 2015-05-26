package com.ebay.fsm.cilog;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.Gson;

public class CIEventDefinitionReader {
	
	public static List<CIEventDefinition> read(String filePath) throws Exception{
		Gson  gson = new Gson();
		File file = new File(filePath);
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
		List<CIEventDefinition> retval = gson.fromJson(isr, new com.google.gson.reflect.TypeToken<List<CIEventDefinition>>(){}.getType());
		isr.close();
		return retval;
	}
}
