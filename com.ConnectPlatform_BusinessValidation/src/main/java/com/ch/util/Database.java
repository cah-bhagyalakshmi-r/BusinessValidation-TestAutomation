package com.ch.util;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;

import com.ch.base.TestBase;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Database extends TestBase{
	
	static Connection con = null;
	Statement stmt = null;
	public static ResultSet rs;
    JsonFileReader jsonreader = new JsonFileReader();

	public static ResultSet executeQueryResult(String Query) throws SQLException, IOException, ParseException {

		JsonFileReader.getdata();
		String url = JsonFileReader.Database.get("url").toString();
		String username = JsonFileReader.Database.get("username").toString();
		String password = JsonFileReader.Database.get("password").toString();
		try {
			con = DriverManager.getConnection(url, username, password);	
			if (con != null) {
				System.out.println("connected to sql server successfully");
			}else {
				System.out.println("Connection failed");
			}
		Statement st= con.createStatement();
		rs= st.executeQuery(Query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	
	}
	
	public static ResultSet executeUpdateResult(String Query) throws SQLException, IOException, ParseException, ClassNotFoundException {
		JsonFileReader.getdata();
		//String url = JsonFileReader.Database.get("url").toString();
		//String username = JsonFileReader.Database.get("username").toString();
		//String password = JsonFileReader.Database.get("password").toString();
		//String url="jdbc:sqlserver://localhost:1433;databaseName=Outcomes";
		String url="jdbc:sqlserver://AOCWFAPSQL01:1433;databaseName=Outcomes";
		String username = "TurtleTeam_DevAutomation";
		String password = "2HS<CH$C,c22q8k6.j?Mje";
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			con = DriverManager.getConnection(url, username, password);	
			if (con != null) {
				System.out.println("connected to sql server successfully");
			}else {
				System.out.println("Connection failed");
			}
		Statement st= con.createStatement();
		boolean rs= st.execute(Query);}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	

	
	public static void closeDB() {
		try {
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();}
		}
	
}
