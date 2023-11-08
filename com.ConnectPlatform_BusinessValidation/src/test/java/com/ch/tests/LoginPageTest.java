package com.ch.tests;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
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

	public LoginPageTest(){
		super();			
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {		
		initialization();
		loginPage = new LoginPage1();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		commonMethods.implicitwait(10);
	}



	@Test(description= "Verify successful signup functionality", priority = 3, groups = {"Regression"})
	public void signupsuccessful_Validation() throws IOException, InterruptedException
	{	
		excelReader reader = new excelReader("./src/main/java/com/ch/testdata/signifyuserdetails.xlsx");
		String sheetName = "Sheet1"; 
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("rowcount" +rowCount);
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			loginPage.signup_click();
			commonMethods.implicitwait(defaultwaittime);
			loginPage.registrationlabel_display();
			commonMethods.implicitwait(defaultwaittime);
			String fname = reader.getCellData(sheetName, "FirstName", rowNum);
			loginPage.registerfirstName.sendKeys(fname);
			String lname = reader.getCellData(sheetName, "LastName", rowNum);
			loginPage.registerlastName.sendKeys(lname);	
			commonMethods.implicitwait(defaultwaittime);
			Thread.sleep(1000);
			loginPage.register_inputdetails1();
			commonMethods.implicitwait(defaultwaittime);
			//loginPage.submitbutton_click();
			Thread.sleep(1000);
			String pharmalicensename = reader.getCellData(sheetName, "StateLicenseNumber1", rowNum);
			loginPage.pharmacistlicensenumber.sendKeys(pharmalicensename);	
			Thread.sleep(1000);
			String pharmastate = reader.getCellData(sheetName, "State", rowNum);
			loginPage.pharmacystate.sendKeys(pharmastate);
			Thread.sleep(1000);
			String email = reader.getCellData(sheetName, "EmailAddress", rowNum);
			loginPage.registeremail.sendKeys(email);
			Thread.sleep(1000);
			String uname = reader.getCellData(sheetName, "username", rowNum);
			loginPage.registerusername.sendKeys(uname);
			commonMethods.implicitwait(defaultwaittime);
			loginPage.dob_inputdata();
			Thread.sleep(1000);
			loginPage.phone_inputdata();
			//loginPage.profdetails();
			commonMethods.implicitwait(defaultwaittime);
			loginPage.submitbutton_click();
			commonMethods.implicitwait(defaultwaittime);
			loginPage.signupsuccessmsg();			
			commonMethods.implicitwait(defaultwaittime);
			loginPage.logintoaccount_click();
			}
	}

@AfterMethod(alwaysRun = true)
public void tearDown(){
	driver.quit();
}

}


