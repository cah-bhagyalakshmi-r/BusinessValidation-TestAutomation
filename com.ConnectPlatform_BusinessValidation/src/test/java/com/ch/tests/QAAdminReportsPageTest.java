package com.ch.tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.QAAdminReportsPage;
import com.ch.util.CommonMethods;

public class QAAdminReportsPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	QAAdminReportsPage qaadminreportsPage;
	CommonMethods commonMethods;

	int defaultWaittime = 45;
	int normalWaittime = 20;
	String prescriberfaxurl = "https://staging.outcomesmtm.com/index.cfm?event=prescriberComm.prescriberCommPDF&f=true";

	public QAAdminReportsPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, ParseException, IOException {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		qaadminreportsPage = new QAAdminReportsPage();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(description = "Verify downloadtoexcel and text for mtmclaims Report- QAAdmin", priority = 2, groups = { "Sanity", "Regression" })
	public void mtmclaimsreport_downloadexcelandtext_QAAdminvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.roleselect("Quality Assurance Admin");
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaims_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaimsheader_display();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.claimstatus_select();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.ncdp_input();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.searchbutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaimsreportheader_display();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaimsreport_validation();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.claimresultexcel_validation();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.claimresulttext_validation();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.dashboard_display();
	}

	@Test(description = "View claims for mtmclaims Report - QAAdmin", priority = 2, groups = { "Sanity", "Regression" })
	public void viewclaims_mtmclaimsreport_QAAdminvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.roleselect("Quality Assurance Admin");
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaims_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaimsheader_display();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.claimstatus_select();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.ncdp_input();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.searchbutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaimsreportheader_display();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaimsreport_validation();
		commonMethods.implicitwait(defaultWaittime);
		String claimnum=qaadminreportsPage.claimnumber.getText().trim();
		System.out.println("Claim number:" +claimnum);
		qaadminreportsPage.viewedit_click();
		commonMethods.implicitwait(defaultWaittime);
		String claimnumres= qaadminreportsPage.claimnumresult.getAttribute("textContent").trim();
		System.out.println("Claim result number:" +claimnum);
		commonMethods.implicitwait(defaultWaittime);
		Assert.assertEquals(claimnum, claimnumres);
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.dashboard_display();
	}

	//@Test(description= "Verify sort order in the mtm claims report - QAAdmin", priority = 2, groups = {"Sanity"})
	public void sortorder_QAAdminvalidation() throws IOException, InterruptedException
	{	
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.roleselect("Quality Assurance Admin");
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaims_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaimsheader_display();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.claimstatus_select();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.ncdp_input();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.searchbutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaimsreportheader_display();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.encounterdate.click();
		commonMethods.implicitwait(defaultWaittime);	
		qaadminreportsPage.encounterdate_sort();
		commonMethods.implicitwait(defaultWaittime);
		//qaadminreportsPage.status_sort();
		//commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.dashboard_display();
	}

	//@Test(description= "Verify pagination in the mtm claims report - QAAdmin", priority = 2, groups = {"Sanity"})
	public void mtmclaimsreport_pagination_QAAdminvalidation() throws IOException, InterruptedException
	{	
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.roleselect("Quality Assurance Admin");
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaims_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaimsheader_display();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.claimstatus_select();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.ncdp_input();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.searchbutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaimsreportheader_display();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.pagination_validation();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.dashboard_display();
	}

	@Test(description = "Verify downloadtoexcel and text for medrecclaims Report - QAAdmin", priority = 2, groups = { "Sanity", "Regression" })
	public void medrecclaimsreport_downloadexcelandtext_QAAdminvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.roleselect("Quality Assurance Admin");
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.medrecclaims_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.medrecclaimsheader_display();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.ncdplist_input();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.searchbutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.medrecclaimsreportheader_display();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.claimresultexcel_validation();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.claimresulttext_validation();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.dashboard_display();
	}
	
	@Test(description = "Verify downloadtoexcel and text for medsyncclaims Report - QAAdmin", priority = 2, groups = { "Sanity", "Regression" })
		public void medsyncclaimsreport_downloadexcelandtext_QAAdminvalidation() throws IOException, InterruptedException {
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.mainmenuclick();
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.switchroles.click();
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.roleselect("Quality Assurance Admin");
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.gobutton_click();
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.medsyncclaims_click();
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.medsyncclaimsheader_display();
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.claimstatuslist_select();
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.ncdplist_input();
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.searchbutton_click();
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.medsyncclaimsreportheader_display();
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.claimresultexcel_validation();
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.claimresulttext_validation();
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.mainmenuclick();
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.switchroles.click();
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.roleselectnew("Pharmacist");
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.gobutton_click();
			commonMethods.implicitwait(defaultWaittime);
			qaadminreportsPage.dashboard_display();
		}
	
	@Test(description = "Verify mtmclaims Adherence Report - QAAdmin", priority = 2, groups = { "Sanity", "Regression" })
	public void mtmclaimsadherenceclaimsreport_QAAdminvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.roleselect("Quality Assurance Admin");
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaimsadherence_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmclaimsadherenceheader_display();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.adherencencdp_input();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.mtmadherence_search();
		qaadminreportsPage.adherenceexport_fielddisplay();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.exportall_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.check_file_exist1();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.delete_file1();
		commonMethods.implicitwait(defaultWaittime);	
		qaadminreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		qaadminreportsPage.dashboard_display();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
