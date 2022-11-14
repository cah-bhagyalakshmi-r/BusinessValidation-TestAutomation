package com.ch.tests;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.base.TestBase;
import com.ch.pages.ClientReportsPage;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.util.CommonMethods;

public class ClientReportsPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	ClientReportsPage clientreportsPage;
	CommonMethods commonMethods;

	int defaultWaittime = 50;
	int normalWaittime = 20;

	public ClientReportsPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		clientreportsPage = new ClientReportsPage();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(description = "Verify mtmclaims Report display, Pagination and download to excel and text- client", priority = 1, groups = { "Sanity", "Regression" })
	public void mtmclaimsreport_downloadexcelandtext_clientvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.roleselectnew("Client");
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.reportsmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mtmclaims_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mtmclaimsheader_display();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.claimstatus_select();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.ncdp_input();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.searchbutton_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mtmclaimsreportheader_display();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mtmclaimsreport_validation();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.pagination_validation();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.downloadexcel_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.downloadtext_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
	}

	@Test(description = "Verify claim activity Report display and download to excel- client", priority = 2, groups = { "Sanity", "Regression" })
	public void claimactivityreport_downloadexcel_clientvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.switchroles.click();
		clientreportsPage.roleselectnew("Client");
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.reportsmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.claimactivity_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.claimsactivityheader_display();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mtmcenter_input();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.claimsactivitysearchbutton_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.claimsactivityreportheader_display();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.claimactivityreport_validation();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.downloadexcel_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
	}

	@Test(description = "Verify oppsbycenter Report display and download to excel and text- Client", priority = 2, groups = { "Sanity", "Regression" })
	public void oppsbycenterreportdownloadexcelandtext_Clientvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.switchroles.click();
		clientreportsPage.roleselectnew("Client");
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.reportsmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.oppsbycenter_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.oppsbycenterheader_display();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.ncdp_input();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mtmopp_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.oppscentersearchbutton_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.oppsbycenterreportheader_display();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.oppsbycenterreport_validation();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.pagination_validation();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.downloadexcel_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.oppsbycenterdownloadtext_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
	}

	@Test(description = "Verify currenttips Report display and download to excel and text- Client", priority = 3, groups = { "Sanity", "Regression" })
	public void currenttipsreportdownloadexcelandtext_clientvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.roleselectnew("Client");
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.reportsmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.oppurtunitycenter_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.currenttips_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.currenttipsheader_display();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.ncdp_input();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.currenttipsearchbutton_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.currenttipreportheader_display();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.currenttipsreport_validation();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.pagination_validation();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.downloadexcel_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.currenttipdownloadtext_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
	}

	@Test(description = "Verify tip performance Report display and download to excel- Client and text", priority = 4, groups = { "Sanity", "Regression" })
	public void tipperformancereportdownloadexcelandtext_clientvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.roleselectnew("Client");
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.reportsmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.performance_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.tipperformance_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.tipperformanceheader_display();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.ncdp_input();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.tipperformancesearchbutton_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.tipperformacnereportheader_display();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.tipperformancereport_validation();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.tipperfdownloadexcel_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.tipperformancedownloadtext_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.roleselectperf("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
	}
	
	@Test(description = "Verify approve request- client", priority = 7, groups = { "Sanity", "Regression" })
	public void approverequest_clientvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.roleselectnew("Client");
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.approvebutton_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.savebtn_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
	}
	
	@Test(description = "Verify deny request- client", priority = 6, groups = { "Sanity", "Regression" })
	public void denyrequest_clientvalidation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.roleselectnew("Client");
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.denybutton_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.savebtn_click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.mainmenuclick();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.roleselectnew("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		clientreportsPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
	}


	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
