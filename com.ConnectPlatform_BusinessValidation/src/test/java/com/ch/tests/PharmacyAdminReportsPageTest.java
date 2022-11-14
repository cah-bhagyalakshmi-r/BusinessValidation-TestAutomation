package com.ch.tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.PharmacyAdminReportsPage;
import com.ch.pages.PrescriberfaxPage;
import com.ch.util.CommonMethods;

public class PharmacyAdminReportsPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	PharmacyAdminReportsPage pharmacyadminreportsPage;
	CommonMethods commonMethods;

	int defaultWaittime = 50;
	int normalWaittime = 20;
	String prescriberfaxurl = "https://staging.outcomesmtm.com/index.cfm?event=prescriberComm.prescriberCommPDF&f=true";

	public PharmacyAdminReportsPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		pharmacyadminreportsPage = new PharmacyAdminReportsPage();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(description = "Verify mtmclaims Report display and download to excel and text - Pharmacy Administrator", priority = 1, groups = { "Sanity", "Regression" })
	public void mtmclaimsreport_downloadexcelandtext_pharmacyadminvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.roleselect("Pharmacy Administrator");
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.mtmclaims_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.mtmclaimsheader_display();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.claimstatus_select();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.ncdp_input();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.searchbutton_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.mtmclaimsreportheader_display();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.mtmclaimsreport_validation();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.pagination_validation();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.downloadexcel_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.downloadtext_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
	}
	
	@Test(description = "Verify oppsbycenter Report display and download to excel and text - Pharmacy Administrator", priority = 2, groups = { "Sanity", "Regression" })
	public void oppsbycenterreportdownloadexcelandtext_pharmacyadminvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.roleselect("Pharmacy Administrator");
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.oppurtunitycenter_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.oppsbycenter_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.oppsbycenterheader_display();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.ncdp_input();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.mtmopp_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.oppscentersearchbutton_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.oppsbycenterreportheader_display();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.oppsbycenterreport_validation();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.pagination_validation();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.downloadexcel_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.oppsbycenterdownloadtext_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
	}
	
	@Test(description = "Verify currenttips Report display and download to excel and text- Pharmacy Administrator", priority = 3, groups = {"Regression" })
	public void currenttipsreportdownloadexcelandtext_pharmacyadminvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.roleselect("Pharmacy Administrator");
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.oppurtunitycenter_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.currenttips_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.currenttipsheader_display();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.ncdp_input();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.currenttipsearchbutton_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.currenttipreportheader_display();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.currenttipsreport_validation();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.pagination_validation();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.downloadexcel_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.currenttipdownloadtext_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
	}
	
	@Test(description = "Verify tip performance Report display and download to excel and text- Pharmacy Administrator", priority = 4, groups = { "Sanity", "Regression" })
	public void tipperformancereportdownloadexcelandtext_pharmacyadminvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.roleselect("Pharmacy Administrator");
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.performance_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.tipperformance_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.tipperformanceheader_display();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.ncdp_input();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.tipperformancesearchbutton_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.tipperformacnereportheader_display();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.tipperformancereport_validation();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.tipperfdownloadexcel_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.tipperformancedownloadtext_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.roleselectperf("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
	}
	
	@Test(description = "Verify cmr performance Report display- Pharmacy Administrator", priority = 2, groups = {"Sanity", "Regression"})
	public void cmrperformancereport_pharmacyadminvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.roleselect("Pharmacy Administrator");
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.performance_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.cmrperformance_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.cmrperformanceheader_display();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.cmrperformancereport_validation();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.exportcmrreport_click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.check_file_exist_cmrreport();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.deletecmrreport_file();
		pharmacyadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		pharmacyadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
