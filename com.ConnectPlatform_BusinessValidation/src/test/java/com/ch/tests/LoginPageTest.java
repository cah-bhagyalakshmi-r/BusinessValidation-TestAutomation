package com.ch.tests;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.LoginPage1;
import com.ch.util.CommonMethods;
import com.ch.util.excelReader;

public class LoginPageTest extends TestBase {

	LoginPage1 loginPage;
	DashboardPage dashboardPage;
	CommonMethods commonMethods;

	int defaultwaittime=15;
	int longerwaittime=30;
	String password = "";

	public LoginPageTest(){
		super();			
	}

	//@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {		
		initialization();
		loginPage = new LoginPage1();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		commonMethods.implicitwait(10);
	}



	@Test(description= "Verify successful signup functionality", priority = 3, groups = {"Regression"})
	public void signupsuccessful_Validation() throws IOException, InterruptedException, ParseException
	{	initialization();
	loginPage = new LoginPage1();
	dashboardPage = new DashboardPage();
	commonMethods = new CommonMethods();
	commonMethods.implicitwait(defaultwaittime);
		excelReader reader = new excelReader("./src/main/java/com/ch/testdata/signifyuserdetails4.xlsx");
		String sheetName = "Sheet1"; 
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("rowcount" +rowCount);
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			loginPage.signup_click();
			commonMethods.implicitwait(defaultwaittime);
			loginPage.registrationlabel_display();
			commonMethods.implicitwait(defaultwaittime);
			String fname = reader.getCellData(sheetName, "first_name", rowNum);
			loginPage.registerfirstName.sendKeys(fname);
			String lname = reader.getCellData(sheetName, "last_name", rowNum);
			loginPage.registerlastName.sendKeys(lname);	
			commonMethods.implicitwait(defaultwaittime);
			String uname = reader.getCellData(sheetName, "username", rowNum);
			loginPage.registerusername.sendKeys(uname);
			commonMethods.implicitwait(defaultwaittime);
			loginPage.register_inputdetails2(uname);		
			commonMethods.implicitwait(defaultwaittime);
			String pharmalicensename = reader.getCellData(sheetName, "license_number", rowNum);
			loginPage.pharmacistlicensenumber.sendKeys(pharmalicensename);	
			String npi = reader.getCellData(sheetName, "npi", rowNum);
			loginPage.npi.sendKeys(npi);
			String dob = reader.getCellData(sheetName, "dob", rowNum);
			loginPage.registerdob.click();
			loginPage.registerdob.sendKeys(dob);
			commonMethods.implicitwait(defaultwaittime);
			String pharmastate = reader.getCellData(sheetName, "license_state1", rowNum);
			loginPage.pharmacystate.sendKeys(pharmastate);
			String email = reader.getCellData(sheetName, "EmailAddress", rowNum);
			loginPage.registeremail.sendKeys(email);
			commonMethods.implicitwait(defaultwaittime);
			commonMethods.implicitwait(defaultwaittime);
			loginPage.phone_inputdata();
			commonMethods.implicitwait(defaultwaittime);
			loginPage.submitbutton_click();
			commonMethods.implicitwait(defaultwaittime);
			loginPage.signupsuccessmsg();			
			commonMethods.implicitwait(defaultwaittime);
			loginPage.logintoaccount_click();
			}
	}
	
	//@Test(description= "Verify roleupdate functionality", priority = 3, groups = {"Regression"})
		public void roleupdate_Validation() throws IOException, InterruptedException, ParseException
		{	internalinitialization();
			loginPage = new LoginPage1();
			dashboardPage = new DashboardPage();
			commonMethods = new CommonMethods();
			commonMethods.implicitwait(defaultwaittime);
			dashboardPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
			commonMethods.implicitwait(defaultwaittime);
			loginPage.manageuseraccount_click();
			commonMethods.implicitwait(defaultwaittime);
			excelReader reader = new excelReader("./src/main/java/com/ch/testdata/signifyuserdetails4.xlsx");
			String sheetName = "Sheet1"; 
			int rowCount = reader.getRowCount(sheetName);
			System.out.println("rowcount" +rowCount);
		    for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			    String accountusernm = reader.getCellData(sheetName, "username", rowNum);
			    commonMethods.implicitwait(defaultwaittime);
				loginPage.manageuseraccountusername.sendKeys(accountusernm);
				commonMethods.implicitwait(defaultwaittime);
				loginPage.manageuser_Searchbutton();
				commonMethods.implicitwait(defaultwaittime);
	            loginPage.action_click();
	            commonMethods.implicitwait(defaultwaittime);
	            JavascriptExecutor executor = (JavascriptExecutor) driver;
	            executor.executeScript("arguments[0].click();", loginPage.edituserrole);
	            commonMethods.implicitwait(defaultwaittime);
	            loginPage.pharmacist.click();
	            commonMethods.implicitwait(defaultwaittime);
	            String role = reader.getCellData(sheetName, "degree", rowNum);
	            if(role.contains("Doctor")) {
	            	loginPage.physician.click();}
	            else if(role.contains("PA")) {
	            	loginPage.physicianassistant.click();}
	            else if(role.contains("NP")) {
	            		loginPage.nursepractictioner.click();
	            }
	            else {
	            	System.out.println("No roles match");
	            }
	            commonMethods.implicitwait(defaultwaittime);
	            loginPage.saveroles_click();
	            commonMethods.implicitwait(defaultwaittime); 
			    loginPage.manageuseraccountusername.clear();
		  }
		}



@AfterMethod(alwaysRun = true)
public void tearDown(){
	driver.quit();
}

}


