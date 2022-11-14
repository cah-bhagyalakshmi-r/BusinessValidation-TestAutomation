package com.ch.tests;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.NINreasonsPage;
import com.ch.pages.TIPPerformancePage;
import com.ch.util.CommonMethods;

import junit.framework.Assert;

public class NINreasonsPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	NINreasonsPage ninreasonsPage;
	CommonMethods commonMethods;

	XSSFWorkbook wb = null;
	XSSFSheet sh = null;

	int defaultwaittime=25;
	int normalwaittime=5;

	public NINreasonsPageTest(){
		super();			
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {		
		internalinitialization();
		ninreasonsPage = new NINreasonsPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(description = "NIN reasons view Validation", priority =1, groups = {"Regression"})
	public void ninreasonsview_Validation() throws IOException, InterruptedException, ParseException
	{	
		commonMethods.implicitwait(defaultwaittime);;
		ninreasonsPage.ninreasons_click();
		commonMethods.implicitwait(defaultwaittime);;
		ninreasonsPage.ninreasons_fieldvalidation();
		commonMethods.implicitwait(defaultwaittime);;
		Select reasontype= new Select(ninreasonsPage.reasontype);
		reasontype.selectByIndex(1);	
		WebElement reasontyp = reasontype.getFirstSelectedOption();
		String selectreason1= reasontyp.getText();
		System.out.println("Reason:" +selectreason1);;
		commonMethods.implicitwait(defaultwaittime);;
		String reasonresult= ninreasonsPage.firstrecord.getText().trim();
		System.out.println("Reason result:" +reasonresult);
		Assert.assertEquals(selectreason1, reasonresult);
		System.out.println("select reason type and result is displayed in search results");				
	}
	
	
	@Test(description = "Change nin reason and save Validation", priority =2, groups = {"Regression"})
	public void ninreasonsave_Validation() throws IOException, InterruptedException, ParseException
	{	
		commonMethods.implicitwait(defaultwaittime);;
		ninreasonsPage.ninreasons_click();
		commonMethods.implicitwait(defaultwaittime);;
		ninreasonsPage.ninreasons_fieldvalidation();
		commonMethods.implicitwait(defaultwaittime);;
		Select reasontype= new Select(ninreasonsPage.reasontype);
		reasontype.selectByIndex(1);
		commonMethods.implicitwait(defaultwaittime);;
		ninreasonsPage.includedcheck();
		commonMethods.implicitwait(defaultwaittime);;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)", "");
		commonMethods.implicitwait(defaultwaittime);;
		ninreasonsPage.save_click();
		System.out.println("Included column value  for nin reasons is changed and saved successfully");		
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
}


