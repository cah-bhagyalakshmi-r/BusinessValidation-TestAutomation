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
import com.ch.pages.RxEligPage;
import com.ch.util.CommonMethods;

public class RxEligPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	RxEligPage rxeligibilityPage;
	CommonMethods commonMethods;

	XSSFWorkbook wb = null;
	XSSFSheet sh = null;

	int defaultwaittime=15;
	int normalwaittime=5;

	public RxEligPageTest(){
		super();			
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {		
		internalinitialization();
		rxeligibilityPage = new RxEligPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//@Test(description = "Verify Rx Export download to excel validation", priority = 2, groups = { "Sanity", "Regression" })
	public void rxexportdownloadexcel_validation() throws Exception {
		commonMethods.implicitwait(defaultwaittime);
		rxeligibilityPage.rxeligibility_click();
		commonMethods.implicitwait(defaultwaittime);
		rxeligibilityPage.rxeligibilityfields_display();
		commonMethods.implicitwait(defaultwaittime);
		rxeligibilityPage.exportrx_click();
		System.out.println("Export Rx button is clicked");
		commonMethods.implicitwait(defaultwaittime);
		rxeligibilityPage.getRecordsCountInexcel_exporttoexcel1();
		System.out.println("Export rx results are validated");
		commonMethods.implicitwait(defaultwaittime);
		rxeligibilityPage.delete_file();
		commonMethods.implicitwait(defaultwaittime);	
	}
	
	//@Test(description = "Verify Rx Eligibility download to excel validation", priority = 2, groups = { "Sanity", "Regression" })
	public void rxeligibilitydownloadexcel_validation() throws Exception {
		commonMethods.implicitwait(defaultwaittime);
		rxeligibilityPage.rxeligibility_click();
		commonMethods.implicitwait(defaultwaittime);
		rxeligibilityPage.rxeligibilityfields_display();
		commonMethods.implicitwait(defaultwaittime);
		rxeligibilityPage.exporteligibility_click();
		System.out.println("Export Eligibility button is clicked");
		commonMethods.implicitwait(defaultwaittime);
		rxeligibilityPage.getRecordsCountInexcel_exporttoexcel();
		System.out.println("Export eligibility results are validated");
		commonMethods.implicitwait(defaultwaittime);
		rxeligibilityPage.delete_file();
		commonMethods.implicitwait(defaultwaittime);	
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
}


