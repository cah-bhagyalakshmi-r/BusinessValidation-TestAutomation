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

public class Database2 extends TestBase{
	
	static Connection con = null;
	Statement stmt = null;
	public static ResultSet rs;
    JsonFileReader jsonreader = new JsonFileReader();

    public class DatabseConnection {
    	public void databaseConnection() {

    	    java.sql.Connection conn =null;
    	    ResultSet result = null;
    	    try {

    	    	String url="jdbc:sqlserver://AOCWFAPSQL01:1433;databaseName=Outcomes";
    			String username = "fuse\bhagyalakshmi.r";
    			String password = "Vedprekshith@2020";
    	//Initialize Sqldriver instance 
    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

    	 // Creating the connection providing URL and username password
    	   conn = DriverManager.getConnection(url, username, password);

    	 //Checking for the connection( returns boolean false if connected)
    	   System.out.println(conn.isClosed());

    	 // For Print
    	    System.out.println("Data values getting displayed below");
    	 // Sql Query to dispaly all the values under xxxxxxxx table            
    	    String query = "SELECT * from outcomes.dbo.tipresult where patientid=89'";
    	 // Providing the query under prepareStatement parameter 
    	    PreparedStatement pst=conn.prepareStatement(query);

    	 //Command to execute query and capturing all the result under Result set 
    	    result=pst.executeQuery();
    	     while(result.next()) {

    	  //Printing the 1 column 2 column and 6 column of the table
    	     System.out.println(result.getString(1)+ "   "+ result.getString(2) +"   " +result.getString(6));
    	            }

    	   // return result;

    	            } catch (Exception e) {
    	            e.printStackTrace();
    	            }finally {

    	            }

    	   // return result;


    	}}


	
	public static void closeDB() {
		try {
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();}
		}
	
}
