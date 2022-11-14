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
import com.ch.pages.PersonalInfoPage;
import com.ch.pages.TIPPage;
import com.ch.util.CommonMethods;
import com.ch.util.JsonFileReader;

import junit.framework.Assert;

public class TIPPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	ClaimsSubmissionPage claimssubmissionPage;
	TIPPage tipPage;
	PersonalInfoPage patientprofilePage;
	CommonMethods commonMethods = new CommonMethods();

	/*
	 * boolean tipFoundWithPatient = false; boolean processTakingMedNoOption = true;
	 * boolean startClaimButtonFound = false; boolean tipComplete = false;
	 */
	int normalWaitTime = 45;
	int defaultWaitTime = 40;
	int WaitTime= 5;

	String deletetipquery;

	public TIPPageTest(){
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
		readTestData();
	}

	private void readTestData() throws IOException, ParseException {
		JsonFileReader.getdata();
		JsonFileReader jsonreader=new JsonFileReader();
		//deletetipquery=jsonreader.TIP.get("deleteadherenceantagonisttipquery").toString();
	}

	////@Test(description ="Verification of TIP workflow - Adherence - Needs Check-in (RAS Antagonist)", groups = {"Sanity", "Regression"}, priority =2)
	public void tiptest_Adherence_Antagonist_Validation() throws InterruptedException, IOException, ParseException {
		boolean tipFoundWithPatient = false;
		boolean processTakingMedNoOption = true;
		boolean startClaimButtonFound = false;
		boolean tipComplete = false;
		commonMethods.implicitwait(defaultWaitTime);
		dashboardPage.searchtext.sendKeys("MTM0021");
		dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultWaitTime);
		String tip= tipPage.tipListHeader.getAttribute("textContent").trim().substring(0,1);
		int availableTIPs=Integer.parseInt(tip);
		System.out.println("Available TIPs: " + availableTIPs);
		for (int j = 1; j <= availableTIPs; j++) 
		{
			if (driver.findElement(By.cssSelector("md-list-item:nth-of-type(" + j + ") .ember-view.flex .opportunity-name")).getAttribute("textContent").contains("Adherence - Needs Check-in (RAS Antagonist)"))
			{
				System.out.println("Clicking TIP " + j + " (" + driver.findElement(tipPage.getTIPName(j)).getText() + "):");
				driver.findElement(tipPage.getTIPLink(j)).click();
				commonMethods.implicitwait(normalWaitTime);
				tipPage.takingMedYesElement.click();
				commonMethods.implicitwait(normalWaitTime);
				if (tipPage.startclaimfortip_display()) {
					startClaimButtonFound = true;
				} else {
					if (processTakingMedNoOption) {
						tipPage.takingMedNoElement.click();
						commonMethods.implicitwait(normalWaitTime);
						if (tipPage.startclaimfortiipbutton.isDisplayed()) {
							startClaimButtonFound = true;
						}
					} else {
						tipPage.closingtipbutton.click();
						continue;
					}
				}
				if (startClaimButtonFound) {
					patientprofilePage.clickStartClaim();
					commonMethods.implicitwait(normalWaitTime);
					//claimssubmissionPage.selectpharmacist();
					commonMethods.implicitwait(normalWaitTime);
					if (driver.findElements(By.xpath("//*[@id='result']/option[text()='Adherence check-in completed']")).size() > 0) {
						claimssubmissionPage.selectOutcome1("Adherence check-in completed");
					}
					commonMethods.implicitwait(normalWaitTime);
					claimssubmissionPage.datepickerfortip_sendkeys();
					claimssubmissionPage.clickNextButton();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.selectAdherenceBarrier();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.selectAdherenceBarrierAction();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.processAdherenceBarriers();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.selectMedication("Other");
					commonMethods.implicitwait(defaultWaitTime);
					tipPage.medinput();
					commonMethods.implicitwait(defaultWaitTime);
					tipPage.medselect();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.clickNextMedButton();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.clickContinueButton();
					commonMethods.implicitwait(defaultWaitTime);
					if (!tipPage.trialMode)
					{
						System.out.println("Clicking Submit Claim button.");
						claimssubmissionPage.clickSubmitClaimButton();
						commonMethods.implicitwait(defaultWaitTime);
					} 
					else 
					{
						System.out.println("Trial Mode is on - skipping the final step.");
					}

					System.out.println("TIP flow completed successfully.");
					tipComplete = true;
					break;
				}	
			}		
			else {
				tipFoundWithPatient = false;
				System.out.println("The tip is not of a type 'Adherence - Needs Check-in (RAS Antagonist)'");
				Assert.assertEquals(tipFoundWithPatient, false);
			}
		}		

	}	

	//@Test(description ="Verification of TIP workflow - Adherence - Needs 90-day Fill (Statin)",groups = {"Sanity", "Regression"}, priority =3)
	public void tiptest_Adherence_Statin_Validation() throws InterruptedException, IOException, ParseException {
		boolean tipFoundWithPatient = false;
		boolean processTakingMedNoOption = true;
		boolean startClaimButtonFound = false;
		boolean tipComplete = false;
		commonMethods.implicitwait(defaultWaitTime);
		dashboardPage.searchtext.sendKeys("MTM0021");
		dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultWaitTime);
		String tip= tipPage.tipListHeader.getAttribute("textContent").trim().substring(0,1);
		int availableTIPs=Integer.parseInt(tip);
		System.out.println("Available TIPs: " + availableTIPs);
		for (int j = 1; j <= availableTIPs; j++) {
			if (driver.findElement(By.cssSelector("md-list-item:nth-of-type(" + j + ") .ember-view.flex .opportunity-name")).getAttribute("textContent").contains("Adherence - Needs 90-day Fill (Statin)")) {
				System.out.println("Clicking TIP " + j + " (" + driver.findElement(tipPage.getTIPName(j)).getText() + "):");
				driver.findElement(tipPage.getTIPLink(j)).click();
				commonMethods.implicitwait(normalWaitTime);
				tipPage.takingMedYesElement.click();
				commonMethods.implicitwait(normalWaitTime);
				if (tipPage.startclaimfortip_display()) {
					startClaimButtonFound = true;
				} else {
					if (processTakingMedNoOption) {
						tipPage.takingMedNoElement.click();
						commonMethods.implicitwait(normalWaitTime);
						if (tipPage.startclaimfortiipbutton.isDisplayed()) {
							startClaimButtonFound = true;
						}
					} else {
						tipPage.closingtipbutton.click();
						continue;
					}
				}
				if (startClaimButtonFound) {
					patientprofilePage.clickStartClaim();
					commonMethods.implicitwait(normalWaitTime);
					//claimssubmissionPage.selectpharmacist();
					commonMethods.implicitwait(normalWaitTime);
					if (driver.findElements(By.xpath("//*[@id='result']/option[text()='Adherence check-in completed + 90-day fill']")).size() > 0) {
						claimssubmissionPage.selectOutcome1("Adherence check-in completed + 90-day fill");
						claimssubmissionPage.radiooption1_click();
						claimssubmissionPage.radiooption2_click();
					}
					commonMethods.implicitwait(normalWaitTime);
					claimssubmissionPage.datepickerfortip_sendkeys();
					claimssubmissionPage.clickNextButton();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.selectAdherence90dayBarrier();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.selectAdherence90dayBarrierAction();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.processAdherenceBarriers();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.selectMedication("Other");
					commonMethods.implicitwait(defaultWaitTime);
					tipPage.medinput();
					commonMethods.implicitwait(defaultWaitTime);
					tipPage.medselect();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.clickNextMedButton();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.clickContinueButton();
					commonMethods.implicitwait(defaultWaitTime);
					if (!tipPage.trialMode)
					{
						System.out.println("Clicking Submit Claim button.");
						claimssubmissionPage.clickSubmitClaimButton();
						commonMethods.implicitwait(defaultWaitTime);
					} 
					else 
					{
						System.out.println("Trial Mode is on - skipping the final step.");
					}

					System.out.println("TIP flow completed successfully.");
					tipComplete = true;
					break;
				}	
			}		
			else {
				tipFoundWithPatient = false;
				System.out.println("The tip is not of a type 'Adherence - Needs 90-day Fill (Statin)'");
				Assert.assertEquals(tipFoundWithPatient, false);
			}
		}		

	}	

	////@Test(description="Verification of TIP workflow - Adherence Monitoring (DPP-IV Inhibitor)",groups = {"Sanity", "Regression"}, priority =3)
	public void tiptest_AdherenceMonitoringdvp_Validation() throws InterruptedException, IOException, ParseException {
		boolean tipFoundWithPatient = false;
		boolean processTakingMedNoOption = true;
		boolean startClaimButtonFound = false;
		boolean tipComplete = false;
		commonMethods.implicitwait(defaultWaitTime);
		dashboardPage.searchtext.sendKeys("MTM0021");
		dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultWaitTime);
		String tip= tipPage.tipListHeader.getAttribute("textContent").trim().substring(0,1);
		int availableTIPs=Integer.parseInt(tip);
		System.out.println("Available TIPs: " + availableTIPs);
		for (int j = 1; j <= availableTIPs; j++) 
		{
			if (driver.findElement(By.cssSelector("md-list-item:nth-of-type(" + j + ") .ember-view.flex .opportunity-name")).getAttribute("textContent").contains("Adherence Monitoring (DPP-IV Inhibitor)")) {
				System.out.println("Clicking TIP " + j + " (" + driver.findElement(tipPage.getTIPName(j)).getText() + "):");
				driver.findElement(tipPage.getTIPLink(j)).click();
				commonMethods.implicitwait(normalWaitTime);
				tipPage.takingMedYesElement.click();
				commonMethods.implicitwait(normalWaitTime);
				if (tipPage.startclaimfortip_display()) {
					startClaimButtonFound = true;
				} else {
					if (processTakingMedNoOption) {
						tipPage.takingMedNoElement.click();
						commonMethods.implicitwait(normalWaitTime);
						if (tipPage.startclaimfortiipbutton.isDisplayed()) {
							startClaimButtonFound = true;
						}
					} else {
						tipPage.closingtipbutton.click();
						continue;
					}
				}
				if (startClaimButtonFound) {
					patientprofilePage.clickStartClaim();
					commonMethods.implicitwait(normalWaitTime);
					//claimssubmissionPage.selectpharmacist();
					commonMethods.implicitwait(normalWaitTime);
					if (driver.findElements(By.xpath("//*[@id='result']/option[text()='Patient monitored & enrolled']")).size() > 0) {
						claimssubmissionPage.selectOutcome1("Patient monitored & enrolled");
					}
					commonMethods.implicitwait(normalWaitTime);
					claimssubmissionPage.datepickerfortip_sendkeys();
					claimssubmissionPage.clickNextButton();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.selectAdherencedvpBarrier();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.selectAdherencedvpBarrierAction();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.processAdherenceBarriers();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.selectMedication("Other");
					commonMethods.implicitwait(defaultWaitTime);
					tipPage.medinput();
					commonMethods.implicitwait(defaultWaitTime);
					tipPage.medselect();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.clickNextMedButton();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.processPatientCommunication();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.clickContinueButton();
					commonMethods.implicitwait(defaultWaitTime);
					if (!tipPage.trialMode)
					{
						System.out.println("Clicking Submit Claim button.");
						claimssubmissionPage.clickSubmitClaimButton();
						commonMethods.implicitwait(defaultWaitTime);
					} 
					else 
					{
						System.out.println("Trial Mode is on - skipping the final step.");
					}

					System.out.println("TIP flow completed successfully.");
					tipComplete = true;
					break;
				}	
			}		
			else {
				tipFoundWithPatient = false;
				System.out.println("The tip is not of a type 'Adherence Monitoring (DPP-IV Inhibitor)'");
				Assert.assertEquals(tipFoundWithPatient, false);
			}
		}		

	}	

	//@Test(description="Verification of TIP workflow - Needs Drug Therapy - Statin (Diabetes)",groups = {"Sanity", "Regression"}, priority =3)
	public void tiptest_NeedsDrugTherapy_Diabetes_Validation() throws InterruptedException, IOException, ParseException {
		boolean tipFoundWithPatient = false;
		boolean processTakingMedNoOption = true;
		boolean startClaimButtonFound = false;
		boolean tipComplete = false;
		commonMethods.implicitwait(defaultWaitTime);
		dashboardPage.searchtext.sendKeys("MTM0021");
		dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultWaitTime);
		String tip= tipPage.tipListHeader.getAttribute("textContent").trim().substring(0,1);
		int availableTIPs=Integer.parseInt(tip);
		System.out.println("Available TIPs: " + availableTIPs);
		for (int j = 1; j <= availableTIPs; j++) {
			if (driver.findElement(By.cssSelector("md-list-item:nth-of-type(" + j + ") .ember-view.flex .opportunity-name")).getAttribute("textContent").contains("Needs Drug Therapy - Statin (Diabetes)")) {
				System.out.println("Clicking TIP " + j + " (" + driver.findElement(tipPage.getTIPName(j)).getText() + "):");
				driver.findElement(tipPage.getTIPLink(j)).click();
				commonMethods.implicitwait(normalWaitTime);
				tipPage.takingMedYesElement.click();
				commonMethods.implicitwait(normalWaitTime);
				if (tipPage.startclaimfortip_display()) {
					startClaimButtonFound = true;
				} else {
					if (processTakingMedNoOption) {
						tipPage.takingMedNoElement.click();
						commonMethods.implicitwait(normalWaitTime);
						if (tipPage.startclaimfortiipbutton.isDisplayed()) {
							startClaimButtonFound = true;
						}
					} else {
						tipPage.closingtipbutton.click();
						continue;
					}
				}
				if (startClaimButtonFound) {
					patientprofilePage.clickStartClaim();
					commonMethods.implicitwait(normalWaitTime);
					//claimssubmissionPage.selectpharmacist();
					//commonMethods.implicitwait(normalWaitTime);
					//if (driver.findElements(By.xpath("//select[@id='result']/option[text()='Recommendation made']")).size() > 0) {
					claimssubmissionPage.selectOutcome1("Recommendation made");
					//}
					commonMethods.implicitwait(normalWaitTime);
					claimssubmissionPage.datepickerfortip_sendkeys();
					claimssubmissionPage.clickNextButton();
					commonMethods.implicitwait(defaultWaitTime);
					tipPage.newmedinput();
					commonMethods.implicitwait(defaultWaitTime);
					tipPage.newmedselect();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.clickNewMedNextButton();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.clickContinueButton();
					commonMethods.implicitwait(defaultWaitTime);
					if (!tipPage.trialMode)
					{
						System.out.println("Clicking Submit Claim button.");
						claimssubmissionPage.clickSubmitClaimButton();
						commonMethods.implicitwait(defaultWaitTime);
					} 
					else 
					{
						System.out.println("Trial Mode is on - skipping the final step.");
					}

					System.out.println("TIP flow completed successfully.");
					tipComplete = true;
					break;
				}	
			}		
			else {
				tipFoundWithPatient = false;
				System.out.println("The tip is not of a type 'Needs Drug Therapy - Statin (Diabetes)'");
				Assert.assertEquals(tipFoundWithPatient, false);
			}
		}		

	}	

	//@Test(description="Verification of TIP workflow - Needs Refill - RAS Antagonist",groups = {"Sanity", "Regression"}, priority =3)
	public void tiptest_NeedsRefill_RASAntagonist_Validation() throws InterruptedException, IOException, ParseException {
		boolean tipFoundWithPatient = false;
		boolean processTakingMedNoOption = true;
		boolean startClaimButtonFound = false;
		boolean tipComplete = false;
		commonMethods.implicitwait(defaultWaitTime);
		dashboardPage.searchtext.sendKeys("MTM0021");
		dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultWaitTime);
		String tip= tipPage.tipListHeader.getAttribute("textContent").trim().substring(0,1);
		int availableTIPs=Integer.parseInt(tip);
		System.out.println("Available TIPs: " + availableTIPs);
		for (int j = 1; j <= availableTIPs; j++) 
		{
			if (driver.findElement(By.cssSelector("md-list-item:nth-of-type(" + j + ") .ember-view.flex .opportunity-name")).getAttribute("textContent").contains("Needs Refill - RAS Antagonist")) {
				System.out.println("Clicking TIP " + j + " (" + driver.findElement(tipPage.getTIPName(j)).getText() + "):");
				driver.findElement(tipPage.getTIPLink(j)).click();
				commonMethods.implicitwait(normalWaitTime);
				tipPage.takingMedYesElement.click();
				commonMethods.implicitwait(normalWaitTime);
				if (tipPage.startclaimfortip_display()) {
					startClaimButtonFound = true;
				} else {
					if (processTakingMedNoOption) {
						tipPage.takingMedNoElement.click();
						commonMethods.implicitwait(normalWaitTime);
						if (tipPage.startclaimfortiipbutton.isDisplayed()) {
							startClaimButtonFound = true;
						}
					} else {
						tipPage.closingtipbutton.click();
						continue;
					}
				}
				if (startClaimButtonFound) {
					patientprofilePage.clickStartClaim();
					commonMethods.implicitwait(normalWaitTime);
					//claimssubmissionPage.selectpharmacist();
					commonMethods.implicitwait(normalWaitTime);
					if (driver.findElements(By.xpath("//*[@id='result']/option[text()='Patient refilled Rx']")).size() > 0) {
						claimssubmissionPage.selectOutcome1("Patient refilled Rx");
						claimssubmissionPage.radiooption3_click();
						claimssubmissionPage.radiooption4_click();
					}
					commonMethods.implicitwait(normalWaitTime);
					claimssubmissionPage.datepickerfortip_sendkeys();
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
					claimssubmissionPage.clickContinueButton();
					commonMethods.implicitwait(defaultWaitTime);
					if (!tipPage.trialMode)
					{
						System.out.println("Clicking Submit Claim button.");
						claimssubmissionPage.clickSubmitClaimButton();
						commonMethods.implicitwait(defaultWaitTime);
					} 
					else 
					{
						System.out.println("Trial Mode is on - skipping the final step.");
					}

					System.out.println("TIP flow completed successfully.");
					tipComplete = true;
					break;
				}	
			}		
			else {
				tipFoundWithPatient = false;
				System.out.println("The tip is not of a type 'Needs Refill - RAS Antagonist'");
				Assert.assertEquals(tipFoundWithPatient, false);
			}
		}		

	}	

	//@Test(description="Verification of TIP workflow - Needs Immunization - Influenza",groups = {"Sanity", "Regression"}, priority =3)
	public void tiptest_NeedsImmunization_Influenza_Validation() throws InterruptedException, IOException, ParseException {
		boolean tipFoundWithPatient = false;
		boolean processTakingMedNoOption = true;
		boolean startClaimButtonFound = false;
		boolean tipComplete = false;
		commonMethods.implicitwait(defaultWaitTime);
		dashboardPage.searchtext.sendKeys("MTM0021");
		dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultWaitTime);
		String tip= tipPage.tipListHeader.getAttribute("textContent").trim().substring(0,1);
		int availableTIPs=Integer.parseInt(tip);
		System.out.println("Available TIPs: " + availableTIPs);
		for (int j = 1; j <= availableTIPs; j++)
		{
			if (driver.findElement(By.cssSelector("md-list-item:nth-of-type(" + j + ") .ember-view.flex .opportunity-name")).getAttribute("textContent").contains("Needs Immunization - Influenza")) 
			{
				System.out.println("Clicking TIP " + j + " (" + driver.findElement(tipPage.getTIPName(j)).getText() + "):");
				driver.findElement(tipPage.getTIPLink(j)).click();
				commonMethods.implicitwait(normalWaitTime);
				tipPage.takingMedYesElement.click();
				commonMethods.implicitwait(normalWaitTime);
				if (tipPage.startclaimfortip_display()) {
					startClaimButtonFound = true;
				} else {
					if (processTakingMedNoOption) {
						tipPage.takingMedNoElement.click();
						commonMethods.implicitwait(normalWaitTime);
						if (tipPage.startclaimfortiipbutton.isDisplayed()) {
							startClaimButtonFound = true;
						}
					} else {
						tipPage.closingtipbutton.click();
						continue;
					}
				}
				if (startClaimButtonFound) 
				{
					patientprofilePage.clickStartClaim();
					commonMethods.implicitwait(normalWaitTime);
					//claimssubmissionPage.selectpharmacist();
					commonMethods.implicitwait(normalWaitTime);
					if (driver.findElements(By.xpath("//*[@id='result']/option[text()='Immunization administered']")).size() > 0) {
						claimssubmissionPage.selectOutcome1("Immunization administered");
						claimssubmissionPage.checkbox1_click();
						claimssubmissionPage.datepickerforimmunization_sendkeys();
					}
					commonMethods.implicitwait(normalWaitTime);
					claimssubmissionPage.datepickerfortipimmunization_sendkeys();
					claimssubmissionPage.clickNextButton();
					commonMethods.implicitwait(defaultWaitTime);
					tipPage.newimmunizationmedinpt();
					commonMethods.implicitwait(defaultWaitTime);
					tipPage.newmedselect();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.clickNewMedNextButton();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.clickContinueButton();
					commonMethods.implicitwait(defaultWaitTime);
					if (!tipPage.trialMode)
					{
						System.out.println("Clicking Submit Claim button.");
						claimssubmissionPage.clickSubmitClaimButton();
						commonMethods.implicitwait(defaultWaitTime);
					} 
					else 
					{
						System.out.println("Trial Mode is on - skipping the final step.");
					}

					System.out.println("TIP flow completed successfully.");
					tipComplete = true;
					break;
				}	
			}		
			else {
				tipFoundWithPatient = false;
				System.out.println("The tip is not of a type 'Needs Immunization - Influenza'");
				Assert.assertEquals(tipFoundWithPatient, false);
			}
		}		

	}	

	//@Test(description="Verification of TIP workflow - Needs Patient Education - Comprehensive Diabetes Care",groups = {"Sanity", "Regression"}, priority =3)
	public void tiptest_NeedsPatientEducation_CompDiabCare_Validation() throws InterruptedException, IOException, ParseException {
		boolean tipFoundWithPatient = false;
		boolean processTakingMedNoOption = true;
		boolean startClaimButtonFound = false;
		boolean tipComplete = false;
		commonMethods.implicitwait(defaultWaitTime);
		dashboardPage.searchtext.sendKeys("MTM0021");
		dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultWaitTime);
		String tip= tipPage.tipListHeader.getAttribute("textContent").trim().substring(0,1);
		int availableTIPs=Integer.parseInt(tip);
		System.out.println("Available TIPs: " + availableTIPs);
		for (int j = 1; j <= availableTIPs; j++) 
		{
			if (driver.findElement(By.cssSelector("md-list-item:nth-of-type(" + j + ") .ember-view.flex .opportunity-name")).getAttribute("textContent").contains("Needs Patient Education - Comprehensive Diabetes Care")) 
			{
				System.out.println("Clicking TIP " + j + " (" + driver.findElement(tipPage.getTIPName(j)).getText() + "):");
				driver.findElement(tipPage.getTIPLink(j)).click();
				commonMethods.implicitwait(normalWaitTime);
				//tipPage.takingMedYesElement.click();
				//commonMethods.implicitwait(normalWaitTime);
				if (tipPage.startclaimfortip_display()) {
					startClaimButtonFound = true;
				} else {
					if (processTakingMedNoOption) {
						tipPage.takingMedNoElement.click();
						commonMethods.implicitwait(normalWaitTime);
						if (tipPage.startclaimfortiipbutton.isDisplayed()) {
							startClaimButtonFound = true;
						}
					} else {
						tipPage.closingtipbutton.click();
						continue;
					}
				}	
				if (startClaimButtonFound)
				{
					patientprofilePage.clickStartClaim();
					commonMethods.implicitwait(normalWaitTime);
					//claimssubmissionPage.selectpharmacist();
					commonMethods.implicitwait(normalWaitTime);
					if (driver.findElements(By.xpath("//*[@id='result']/option[text()='Patient education provided']")).size() > 0) 
					{
						claimssubmissionPage.selectOutcome1("Patient education provided");
						tipPage.selectEducatedThePatientBox();
					}
					commonMethods.implicitwait(normalWaitTime);
					claimssubmissionPage.datepickerfortip_sendkeys();
					claimssubmissionPage.clickNextButton();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.clickContinueButton();
					commonMethods.implicitwait(defaultWaitTime);
					if (!tipPage.trialMode)
					{
						System.out.println("Clicking Submit Claim button.");
						claimssubmissionPage.clickSubmitClaimButton();
						commonMethods.implicitwait(defaultWaitTime);
					} 
					else 
					{
						System.out.println("Trial Mode is on - skipping the final step.");
					}

					System.out.println("TIP flow completed successfully.");
					tipComplete = true;
					break;
				}		
			}
			else {
				tipFoundWithPatient = false;
				System.out.println("The tip is not of a type 'Needs Patient Education - Comprehensive Diabetes Care'");
				Assert.assertEquals(tipFoundWithPatient, false);
			}
		}		

	}	

	//@Test(description="Verification of TIP workflow - Needs Disease State Education - Diabetes",groups = {"Sanity", "Regression"}, priority =3)
	public void tiptest_NeedsdiseaseStateEducation_Diabetes_Validation() throws InterruptedException, IOException, ParseException {
		boolean tipFoundWithPatient = false;
		boolean processTakingMedNoOption = true;
		boolean startClaimButtonFound = false;
		boolean tipComplete = false;
		commonMethods.implicitwait(defaultWaitTime);
		dashboardPage.searchtext.sendKeys("MTM0074");
		dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultWaitTime);
		String tip= tipPage.tipListHeader.getAttribute("textContent").trim().substring(0,1);
		int availableTIPs=Integer.parseInt(tip);
		System.out.println("Available TIPs: " + availableTIPs);
		for (int j = 1; j <= availableTIPs; j++) 
		{
			if (driver.findElement(By.cssSelector("md-list-item:nth-of-type(" + j + ") .ember-view.flex .opportunity-name")).getAttribute("textContent").contains("Needs Disease State Education - Diabetes")) 
			{
				System.out.println("Clicking TIP " + j + " (" + driver.findElement(tipPage.getTIPName(j)).getText() + "):");
				driver.findElement(tipPage.getTIPLink(j)).click();
				commonMethods.implicitwait(normalWaitTime);
				tipPage.takingMedYesElement.click();
				commonMethods.implicitwait(normalWaitTime);
				if (tipPage.startclaimfortip_display()) {
					startClaimButtonFound = true;
				} else {
					if (processTakingMedNoOption) {
						tipPage.takingMedNoElement.click();
						commonMethods.implicitwait(normalWaitTime);
						if (tipPage.startclaimfortiipbutton.isDisplayed()) {
							startClaimButtonFound = true;
						}
					} else {
						tipPage.closingtipbutton.click();
						continue;
					}
				}	
				if (startClaimButtonFound)
				{
					patientprofilePage.clickStartClaim();
					commonMethods.implicitwait(normalWaitTime);
					//claimssubmissionPage.selectpharmacist();
					commonMethods.implicitwait(normalWaitTime);
					if (driver.findElements(By.xpath("//select[@id='result']/option[text()='Disease state education provided']")).size() > 0) 
					{
						claimssubmissionPage.selectOutcome_needspatienteducation("Disease state education provided");
						commonMethods.implicitwait(normalWaitTime);
						claimssubmissionPage.diseasestchbox_click();

					}
					commonMethods.implicitwait(normalWaitTime);
					claimssubmissionPage.datepickerfortip_sendkeys();
					claimssubmissionPage.clickNextButton();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.processPatientCommunication();
					commonMethods.implicitwait(defaultWaitTime);
					claimssubmissionPage.clickContinueButton();
					commonMethods.implicitwait(defaultWaitTime);
					if (!tipPage.trialMode)
					{
						System.out.println("Clicking Submit Claim button.");
						claimssubmissionPage.clickSubmitClaimButton();
						commonMethods.implicitwait(defaultWaitTime);
					} 
					else 
					{
						System.out.println("Trial Mode is on - skipping the final step.");
					}

					System.out.println("TIP flow completed successfully.");
					tipComplete = true;
					break;
				}	
			}		
			else {
				tipFoundWithPatient = false;
				System.out.println("The tip is not of a type 'Needs Disease State Education - Diabetes'");
				Assert.assertEquals(tipFoundWithPatient, false);
			}
		}		

	}	

	@Test(description = "Verification of No Intervention needed tip TIP Workflow", priority = 1, groups = {"Sanity", "Regression"})
	public void tiptest_nointerventionneededtip() throws IOException {
		boolean tipFoundWithPatient = false;
		boolean tipComplete = false;

		commonMethods.implicitwait(defaultWaitTime);
		dashboardPage.searchtext.sendKeys("MTM0074");
		//dashboardPage.searchbuttonclick();
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		commonMethods.implicitwait(defaultWaitTime);
		String tip= tipPage.tipListHeader.getAttribute("textContent").trim().substring(0,1);
		int availableTIPs=Integer.parseInt(tip);
		commonMethods.implicitwait(defaultWaitTime);
		for (int j = 1; j <= availableTIPs; j++) {
			System.out.println("Clicking TIP " + j + " (" + driver.findElement(tipPage.getTIPName(j)).getText() + "):");

			driver.findElement(tipPage.getTIPLink(j)).click();
			commonMethods.implicitwait(defaultWaitTime);

			System.out.println("Looking for the 'targeted medication consumption' question.");
			if (driver.findElements(By.cssSelector("#ptTakingRefMedN")).size() != 0 && driver.findElement(By.cssSelector("#ptTakingRefMedN")).isDisplayed()) {
				System.out.println("Selecting No for the 'targeted medication consumption' question.");
				driver.findElement(By.cssSelector("#ptTakingRefMedN")).click();
				commonMethods.implicitwait(defaultWaitTime);
			} else {
				System.out.println("The 'targeted medication consumption' question cannot be found.");
				commonMethods.implicitwait(defaultWaitTime);
			}

			System.out.println("Looking for 'No Intervention Needed' button.");
			if (tipPage.isNINButtonAvailable()) {
				System.out.println("'No Intervention Needed' button found.");

				System.out.println("Clicking the 'No Intervention Needed' button.");
				tipPage.processNoInterventionNeeded();
				commonMethods.implicitwait(defaultWaitTime);

				System.out.println("Selecting a reason why no intervention was needed.");
				tipPage.selectNoInterventionReason();
				commonMethods.implicitwait(defaultWaitTime);
				if (!tipPage.trialMode)
				{
					System.out.println("Clicking on 'Remove TIP' button.");
					tipPage.processTIPRemoval();
					commonMethods.implicitwait(defaultWaitTime);
				} 
				else 
				{
					System.out.println("Trial Mode is on - skipping the final step.");
				}

				System.out.println("No Intervention TIP flow completed successfully.");
				tipComplete = true;
				break;
			}	
		}}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}	



