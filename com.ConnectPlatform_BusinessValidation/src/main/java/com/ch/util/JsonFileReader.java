package com.ch.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;

import com.ch.base.TestBase;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileReader extends TestBase {
	
	public static Map<String, Object> Login;
	public static Map<String, Object> Search;
	public static Map<String, Object> CMR;
	public static Map<String, Object> TIP;
	public static Map<String, Object> ClaimSubmission;
	public static Map<String, Object> DataGeneratortip;
	public static  Map<String, Object> Database;
	public static  Map<String, Object> Patientnotes;
	
	@SuppressWarnings("unchecked")
	public static void getdata() throws IOException, ParseException {
		try {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node;
		
		node=mapper.readTree(new File(System.getProperty("user.dir")+ "/src/main/java/com/ch/testdata/testdata.json"));
		
		Login = mapper.readValue(node.get("login").toString(),Map.class);
		Search = mapper.readValue(node.get("search").toString(),Map.class);
		CMR = mapper.readValue(node.get("cmr").toString(),Map.class);
		TIP = mapper.readValue(node.get("tip").toString(),Map.class);
		ClaimSubmission = mapper.readValue(node.get("claimssubmission").toString(),Map.class);
		DataGeneratortip = mapper.readValue(node.get("datageneratortip").toString(),Map.class);
		Database = mapper.readValue(node.get("database").toString(),Map.class);
		Patientnotes = mapper.readValue(node.get("patientnotes").toString(),Map.class);
		new TypeReference<Map<String, Object>>()
		{	
		};
		}catch (Exception e) {
			//fail("Exception", e);
		}
		
	}
	
}
