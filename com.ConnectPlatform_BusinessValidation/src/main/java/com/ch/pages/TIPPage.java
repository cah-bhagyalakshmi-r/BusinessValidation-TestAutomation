package com.ch.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
	
	@FindBy(css = "#tipsList > flux-card-header")
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
	
	public boolean isNINButtonAvailable () {
		if ((driver.findElements(By.cssSelector("#NINonlyOption .btn-secondary")).size() != 0 && driver.findElement(By.cssSelector("#NINonlyOption .btn-secondary")).isDisplayed()) ||
			(driver.findElements(By.cssSelector("#TIPmenu .btn-secondary")).size() != 0 && driver.findElement(By.cssSelector("#TIPmenu .btn-secondary")).isDisplayed())
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
	
	
	
	
	

}
