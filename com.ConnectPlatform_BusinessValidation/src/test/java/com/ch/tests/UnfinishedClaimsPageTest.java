package com.ch.tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.base.TestBase;
import com.ch.pages.ClaimsSubmissionPage;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.PersonalInfoPage;
import com.ch.pages.TIPPage;
import com.ch.util.CommonMethods;

import junit.framework.Assert;

public class UnfinishedClaimsPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	ClaimsSubmissionPage claimssubmissionPage;
	TIPPage tipPage;
	PersonalInfoPage patientprofilePage;
	CommonMethods commonMethods;

	int normalWaitTime = 35;
	int defaultWaitTime = 60;

	String deletetipquery;

	public UnfinishedClaimsPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		claimssubmissionPage = new ClaimsSubmissionPage();
		tipPage = new TIPPage();
		patientprofilePage = new PersonalInfoPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(description ="Verification of successful submission of unfinished clams workflow", groups = {"Sanity", "Regression"}, priority =1)
	public void unfinishedclaims_successfulValidation1() throws InterruptedException, IOException, ParseException {
		boolean flowComplete = false;
		boolean dataFoundWithPatient = false;
		int maxPatientRecordsToCheck = 50;
		commonMethods.implicitwait(defaultWaitTime);
		for (int i = 2; i <= maxPatientRecordsToCheck; i++) {
			if
			(driver.findElements(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div.right-side-panel-container.flux-grid-item-9.flux-pad-l-md > div:nth-child(2) > ul > li:nth-child(" + i + ") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).size() == 0) { 
				break; }
			if (driver.findElement(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div.right-side-panel-container.flux-grid-item-9.flux-pad-l-md > div:nth-child(2) > ul > li:nth-child(" + i + ") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).getText().contains("CMR") || (driver.findElement(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div.right-side-panel-container.flux-grid-item-9.flux-pad-l-md > div:nth-child(2) > ul > li:nth-child(" + i + ") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).getText().contains("TIP"))){
				dataFoundWithPatient = true;
				driver.findElement(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div.right-side-panel-container.flux-grid-item-9.flux-pad-l-md > div:nth-child(2) > ul > li:nth-child(" + i + ") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).click();
				 Thread.sleep(8000);
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				commonMethods.implicitwait(defaultWaitTime);
					patientprofilePage.clickStartClaim();
					commonMethods.implicitwait(normalWaitTime);
					claimssubmissionPage.selectReason();
					commonMethods.implicitwait(normalWaitTime);
					claimssubmissionPage.selectService();
					commonMethods.implicitwait(normalWaitTime);	
					claimssubmissionPage.selectOutcome1("Unable to reach patient after 3 attempts");
					commonMethods.implicitwait(normalWaitTime);
					claimssubmissionPage.datepickerfortip_sendkeys();
					commonMethods.implicitwait(normalWaitTime);
					claimssubmissionPage.clickNextButton();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.selectMedication("Other");
					commonMethods.implicitwait(defaultWaitTime);
					tipPage.medinput();
					commonMethods.implicitwait(defaultWaitTime);
					tipPage.medselect();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.clickNextMedButton();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.leaveclaimpending_click();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.pharmacistaction_click();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.saveandcontinue_click();
					commonMethods.implicitwait(defaultWaitTime);
					String unfinishedclaim= tipPage.unfinishedclaimlistheader.getAttribute("textContent").trim().substring(0,1);
					int availableclaims=Integer.parseInt(unfinishedclaim);
					System.out.println("Available Claims: " + availableclaims);
					for (int j = 1; j <= availableclaims; j++) 
					{
						if (driver.findElement(By.cssSelector("md-list-item:nth-of-type(" + j + ") .ember-view.flex .opportunity-name")).getAttribute("textContent").contains("Adherence"))
						{
							driver.findElement(tipPage.getTIPLink(j)).click();
							commonMethods.implicitwait(normalWaitTime);
							claimssubmissionPage.clickContinueButton();
							commonMethods.implicitwait(normalWaitTime);
							claimssubmissionPage.clickSubmitClaimButton();
							System.out.println("Unfinished claim flow completed successfully.");
							commonMethods.implicitwait(defaultWaitTime);
							claimssubmissionPage.mtmclaimshistory_click();
							commonMethods.implicitwait(defaultWaitTime);
							claimssubmissionPage.searchbydate();
							commonMethods.implicitwait(defaultWaitTime);
							claimssubmissionPage.deleteclaimrow_click();
							commonMethods.implicitwait(defaultWaitTime);
							js.executeScript("window.scrollBy(0,8000)", "");
							claimssubmissionPage.cancelclaim1_click();
							commonMethods.implicitwait(defaultWaitTime);
						}	
					}	
					break;			
				}
			else {
				dataFoundWithPatient = false;
				System.out.println("CMR or TIP not present in the patient record.");
			}
			if (flowComplete) {
				break;
			} else if (dataFoundWithPatient) {
				dashboardPage.goToDashboard();
				commonMethods.implicitwait(defaultWaitTime);
			}
		}	

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
