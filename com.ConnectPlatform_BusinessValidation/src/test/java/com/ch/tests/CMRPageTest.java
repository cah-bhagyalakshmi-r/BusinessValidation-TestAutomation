package com.ch.tests;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.base.TestBase;
import com.ch.pages.CMRPage;
import com.ch.pages.ClaimsSubmissionPage;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.util.CommonMethods;
import com.ch.util.JsonFileReader;


public class CMRPageTest extends TestBase {

	int normalwaittime=45;
	int defaultwaittime=25;
	int longerwaittime=40;
	String currentDate = new SimpleDateFormat("MMddyyyy").format(new Date());	
	Date todayDate = new Date();
	Date tomorrowDate = new Date(todayDate.getTime() + (1000 * 60 * 60 * 24));
	String cmrDate = new SimpleDateFormat("MMddyyyy").format(tomorrowDate);
	String patientid, patientid1;

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CommonMethods commonMethods;
	CMRPage cmrPage;
	ClaimsSubmissionPage claimssubmissionPage;
	JsonFileReader jsonreader=new JsonFileReader();

	public CMRPageTest(){
		super();
	}
	
	private void readTestData() throws IOException, ParseException {
		jsonreader.getdata();
		patientid = jsonreader.CMR.get("patientid").toString();
		patientid1 = jsonreader.CMR.get("patientid1").toString();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {		
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		cmrPage = new CMRPage();
		claimssubmissionPage = new ClaimsSubmissionPage();
		commonMethods.implicitwait(normalwaittime);
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		commonMethods.implicitwait(normalwaittime);
		readTestData();
	}


	@Test(description = "Verification of CMR workflow using Video conference delivery method",priority= 1,groups = {"Sanity", "Regression"})
	public void validateCMR_DeliveryMethod_videoconference () throws IOException, InterruptedException, ParseException {
		boolean deliveryMethodAvailable = true;
		boolean addMedication = true;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys("CMR-a81c8e3b-ed79-4320-99e2-92ca820b8c5e");
		//dashboardPage.searchtext.sendKeys(patientid);
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		commonMethods.implicitwait(defaultwaittime);
		Thread.sleep(8000);
		//if(cmrPage.gotocmrbtn.size() > 0){
			cmrPage.startContinueCMR();
			commonMethods.implicitwait(normalwaittime);
			//cmrPage.servicedeliverytab_click();
			commonMethods.implicitwait(normalwaittime);
			if (deliveryMethodAvailable) {
				cmrPage.videooption_click();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.goToHealthProfile();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.new_removecurrentcondition();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.new_removedrugallegy();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.goToMedList();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.removemedication();
				if (addMedication) {
					cmrPage.addMedication();
					commonMethods.implicitwait(normalwaittime);
					if (! cmrPage.selectallchkbox.getAttribute("class").contains("mat-checkbox-checked")) {
						cmrPage.selectallchkbox_click();
						System.out.println("selectall chkbox clicked");
						commonMethods.implicitwait(defaultwaittime);
					}
					cmrPage.medlisttoolbarbtn_click();
					System.out.println("medlist toolbar clicked");
					commonMethods.implicitwait(defaultwaittime);
				}
				cmrPage.goToActionPlan();
				commonMethods.implicitwait(defaultwaittime);
				//cmrPage.removeactionplan();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.goToTakeaway();
				commonMethods.implicitwait(defaultwaittime);
				//cmrPage.takeawayinputdetails();
				cmrPage.takeawayinputdetails_new();
				commonMethods.implicitwait(defaultwaittime);
				Thread.sleep(2000);
				commonMethods.implicitwait(defaultwaittime);
				js.executeScript("window.scrollBy(0,-5000)", "");
				commonMethods.implicitwait(defaultwaittime);
				js.executeScript("arguments[0].click();", cmrPage.takeawaybtn1);
				System.out.println("Patient takeaway button clicked");
			//	js.executeScript("window.scrollBy(0,8000)", "");
				commonMethods.implicitwait(defaultwaittime);
				 // if (!cmrPage.chkattestation1.getAttribute("class").contains("attestation")) {
				  cmrPage.chkattestationchkbox_click();
				 // js.executeScript("arguments[0].scrollIntoView();", cmrPage.chkattestation1);
				//  js.executeScript("arguments[0].click();", cmrPage.chkattestation1);
				  System.out.println("attestation box clicked");
				  commonMethods.implicitwait(defaultwaittime); //}
				if (driver.findElements(By.cssSelector("input#input-patTakeAwayDate")).size() > 0 && driver.findElement(By.cssSelector("input#input-patTakeAwayDate")).isDisplayed()) {
					System.out.println("Patient takeaway delivery date option is available. Selecting patient takeaway delivery date.");
					WebElement patientTakeawayDate = driver.findElement(By.cssSelector("input#input-patTakeAwayDate"));
					patientTakeawayDate.click();
					commonMethods.implicitwait(defaultwaittime);
					patientTakeawayDate.sendKeys(currentDate);
					commonMethods.implicitwait(defaultwaittime);
					patientTakeawayDate.sendKeys(Keys.ENTER);
					commonMethods.implicitwait(defaultwaittime);
				} else {
					System.out.println("Patient takeaway delivery date option is not available.");
				}
				/*
				 * if (cmrPage.submitClaimButton1.getAttribute("disabled") != null) {
				 * cmrPage.saveCMR(); commonMethods.implicitwait(defaultwaittime); } else {
				 */
					cmrPage.submitCMR();
					System.out.println("CMR flow completed successfully.");
					commonMethods.implicitwait(normalwaittime);
					claimssubmissionPage.mtmclaimshistory_click();
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.searchbydate();
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.deleteclaimrow_click();
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.cancelclaim_click();
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.okbutton_click1();
					commonMethods.implicitwait(defaultwaittime);
					System.out.println("Submitted CMR flow cancelled successfully.");
				}
			//}
		//} 	
	}	


	@Test(description = "Verification of scheduled cmr for current date" ,priority = 2,groups = {"Sanity", "Regression"})
	public void validateschedulingappointment_currentdate() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultwaittime);
		//dashboardPage.searchtext.sendKeys("MTM0136");
		dashboardPage.searchtext.sendKeys(patientid);
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		commonMethods.implicitwait(defaultwaittime);
		Thread.sleep(5000);
		if (cmrPage.dateInputWithCalendar.size() > 0) {
			cmrPage.schedulecurrentcmr_inputdetails();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.saveCMRSchedule();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.cancelCMRSchedule();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.startContinueCMR_display();
			System.out.println("Scheduled CMR for current date successfully.");
		} 
	}

	@Test(description = "Verification of the Scheduled CMR for future date" ,priority = 2,groups = {"Sanity", "Regression"})
	public void validateScheduledCMR_futuredate () throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultwaittime);
		//dashboardPage.searchtext.sendKeys("MTM0136");
		dashboardPage.searchtext.sendKeys(patientid);
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		commonMethods.implicitwait(defaultwaittime);
		Thread.sleep(5000);
		if (cmrPage.dateInputWithCalendar.size() > 0) {
			cmrPage.schedulecmr_inputdetails();
			cmrPage.saveCMRSchedule();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.cancelCMRSchedule();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.startContinueCMR_display();
			System.out.println("Scheduled CMR for future date successfully.");
		}

	}

	@Test(description = "Verification of submitting a claim as unable to reach- CMR workflow", priority= 3, groups = {"Sanity", "Regression"})
	public void validatesubmitcliam_unabletoreach_CMR () throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultwaittime);
		//dashboardPage.searchtext.sendKeys("MTM0136");
		dashboardPage.searchtext.sendKeys(patientid);
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		commonMethods.implicitwait(defaultwaittime);
		//if (driver.findElements(By.cssSelector("#documentUnsuccessfulCmrButton")).size() > 0) {
			cmrPage.loadCMRRefusalOptions();
			commonMethods.implicitwait(normalwaittime);
			//if (cmrPage.unableToReachOptionExists()) {
				cmrPage.selectUnableToReachOption();
				commonMethods.implicitwait(normalwaittime);
				cmrPage.datepicker_Sendkeys();
				cmrPage.submitUnsuccessfulCMR();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.mtmclaimshistory_click();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.searchbydate();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.deleteclaimrow_click();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.cancelclaim_click();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.okbutton_click1();
				commonMethods.implicitwait(defaultwaittime);
				System.out.println("'Submit a claim as Patient refused or Unable to reach' link flow completed successfully");
			//} 
		//}
	}

	@Test(description = "Verification of submitting a claim as patient refused they do not have time- CMR workflow", priority= 3, groups = {"Sanity", "Regression"})
	public void validatesubmitclaim_patientrefused_notime_CMR () throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultwaittime);
		//dashboardPage.searchtext.sendKeys("MTM0136");
		dashboardPage.searchtext.sendKeys(patientid);
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		commonMethods.implicitwait(defaultwaittime);
		Thread.sleep(5000);
		//if (driver.findElements(By.cssSelector("#documentUnsuccessfulCmrButton")).size() > 0) {
			cmrPage.loadCMRRefusalOptions();
			commonMethods.implicitwait(normalwaittime);
			//if (cmrPage.unableToReachOptionExists()) {
				cmrPage.selectpatientrefusedOption();
				commonMethods.implicitwait(normalwaittime);
				cmrPage.selectrefusalreason("They do not have time");
				commonMethods.implicitwait(normalwaittime);	
				cmrPage.datepicker_Sendkeys();
				cmrPage.submitUnsuccessfulCMR();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.mtmclaimshistory_click();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.searchbydate();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.deleteclaimrow_click();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.cancelclaim_click();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.okbutton_click1();
				commonMethods.implicitwait(defaultwaittime);
				System.out.println("Verification of submitting a claim as patient refused they do not have time- flow completed successfully");
			//} 
		//}
	}

	@Test(description = "Verification of submitting a claim as patient refused they are unwilling- CMR workflow", priority= 3, groups = {"Sanity", "Regression"})
	public void validatesubmitclaim_patientrefused_unwilling_CMR () throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultwaittime);
		//dashboardPage.searchtext.sendKeys("MTM0136");
		dashboardPage.searchtext.sendKeys(patientid);
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		commonMethods.implicitwait(defaultwaittime);
		Thread.sleep(5000);
		//if (driver.findElements(By.cssSelector("#documentUnsuccessfulCmrButton")).size() > 0) {
			cmrPage.loadCMRRefusalOptions();
			commonMethods.implicitwait(normalwaittime);
			if (cmrPage.unableToReachOptionExists()) {
				cmrPage.selectpatientrefusedOption();
				commonMethods.implicitwait(normalwaittime);
				cmrPage.selectrefusalreason("They are unwilling");
				commonMethods.implicitwait(normalwaittime);	
				cmrPage.datepicker_Sendkeys();
				cmrPage.submitUnsuccessfulCMR();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.mtmclaimshistory_click();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.searchbydate();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.deleteclaimrow_click();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.cancelclaim_click();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.okbutton_click1();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.startContinueCMR_display();
				System.out.println("Verification of submitting a claim as patient refused they are unwilling- flow completed successfully");
			} 
		//}
	}

	@Test(description = "Verification of submitting a claim as patient refused they already received the service- CMR workflow", priority= 3, groups = {"Sanity", "Regression"})
	public void validatesubmitclaim_patientrefused_receivedservice_CMR () throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultwaittime);
		//dashboardPage.searchtext.sendKeys("MTM0136");
		dashboardPage.searchtext.sendKeys(patientid);
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		commonMethods.implicitwait(defaultwaittime);
		//if (driver.findElements(By.cssSelector("#documentUnsuccessfulCmrButton")).size() > 0) {
			cmrPage.loadCMRRefusalOptions();
			commonMethods.implicitwait(normalwaittime);
			//if (cmrPage.unableToReachOptionExists()) {
				cmrPage.selectpatientrefusedOption();
				commonMethods.implicitwait(normalwaittime);
				cmrPage.selectrefusalreason("Already received this service");
				commonMethods.implicitwait(normalwaittime);	
				cmrPage.datepicker_Sendkeys();
				cmrPage.submitUnsuccessfulCMR();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.mtmclaimshistory_click();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.searchbydate();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.deleteclaimrow_click();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.cancelclaim_click();
				commonMethods.implicitwait(defaultwaittime);
				claimssubmissionPage.okbutton_click1();
				commonMethods.implicitwait(defaultwaittime);
				System.out.println("Verification of submitting a claim as patient refused they already received the service- flow completed successfully");
			//}
		//}		
	}


	@Test(description = "Verification of the cancelled CMR workflow" ,priority = 4,groups = {"Sanity", "Regression"})
	public void validatecancelledCMR () throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultwaittime);
		//dashboardPage.searchtext.sendKeys("MTM0136");
		dashboardPage.searchtext.sendKeys(patientid);
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		commonMethods.implicitwait(defaultwaittime);
		//if (cmrPage.dateInputWithCalendar.size() > 0) {
			cmrPage.schedulecmr_inputdetails();
			cmrPage.saveCMRSchedule();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.scheduleheader_validation();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.cancelCMRSchedule();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.startContinueCMR_display();
			System.out.println("cancelled CMR flow completed successfully.");
		//} 		
	}

	@Test(description = "Verification of contacting and waiting for patient response workflow" ,priority = 5,groups = {"Sanity", "Regression"})
	public void validate_waitingforresponse_CMR () throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultwaittime);
		//dashboardPage.searchtext.sendKeys("MTM0054");
		dashboardPage.searchtext.sendKeys(patientid1);
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		commonMethods.implicitwait(defaultwaittime);
				if (cmrPage.dateInputWithCalendar.size() > 0) {
					cmrPage.contactpatient_click();
					commonMethods.implicitwait(defaultwaittime);
					cmrPage.saveCMRSchedule();
					commonMethods.implicitwait(defaultwaittime);
					cmrPage.schedulemsg_validation();
					commonMethods.implicitwait(defaultwaittime);
				} 
	}
	

	//////@Test(description = "Verification of communication preferences" ,priority = 2,groups = {"Regression"})
	public void communicationpreferences_validation () throws IOException, InterruptedException {
		boolean cmrComplete = false;
		boolean cmrFoundWithPatient = false;
		boolean deliveryMethodAvailable = true;
		boolean addMedication = true;
		int defaultNumberOfPatientsDisplayed = 5;
		int maxPatientRecordsToCheck = 7;
		int mtmOpportunitiesColumnNumber = 5;
		int patientNameColumnNumber = 1;
		int columnAdjuster = 0;
		commonMethods.implicitwait(defaultwaittime);
		for (int i = 3; i <= maxPatientRecordsToCheck; i++) {

			WebElement root = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/my-pharmacy-component"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
			WebElement pageselection= shadowroot.findElement(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div > div:nth-child(2) > div > div.paging-info-per-page.flux-flex.flex-align-items-center > div.v-popover > div > div > div"));
			pageselection.click();
			Thread.sleep(3000);
			WebElement pageselection1= driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div[1]/div/div/div/div[2]"));
			pageselection1.click();
			js.executeScript("window.scrollBy(0,-5000)", "");
			if
			(shadowroot.findElements(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div > div:nth-child(2) > ul > li:nth-child("+ i +") > div > div.flux-flex-row.patient-wrapper > div.card-header-section")).size() == 0) { 
				break; }
			commonMethods.implicitwait(defaultwaittime);
			//if (driver.findElement(By.cssSelector("span#web-component-root tr:nth-child(" + i + ") > td:nth-child(5)")).getText().contains("CMR")) 
			//if (driver.findElement(By.cssSelector("span#web-component-root tr:nth-child(" + i + ") > td:nth-child(" + mtmOpportunitiesColumnNumber + ")")).getText().contains("CMR")){
			if (shadowroot.findElement(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div > div:nth-child(2) > ul > li:nth-child("+ i +") > div > div.flux-flex-row.patient-wrapper > div.card-header-section")).getText().contains("CMR")) {
				cmrFoundWithPatient = true;
				shadowroot.findElement(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div > div:nth-child(2) > ul > li:nth-child("+ i + ") > div > div.flux-flex-row.patient-wrapper > div.card-header-section")).click();
				commonMethods.implicitwait(defaultwaittime);
				if (cmrPage.communicationprefcheck.size() > 0) {
					cmrPage.communicationprefchecks.click();
					commonMethods.implicitwait(defaultwaittime);
					cmrPage.communicationphnnum_sendkeys();
					commonMethods.implicitwait(defaultwaittime);
					if (! cmrPage.trialMode) {
						cmrPage.communicationphnnum_save();
						commonMethods.implicitwait(defaultwaittime);
					} else {
						System.out.println("Trial Mode is on - skipping the final step.");
					}
					System.out.println("communication preferences checked and saved successfully.");
					cmrComplete = true;
					break;
				} else {
					System.out.println("communication preferences not found.");
					continue;
				}
			} else {
				cmrFoundWithPatient = false;
				System.out.println("CMR not present in the patient record.");
			}
			if (cmrComplete) {
				break;
			} else if (cmrFoundWithPatient) {
				System.out.println("Going to the dashboard.");
				dashboardPage.goToDashboard();
				commonMethods.implicitwait(defaultwaittime);
			}
		}
		System.out.println("END TEST - Communication preferences");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.close();
	}
}