package com.ch.pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ch.base.TestBase;
import com.ch.util.CommonMethods;

public class ClaimsSubmissionPage extends TestBase {

	@FindBy(css = "#barrier8action24_29_2_42")
	WebElement adherenceBarrierMedicationCostEducation;

	@FindBy(css = "#barrier8_29_2_42")
	WebElement adherenceBarrierMedicationCostOption;

	@FindBy(css = "a#adhBarriersNextButton")
	WebElement adherenceBarriersNextButton;

	@FindBy(xpath = "//select[@id='reasonCode'] ")
	WebElement reasonDropdownLocator;

	@FindBy(css = "select#actionCode")
	WebElement serviceDropdownLocator;

	@FindBy(css = "select#result")
	WebElement outcomeDropdownLocator;

	@FindBy(css = "input#MTMserviceDate")
	WebElement serviceDateLocator;

	@FindBy(css = "a#aboutMTMNextButton")
	WebElement nextButtonLocator;

	@FindBy(xpath = "//select[@id='currentMedfromHistory']")
	WebElement medicationDropdownLocator;

	@FindBy(css = "#claimProviderRoleID")
	WebElement pharmacistdropdown;

	@FindBy(css = "a#currentMedNextButton")
	WebElement nextMedButtonLocator;

	@FindBy(css = "a#continueReview")
	WebElement continueButtonLocator;

	@FindBy(xpath = "//a[contains(text(),'Leave Claim as Pending')]")
	WebElement leaveclaimaspending;

	@FindBy(css = "#saveForLaterReason1")
	WebElement pharmacistaction;

	@FindBy(css = "#continue")
	WebElement saveandcontinue;

	@FindBy(css = "a#NextButton")
	WebElement newMedNextButtonElement;

	@FindBy(css = "a#submitClaim")
	WebElement submitClaimButtonElement;

	@FindBy(css = "a#patientTakeawayNextButton")
	WebElement patientCommunicationNextButton;

	@FindBy(xpath = "//*[@id='MTMserviceDate']")
	WebElement datepicker;

	@FindBy(css = "#immunizationDate")
	WebElement datepickerimmunization;

	@FindBy(xpath = "/html/body/div[2]/div/form[1]/div[1]/div[4]/div/p[1]/select")
	WebElement selmedfortip;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[5]/p[1]/select")
	WebElement seloutcome;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[6]/p[1]/select[1]")
	WebElement seloutcome1;

	@FindBy(xpath = "/html/body/div[2]/div/form[1]/div[1]/div[2]/div/p[3]/select")
	WebElement parmacistsel;

	@FindBy(css = "#ui-id-15 > p:nth-child(1) > label")
	public WebElement currentmedhistory;

	@FindBy(css = "#claimQuestion_42yes")
	public WebElement radiooption1;

	@FindBy(css = "#claimQuestion_43yes")
	public WebElement radiooption2;

	@FindBy(css = "#claimQuestion_48yes")
	public WebElement radiooption3;

	@FindBy(css = "#claimQuestion_49yes")
	public WebElement radiooption4;

	@FindBy(css = "#barrier8action24_30_2_43")
	WebElement adherence90dayBarrierMedicationCostEducation;

	@FindBy(css = "#barrier8_30_2_43")
	WebElement adherence90dayBarrierMedicationCostOption;

	@FindBy(css = "#barrier8action24_31_2_44")
	WebElement adherencedvpbarrierMedicationCostEducation;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[9]/div[21]/p[2]/input[1]")
	WebElement diseasestatecheckbox;

	@FindBy(css = "#claimQuestion_74")
	public WebElement checkbox1;	

	@FindBy(css = "#barrier8_31_2_44")
	WebElement adherencedvpBarrierMedicationCostOption;

	@FindBy(css = "#startClaimLink")
	WebElement startLinkLocator;

	@FindBy(xpath = "//p[contains(text(),'MTM Claims History')]")
	WebElement mtmclaimshistory;

	@FindBy(xpath = "//body/div[@id='lookHere']/div[1]/div[4]/div[1]/div[2]/label[1]/input[1]")
	WebElement mtmclaimshistorysearch;

	@FindBy(xpath = "/html/body/div[2]/div/p[3]/a[1]")
	WebElement cancelclaim;

	@FindBy(xpath = "/html/body/div[2]/div/p[3]/a[2]")
	WebElement cancelclaim1;

	@FindBy(xpath = "/html/body/div[2]/div/div[4]/div[1]/table/tbody/tr/td[6]/div")
	WebElement deleterclaimow;

	@FindBy(xpath = "/html/body/div[15]/div[3]/div/button")
	WebElement okbutton;

	public void diseasestchbox_click() {
		diseasestatecheckbox.click();
	}


	public void selectAdherencedvpBarrier() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", adherencedvpBarrierMedicationCostOption);
		executor.executeScript("arguments[0].click();", adherence90dayBarrierMedicationCostOption);
		//adherenceBarrierMedicationCostOption.click();
	}

	public void selectAdherencedvpBarrierAction() {
		//adherenceBarrierMedicationCostEducation.click();
		//WebDriverWait wait = new WebDriverWait(driver,25);
		//wait.until(ExpectedConditions.elementToBeClickable(adherencedvpbarrierMedicationCostEducation));
		//Actions act= new Actions(driver);
		//act.moveToElement(adherenceBarrierMedicationCostEducation).click().build().perform();	 
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", adherencedvpbarrierMedicationCostEducation);
		executor.executeScript("arguments[0].click();", adherencedvpbarrierMedicationCostEducation);
	}

	public void selectAdherence90dayBarrier() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", adherence90dayBarrierMedicationCostOption);
		executor.executeScript("arguments[0].click();", adherence90dayBarrierMedicationCostOption);
		//adherenceBarrierMedicationCostOption.click();
	}

	public void selectAdherence90dayBarrierAction() {
		//adherenceBarrierMedicationCostEducation.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(adherence90dayBarrierMedicationCostEducation));
		//Actions act= new Actions(driver);
		//act.moveToElement(adherenceBarrierMedicationCostEducation).click().build().perform();	 
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", adherence90dayBarrierMedicationCostEducation);
		executor.executeScript("arguments[0].click();", adherence90dayBarrierMedicationCostEducation);
	}


	String currentDate = new SimpleDateFormat("MMddyyyy").format(new Date());

	CommonMethods commonMethods;
	int normalWaitTime = 10;

	public ClaimsSubmissionPage() {
		PageFactory.initElements(driver, this);
		commonMethods = new CommonMethods();
	}

	public void selectReason() {
		reasonDropdownLocator.click();
		commonMethods.implicitwait(normalWaitTime);
		Select dropdown = new Select(reasonDropdownLocator);
		dropdown.selectByIndex(1);
		//dropdown.selectByVisibleText("Adherence - Needs check-in + 90-day fill");
	}

	public void selectService() {
		Select dropdown = new Select(serviceDropdownLocator);
		dropdown.selectByVisibleText("Patient consultation");
		serviceDropdownLocator.click();
	}

	public void selectOutcome(String selection) {
		Select dropdown = new Select(outcomeDropdownLocator);
		dropdown.selectByVisibleText("selection");
	}

	public void selectOutcome_claim(String selection) {
		Select dropdown = new Select(outcomeDropdownLocator);
		dropdown.selectByIndex(1);
	}

	public void selectMedication(String selection) throws InterruptedException {
		Thread.sleep(2000);
		medicationDropdownLocator.click();
		commonMethods.implicitwait(normalWaitTime);
		Select dropdown = new Select(medicationDropdownLocator);
		dropdown.selectByVisibleText(selection);
	}

	public void selectpharmacist(String selection) {
		commonMethods.implicitwait(normalWaitTime);
		Select dropdown = new Select(pharmacistdropdown);
		dropdown.selectByVisibleText(selection);
	}

	public void setDate(String date) {
		serviceDateLocator.click();
		serviceDateLocator.sendKeys(date);
	}

	public void clickNextButton() {
		//nextButtonLocator.click();;
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", nextButtonLocator);
		executor.executeScript("arguments[0].click();", nextButtonLocator);
	}

	public void clickNextMedButton() {
		nextMedButtonLocator.click();;
	}

	public void clickContinueButton() {
		//continueButtonLocator.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", continueButtonLocator);
		executor.executeScript("arguments[0].click();", continueButtonLocator);
	}

	public void leaveclaimpending_click() {
		leaveclaimaspending.click();
	}

	public void pharmacistaction_click() {
		pharmacistaction.click();
	}

	public void saveandcontinue_click() {
		saveandcontinue.click();
	}


	public void clickNewMedNextButton() {
		newMedNextButtonElement.click();
	}

	public void clickSubmitClaimButton() {
		//submitClaimButtonElement.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", submitClaimButtonElement);
		executor.executeScript("arguments[0].click();", submitClaimButtonElement);
	}

	public void processPatientCommunication() {
		patientCommunicationNextButton.click();
	}

	public void processAdherenceBarriers() {
		adherenceBarriersNextButton.click();
	}

	public void selectAdherenceBarrier() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", adherenceBarrierMedicationCostOption);
		executor.executeScript("arguments[0].click();", adherenceBarrierMedicationCostOption);
		//adherenceBarrierMedicationCostOption.click();
	}

	public void selectAdherenceBarrierAction() {
		//adherenceBarrierMedicationCostEducation.click();
		//WebDriverWait wait = new WebDriverWait(driver,25);
		//wait.until(ExpectedConditions.elementToBeClickable(adherenceBarrierMedicationCostEducation));
		//Actions act= new Actions(driver);
		//act.moveToElement(adherenceBarrierMedicationCostEducation).click().build().perform();	 
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", adherenceBarrierMedicationCostEducation);
		executor.executeScript("arguments[0].click();", adherenceBarrierMedicationCostEducation);
	}

	public void datepicker_sendkeys() {
		datepicker.click();
		datepicker.sendKeys("07022020");
	}

	/*
	 * public void selectpharmacist() { pharmacistdropdown.click();
	 * commonMethods.implicitwait(normalWaitTime); Select dropdown= new
	 * Select(parmacistsel); dropdown.selectByVisibleText("Andy Kim");
	 * parmacistsel.click(); }
	 */

	public void selectOutcome1() {
		commonMethods.implicitwait(5);
		seloutcome.click();
		commonMethods.implicitwait(normalWaitTime);
		Select dropdown= new Select(seloutcome);
		dropdown.selectByVisibleText("Recommendation made");
		//dropdown.selectByVisibleText("Recommendation made");
		seloutcome.click(); 
	}

	public void selectOutcome1(String Selection) {
		commonMethods.implicitwait(10);
		seloutcome.click();
		commonMethods.implicitwait(normalWaitTime);
		Select dropdown= new Select(seloutcome);
		dropdown.selectByVisibleText(Selection);
		seloutcome.click(); 
	}

	public void selectOutcome_claims() {
		commonMethods.implicitwait(10);
		seloutcome.click();
		commonMethods.implicitwait(normalWaitTime);
		Select dropdown= new Select(seloutcome);
		dropdown.selectByIndex(1);
		seloutcome.click(); 
	}


	public void selectOutcome_needspatienteducation(String Selection) {
		commonMethods.implicitwait(5);
		seloutcome.click();
		commonMethods.implicitwait(normalWaitTime);
		Select dropdown= new Select(seloutcome);
		dropdown.selectByVisibleText(Selection);
		seloutcome.click(); 
	}

	public void datepickerfortip_sendkeys() throws InterruptedException {
		Thread.sleep(2000);
		datepicker.click();
		datepicker.sendKeys(currentDate);
		datepicker.sendKeys(Keys.TAB);	
	}

	public void datepickerfortipimmunization_sendkeys() throws InterruptedException {
		Thread.sleep(2000);
		//datepicker.click();
		datepicker.sendKeys(currentDate);
		datepicker.sendKeys(Keys.TAB);	
	}

	public void datepickerforimmunization_sendkeys() {
		datepickerimmunization.click();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, -1);
		String outputdate = sdf.format(c.getTime());
		System.out.println(outputdate);
		datepickerimmunization.sendKeys(outputdate);
	}

	public void selectMedicationfortip() {
		selmedfortip.click();
		commonMethods.implicitwait(normalWaitTime);
		Select medsel= new Select(selmedfortip);
		medsel.selectByVisibleText("Other");
		selmedfortip.click(); 
	}

	public void selectpharmacist() {
		//Actions act= new Actions(driver);
		//act.moveToElement(pharmacistdropdown).click().build().perform();
		pharmacistdropdown.click();		 
		commonMethods.implicitwait(normalWaitTime);
		Select dropdown= new Select(parmacistsel);
		dropdown.selectByVisibleText("Andy Kim");
		parmacistsel.click();  
	}

	public boolean currentmedhistory_display() {
		if(currentmedhistory.isDisplayed()){
			return true;
		}else 
			return false;
	}

	public void radiooption1_click() {
		radiooption1.click();
	}

	public void radiooption2_click() {
		radiooption2.click();
	}

	public void radiooption3_click() {
		radiooption3.click();
	}

	public void radiooption4_click() {
		radiooption4.click();
	}

	public void checkbox1_click() {
		checkbox1.click();
	}

	public void clickClaimLink(){
		startLinkLocator.click();
	}

	public void mtmclaimshistory_click() throws InterruptedException {
		//Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(45));
		wait.until(ExpectedConditions.elementToBeClickable(mtmclaimshistory));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", mtmclaimshistory);
		executor.executeScript("arguments[0].click();", mtmclaimshistory);
		//mtmclaimshistory.click();
	}

	public void searchbydate() {	
		//mtmclaimshistorysearch.sendKeys(currentDate);
		//mtmclaimshistorysearch.sendKeys(Keys.TAB);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 0);
		String outputdate = sdf.format(c.getTime());
		System.out.println(outputdate);
		mtmclaimshistorysearch.sendKeys(outputdate);
	}

	public void cancelclaim_click() throws InterruptedException {
		cancelclaim.click();
	}

	public void cancelclaim1_click() throws InterruptedException {
		cancelclaim1.click();
		Thread.sleep(2000);
		okbutton_click();
	}

	public void deleteclaimrow_click() {
		deleterclaimow.click();
	}

	public void okbutton_click() {
		/*
		 * Alert alert = driver.switchTo().alert(); alert.accept();
		 */

		okbutton.click();
	}

}
