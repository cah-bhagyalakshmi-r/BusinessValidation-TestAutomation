package com.ch.pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ch.base.TestBase;
import com.ch.util.CommonMethods;

import junit.framework.Assert;

public class TIPPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'TIP Engine')]")
	WebElement tipengine;
	
	@FindBy(xpath = "//h3[contains(text(),'TIP Engine')]")
	WebElement tipengineheader;
	
	@FindBy(xpath = "//body/div[1]/form[1]/div[2]/div[2]/div[1]")
	WebElement existingtipheader;
	
	@FindBy(xpath = "//th[contains(text(),'TIP ID')]")
	WebElement tipid;
	
	@FindBy(xpath = "//th[contains(text(),'TIP Title')]")
	WebElement tiptitle;
	
	@FindBy(xpath = "//thead/tr[1]/th[3]/span[1]/select[1]")
	public WebElement all;
	
	@FindBy(xpath = "//th[contains(text(),'Create Date')]")
	public WebElement createdate;
	
	@FindBy(xpath = "//a[@id='save']")
	public WebElement savetip;
	
	@FindBy(xpath = "//a[@id='clear']")
	public WebElement createnewtip;
	
	@FindBy(xpath = "//body/div[1]/form[1]/div[2]/div[2]/div[2]/div[2]/label[1]/input[1]")
	public WebElement searchinput;
	
	@FindBy(xpath = "//input[@id='txtTipTitle']")
	public WebElement tiptitleinput;
	
	@FindBy(xpath = "//span[contains(text(),'Select Reason')]")
	public WebElement selectreason;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[4]/div[1]/div[6]/div[1]/div[1]/div[1]/ul[1]/li[1]")
	public WebElement selectreasoninput;
	
	@FindBy(xpath = "//span[contains(text(),'Select Action')]")
	public WebElement selectaction;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[4]/div[1]/div[7]/div[1]/div[1]/ul[1]/li[1]")
	public WebElement selectactioninput;
	
	@FindBy(xpath = "//span[contains(text(),'Select Severity')]")
	public WebElement selectseverity;	
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[4]/div[1]/div[8]/div[1]/div[1]/ul[1]/li[1]")
	public WebElement selectseverityinput;
	
	@FindBy(xpath = "//input[@id='chkDirectTip']")
	public WebElement directtip;
	
	@FindBy(xpath = "//input[@id='chkDirectTipRunRules']")
	public WebElement runtiprules;
	
	@FindBy(xpath = "//body/div[1]/form[1]/div[2]/div[4]/div[1]/div[11]/div[1]/div[1]/div[1]/label[3]")
	public WebElement medsyncnone;
	
	@FindBy(xpath = "//input[@id='txtNINRegenerationDays']")
	public WebElement nointerventiondays;
	
	@FindBy(xpath = "//input[@id='txtDefaultRegeneration']")
	public WebElement succesfuldays;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[4]/div[1]/div[15]/div[1]/table[1]/tbody[1]/tr[3]/td[2]/input[1]")
	public WebElement prescriberrefused;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[4]/div[1]/div[15]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/input[1]")
	public WebElement utrprescriber;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[4]/div[1]/div[15]/div[1]/table[1]/tbody[1]/tr[5]/td[2]/input[1]")
	public WebElement patientrefused;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[4]/div[1]/div[15]/div[1]/table[1]/tbody[1]/tr[6]/td[2]/input[1]")
	public WebElement utrpatient;
	
	@FindBy(xpath = "//input[@id='txtExpirationRegenerationDays']")
	public WebElement expregendays;
	
	@FindBy(xpath = "//input[@id='DXRules']")
	public WebElement rulesmanagerdx;
	
	@FindBy(xpath = "//body/div[1]/form[1]/div[2]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]")
	public WebElement pharmacistoverview;
	
	@FindBy(xpath = "//body/div[1]/form[1]/div[2]/div[4]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]")
	public WebElement patientoverview;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[4]/div[2]/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]")
	public WebElement physicianoverview;
	
	@FindBy(xpath = "//a[@id='addRule']")
	public WebElement addruletotip;
	
	@FindBy(xpath = "//a[@id='lnkFormularyAccordDiv']")
	public WebElement alternatives;
	
	@FindBy(xpath = "//select[@id='selectFormSearchType']")
	public WebElement selecttype;
	
	@FindBy(xpath = "//select[@id='selectFoundMeds']")
	public WebElement medicationnames;
	
	@FindBy(xpath = "//select[@id='selectFoundMeds']")
	public WebElement addbutton;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[2]")
	public WebElement newtipdata;
	
	@FindBy(xpath = "//a[@id='edit']")
	public WebElement edittip;
	
	@FindBy(xpath = "//p[@id='pResult1']")
	public WebElement edittipsavemsg;
	
	@FindBy(xpath = "//a[@id='copyTip']")
	public WebElement copytip;
	
	@FindBy(xpath = "//input[@id='txtExpirationOfTIPDays']")
	public WebElement tipexpdays;
	
	@FindBy(xpath = "//input[@id='txtFormularySearch']")
	public WebElement searchnameinput;
	
	@FindBy(xpath = "//input[@id='chkFormularyDependent']")
	public WebElement includealternatives;
	
	@FindBy(xpath = "//a[@id='addFormulary']")
	public WebElement addalternatives;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[4]/div[2]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/a[1]/i[1]")
	public WebElement deletealternatives;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[9]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	public WebElement lefttiprulebuilder;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[9]/div[3]/table[1]/tbody[1]/tr[1]/td[5]/input[1]")
	public WebElement righttiprulebuilder;
	
	@FindBy(css = "#divTipRuleError")
	public WebElement tipbuildererror;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[9]/div[3]/table[1]/tbody[1]/tr[1]/td[7]/a[1]")
	public WebElement tipbuilderdelete;
	
	@FindBy(css = "#PDCRules")
	public WebElement rulesmanagerpdc;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[9]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/label[1]/input[1]")
	public WebElement pdccheck;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[4]/div[2]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/input[1]")
	public WebElement addalternativeinput;
	
	@FindBy(css = "#divTipDetailRuleError")
	public WebElement tipbuilderdetailerror;
	
	@FindBy(xpath = "/html/body/div[1]/form/div[2]/div[9]/div[3]/table/tbody/tr/td[2]/div/div[3]/label/input")
	public WebElement pdccheckbox;
	
	@FindBy(xpath = "/html/body/div[1]/form/div[2]/div[9]/div[3]/table/tbody/tr/td[2]/div/div[4]/div[1]/input")
	public WebElement pdcrangefrom;
	
	@FindBy(xpath = "/html/body/div[1]/form/div[2]/div[9]/div[3]/table/tbody/tr/td[2]/div/div[4]/div[2]/input")
	public WebElement pdcrangeto;
	
	CommonMethods commonMethods= new CommonMethods();
	int defaultwaittime=15;
	JavascriptExecutor js = (JavascriptExecutor)driver;

	public TIPPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void tipengine_click() {
		tipengine.click();		
	}
	
	public void tip_fieldvalidation() {
		tipengineheader.isDisplayed();
		existingtipheader.isDisplayed();
		tipid.isDisplayed();	
		tiptitle.isDisplayed();
		all.isDisplayed();
		createdate.isDisplayed();
		savetip.isDisplayed();
		createnewtip.isDisplayed();
	}
	
	public void createnewtip_click() {
		createnewtip.click();
	}
	
	public void tittitle_input() {
		String tititle = "cardinalaccnt" + RandomStringUtils.randomNumeric(3);
		tiptitleinput.sendKeys(tititle);
	}
	
	public void reasonselect() throws InterruptedException {
		selectreason.click();
		selectreasoninput.click();

	}
	
	public void actionselect() throws InterruptedException {
		selectaction.click();
		Thread.sleep(2000);
		selectactioninput.click();
	}
	
	public void severityselect() throws InterruptedException {
		Thread.sleep(3000);
		selectseverity.click();
		Thread.sleep(2000);
		selectseverityinput.click();
	}
	
	public void directtip_click() {
		directtip.click();
	}
	
	public void runtiprule_click() {
		runtiprules.click();
	}
	
	public void medsyncnone_click() {
		medsyncnone.click();
	}
	
	public void tipgeneration_input() {
		nointerventiondays.sendKeys("180");
		succesfuldays.sendKeys("60");
		prescriberrefused.sendKeys("3");
		utrprescriber.sendKeys("3");
		patientrefused.sendKeys("3");
		utrpatient.sendKeys("3");
		expregendays.sendKeys("1");
	}
	
	public void rulesmanager_click() {
		rulesmanagerdx.click();
	}
	
	public void rulesmanagerpdc_click() {
		rulesmanagerpdc.click();
	}
	
	public void addruletip_click() {
		addruletotip.click();
	}
	
	public void pharmacistoverview_input() {
		pharmacistoverview.sendKeys("AutomationTesting");
	}
	
	public void patientoverview_input() {
		patientoverview.sendKeys("AutomationTesting");
	}
	
	public void physicianoverview_input() {
		physicianoverview.sendKeys("AutomationTesting");
	}
	
	public void savetip_click() throws InterruptedException {
		Thread.sleep(2000);
		//savetip.click();
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", savetip);
		executor.executeScript("arguments[0].click();", savetip);
	}
	
	public void edittip_click(){
		//edittip.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", edittip);
		executor.executeScript("arguments[0].click();", edittip);
	}
	
	public void copytip_click() {
		copytip.click();
	}
	
	public void tipgeneration_change() throws InterruptedException {
		succesfuldays.clear();
		Thread.sleep(1000);
		String succesfuldayschng = RandomStringUtils.randomNumeric(2);
		succesfuldays.sendKeys(succesfuldayschng);
	}
	
	public void tipexpdays_change() throws InterruptedException {
		tipexpdays.clear();
		Thread.sleep(1000);
		tipexpdays.sendKeys("180");
	}
	
	public void alternatives_click() {
		alternatives.click();
	}
	
	public void addalternative() {
		if(!searchnameinput.isEnabled()) {
			alternatives_click();
			includealternatives.click();
			searchnameinput.sendKeys("VIT", Keys.TAB, Keys.ENTER);
			addalternatives.click();
			
		}
	}
	
	public void includealternatives_check() throws InterruptedException{
		if(!includealternatives.isSelected()){
			includealternatives.click();
			Thread.sleep(2000);
			alternatives_click();
			searchnameinput.sendKeys("VIT", Keys.TAB, Keys.ENTER);
			addalternatives.click();		
		}
		else {
			alternatives_click();
			searchnameinput.sendKeys("VIT", Keys.TAB, Keys.ENTER);
			addalternatives.click();		
		}
	}
	
	public void addalternative_input() {
		addalternativeinput.sendKeys("AutomatonTesting");
	}
	
	public void deletealternative_click() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", deletealternatives);
		executor.executeScript("arguments[0].click();", deletealternatives);
	}
	
	public void editipsave_msgvalidation() {
		String expedittipsave= "Tip successfully saved.";
		String actedittipsave = edittipsavemsg.getText().trim();
		System.out.println("Edit tip save msg:" +actedittipsave);
		Assert.assertEquals(expedittipsave, actedittipsave);		
	}	
	
	public void copytipsave_msgvalidation() {
		String expedittipsave= "Tip successfully saved.";
		String actedittipsave = edittipsavemsg.getText().trim();
		System.out.println("Copy tip save msg:" +actedittipsave);
		Assert.assertEquals(expedittipsave, actedittipsave);		
	}
	
	public void tipdetails_input() throws InterruptedException {
		tittitle_input();
		reasonselect();
		js.executeScript("window.scrollBy(0,500)", "");
		actionselect();
		severityselect();
		directtip_click();
		runtiprule_click();
		medsyncnone_click();
		tipgeneration_input();
		addruletip_click();
		pharmacistoverview_input();
		patientoverview_input();
		physicianoverview_input();
		js.executeScript("window.scrollBy(0,-500)", "");
	}
	
	public void lefttiprulebuilder_click() throws InterruptedException {
		Thread.sleep(2000);
		lefttiprulebuilder.click();
	}
	
	public void righttiprulebuilder_click() {
		righttiprulebuilder.click();
	}
	
	public void tipbuilderdelete_click() {
		tipbuilderdelete.click();
	}
	
	public void pdccheck_click() {
		pdccheck.click();
	}
	
	public void pdccheck_input() throws InterruptedException {
		pdccheckbox.click();
		Thread.sleep(2000);
		pdcrangefrom.sendKeys("-0.2");
		Thread.sleep(2000);
		pdcrangeto.sendKeys("0.1");
	}
	
	
	public void lefttipbuilder_parentheticalerror() {
		String exptipbuildererror = "Ensure that every open parenthesis has a closing parenthesis in the following rules";
		String acttipbuildererror= tipbuildererror.getText().trim();
		System.out.println("Open Parenthesis error: "+acttipbuildererror);
		Assert.assertEquals(exptipbuildererror, acttipbuildererror);
	}
	
	public void righttipbuilder_parentheticalerror() {
		String exptipbuildererror = "You cannot have a closing parenthesis before an opening one\n"
				+ "Ensure that every open parenthesis has a closing parenthesis in the following rules";
		String acttipbuildererror= tipbuildererror.getText().trim();
		System.out.println("closing Parenthesis error: "+acttipbuildererror);
		Assert.assertEquals(exptipbuildererror, acttipbuildererror);
	}
	
	public void deletetipbuilderrule_validation() {
		String exptipbuildererror = "Please add at least one rule to the tipThe last rule must have end as the logic";
		String acttipbuildererror= tipbuildererror.getText().trim();
		System.out.println("Remove tip builder rule error: "+acttipbuildererror);
		Assert.assertEquals(exptipbuildererror, acttipbuildererror);
	}
	
	public void pdcerror_validation() {
		String exptipbuildererror = "Please fill out the highlighted fields below";
		String acttipbuildererror= tipbuilderdetailerror.getText().trim();
		System.out.println("PDC error: "+acttipbuildererror);
		Assert.assertEquals(exptipbuildererror, acttipbuildererror);
	}
	
	public void tipbuildererror_validation() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,3000)", "");
		//addruletip_click();
		Thread.sleep(2000);
		lefttiprulebuilder_click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-3000)", "");
		Thread.sleep(2000);
		savetip_click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,10000)", "");
		lefttipbuilder_parentheticalerror();
		Thread.sleep(2000);
		lefttiprulebuilder_click();
		Thread.sleep(2000);
		righttiprulebuilder_click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-2000)", "");
		Thread.sleep(2000);
		savetip_click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,10000)", "");
		righttipbuilder_parentheticalerror();
		Thread.sleep(2000);
		tipbuilderdelete_click();
		js.executeScript("window.scrollBy(0,-3000)", "");
		Thread.sleep(2000);
		savetip_click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,11000)", "");
		deletetipbuilderrule_validation();
		Thread.sleep(2000);
		rulesmanagerpdc_click();
		Thread.sleep(2000);
		addruletip_click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,3000)", "");
		pdccheck_click();
		Thread.sleep(2000);
		pdccheck_input();
		Thread.sleep(2000);
		savetip_click();
		Thread.sleep(2000);
		pdcerror_validation();
		js.executeScript("window.scrollBy(0,11000)", "");
		Thread.sleep(2000);
	}
	
	
	
	
	
}