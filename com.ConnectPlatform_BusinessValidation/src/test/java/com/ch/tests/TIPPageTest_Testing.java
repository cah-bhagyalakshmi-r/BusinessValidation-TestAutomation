package com.ch.tests;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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


public class TIPPageTest_Testing extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	ClaimsSubmissionPage claimssubmissionPage;
	TIPPage tipPage;
	PersonalInfoPage patientprofilePage;
	CommonMethods commonMethods = new CommonMethods();

	int normalWaitTime = 10;
	int defaultWaitTime = 15;
	int WaitTime= 5;
	boolean trialmode= true;

	String deletetipquery;


	public TIPPageTest_Testing(){
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
		commonMethods.implicitwait(defaultWaitTime);
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		readTestData();

	}

	private void readTestData() throws IOException, ParseException {
		JsonFileReader.getdata();
		JsonFileReader jsonreader=new JsonFileReader();
	}

	@Test(description = "Verification of No Intervention needed tip TIP Workflow", priority = 1, groups = {"Sanity", "Regression"})
	public void tiptest_nointerventionneededtip() throws IOException, InterruptedException {
		Actions action= new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int maxPatientRecordsToCheck = 15;
		commonMethods.implicitwait(defaultWaitTime);
		for (int i = 4; i <= maxPatientRecordsToCheck; i++) {	
			String tipcheck=driver.findElement(By.cssSelector("#opportunities > div.flux-grid.all-patient-opportunities-container > div.right-side-panel-container.flux-grid-item-2 > div:nth-child(2) > ul > li:nth-child(" + i +") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).getText();
			System.out.println("Tip present:"+tipcheck);
			if (driver.findElement(By.cssSelector("#opportunities > div.flux-grid.all-patient-opportunities-container > div.right-side-panel-container.flux-grid-item-2 > div:nth-child(2) > ul > li:nth-child(" + i +") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).getText().contains("TIP")){
				driver.findElement(By.cssSelector("#opportunities > div.flux-grid.all-patient-opportunities-container > div.right-side-panel-container.flux-grid-item-2 > div:nth-child(2) > ul > li:nth-child(" + i +") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).click();
				commonMethods.implicitwait(defaultWaitTime);
				Thread.sleep(6000);
				String tips=driver.findElement(By.cssSelector("#tipsList > flux-card-header")).getText().trim();
				System.out.println("tip header:" + tips);
				String tipnum=tips.substring(0,1);
				System.out.println("tip num:" + tipnum);
				int availableTIPs=Integer.parseInt(tipnum);
				System.out.println("Available tips:" + availableTIPs);
				commonMethods.implicitwait(defaultWaitTime);
				for (int j = 1; j <= availableTIPs;) {
					System.out.println("Clicking TIP " + j + " (" + driver.findElement(tipPage.getTIPName1(j)).getText() + "):");
					System.out.println("Clicking TIP " + j + " (" + driver.findElement(tipPage.getTIPName(j)).getText() + ") (" + driver.findElement(tipPage.getTIPName1(j)).getText() + "):");
					WebElement tip=driver.findElement(tipPage.getTIPName1(j));
					action.moveToElement(tip).click().build().perform();
					Thread.sleep(3000);
					commonMethods.implicitwait(defaultWaitTime);
					if (driver.findElements(By.cssSelector("#ptTakingRefMedN")).size() != 0 && driver.findElement(By.cssSelector("#ptTakingRefMedN")).isDisplayed()) {
						driver.findElement(By.cssSelector("#ptTakingRefMedN")).click();
						commonMethods.implicitwait(defaultWaitTime);
						tipPage.processNoInterventionNeeded();
						commonMethods.implicitwait(defaultWaitTime);					
						tipPage.selectNoInterventionReason();
						System.out.println("No Intervention needed using the targeted medication option");
					}
					else if(tipPage.shadowroot_nointervention_click().size() != 0 ) {
						WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
						SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
						WebElement nointtip=shadowroot.findElement(By.cssSelector("#no-intervention-needed-outcomeinput"));
						action.moveToElement(nointtip).click().build().perform();
						Thread.sleep(2000);
						tipPage.selectNoInterventionReason1();
						Thread.sleep(2000);
						tipPage.noint_nextbutton_click();
						System.out.println("No Intervention needed using the service details option");
					}
					else if(tipPage.shadowroot_nooption_click().size()!= 0){
						WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
						SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
						WebElement nointtip1=shadowroot.findElement(By.cssSelector("#No"));
						action.moveToElement(nointtip1).click().build().perform();
						System.out.println("No Intervention needed for Adherence related tips using yes and no buttons");
					}
					else {
						System.out.println("The above tip options are not available");
					}
					if (!trialMode)
					{
						System.out.println("Clicking on 'Remove TIP' button.");
						tipPage.processTIPRemoval();
						commonMethods.implicitwait(defaultWaitTime);
					} 
					else 
					{
						System.out.println("Trial Mode is on - skipping the final step.");
					}
					break;
				}	
				break;
			}	
		}
	}

	@Test(description = "Verification of Adherence TIP Workflow", priority = 1, groups = {"Sanity", "Regression"})
	public void tiptest_adherence() throws IOException, InterruptedException {
		Actions action= new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int maxPatientRecordsToCheck = 10;
		boolean tipFoundWithPatient;
		boolean tipComplete = false;
		boolean startClaim= false;
		commonMethods.implicitwait(defaultWaitTime);
		for (int i = 9; i <= maxPatientRecordsToCheck; i++) {					
			if (driver.findElement(By.cssSelector("#opportunities > div.flux-grid.all-patient-opportunities-container > div.right-side-panel-container.flux-grid-item-2 > div:nth-child(2) > ul > li:nth-child(" + i +") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).getText().contains("TIP")){
				driver.findElement(By.cssSelector("#opportunities > div.flux-grid.all-patient-opportunities-container > div.right-side-panel-container.flux-grid-item-2 > div:nth-child(2) > ul > li:nth-child(" + i +") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).click();
				tipFoundWithPatient = true;
				commonMethods.implicitwait(normalWaitTime);
				Thread.sleep(8000);
				String tips=driver.findElement(By.cssSelector("#tipsList > flux-card-header")).getText().trim();
				System.out.println("tip header:" + tips);
				String tipnum=tips.substring(0,1);
				System.out.println("tip num:" + tipnum);
				int availableTIPs=Integer.parseInt(tipnum);
				System.out.println("Available tips:" + availableTIPs);
				commonMethods.implicitwait(normalWaitTime);
				for (int j = 1; j <= availableTIPs; j++) {
					if (driver.findElement(By.cssSelector("md-list-item:nth-of-type(" + j + ") .ember-view.flex .opportunity-name")).getAttribute("textContent").contains("Adherence"))
					{
						System.out.println("Clicking TIP " + j + " (" + driver.findElement(tipPage.getTIPName1(j)).getText() + "):") ;
					}
					else {
						System.out.println("The current TIP is not of type 'Adherence'.");
						continue;
					}
					System.out.println("Clicking TIP " + j + " (" + driver.findElement(tipPage.getTIPName(j)).getText() + ") (" + driver.findElement(tipPage.getTIPName1(j)).getText() + "):");
					driver.findElement(tipPage.getTIPLink(j)).click();
					commonMethods.implicitwait(normalWaitTime);
					Thread.sleep(5000);
					WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
					SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
					WebElement nointtip1=shadowroot.findElement(By.cssSelector("#currentlyMedicatedYes"));
					//action.moveToElement(nointtip1).click().build().perform();
					js.executeScript("arguments[0].scrollIntoView();", nointtip1);
					js.executeScript("arguments[0].click();", nointtip1);
					if (tipPage.shadowroot_patientenrolled_click().size()!= 0) {
						WebElement ptenroll=shadowroot.findElement(By.cssSelector("#patient-monitored-and-enrolled-outcomeinput"));
						action.moveToElement(ptenroll).click().build().perform();
						startClaim= true;
					} 
					else if (tipPage.shadowroot_adherencecheckin_click().size() > 0) {
						System.out.println("Selecting 'Adherence checkin completed' option for the 'What was the outcome of the service?'");
						WebElement adhchkin=shadowroot.findElement(By.cssSelector("#adherence-check-in-completed-outcomeinput"));
						action.moveToElement(adhchkin).click().build().perform();
						startClaim= true;
					}
					else if (tipPage.shadowroot_checkpoint_click().size() > 0) {
						System.out.println("Selecting 'Checkpoint complete' option for the 'What was the outcome of the service?'");
						WebElement checkpoint=shadowroot.findElement(By.cssSelector("#checkpoint-complete-outcomeinput"));
						action.moveToElement(checkpoint).click().build().perform();
						Thread.sleep(5000);
						//List<WebElement> chkpnt= shadowroot.findElements(By.cssSelector("#experiencingAdherenceBarriersYes"));
						WebElement chkpnt= shadowroot.findElement(By.cssSelector("#experiencingAdherenceBarriersYes"));
						js.executeScript("arguments[0].scrollIntoView();", chkpnt);
						js.executeScript("arguments[0].click();", chkpnt);
						startClaim= true;
					} else {
						System.out.println("There are other options available for 'What was the outcome of the service?'");
						continue;
					}					
					if (startClaim) {						
						commonMethods.implicitwait(normalWaitTime);
						tipPage.selectAdherenceBarrier();
						commonMethods.implicitwait(defaultWaitTime);
						tipPage.selectAdherenceBarrierAction();
						commonMethods.implicitwait(defaultWaitTime);
						tipPage.selectmedicationfactors();
						commonMethods.implicitwait(defaultWaitTime);
						tipPage.selectmedicationfactorsaction();
						commonMethods.implicitwait(defaultWaitTime);
						tipPage.selectpatientfactors();
						commonMethods.implicitwait(defaultWaitTime);
						tipPage.selectpatientfactorsaction();
						commonMethods.implicitwait(defaultWaitTime);
						if (!tipPage.trialMode)
						{
							System.out.println("Clicking Submit Claim button.");
							tipPage.clickSubmitClaimButton();
							commonMethods.implicitwait(defaultWaitTime);
						} 
						else 
						{
							System.out.println("Trial Mode is on - skipping the final step.");
						}

						System.out.println("TIP flow completed successfully.");
						tipComplete = true;
						break;
					} else {
						System.out.println("No 'Start a Claim for this TIP' button found for this TIP.");
						continue;
					}
				}
			} else {
				tipFoundWithPatient = false;
				System.out.println("TIP(s) not present in the patient record.");
			}
			if (tipComplete) {
				break;
			} else if (tipFoundWithPatient) {
				System.out.println("Going to the dashboard.");
				dashboardPage.goToDashboard();
			}
		}
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}	



