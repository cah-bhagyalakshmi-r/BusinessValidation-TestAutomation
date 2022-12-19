package com.ch.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.OperationsPage;
import com.ch.util.CommonMethods;

public class OperationsPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CommonMethods commonMethods;
	OperationsPage operationsPage;

	int defaultwaittime=25;
	int normalwaittime=12;

	public OperationsPageTest(){
		super();			
	}

	@Test(description= "Verify Operations-Salesforce Page Validation", priority = 1, groups = {"Regression"})
	public void operations_salesforcepage_validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		operationsPage = new OperationsPage();
		commonMethods = new CommonMethods();		
		Thread.sleep(2000);
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		operationsPage.salesforce_click();
		Thread.sleep(2000);
		operationsPage.continuesalesforce_click();
		Thread.sleep(2000);
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(browserTabs .get(1)); 
		Thread.sleep(2000);
		System.out.println("Title:"+driver.getTitle()); 
		String expectedTitle = "Login | Salesforce"; 
		AssertJUnit.assertEquals(expectedTitle, driver.getTitle()); 
		System.out.println("Navigated to salesforce webpage");
		Thread.sleep(2000);	
	}

	@Test(description= "Verify Operations-Legacy Page Validation", priority = 2, groups = {"Regression"})
	public void operations_legacypage_validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		operationsPage = new OperationsPage();
		commonMethods = new CommonMethods();		
		Thread.sleep(2000);
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		operationsPage.legacy_click();
		Thread.sleep(2000);
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(browserTabs .get(1)); 
		Thread.sleep(2000);
		System.out.println("Title:"+driver.getTitle()); 
		String expectedTitle = "OutcomesMTM"; 
		AssertJUnit.assertEquals(expectedTitle, driver.getTitle()); 
		System.out.println("Navigated to legacy webpage");
		Thread.sleep(2000);		
	}

	@Test(description= "Verify Operations-Patientlookup Page Validation", priority = 3, groups = {"Regression"})
	public void operations_patientlookup_validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		operationsPage = new OperationsPage();
		commonMethods = new CommonMethods();		
		Thread.sleep(2000);
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		operationsPage.patientlookup_click();
		Thread.sleep(2000);
		operationsPage.patientlookup_display();
		System.out.println("Navigated to Patientlookup page and the field labels are displayed");
		Thread.sleep(2000);
	}
	
	//@Test(description= "Verify Reportstodownload Validation", priority = 3, groups = {"Regression"})
	public void reportstodownload_validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		operationsPage = new OperationsPage();
		commonMethods = new CommonMethods();		
		Thread.sleep(2000);
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		operationsPage.selectreport_click();
		Thread.sleep(2000);
		operationsPage.selectreport_input();
		Thread.sleep(2000);
		operationsPage.downloadreport_click();
		System.out.println("Reportisdownloaded");
		Thread.sleep(2000);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}

}


