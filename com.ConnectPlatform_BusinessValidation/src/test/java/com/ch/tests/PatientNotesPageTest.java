package com.ch.tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.PatientNotesPage1;
import com.ch.util.CommonMethods;
import com.ch.util.JsonFileReader;

public class PatientNotesPageTest extends TestBase {
	int normalwaittime=5;
	int defaultwaittime=10;
	int longerwaittime=40;

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CommonMethods commonMethods;
	PatientNotesPage1 patientnotesPage;
	JsonFileReader jsonreader=new JsonFileReader();

	public PatientNotesPageTest(){
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {		
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		patientnotesPage = new PatientNotesPage1();
		commonMethods.implicitwait(normalwaittime);
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		commonMethods.implicitwait(normalwaittime);
	}


	@Test(description = "Add/edit/delete patient notes successfully",priority= 1,groups = {"Sanity", "Regression"})
	public void addeditdelete_patientnotes_validation() throws IOException, InterruptedException, ParseException {
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys("CMR-a81c8e3b-ed79-4320-99e2-92ca820b8c5e");
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		commonMethods.implicitwait(defaultwaittime);
		Thread.sleep(10000);
		patientnotesPage.patientnotes_click();
		commonMethods.implicitwait(normalwaittime);
		patientnotesPage.addnote_click(); 
		commonMethods.implicitwait(normalwaittime);
		patientnotesPage.addnote_input(); 
		commonMethods.implicitwait(normalwaittime);
		patientnotesPage.savenote_click();
		commonMethods.implicitwait(normalwaittime);
		patientnotesPage.patientnote_validation();
		System.out.println("Patient note added successfully");
		commonMethods.implicitwait(normalwaittime);
		patientnotesPage.editnote_click();
		commonMethods.implicitwait(normalwaittime);
		patientnotesPage.patientnoteedit_input();
		commonMethods.implicitwait(normalwaittime);
		patientnotesPage.patienteditsavebutton_click();
		commonMethods.implicitwait(normalwaittime);
		patientnotesPage.patientnoteedit_validation();
		commonMethods.implicitwait(normalwaittime);
		System.out.println("Patient note modified successfully");
		patientnotesPage.deletenote_click();
		commonMethods.implicitwait(normalwaittime);
		System.out.println("Patient note deleted successfully");

	}

	//@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.close();
	}
}


