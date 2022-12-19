package com.ch.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.parser.ParseException;

import com.ch.base.TestBase;

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
				System.out.println("connected to postgresql server successfully");
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
	
	public static ResultSet executeUpdateResult(String Query) throws SQLException, IOException, ParseException {
		JsonFileReader.getdata();
		String url = JsonFileReader.Database.get("url").toString();
		String username = JsonFileReader.Database.get("username").toString();
		String password = JsonFileReader.Database.get("password").toString();
		try {
			con = DriverManager.getConnection(url, username, password);	
			if (con != null) {
				System.out.println("connected to postgresql server successfully");
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
