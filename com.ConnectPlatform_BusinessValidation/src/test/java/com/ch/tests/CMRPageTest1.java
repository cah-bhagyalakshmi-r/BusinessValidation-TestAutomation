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


public class CMRPageTest1 extends TestBase {

	int normalwaittime=35;
	int defaultwaittime=35;
	int longerwaittime=20;
	String currentDate = new SimpleDateFormat("MMddyyyy").format(new Date());	
	Date todayDate = new Date();
	Date tomorrowDate = new Date(todayDate.getTime() + (1000 * 60 * 60 * 24));
	String cmrDate = new SimpleDateFormat("MMddyyyy").format(tomorrowDate);

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CommonMethods commonMethods;
	CMRPage cmrPage;
	ClaimsSubmissionPage claimssubmissionPage;
	JsonFileReader jsonreader=new JsonFileReader();

	public CMRPageTest1(){
		super();
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
	}


	@Test(description = "Verification of CMR workflow using Video conference delivery method",priority= 1,groups = {"Sanity", "Regression"})
	public void validateCMR_DeliveryMethod_videoconference () throws IOException, InterruptedException, ParseException {
		boolean cmrComplete = false;
		boolean deliveryMethodAvailable = true;
		boolean addMedication = true;
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys("MTM00000373");
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		//dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultwaittime);
		if(cmrPage.gotocmrbtn.size() > 0){
			cmrPage.startContinueCMR();
			commonMethods.implicitwait(normalwaittime);
			cmrPage.servicedeliverytab_click();
			commonMethods.implicitwait(normalwaittime);
			if (deliveryMethodAvailable) {
				cmrPage.videooption_click();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.goToHealthProfile();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.removecurrentcondition();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.removedrugallergy();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.goToMedList();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.removemedication();
				if (addMedication) {
					cmrPage.addMedication();
					commonMethods.implicitwait(normalwaittime);
					if (! cmrPage.selectallchkbox.getAttribute("class").contains("mat-checkbox-checked")) {
						cmrPage.selectallchkbox_click();
						commonMethods.implicitwait(defaultwaittime);
					}
					cmrPage.medlisttoolbarbtn_click();
					commonMethods.implicitwait(defaultwaittime);
				}
				cmrPage.goToActionPlan();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.goToTakeaway();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.takeawayinputdetails();
				commonMethods.implicitwait(defaultwaittime);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,2000)", "");
				cmrPage.takeawaybtn.click();
				commonMethods.implicitwait(longerwaittime);
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
				if (cmrPage.submitClaimButton.getAttribute("disabled") != null) {
					cmrPage.saveCMR();
					commonMethods.implicitwait(defaultwaittime);
				} else {
					cmrPage.submitCMR();
					commonMethods.implicitwait(normalwaittime);
					claimssubmissionPage.mtmclaimshistory_click();
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.searchbydate();
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.deleteclaimrow_click();
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.cancelclaim_click();
					commonMethods.implicitwait(defaultwaittime);
					claimssubmissionPage.okbutton_click();
					commonMethods.implicitwait(defaultwaittime);
				}
			}
		} else {
			System.out.println("No 'Videoconference' option available under Delivery Method.");
		}
		System.out.println("CMRly flow completed successful.");
		cmrComplete = true;
	}

	@Test(description = "Verification of scheduled cmr for current date" ,priority = 4,groups = {"Sanity", "Regression"})
	public void validateschedulingappointment_currentdate() throws IOException, InterruptedException {
		boolean cmrComplete = false;
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys("	");
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		//dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultwaittime);
		if (cmrPage.dateInputWithCalendar.size() > 0) {
			cmrPage.schedulecurrentcmr_inputdetails();
			if (! cmrPage.trialMode) {
				cmrPage.saveCMRSchedule();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.scheduleheader_validation();
				System.out.println("Scheduled CMR flow completed successfully.");
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.cancelCMRSchedule();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.startContinueCMR_display();
			} else {
				System.out.println("Trial Mode is on - skipping the final step.");
			}	
			cmrComplete = true;
			//break;
		} else {
			System.out.println("Date picker not found.");
			//continue;
		}
	}

	@Test(description = "Verification of the Scheduled CMR for future date" ,priority = 2,groups = {"Sanity", "Regression"})
	public void validateScheduledCMR_futuredate () throws IOException, InterruptedException {
		boolean cmrComplete = false;
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys("MTM00000373");
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		//dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultwaittime);
		if (cmrPage.dateInputWithCalendar.size() > 0) {
			cmrPage.schedulecmr_inputdetails();
			if (! cmrPage.trialMode) {
				cmrPage.saveCMRSchedule();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.scheduleheader_validation();
				System.out.println("Scheduled CMR for future date completed successfully.");
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.cancelCMRSchedule();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.startContinueCMR_display();
			} else {
				System.out.println("Trial Mode is on - skipping the final step.");
			}	
			cmrComplete = true;
			//break;
		} else {
			System.out.println("Date picker not found.");
			//continue;
		}
	}
	@Test(description = "Verification of submitting a claim as unable to reach- CMR workflow", priority= 3, groups = {"Sanity", "Regression"})
	public void validatesubmitcliam_unabletoreach_CMR () throws IOException, InterruptedException {
		boolean cmrComplete = false;
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys("MTM00000373");
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		//dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultwaittime);
		if (driver.findElements(By.cssSelector("#documentUnsuccessfulCmrButton")).size() > 0) {
			cmrPage.loadCMRRefusalOptions();
			commonMethods.implicitwait(normalwaittime);
			if (cmrPage.unableToReachOptionExists()) {
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
				claimssubmissionPage.okbutton_click();
				commonMethods.implicitwait(defaultwaittime);
				System.out.println("'Submit a claim as Patient refused or Unable to reach' link flow completed successfully");
			} else {
				System.out.println("No 'Unable to reach the patient after 3 attempts' option available.");
			}}


	}

	@Test(description = "Verification of submitting a claim as patient refused they do not have time- CMR workflow", priority= 3, groups = {"Sanity", "Regression"})
	public void validatesubmitclaim_patientrefused_notime_CMR () throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys("MTM00000373");
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		//dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultwaittime);
		if (driver.findElements(By.cssSelector("#documentUnsuccessfulCmrButton")).size() > 0) {
			cmrPage.loadCMRRefusalOptions();
			commonMethods.implicitwait(normalwaittime);
			if (cmrPage.unableToReachOptionExists()) {
				cmrPage.selectpatientrefusedOption();
				commonMethods.implicitwait(normalwaittime);
				cmrPage.selectrefusalreason("They do not have time");
				commonMethods.implicitwait(normalwaittime);	
				cmrPage.datepicker_Sendkeys();
				commonMethods.implicitwait(defaultwaittime);
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
				claimssubmissionPage.okbutton_click();
				commonMethods.implicitwait(defaultwaittime);
				System.out.println("Verification of submitting a claim as patient refused they do not have time- flow completed successfully");
			} else {
				System.out.println("No 'Patient Refused' option available.");
			}}
	}

	@Test(description = "Verification of submitting a claim as patient refused they are unwilling- CMR workflow", priority= 3, groups = {"Sanity", "Regression"})
	public void validatesubmitclaim_patientrefused_unwilling_CMR () throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys("MTM00000373");
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		//dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultwaittime);
		if (driver.findElements(By.cssSelector("#documentUnsuccessfulCmrButton")).size() > 0) {
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
				claimssubmissionPage.okbutton_click();
				commonMethods.implicitwait(defaultwaittime);
				System.out.println("Verification of submitting a claim as patient refused they are unwilling- flow completed successfully");
			} else {
				System.out.println("No 'Patient Refused' option available.");
			}
		}
	}

	@Test(description = "Verification of submitting a claim as patient refused they already received the service- CMR workflow", priority= 3, groups = {"Sanity", "Regression"})
	public void validatesubmitclaim_patientrefused_receivedservice_CMR () throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys("MTM00000373");
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		//dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultwaittime);
		if (driver.findElements(By.cssSelector("#documentUnsuccessfulCmrButton")).size() > 0) {
			cmrPage.loadCMRRefusalOptions();
			commonMethods.implicitwait(normalwaittime);
			if (cmrPage.unableToReachOptionExists()) {
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
				claimssubmissionPage.okbutton_click();
				commonMethods.implicitwait(defaultwaittime);
				System.out.println("Verification of submitting a claim as patient refused they already received the service- flow completed successfully");
			} else {
				System.out.println("No 'Patient Refused' option available.");
			}
		}
	}


	@Test(description = "Verification of the cancelled CMR workflow" ,priority = 5,groups = {"Sanity", "Regression"})
	public void validatecancelledCMR () throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys("MTM00000373");
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		//dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultwaittime);
		if (cmrPage.dateInputWithCalendar.size() > 0) {
			cmrPage.schedulecmr_inputdetails();
			cmrPage.saveCMRSchedule();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.scheduleheader_validation();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.cancelCMRSchedule();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.startContinueCMR_display();
			System.out.println("cancelled CMR flow completed successfully.");
		} 


	}

	@Test(description = "Verification of communication preferences" ,priority = 2,groups = {"Regression"})
	public void communicationpreferences_validation () throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys("MTM0169");
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		//dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultwaittime);
		if (cmrPage.communicationprefcheck.size() > 0) {
			//cmrPage.dnccheck_validation();
			commonMethods.implicitwait(defaultwaittime);
			//cmrPage.swncheck_validation();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.communicationprefchecks.click();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.communicationphnnum_sendkeys();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.communicationphnnum_cancel();
			commonMethods.implicitwait(defaultwaittime); 
			cmrPage.donotcall_click();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.communicationphnnum_sendkeys(); 
			if (! cmrPage.trialMode) {
				//String currentDate1 = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
				String randomnum=cmrPage.communicationphnnum.getAttribute("value");
				System.out.println("Fakenum:"+randomnum);
				cmrPage.communicationphnnum_save();
				commonMethods.implicitwait(defaultwaittime);
				cmrPage.communicationsavebutton1.click();		
				commonMethods.implicitwait(defaultwaittime);
				//String fakehistory=cmrPage.communprefhistory.getAttribute("value");
				//System.out.println("fakehistory:"+fakehistory);	 
				//String expfakehistory=currentDate1 +" " +"-" +" " +"OUTCOMES TRAINING PHARMACY added" +" " +randomnum +" " +"as DNC";
				//System.out.println("primary phone number history-Fakehistory:"+expfakehistory);	      
				 //Assert.assertEquals(fakehistory, expfakehistory);
				System.out.println("communication preferences checked and saved successfully.");
				}
			else {
				System.out.println("Trial Mode is on - skipping the final step."); 
			}
		}
	}

	@Test(description = "Verification of contacting and waiting for patient response workflow" ,priority = 5,groups = {"Sanity", "Regression"})
	public void validate_waitingforresponse_CMR () throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys("MTM00000247");
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		//dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultwaittime);
		if (cmrPage.dateInputWithCalendar.size() > 0) {
			cmrPage.contactpatient_click();
			cmrPage.saveCMRSchedule();
			commonMethods.implicitwait(defaultwaittime);
			cmrPage.schedulemsg_validation();
			commonMethods.implicitwait(defaultwaittime);
		}	
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.close();
	}
}


