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
import com.ch.pages.TIPPerfPage;
import com.ch.util.CommonMethods;

public class TIPPerfPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	TIPPerfPage tipperformancePage;
	CommonMethods commonMethods;

	XSSFWorkbook wb = null;
	XSSFSheet sh = null;

	int defaultwaittime = 35;
	int normalwaittime = 5;

	public TIPPerfPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {
		internalinitialization();
		tipperformancePage = new TIPPerfPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	//@Test(description = "Verify tip performance Report download to excel", priority = 2, groups = { "Sanity","Regression" })
	public void tipperformance_downloadexcel_validation() throws IOException, InterruptedException, ParseException {
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.tipperformance_click();
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.tipperformancefields_display();
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.date_select();
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.searchbutton_click();
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.tipperformancecolumn_display();
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.downloadtoexcel_click();
		System.out.println("Summary tab download to excel link is clicked");
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.getRecordsCountInCSV_exporttoexcel();
		System.out.println("Summary tab results are validated");
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.delete_file();
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.tiptab.click();
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.downloadtoexcel_click();
		System.out.println("tip breakdown tab download to excel link is clicked");
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.getRecordsCountInCSV_exporttoexcel1();
		System.out.println("tip breakdown tab results are validated");
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.delete_file();
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.pharmacytab.click();
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.pharmacy_downloadtoexcel_click();
		System.out.println("pharmacy breakdown tab download to excel link is clicked");
		Thread.sleep(15000);
		tipperformancePage.getRecordsCountInCSV_pharmacybreakdownexporttoexcel();
		System.out.println("pharmacy breakdown tab results are validated");
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.delete_file();
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.policytab_click();
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.downloadtoexcel_click();
		System.out.println("policy breakdown tab download to excel link is clicked");
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.getRecordsCountInCSV_exporttoexcel1();
		System.out.println("policy breakdown tab results are validated");
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.delete_file();
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.chaintab.click();
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.downloadtoexcel_click();
		System.out.println("chain breakdown tab download to excel link is clicked");
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.getRecordsCountInCSV_exporttoexcel1();
		System.out.println("chain breakdown tab results are validated");
		commonMethods.implicitwait(defaultwaittime);
		tipperformancePage.delete_file();
		commonMethods.implicitwait(defaultwaittime);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
