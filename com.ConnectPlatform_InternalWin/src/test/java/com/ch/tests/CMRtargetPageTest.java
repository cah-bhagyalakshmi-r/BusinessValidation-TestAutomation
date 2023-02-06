package com.ch.tests;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.base.TestBase;
import com.ch.pages.CMRtargetPage;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.util.CommonMethods;

public class CMRtargetPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CMRtargetPage cmrtargetedmembersPage;
	CommonMethods commonMethods;

	XSSFWorkbook wb = null;
	XSSFSheet sh = null;

	int defaultwaittime=35;
	int normalwaittime=5;

	public CMRtargetPageTest(){
		super();			
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {		
		internalinitialization();
		cmrtargetedmembersPage = new CMRtargetPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(description = "Verify cmr targeted members Report download to excel", priority = 2, groups = { "Sanity", "Regression" })
	public void cmrtargetedmembersdownloadexcel_validation() throws IOException, InterruptedException, ParseException {
		commonMethods.implicitwait(defaultwaittime);
		cmrtargetedmembersPage.cmrtargetedmembers_click();
		commonMethods.implicitwait(defaultwaittime);
		cmrtargetedmembersPage.cmrtargetedmembersfields_display();
		commonMethods.implicitwait(defaultwaittime);
		cmrtargetedmembersPage.downloadtoexcel_click();
		commonMethods.implicitwait(defaultwaittime);
		cmrtargetedmembersPage.getRecordsCountInCSV_exporttoexcel();
		commonMethods.implicitwait(defaultwaittime);
		cmrtargetedmembersPage.delete_file();
		commonMethods.implicitwait(defaultwaittime);		
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
}

