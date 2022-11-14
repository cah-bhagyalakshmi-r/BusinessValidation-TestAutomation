package com.ch.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ch.base.TestBase;
import com.ch.util.CommonMethods;
import com.ch.util.JsonFileReader;

public class CMRPage extends TestBase {

	@FindBy(css = "#add-medication-button")
	public WebElement addMedicationButton;

	@FindBy(xpath = "//mat-dialog-container[@id='mat-dialog-0']/app-delete-medication-dialog[@class='ng-star-inserted']//span[@class='mat-button-wrapper']")
	public WebElement confirmDeleteButton;

	@FindBy(xpath = "/html[1]/body[1]/div[5]/div[2]/div[1]/mat-dialog-container[1]/app-global-dialog-container[1]/footer[1]/button[1]")
	public WebElement confirmDeleteButton1;

	@FindBy(css = "#goToCmrButton")
	public WebElement continueCMRButton;

	@FindBy(css = "#medlist-delete-toolbar-button")
	public WebElement deleteButton;

	@FindBy(xpath =
			"/html[1]/body[1]/div[4]/div[1]/div[1]/div[5]/div[2]/md-content[1]/div[1]/div[1]/md-content[1]/div[1]/div[1]/span[1]/ng-service-delivery[1]/div[1]/form[1]/app-selection-card-group[1]/app-selection-card[3]/flux-card[1]/div[1]")
	public WebElement deliveryMethodVideoOption;

	@FindBy(xpath =
			"/html[1]/body[1]/div[4]/div[1]/div[1]/div[4]/div[2]/md-content[1]/div[1]/div[1]/md-content[1]/div[1]/div[1]/ng-service-delivery[1]/div[1]/form[1]/app-selection-card-group[1]/app-selection-card[2]/label[1]/flux-card[1]")
	public WebElement deliveryMethodPhoneOption;

	@FindBy(xpath =
			"/html[1]/body[1]/div[4]/div[1]/div[1]/div[4]/div[2]/md-content[1]/div[1]/div[1]/md-content[1]/div[1]/div[1]/ng-service-delivery[1]/div[1]/form[1]/app-selection-card-group[1]/app-selection-card[1]/label[1]/flux-card[1]/div[1]/div[1]")
	public WebElement deliveryMethodfaceOption;


	@FindBy(css = "#btnNextStep")
	public WebElement nextButton;

	@FindBy(xpath = "//*[@id='btnSaveClaim']")
	public WebElement saveClaimButton;

	@FindBy(css = "#saveCmrScheduleButton")
	public WebElement saveCMRScheduleButton;

	@FindBy(css = "#schedulingActionMessage")
	public WebElement schedulemessage;

	@FindBy(css = "#submitCMRButtonBottom")
	public WebElement submitClaimButton;

	@FindBy(xpath = "//button[@id='submitCMRButtonBottom']")
	public WebElement submitClaimButton1;

	@FindBy(css = "#ptTakingRefMedN")
	public WebElement takingMedNo;

	@FindBy(css = "#ptTakingRefMedY")
	public WebElement takingMedYes;

	@FindBy(css = "#TIPGuideURL")
	public WebElement tipGuide;

	@FindBy(css = "md-radio-button:nth-of-type(1)  .md-off")
	public List<WebElement> unableToReachPatientOption;

	//@FindBy(css = "md-radio-button:nth-of-type(1)  .md-off")
	//public List<WebElement> unableToReachPatientOption;

	@FindBy(css = "#documentUnsuccessfulCmrButton")
	public WebElement unsuccessfulCMRLink;

	@FindBy(css = "#btnSubmit")
	public WebElement unsuccessfulCMRSubmitButton;

	@FindBy(xpath = "//app-medication-row[@id='medication-row-0']/tr[1]/td[5]/app-custom-autocomplete//textarea[@type='text']")
	public WebElement medicationColumn;

	@FindBy(xpath = "//app-medication-row[@id='medication-row-0']/tr[1]//app-medication-sig-picker//textarea[@placeholder='Enter directions']")
	public WebElement medicationColumn1;

	@FindBy(xpath = "//app-medication-row[@id='medication-row-0']/tr[1]/td[8]/app-custom-autocomplete//textarea[@type='text']")
	public WebElement medicationColumn2;

	@FindBy(xpath = "//app-medication-row[@id='medication-row-0']/tr[1]/td[9]/app-custom-autocomplete//textarea[@type='text']")
	public WebElement medicationColumn3;

	@FindBy(css = "#app-medication-row#medication-row-")
	public WebElement medicationrow;

	@FindBy(css = "//body/div[@id='clientPage']/div[@id='app']/div[@id='ember331']/div[@id='connect-client']/div[@id='connect-dashboard']/oc-dashboard[1]/span[1]/div[1]/table[1]")
	public List<WebElement> patientrecordfound;

	@FindBy(xpath = "//*[@id='goToCmrButton']")
	public List<WebElement> gotocmrbtn;

	@FindBy(xpath = "/html/body/div[4]/div/div/div[4]/div/nav/ul/li[1]/div/span[2]/i")
	public WebElement servicedeliverytab;

	@FindBy(xpath = "//div[@id='tab-healthProfile']")
	public WebElement healthprofiletab;

	@FindBy(css = "#select-all-checkbox")
	public WebElement selectallchkbox;

	@FindBy(css = "#medlist-review-toolbar-button")
	public WebElement medlisttoolbarbtn;

	@FindBy(css = "input#input-cmrCompletedDate")
	public WebElement cmrcompleteddate;

	@FindBy(css = "#deliveredToSelect")
	public WebElement cmrservicerecipient;

	@FindBy(css = ".ltc-indicator .ember-view .ember-view:nth-of-type(2)")
	public WebElement longtrmcareoption;

	@FindBy(xpath = "//span[contains(text(),'ex. 8am to 5pm, Monday through Friday')]")
	public WebElement pharmacistavailability1;

	@FindBy(css = ".pharAvailSelect")
	public WebElement pharmacistavailability;

	@FindBy(css = ".md-checkbox")
	public WebElement chkattestation;

	@FindBy(css = ".attestation.ember-view.md-checkbox.md-default-theme > .md-container.md-ink-ripple")
	public WebElement chkattestationchkbox;

	@FindBy(css = "button#generatePatientTakeawayButton")
	public WebElement takeawaybtn;

	@FindBy(css = "input#input-patTakeAwayDate")
	public WebElement patienttakeawaydate;

	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[5]/div[2]/md-content[1]/div[1]/div[1]/md-content[1]/div[1]/div[1]/div[2]/div[1]/form[1]/md-card[2]/md-card-content[1]/div[7]/md-input-container[1]/input[1]")
	public WebElement zipcode;

	@FindBy(xpath = "/html/body/div[4]/div/div/div[5]/div[2]/md-content/div/div/md-content/div[1]/div/div[4]/div[2]/div/div/button")
	public WebElement addallergybtn;

	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[5]/div[2]/md-content[1]/div[1]/div[1]/md-content[1]/div[1]/div[1]/div[4]/div[2]/div[1]/md-card[1]/md-list[1]/md-list-item[1]/div[1]/button[1]")
	public List<WebElement> drugallergyRowExists;

	@FindBy(xpath = "/html/body/div[4]/div/div/div[5]/div[2]/md-content/div/div/md-content/div[1]/div/div[2]/div[2]/div/md-card/md-list/md-list-item/div/md-checkbox")
	public List<WebElement> noknownallergychkbox;

	@FindBy(xpath = "/html/body/div[4]/div/div/div[5]/div[2]/md-content/div/div/md-content/div[1]/div/div[4]/div[2]/div/md-card/md-list/md-list-item/div/div[1]/div[2]/button/i")
	public List<WebElement> deletedrugallergyrow;

	@FindBy(css = "#allergenSelect")
	public WebElement selectallergy;

	@FindBy(css = "#allergy-0-0")
	public WebElement checkboxclick;

	@FindBy(css = "#cb-0-0")
	public WebElement checkboxclick1;

	@FindBy(xpath = "/html/body/div[6]/md-dialog/md-dialog-content/p/div/div/div/div/div[1]/div[1]/md-checkbox/div[1]/div[2]")
	public WebElement addconditncheckbox;

	@FindBy(xpath = "/html/body/div[6]/md-dialog/md-dialog-content/p/div/div/div/div/div[1]/div[4]/md-checkbox/div[1]/div[2]")
	public WebElement addconditncheckbox1;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/md-dialog[1]/form[1]/md-dialog-actions[1]/button[3]/div")
	public WebElement saveandclosebtn;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/md-dialog[1]/md-dialog-actions[1]/button[2]")
	public WebElement saveandclosebtn1;

	@FindBy(css = "#input-priorAuthCode")
	public WebElement phoneauthcode;

	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[5]/div[2]/md-content[1]/div[1]/div[1]/md-content[1]/div[1]/div[1]/div[4]/div[1]/div[1]/md-card[1]/md-list[1]/md-list-item[1]/div[1]")
	public List<WebElement> currentconditionrowExists;

	@FindBy(xpath = "/html/body/div[4]/div/div/div[5]/div[2]/md-content/div/div/md-content/div[1]/div/div[4]/div[1]/div/div/button")
	public WebElement addconditionbtn;

	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[5]/div[2]/md-content[1]/div[1]/div[1]/md-content[1]/div[1]/div[1]/div[4]/div[1]/div[1]/md-card[1]/md-list[1]/md-list-item[1]/div[1]")
	public List<WebElement> noconditionexists;

	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[5]/div[2]/md-content[1]/div[1]/div[1]/md-content[1]/div[1]/div[1]/div[4]/div[1]/div[1]/md-card[1]/md-list[1]/md-list-item[1]/div[1]/div[2]/button[1]/i[1]")
	public List<WebElement> deleteconditionrow;

	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[5]/div[2]/md-content[1]/div[1]/div[1]/md-content[1]/div[1]/div[1]/div[2]/div[1]/div[1]/md-card[1]/md-list[1]/md-list-item")
	public List<WebElement> currentconditionrowsExists;

	@FindBy(xpath = "/html/body/div[4]/div/div/div[4]/div[2]/md-content/div/div/md-content/div[1]/div/div[2]/md-card/md-content/md-list/div/div/md-list-item/div/div[1]")
	public List<WebElement> actionplanrowExists;

	@FindBy(xpath = "/html/body/div[4]/div/div/div[5]/div[2]/md-content/div/div/md-content/div[1]/div/div[2]/md-card/md-content/md-list/div/div/md-list-item/div/div[1]/div[5]/i")
	public List<WebElement> deleteactionrow;

	@FindBy(xpath = "/html/body/div[2]/div/md-dialog/md-dialog-actions/button[2]")
	public WebElement actionplanokbutton;

	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[4]/div[2]/md-content[1]/div[1]/div[1]/md-content[1]/div[1]/div[1]/div[2]/div[2]/md-card[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[12]")
	public WebElement pdfcmrcompleteddate;

	@FindBy(css = "#input-paperInputMask")
	public WebElement datepicker;

	@FindBy(css = ".time-select-input")
	public WebElement timePicker;

	@FindBy(css = "md-radio-button:nth-of-type(1)  .md-off")
	public WebElement unableToReachPatientbutton;

	@FindBy(css = "md-radio-button:nth-of-type(2)  .md-off")
	public WebElement patientrefusedbutton;

	@FindBy(xpath = "//span[contains(text(),'Select reason')]")
	public WebElement selectrefusalreason;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/ul[1]/li")
	public List<WebElement> refusalreasonoptions;

	@FindBy(xpath = "//div[@id='pharmacistAttemptedSelect']")
	public WebElement selectpharmacist;

	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[5]/div[2]/md-content[1]/div[1]/div[1]/md-content[1]/div[1]/div[1]/button[1]")
	public WebElement additembutton;

	@FindBy(xpath = "/html/body/div[4]/div/div/div[5]/div[2]/md-content/div/div/md-content/div[1]/div/div[4]/div[2]/div/md-card/md-list/md-list-item/div/div[1]/div[2]/button/i")
	public WebElement deleterow;

	@FindBy(css = "#dateInputWithCalendar")
	public List<WebElement> dateInputWithCalendar;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/input[1]")
	public WebElement pharmacysel;

	@FindBy(xpath = "/html/body/div[4]/div/div/div[5]/div[2]/md-content/div/div/md-content/div[1]/div/div[2]/md-card/md-content/md-list/div/div/md-list-item/div/div[1]/div[5]/i")
	public WebElement deleteactionrow1;

	@FindBy(xpath = "/html/body/div[4]/div/div/div[5]/div[2]/md-content/div/div/md-content/div[1]/div/div[4]/div[1]/div/md-card/md-list/md-list-item[1]/div/div[2]/button[1]/i[1]")
	public WebElement deletecurrentcondition;

	@FindBy(xpath = "//div[contains(text(),'Schedule')]")
	public WebElement scheduleheader;

	@FindBy(xpath = "//button[@id='cancelScheduledCmr']")
	public WebElement cancelschedulecmr;

	@FindBy(xpath = "//span[contains(text(),'Select Pharmacist')]")
	public WebElement pharmacist;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/weld-card[1]/div[2]/div[2]/div[2]/div[1]/div[1]/md-radio-group[1]/md-radio-button[1]")
	public WebElement contactpatientchkbox;

	@FindBy(css = "#schedulingActionMessage")
	public WebElement scheduledmessage;

	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[5]/div[2]/md-content[1]/div[1]/div[1]/md-content[1]/div[1]/div[1]/div[2]/div[2]/md-card[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[7]")
	public WebElement pdfdate;

	@FindBy(css = "#add_new_dnc_check")
	public List<WebElement> communicationprefcheck;

	@FindBy(css = "#add_new_dnc_check")
	public WebElement communicationprefchecks;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div[2]/div/div[1]/div[4]/div[1]/oc-tcpa-component/span/div/flux-card/div/div/div[2]/div/input")
	public WebElement communicationprefchecks1;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div[2]/div/div[1]/div[4]/div[1]/oc-tcpa-component/span/div/flux-card/div/div/div[2]/span/input")
	public WebElement communicationphnnum;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement communicationsavebutton;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div[2]/div/div[1]/div[4]/div[1]/oc-tcpa-component/span/div/flux-card/div/div/div[5]/flux-card/flux-card-footer/button[1]")
	public WebElement communicationsavebutton1;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div[2]/div/div[1]/div[4]/div[1]/oc-tcpa-component/span/div/flux-card/div/div/div[3]/button[2]")
	public WebElement communicationcancelbutton;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/span[1]/div[1]/weld-card[1]/div[2]/div[2]/div[2]/div[1]/md-checkbox[1]/div[1]")
	public WebElement contactpatientcheckbox;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div[2]/div/div[1]/div[4]/div[1]/oc-tcpa-component/span/div/flux-card/div/div/div[1]/div/div/div[1]/input")
	public WebElement dnccheckbox;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div[2]/div/div[1]/div[4]/div[1]/oc-tcpa-component/span/div/flux-card/div/div/div[1]/div/div/div[2]/input")
	public WebElement swncheckbox;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[4]/div[1]/oc-tcpa-component[1]/span[1]/div[1]/flux-card[1]/div[1]/div[1]/div[1]/div[1]/label[1]/span[2]")
	public WebElement primaryphnum;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[4]/div[1]/oc-tcpa-component[1]/span[1]/div[1]/flux-card[1]/div[1]/div[1]/div[4]/div[1]")
	public WebElement communprefhistory;

	boolean addallergy = true;
	boolean removedrugallergy = true;
	boolean addMedication = true;
	boolean removeOtherMedications = true;
	boolean selectMedication = true;
	boolean removecondition = true;
	boolean removedrug = true;
	boolean removemedications = true;
	boolean removeaction = true;
	String currentDate = new SimpleDateFormat("MMddyyyy").format(new Date());
	Date todayDate = new Date();
	Date tomorrowDate = new Date(todayDate.getTime() + (1000 * 60 * 60 * 24));
	String cmrDate = new SimpleDateFormat("MMddyyyy").format(tomorrowDate);
	String allergy, phoneathcode, medication, directions, condition, prescriber;
	int normalWaitTime = 4;
	int defaultWaitTime = 5;

	Actions act = new Actions(driver);
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	CommonMethods commonMethods = new CommonMethods();
	JsonFileReader jsonreader = new JsonFileReader();

	public CMRPage() throws IOException, ParseException {
		PageFactory.initElements(driver, this);
		readTestData();
	}

	private void readTestData() throws IOException, ParseException {
		jsonreader.getdata();
		allergy = jsonreader.CMR.get("allergy").toString();
		phoneathcode = jsonreader.CMR.get("phoneauthcode").toString();
		medication = jsonreader.CMR.get("medication").toString();
		directions = jsonreader.CMR.get("directions").toString();
		condition = jsonreader.CMR.get("condition").toString();
		prescriber = jsonreader.CMR.get("prescriber").toString();
	}

	public WebElement getTIPGuideElement() {
		return tipGuide;
	}

	public void goToActionPlan() {
		nextButton.click();
	}

	public void goToHealthProfile() {
		nextButton.click();
	}

	public void goToMedList() {
		nextButton.click();
	}

	public void goToTakeaway() {
		nextButton.click();
	}

	public void loadCMRRefusalOptions() {
		unsuccessfulCMRLink.click();
	}

	public void removeSelectedMedication() {
		deleteButton.click();
	}

	public void saveCMR() {
		saveClaimButton.click();
	}

	public void saveCMRSchedule() {
		saveCMRScheduleButton.click();
	}

	public void cancelCMRSchedule() {
		cancelschedulecmr.click();
	}

	public void videooption_click() {
		executor.executeScript("arguments[0].click();", deliveryMethodVideoOption);
	}

	public void faceoption_click() {
		executor.executeScript("arguments[0].click();", deliveryMethodfaceOption);
	}

	public void phoneoption_click() {
		executor.executeScript("arguments[0].click();", deliveryMethodPhoneOption);
	}

	public void phoneauthcode() {
		phoneauthcode.sendKeys(phoneathcode);
	}

	public void selectUnableToReachOption() {
		unableToReachPatientbutton.click();
	}

	public void selectpatientrefusedOption() {
		patientrefusedbutton.click();
	}

	public void selectrefusalreason(String refusaloption) throws InterruptedException {
		selectrefusalreason.click();	
		Thread.sleep(2000);
		//driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/ul[1]/li[1]")).click();
		try {
			List <WebElement> refusalreasonoptions =
					driver.findElements(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/ul[1]/li"
							)); for(WebElement option:refusalreasonoptions){
								if(option.getText().equals(refusaloption)) { 
									Thread.sleep(1000);
									option.click(); } }
		}
		catch (StaleElementReferenceException elementHasDisappeared) {

		}

	}

	public void startContinueCMR() {
		continueCMRButton.click();
	}

	public void submitCMR() {
		executor.executeScript("arguments[0].scrollIntoView();", submitClaimButton1);
		submitClaimButton1.click();
		//nextButton.click();
	}

	public void submitUnsuccessfulCMR() {
		unsuccessfulCMRSubmitButton.click();
	}

	public boolean unableToReachOptionExists() {
		if (unableToReachPatientOption.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void schedulemsg_validation() {
		String schedulemsg = schedulemessage.getText();
		if(schedulemsg.contains("reached out to the patient")) {
			System.out.println("Clicked on contact the patient and waiting for response and saved successfully");
		}
		else {
			System.out.println("Unable to Click on contact the patient and waiting for response");
		}

	}

	public void servicedeliverytab_click() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(servicedeliverytab));
		servicedeliverytab.click();
	}

	public void healthprofiletab_click() {
		healthprofiletab.click();
	}

	public void selectallchkbox_click() {
		selectallchkbox.click();
	}

	public void medlisttoolbarbtn_click() {
		medlisttoolbarbtn.click();
	}

	public void cmrcompleteddate_click() {
		cmrcompleteddate.click();
	}

	public void servicerecipient_click() throws InterruptedException {
		executor.executeScript("arguments[0].scrollIntoView();", cmrservicerecipient);
		cmrservicerecipient.click();
		//cmrservicerecipient.click();
		WebElement cmrrecptdata=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/input[1]"));
		cmrrecptdata.sendKeys("Patient");	
		Thread.sleep(1000);
		WebElement patientclick=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/ul[1]/li[1]"));
		patientclick.click();
	}

	public void longtermcareoptn_click() {
		longtrmcareoption.click();
	}

	public void chkattestationchkbox_click() {
		chkattestationchkbox.click();
	}

	public void takeawaybtn_click() {
		executor.executeScript("arguments[0].scrollIntoView();", takeawaybtn);
		takeawaybtn.click();
	}

	public void addallergybtn_click() {
		addallergybtn.click();
	}

	public void deletedrugallergyrow_click() {
		deleterow.click();
	}

	public void selectallergy() throws IOException, ParseException {
		selectallergy.sendKeys(allergy);
		commonMethods.implicitwait(normalWaitTime);
	}

	public void checkbox_click() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(checkboxclick));
		checkboxclick.click();

	}

	public void addconditioncheckbox_click() throws InterruptedException {
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		if (!addconditncheckbox.isSelected()) {
			action.moveToElement(addconditncheckbox).click().build().perform();
			//addconditncheckbox.click();
		} else if (addconditncheckbox.isSelected()) {
			action.moveToElement(addconditncheckbox1).click().build().perform();
			//addconditncheckbox1.click();
		} else if (addconditncheckbox1.isSelected()) {
			addconditncheckbox.click();
		} else {
			action.moveToElement(addconditncheckbox1).click().build().perform();
			//addconditncheckbox1.click();
		}
	}
	
	public void addconditioncheckbox_click1() throws InterruptedException {
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		action.moveToElement(addconditncheckbox).click().build().perform();
	}

	public void saveandclosebtn_click() {
		act.moveToElement(saveandclosebtn).click().build().perform();
	}

	public void saveandclosebtn2_click() {
		saveandclosebtn1.click();
	}

	public void addDrugAllergy() throws IOException, ParseException {
		addallergybtn_click();
		commonMethods.implicitwait(normalWaitTime);
		selectallergy();
		checkbox_click();
		commonMethods.implicitwait(normalWaitTime);
		saveandclosebtn_click();
		commonMethods.implicitwait(normalWaitTime);
	}

	public boolean drugallergyRowExists() {
		if (drugallergyRowExists.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void removemedication() {
		boolean removeOtherMedications = true;
		boolean selectMedication = true;
		int rowCount = 1;
		while (selectMedication) {
			if (medicationRowExists(rowCount)) {
				selectMedicationRow(rowCount);
				commonMethods.implicitwait(normalWaitTime);
			} else {
				selectMedication = false;
				if ((rowCount == 1)) {
					removeOtherMedications = false;
				}
			}
			rowCount++;
		}
		if (removeOtherMedications) {
			removeSelectedMedication();
			commonMethods.implicitwait(defaultWaitTime);
			//confirmMedicationRemoval1();
			commonMethods.implicitwait(defaultWaitTime);
		}
	}

	public void saveandclosebtn1_click() {
		saveandclosebtn1.sendKeys(Keys.ENTER);
	}

	public void takeawayinputdetails() throws InterruptedException {
		int normalWaitTime = 7;
		commonMethods.implicitwait(normalWaitTime);
		cmrcompleteddate_click();
		commonMethods.implicitwait(defaultWaitTime);
		cmrcompleteddate.sendKeys(currentDate);
		commonMethods.implicitwait(normalWaitTime);
		servicerecipient_click();
		commonMethods.implicitwait(normalWaitTime);
		pharmacistavailability.click();
		WebElement parmacistdata = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/input[1]"));
		parmacistdata.sendKeys("9-5");
		commonMethods.implicitwait(defaultWaitTime);
		parmacistdata.sendKeys(Keys.TAB);
		commonMethods.implicitwait(normalWaitTime);
		longtermcareoptn_click();
		System.out.println("longtermcareoption clicked");
		commonMethods.implicitwait(normalWaitTime);;
		String zip = RandomStringUtils.randomNumeric(5);
		zipcode.sendKeys(Keys.COMMAND + "a");
		zipcode.sendKeys(Keys.DELETE);
		zipcode.click();
		zipcode.clear();
		commonMethods.implicitwait(defaultWaitTime);
		zipcode.sendKeys(zip);
		System.out.println("zipcode entered");
		commonMethods.implicitwait(defaultWaitTime);
		if (!chkattestation.getAttribute("class").contains("md-checked")) {
			chkattestationchkbox_click();
			;
			commonMethods.implicitwait(defaultWaitTime);
		}
	}

	public void deletecurrentcondition_click() {
		deletecurrentcondition.click();
	}

	public void addconditionbtn_click() {
		addconditionbtn.click();
	}

	public void removecurrentcondition() throws InterruptedException {
		boolean addcondition = true;
		int rowCount = 1;
		while (addcondition) {
			if (currentconditionrowExists.size() > 0 && deleteconditionrow.size() > 0) {
				deletecurrentcondition_click();
				commonMethods.implicitwait(4);
			} else {
				addcondition = false;
				if ((rowCount == 1)) {
					removecondition = true;
				}
			}
			rowCount++;
		}
		commonMethods.implicitwait(5);
		if (removecondition) {
			addcondition();
		}
	}

	public void removedrugallergy() throws IOException, ParseException {
		boolean selectdrug = true;
		int rowCount = 1;
		while (selectdrug) {
			if (drugallergyRowExists.size() > 0 && deletedrugallergyrow.size() > 0) {
				deletedrugallergyrow_click();
				commonMethods.implicitwait(4);
			} else {
				selectdrug = false;
				if ((rowCount == 1)) {
					removedrug = true;
				}
			}
			rowCount++;
		}
		commonMethods.implicitwait(5);
		if (removecondition) {
			addDrugAllergy();
		}
	}

	public void addcondition() throws InterruptedException {
		addconditionbtn_click();
		commonMethods.implicitwait(normalWaitTime);
		addconditioncheckbox_click1();
		commonMethods.implicitwait(normalWaitTime);
		saveandclosebtn2_click();
		commonMethods.implicitwait(normalWaitTime);
	}

	public void removemedication1() {
		boolean removeOtherMedications = true;
		boolean selectMedication = true;
		int rowCount = 1;
		while (selectMedication) {
			System.out.println("Check if medication row " + rowCount + " exists.");
			if (medicationRowExists(rowCount)) {
				System.out.println("Medication row " + rowCount + " do exist.");
				System.out.println("Select medication row " + rowCount + ".");
				selectMedicationRow(rowCount);
				commonMethods.implicitwait(5);
			} else {
				System.out.println("Medication row " + rowCount + " do not exist.");
				selectMedication = false;
				if (rowCount == 1) {
					removeOtherMedications = false;
				}
			}
			rowCount++;
		}
		if (removeOtherMedications) {
			System.out.println("Remove selected medication rows (all except the 1st row).");
			removeSelectedMedication();
			commonMethods.implicitwait(5);
			confirmMedicationRemoval();
			commonMethods.implicitwait(5);
		}
	}

	public void selectMedicationRow1(int rowNum) {
		WebElement selectmedrow = driver.findElement(By.cssSelector("app-medication-row:nth-of-type(" + rowNum
				+ ") .checkbox-selection-spacing.mat-accent.mat-checkbox  .mat-checkbox-inner-container.mat-checkbox-inner-container-no-side-margin"));
		selectmedrow.click();
	}

	public void removemedication2() throws InterruptedException {
		boolean selectmedication = true;
		boolean removemedication = true;
		int rowCount = 1;
		while (selectmedication) {
			if (medicationRowExists(rowCount)) {
				selectMedicationRow(rowCount);
			} else {
				selectmedication = false;
				if (rowCount == 1) {
					removemedication = false;
				}
			}
			rowCount++;
		}
		commonMethods.implicitwait(5);
		if (removemedication) {
			removeSelectedMedication();
			commonMethods.implicitwait(7);
			confirmMedicationRemoval();
			commonMethods.implicitwait(7);
		}
	}

	public boolean medicationRowExists(int rowNum) {
		if (driver.findElements(By.cssSelector("app-medication-row:nth-of-type(" + rowNum
				+ ") .checkbox-selection-spacing.mat-accent.mat-checkbox  .mat-checkbox-inner-container.mat-checkbox-inner-container-no-side-margin"))
				.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void addMedication() throws InterruptedException {
		System.out.println("Clicking on 'Add medication' button.");
		int defaultWaitTime = 3;
		commonMethods.waitBySeconds(defaultWaitTime);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(addMedicationButton));
		addMedicationButton.click();
		commonMethods.waitBySeconds(defaultWaitTime);
		WebElement medicationColumn = driver.findElement(By.xpath(
				"//app-medication-row[@id='medication-row-0']/tr[1]/td[5]/app-custom-autocomplete//textarea[@type='text']"));
		medicationColumn.click();
		wait.until(ExpectedConditions.visibilityOf(medicationColumn));
		commonMethods.waitBySeconds(defaultWaitTime);
		System.out.println("adding medication");
		medicationColumn.sendKeys(medication);
		commonMethods.waitBySeconds(defaultWaitTime);
		medicationColumn.sendKeys(Keys.TAB);
		commonMethods.waitBySeconds(defaultWaitTime);
		medicationColumn = driver.findElement(By.xpath(
				"//app-medication-row[@id='medication-row-0']/tr[1]//app-medication-sig-picker//textarea[@placeholder='Enter directions']"));
		commonMethods.waitBySeconds(defaultWaitTime);
		medicationColumn.sendKeys(directions);
		System.out.println("adding directions");
		commonMethods.waitBySeconds(defaultWaitTime);
		medicationColumn.sendKeys(Keys.TAB);
		commonMethods.waitBySeconds(defaultWaitTime);
		medicationColumn = driver.findElement(By.xpath(
				"//app-medication-row[@id='medication-row-0']/tr[1]/td[7]/app-custom-autocomplete//textarea[@type='text']"));
		medicationColumn.click();
		commonMethods.waitBySeconds(defaultWaitTime);
		medicationColumn.sendKeys(condition);
		System.out.println("adding condition");
		commonMethods.waitBySeconds(defaultWaitTime);
		medicationColumn.sendKeys(Keys.TAB);
		commonMethods.waitBySeconds(defaultWaitTime);
		medicationColumn = driver.findElement(By.xpath(
				"//app-medication-row[@id='medication-row-0']/tr[1]/td[8]/app-custom-autocomplete//textarea[@type='text']"));
		medicationColumn.click();
		commonMethods.waitBySeconds(defaultWaitTime);
		//medicationColumn.sendKeys(prescriber);
		//System.out.println("adding prescriber");
		commonMethods.waitBySeconds(defaultWaitTime);
		medicationColumn.sendKeys(Keys.TAB);
		commonMethods.waitBySeconds(defaultWaitTime);

	}

	public void checkFillMedicationRow(int rowNum) {
		rowNum = rowNum - 1;
		if (driver.findElement(By.cssSelector("app-medication-row#medication-row-" + rowNum + " textarea"))
				.getAttribute("value").trim().length() == 0) {
			driver.findElement(By.cssSelector("app-medication-row#medication-row-" + rowNum + " textarea"))
			.sendKeys(directions);
			commonMethods.implicitwait(2);
		}
	}

	public void selectMedicationRow(int rowNum) {
		WebElement selectmedrow = driver.findElement(By.cssSelector("app-medication-row:nth-of-type(" + rowNum
				+ ") .checkbox-selection-spacing.mat-accent.mat-checkbox  .mat-checkbox-inner-container.mat-checkbox-inner-container-no-side-margin"));
		selectmedrow.click();
	}

	public void confirmMedicationRemoval() {
		confirmDeleteButton.click();
	}

	public void confirmMedicationRemoval1() {
		confirmDeleteButton1.click();
	}

	public void deleteactionrow_click() {
		deleteactionrow1.click();
	}

	public void actionplanokbutton() {
		actionplanokbutton.click();
	}

	public void removeactionplan() {
		boolean addaction = true;
		int rowCount = 1;
		while (addaction) {
			if (actionplanrowExists.size() > 0 && deleteactionrow.size() > 0) {
				deleteactionrow_click();
				commonMethods.implicitwait(normalWaitTime);
				actionplanokbutton();
				commonMethods.implicitwait(normalWaitTime);
			} else {
				addaction = false;
				if ((rowCount == 1)) {
					removeaction = true;
				}
			}
			rowCount++;
		}
	}

	public void schedulecmr_inputdetails() throws InterruptedException {
		Thread.sleep(2000);
		datepicker.click();
		commonMethods.implicitwait(normalWaitTime);
		datepicker.sendKeys(cmrDate);
		commonMethods.implicitwait(normalWaitTime);
		timePicker.click();
		commonMethods.implicitwait(normalWaitTime);
		timePicker.sendKeys("11:45 PM", Keys.TAB, Keys.ENTER);
		commonMethods.implicitwait(normalWaitTime);
	}

	public void schedulecurrentcmr_inputdetails() {
		datepicker.click();
		commonMethods.implicitwait(normalWaitTime);
		datepicker.sendKeys(currentDate);
		commonMethods.implicitwait(normalWaitTime);
		timePicker.click();
		commonMethods.implicitwait(normalWaitTime);
		timePicker.sendKeys("11:45 PM", Keys.TAB, Keys.ENTER);
		commonMethods.implicitwait(normalWaitTime);
	}

	public void scheduleheader_validation() {
		scheduleheader.isDisplayed();
	}

	public void startContinueCMR_display() {
		continueCMRButton.isDisplayed();
	}

	public void contactpatient_checkbox() throws InterruptedException {
		Thread.sleep(2000);
		contactpatientcheckbox.click();
	}

	public void scheduledmessage_display() {
		scheduledmessage.isDisplayed();
	}

	public void datepicker_Sendkeys()throws InterruptedException {
		Thread.sleep(2000);
		datepicker.click();
		commonMethods.implicitwait(normalWaitTime);
		datepicker.sendKeys(currentDate);
		commonMethods.implicitwait(normalWaitTime);
	}

	public void selectpharmacistoption() {
		selectpharmacist.click();
		commonMethods.implicitwait(normalWaitTime);
		pharmacysel.sendKeys(Keys.ENTER);
		commonMethods.implicitwait(normalWaitTime);
	}

	public void pdfcmrcompleteddate() {
		String pdfgettext = pdfdate.getText();
		System.out.println(pdfgettext);
		Date date = Calendar.getInstance().getTime();
		System.out.println(date);
		//Assert.assertEquals(date, pdfgettext);
	}
	
	public void donotcall_click() throws InterruptedException {
		Thread.sleep(3000);
		communicationprefchecks1.click();	
		Thread.sleep(2000);
	}

	public void communicationphnnum_sendkeys() throws InterruptedException {
		Thread.sleep(2000);
		String phnum = RandomStringUtils.randomNumeric(10);
		communicationphnnum.click();
		communicationphnnum.sendKeys(phnum);
		Thread.sleep(2000);
	}

	public void communicationphnnum_save() {
		communicationsavebutton.click();
	}

	public void contactpatient_click() {
		contactpatientcheckbox.click();
	}

	public void communicationphnnum_cancel() throws InterruptedException {
		Thread.sleep(2000);
		communicationcancelbutton.click();
	}

	public void dnccheck_click() {
		dnccheckbox.click();
	}

	public void dnccheck_validation() throws InterruptedException {
		Thread.sleep(2000);
		dnccheck_click();
		if(dnccheckbox.isSelected()) {
			Assert.assertEquals(true, communicationsavebutton.isEnabled());
			Assert.assertEquals(true, communicationcancelbutton.isEnabled());
		}
		communicationphnnum_save();
		Thread.sleep(2000);
		dnchistory_validation();
		Thread.sleep(2000);
		dnccheck_click();
		Thread.sleep(2000);
		communicationphnnum_save();
		Thread.sleep(2000);
		dnchistory_validation1();	
	}

	public void swncheck_validation() throws InterruptedException {
		Thread.sleep(2000);
		swncheckbox.click();
		Thread.sleep(2000);
		if(swncheckbox.isSelected()) {
			communicationsavebutton.isEnabled();
			communicationcancelbutton.isEnabled();			
		}
		communicationphnnum_save();
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		swnhistory_validation();
		Thread.sleep(2000);
		swncheckbox.click();
		Thread.sleep(2000);
		communicationphnnum_save();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		swnhistory_validation1();
	}
	
	
	public void swnhistory_validation() {
		String currentDate1 = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		String prmphnum=primaryphnum.getAttribute("innerText");
		//System.out.println("primary phone number:"+prmphnum);
		
		String swnhistory=communprefhistory.getAttribute("innerText");
		//System.out.println("primary phone number history-SWN:"+swnhistory);

		String expswnhistory=currentDate1 +" " +"-" +" " +"TRAIN listed" +" " +prmphnum +" " +"as SWN";
		System.out.println("primary phone number history-SWN:"+expswnhistory);
      
		 Assert.assertEquals(swnhistory, expswnhistory); 
		}
	
	public void swnhistory_validation1() {
		String currentDate1 = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		String prmphnum=primaryphnum.getAttribute("innerText");
		//System.out.println("primary phone number:"+prmphnum);
		
		String swnhistory=communprefhistory.getAttribute("innerText");
		//System.out.println("primary phone number history:"+dnchistory);

		String expswnhistory=currentDate1 +" " +"-" +" " +"TRAIN listed" +" " +prmphnum +" " +"as no longer SWN";
		System.out.println("primary phone number history-SWN:"+expswnhistory);
      
		 Assert.assertEquals(swnhistory, expswnhistory); 
		}
	
	public void dnchistory_validation() {
		String currentDate1 = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		String prmphnum=primaryphnum.getText().trim();
		//System.out.println("primary phone number:"+prmphnum);
		
		String dnchistory=communprefhistory.getText().trim();
		//System.out.println("primary phone number history:"+dnchistory);

		String expdnchistory=currentDate1 +" " +"-" +" " +"OUTCOMES TRAINING PHARMACY listed" +" " +prmphnum +" " +"as DNC";
		System.out.println("primary phone number history-DNC:"+expdnchistory);
      
		 Assert.assertEquals(dnchistory, expdnchistory); 
		}
	
	public void dnchistory_validation1() {
		String currentDate1 = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		String prmphnum=primaryphnum.getText().trim();
		//System.out.println("primary phone number:"+prmphnum);
		
		String dnchistory=communprefhistory.getText().trim();
		//System.out.println("primary phone number history:"+dnchistory);

		String expdnchistory=currentDate1 +" " +"-" +" " +"OUTCOMES TRAINING PHARMACY listed" +" " +prmphnum +" " +"as no longer DNC";
		System.out.println("primary phone number history-DNC:"+expdnchistory);
      
		 Assert.assertEquals(dnchistory, expdnchistory); 
		}
	
	public void fakenumberhistory_validation1() {
		String currentDate1 = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		String prmphnum=primaryphnum.getText().trim();
		//System.out.println("primary phone number:"+prmphnum);
		
		String dnchistory=communprefhistory.getText().trim();
		//System.out.println("primary phone number history:"+dnchistory);

		String expdnchistory=currentDate1 +" " +"-" +" " +"OUTCOMES TRAINING PHARMACY listed" +" " +prmphnum +" " +"as no longer DNC";
		System.out.println("primary phone number history-DNC:"+expdnchistory);
      
		 Assert.assertEquals(dnchistory, expdnchistory); 
		}
	
}
