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
import com.ch.pages.ClaimsSubmissionPage;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.TIPPage;
import com.ch.util.CommonMethods;
import com.ch.util.JsonFileReader;

public class ClaimsSubmissionPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	ClaimsSubmissionPage claimssubmissionPage;
	CommonMethods commonMethods;
	TIPPage tipPage;
	JsonFileReader jsonreader = new JsonFileReader();

	int defaultwaittime = 25;
	int normalwaittime = 15;
	int longerwaittime = 20;
	String clmsubid;

	public ClaimsSubmissionPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		claimssubmissionPage = new ClaimsSubmissionPage();
		tipPage = new TIPPage();
		commonMethods = new CommonMethods();
		commonMethods.implicitwait(normalwaittime);
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		readTestData();
	}

	private void readTestData() throws IOException, ParseException {
		jsonreader.getdata();
		clmsubid = jsonreader.ClaimSubmission.get("clmsubid").toString();
	}

	@Test(description = "Validation of Claims Submission and cancel claim ", priority = 1, groups = {"Regression" })
	public void submissionandcancellationofClaims_validation() throws IOException, InterruptedException, ParseException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys("MTM0021");
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		commonMethods.implicitwait(defaultwaittime);
				Thread.sleep(5000);
				if(claimssubmissionPage.gotocmrbtn.size() > 0){
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.clickClaimLink();
					commonMethods.implicitwait(normalwaittime);
					claimssubmissionPage.selectReason();
					commonMethods.implicitwait(normalwaittime);
					claimssubmissionPage.selectService();
					commonMethods.implicitwait(normalwaittime);
					claimssubmissionPage.selectOutcome1("Unable to reach patient after 3 attempts");
					commonMethods.implicitwait(normalwaittime);
					claimssubmissionPage.datepickerfortip_sendkeys();
					claimssubmissionPage.clickNextButton();
					commonMethods.implicitwait(normalwaittime);
					claimssubmissionPage.selectMedicationfortip();
					commonMethods.implicitwait(normalwaittime);
					claimssubmissionPage.selectMedication("Other");
					commonMethods.implicitwait(defaultwaittime);
					tipPage.medinput();
					commonMethods.implicitwait(defaultwaittime);
					tipPage.medselect();
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.clickNextMedButton();
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.clickContinueButton();
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.clickSubmitClaimButton();
					System.out.println("Claim submitted successfully");
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.mtmclaimshistory_click();
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.searchbydate();
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.deleteclaimrow_click();
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.cancelclaim1_click();
					Thread.sleep(2000);
					claimssubmissionPage.okbutton_click();
					commonMethods.implicitwait(defaultwaittime);
					System.out.println("Claim cancelled successfully")	;
				}

		}

	@AfterMethod(alwaysRun = true)
		public void tearDown() {
			driver.quit();
		}

	}
