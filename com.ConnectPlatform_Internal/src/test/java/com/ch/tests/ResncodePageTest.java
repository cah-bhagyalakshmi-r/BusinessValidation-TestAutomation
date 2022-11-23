package com.ch.tests;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.ReasoncodeTIPconfigurationPage;
import com.ch.pages.TIPPerformancePage;
import com.ch.util.CommonMethods;

public class ResncodePageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	ReasoncodeTIPconfigurationPage reasoncodeTIPconfigurationPage;
	CommonMethods commonMethods;

	XSSFWorkbook wb = null;
	XSSFSheet sh = null;

	int defaultwaittime=15;
	int normalwaittime=5;

	public ResncodePageTest(){
		super();			
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {		
		internalinitialization();
		reasoncodeTIPconfigurationPage = new ReasoncodeTIPconfigurationPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(description = "Reason code Tip configuration view Validation", priority =2, groups = {"Regression"})
	public void reasoncodeview_Validation() throws IOException, InterruptedException, ParseException
	{	
		commonMethods.implicitwait(defaultwaittime);
		reasoncodeTIPconfigurationPage.reasoncodetipconfiguration_click();
		commonMethods.implicitwait(defaultwaittime);
		reasoncodeTIPconfigurationPage.reasoncode_fieldvalidation();
		commonMethods.implicitwait(defaultwaittime);
		reasoncodeTIPconfigurationPage.firstrec_click();
		commonMethods.implicitwait(defaultwaittime);
		reasoncodeTIPconfigurationPage.reasoncode_view();
		System.out.println("Reason code was clicked and the fields are viewed");
		commonMethods.implicitwait(defaultwaittime);		
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
}


