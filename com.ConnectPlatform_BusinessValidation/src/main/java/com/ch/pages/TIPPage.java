package com.ch.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ch.base.TestBase;
import com.ch.util.CommonMethods;
import com.ch.util.JsonFileReader;

public class TIPPage extends TestBase {

	@FindBy(css = "input[name='claimQuestion_5']")
	WebElement educatedThePatientBox;

	@FindBy(css = "select#invalidTipReasonCode")
	WebElement noInterventionReasonDropdown;

	@FindBy(css = "#removeTIP")
	WebElement removeTIPButton;

	@FindBy(css = "#ptTakingRefMedN")
	public WebElement takingMedNoElement;

	@FindBy(css = "#ptTakingRefMedY")
	public WebElement takingMedYesElement;

	@FindBy(css = "#TIPGuideURL")
	public WebElement tipGuideElement;

	@FindBy(css = "#unfinishedClaimsList > flux-card-header")
	public WebElement unfinishedclaimlistheader;
	
	@FindBy(css = "weld-card#tipsList > weld-card-header")
	public WebElement tipListHeader;

	@FindBy(css = "div:nth-of-type(11)  button[title='Close'] > .ui-button-icon.ui-icon.ui-icon-closethick")
	WebElement tipWindowCloseButton;
	
	@FindBy(css = "#NINonlyOption .btn-secondary")
	WebElement nionlyoption;
	
	@FindBy(css = "#TIPmenu .btn-secondary")
	WebElement tipmenuoption;
	
	@FindBy(css = "#startClaimForTipButton")
	public WebElement startclaimfortiipbutton;
	
	@FindBy(css = "body.default.patientNavigationRendered.leftNavRendered.experimentalNav:nth-child(2) div.ui-dialog.ui-corner-all.ui-widget.ui-widget-content.ui-front.ui-draggable.ui-resizable:nth-child(44) div.ui-dialog-titlebar.ui-corner-all.ui-widget-header.ui-helper-clearfix.ui-draggable-handle:nth-child(1) button.ui-button.ui-corner-all.ui-widget.ui-button-icon-only.ui-dialog-titlebar-close > span.ui-button-icon.ui-icon.ui-icon-closethick")
	public WebElement closingtipbutton;
	
	@FindBy(xpath = "//*[@id='MTMserviceDate']")
	public WebElement datepicker;
	
	@FindBy(xpath = "//*[@id='currentMedName']")
	public WebElement medinput;
	
	@FindBy(xpath = "//*[@id='newMedName']")
	public WebElement newmedinput;
	
	@FindBy(css = "textarea#ecaExplanation")
	public WebElement encounternote;
	
	@FindBy(css = "#currentMedfromHistory")
	public WebElement currentmedhistory;
	
	@FindBy(xpath = "//*[@id='ui-id-34']")
	public WebElement medselect;
	
	@FindBy(css = "#ui-id-26 > li:nth-child(1)")
	public WebElement newmedselect;
	
	@FindBy(css = "div#eca > div[role='tabpanel']  .btn2")
	public WebElement tabpanel;
	
	@FindBy(css = "#healthcareAccessBarriers-MEDICATION_COST_IS_TOO_HIGH-input")
	WebElement adherenceBarrierMedicationCostOption;
	
	@FindBy(css = "#medicationCostIsTooHighActions-PROVIDED_PATIENT_EDUCATION-input")
	WebElement adherenceBarrierMedicationCostEducation;
	
	@FindBy(css = "a#submitClaim")
	WebElement submitClaimButtonElement;
	
	JavascriptExecutor executor = (JavascriptExecutor) driver;	
	
	public String currentDate = new SimpleDateFormat("MMddyyyy").format(new Date());
	public String tipnum;
	String medinpt, newmedinpt,newimmunizationmedinpt;
	int defaultWaitTime = 10;
	int normalWaitTime = 3;
		
	CommonMethods commonMethods;
	JsonFileReader jsonreader=new JsonFileReader();

	public TIPPage() throws IOException, ParseException {
		PageFactory.initElements(driver, this);
		commonMethods = new CommonMethods();
		readTestData();
	}
	
	private void readTestData() throws IOException, ParseException {
		JsonFileReader.getdata();
		medinpt=JsonFileReader.TIP.get("medinput").toString();
		newmedinpt=JsonFileReader.TIP.get("newmedinput").toString();
		newimmunizationmedinpt=JsonFileReader.TIP.get("newmedimmunizationinput").toString();
	}

	
	public void closeTIPWindow () {
		tipWindowCloseButton.click();
	}
	
	public By getTIPLink(int rowNum) {
		return By.cssSelector("md-list > md-list-item:nth-of-type(" + rowNum + ")");
	}
	
	public By getTIPName(int rowNum) {
		return By.cssSelector("md-list-item:nth-of-type(" + rowNum + ") .ember-view.flex .opportunity-name");
	}
	
	public By getTIPName1(int rowNum) {
		return By.cssSelector("md-list-item:nth-of-type(" + rowNum + ") .current-med-name");
	}
	
	public boolean isNINButtonAvailable () {
		if ((driver.findElements(By.cssSelector("#NINonlyOption .btn-secondary")).size() != 0 && driver.findElement(By.cssSelector("#NINonlyOption .btn-secondary")).isDisplayed()) ||
			(driver.findElements(By.cssSelector("#TIPmenu .btn-secondary")).size() != 0 && driver.findElement(By.cssSelector("#TIPmenu .btn-secondary")).isDisplayed())
		) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isNINButtonAvailable1 () {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		if ((shadowroot.findElements(By.cssSelector("#no-intervention-needed-outcomeinput")).size() != 0 && shadowroot.findElement(By.cssSelector("#no-intervention-needed-outcomeinput")).isDisplayed())
			//	 ||(driver.findElements(By.cssSelector("#TIPmenu .btn-secondary")).size() != 0 && driver.findElement(By.cssSelector("#TIPmenu .btn-secondary")).isDisplayed())
		) {
			return true;
		} else {
			return false;
		}
	}

	public void processNoInterventionNeeded () {
		if (driver.findElements(By.cssSelector("#NINonlyOption .btn-secondary")).size() != 0 && driver.findElement(By.cssSelector("#NINonlyOption .btn-secondary")).isDisplayed()) {
			nionlyoption.click();
		} else if (driver.findElements(By.cssSelector("#TIPmenu .btn-secondary")).size() != 0 && driver.findElement(By.cssSelector("#TIPmenu .btn-secondary")).isDisplayed()) {
			tipmenuoption.click();
		}
	}

	public void processTIPRemoval () {
		removeTIPButton.click();
	}

	public void selectEducatedThePatientBox () {
		educatedThePatientBox.click();
	}

	public void selectNoInterventionReason () {
		commonMethods.implicitwait(normalWaitTime);
		noInterventionReasonDropdown.click();
		commonMethods.implicitwait(normalWaitTime);
		noInterventionReasonDropdown.sendKeys("P", Keys.TAB, Keys.TAB);
		commonMethods.implicitwait(normalWaitTime);
	}
	
	public void selectNoInterventionReason1 () {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		shadowroot.findElement(By.cssSelector("#noInterventionNeededReason-input")).click();
		commonMethods.implicitwait(normalWaitTime);
		shadowroot.findElement(By.cssSelector("#noInterventionNeededReason-input")).sendKeys("P", Keys.TAB, Keys.TAB);
		commonMethods.implicitwait(normalWaitTime);
	}
	
	public void noint_nextbutton_click() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		shadowroot.findElement(By.cssSelector("span:nth-child(2) > button")).click();
		commonMethods.implicitwait(normalWaitTime);
	}
	
	public List<WebElement> shadowroot_nointervention_click() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		List<WebElement> shadowele=shadowroot.findElements(By.cssSelector("#no-intervention-needed-outcomeinput"));
		return shadowele;
	}
	
	public List<WebElement> shadowroot_nooption_click() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		List<WebElement> shadowele1=shadowroot.findElements(By.cssSelector("#No"));
		return shadowele1;
	}
	
	public List<WebElement> shadowroot_yesoption_click() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		List<WebElement> shadowele1=shadowroot.findElements(By.cssSelector("#Yes"));
		return shadowele1;
	}
	
	public List<WebElement> shadowroot_adherencecheckin_click() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		List<WebElement> shadowele1=shadowroot.findElements(By.cssSelector("#adherence-check-in-completed-outcomeinput"));
		return shadowele1;
	}
	
	public List<WebElement> shadowroot_checkpoint_click() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		List<WebElement> shadowele1=shadowroot.findElements(By.cssSelector("#checkpoint-complete-outcomeinput"));
		return shadowele1;
	}
		
	
	public List<WebElement> shadowroot_patientenrolled_click() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		List<WebElement> shadowele1=shadowroot.findElements(By.cssSelector("#patient-monitored-and-enrolled-outcomeinput"));
		return shadowele1;

	}
	
	public void selectAdherenceBarrier() throws InterruptedException {	
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		shadowroot.findElement(By.cssSelector("#healthcareAccessBarriers-MEDICATION_COST_IS_TOO_HIGH-input")).click();
	}
	
	public void selectAdherenceBarrierAction() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		shadowroot.findElement(By.cssSelector("#medicationCostIsTooHighActions-PROVIDED_PATIENT_EDUCATION-input")).click();
	}
	
	public void selectmedicationfactors() throws InterruptedException {	
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		shadowroot.findElement(By.cssSelector("#medicationFactorsBarriers-CONCERNED_ABOUT_POTENTIAL_SIDE_EFFECTS-input")).click();
	}
	
	public void selectmedicationfactorsaction() throws InterruptedException {	
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		shadowroot.findElement(By.cssSelector("#concernedAboutPotentialSideEffectsActions-PROVIDED_PATIENT_EDUCATION-input")).click();
	}
	
	public void selectpatientfactors() throws InterruptedException {	
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		shadowroot.findElement(By.cssSelector("#patientFactorsBarriers-BELIEVES_TO_BE_ADHERENT-input")).click();
	}
	
	public void selectpatientfactorsaction() throws InterruptedException {		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		shadowroot.findElement(By.cssSelector("#believesToBeAdherentActions-PROVIDED_PATIENT_EDUCATION-input")).click();
	}
	
	public void clickSubmitClaimButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		shadowroot.findElement(By.xpath("//div/div/div/div/div/div/div/div[3]/div/div[1]/div[3]/div[2]/span[2]/button")).click();
	}
	

	public void startclaimfortip_click() {
		startclaimfortiipbutton.click();
	}
	
	public boolean startclaimfortip_display() {
		if(startclaimfortiipbutton.isDisplayed()){
			return true;
		}else 
			return false;
		}
	
	public boolean currentmedhistory_display() {
		if(currentmedhistory.isDisplayed()){
			return true;
		}else 
			return false;
		}

	public void datepicker_sendkeys() {
		datepicker.click();
		datepicker.sendKeys(currentDate);
		commonMethods.implicitwait(defaultWaitTime);
	}
	
	public void tipheader() {
		String tip= tipListHeader.getAttribute("textContent").trim();
		tipnum=tip.substring(0,1);
	}
	
	public void newmedinput() {
		newmedinput.sendKeys(newmedinpt);
		commonMethods.implicitwait(defaultWaitTime);
	}
	
	public void newimmunizationmedinpt() {
		newmedinput.sendKeys(newimmunizationmedinpt);
		commonMethods.implicitwait(defaultWaitTime);
	}
	
	
	public void medinput() {
		executor.executeScript("arguments[0].click();", medinput);
		medinput.sendKeys(medinpt);
		commonMethods.implicitwait(defaultWaitTime);
	}
	
	public void encounternote_sendkeys() {
		encounternote.sendKeys("Sample explanation");
		commonMethods.implicitwait(defaultWaitTime);
	}
	
	public void takingMedYes() {
		executor.executeScript("arguments[0].click();", takingMedYesElement);
	}
	
	public void takingMedNo() {
		executor.executeScript("arguments[0].click();", takingMedNoElement);
	}
	
	public void medselect() {
		medselect.click();
	}
	
	public void newmedselect() {
		newmedselect.click();
	}
	
	public void tabpanel() {
		tabpanel.click();
	}
	
	public boolean tipclick() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		if (shadowroot.findElements(By.cssSelector("#no-intervention-needed-outcomeinput")).size() != 0 && shadowroot.findElement(By.cssSelector("#no-intervention-needed-outcomeinput")).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean nointervention_click() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/point-of-care-services"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		if (shadowroot.findElements(By.cssSelector("#No")).size() != 0 ) {
			//return true;
			WebElement nointtip=shadowroot.findElement(By.cssSelector("#no-intervention-needed-outcomeinput"));
			Actions action = new Actions(driver);
			action.moveToElement(nointtip).click().build().perform();
			Thread.sleep(3000);
			System.out.println("Selecting a reason why no intervention was needed.");
			selectNoInterventionReason1();
		}
		else {
		
		System.out.println("Clicking the 'No Intervention Needed' button.");}
		return false;
		
	}
	
	
	
	

}
