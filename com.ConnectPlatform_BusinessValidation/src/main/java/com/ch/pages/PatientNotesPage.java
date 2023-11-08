package com.ch.pages;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ch.base.TestBase;
import com.ch.util.CommonMethods;
import com.ch.util.JsonFileReader;

public class PatientNotesPage extends TestBase {

	@FindBy(css = "button#add-medication-button > .mat-button-wrapper")
	public WebElement addMedicationButton;
	
	@FindBy(xpath = "//div[contains(text(),'Patient Notes')]")
	public WebElement patientnote;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/md-dialog[1]/md-dialog-content[1]/div[1]/div[1]/md-list-item[1]/div[1]/div[2]/button[1]")
	public WebElement addnote;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/md-dialog[1]/md-dialog-content[1]/div[1]/div[1]/div[1]/div[1]/div[1]/md-list-item[1]/div[1]/div[1]/div[1]/md-input-container[1]/textarea[1]")
	public WebElement patientnotevalue;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/md-dialog[1]/md-dialog-content[1]/div[1]/div[1]/div[1]/div[1]/div[1]/md-list-item[1]/div[1]/div[1]/div[2]/button[2]")
	public WebElement savenote;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/md-dialog[1]/md-dialog-content[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/i[1]")
	public WebElement deletenote;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/md-dialog[1]/md-dialog-actions[1]/button[2]")
	public WebElement okbutton;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/md-dialog[1]/md-dialog-content[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	public WebElement notesrow;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/md-dialog[1]/md-dialog-content[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/i[1]")
	public WebElement deleterow;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/md-dialog[1]/md-dialog-content[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/i[1]")
	public WebElement editrow;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/md-dialog[1]/md-dialog-content[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/md-list-item[1]/div[1]/div[1]/div[1]/md-input-container[1]/textarea[1]")
	public WebElement patientnoteedit;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/md-dialog[1]/md-dialog-content[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/md-list-item[1]/div[1]/div[1]/div[2]/button[2]")
	public WebElement patientnoteeditsavebutton;
	
	
	int normalWaitTime = 4;
	int defaultWaitTime = 5;
	String patientnotes;
	boolean removenote = true;
	boolean removedrug = true;
	boolean removecondition = true;

	Actions act = new Actions(driver);
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	CommonMethods commonMethods = new CommonMethods();
	JsonFileReader jsonreader = new JsonFileReader();

	public PatientNotesPage() throws IOException, ParseException {
		PageFactory.initElements(driver, this);
		readTestData();
	}

	private void readTestData() throws IOException, ParseException {
		jsonreader.getdata();
		patientnotes = jsonreader.Patientnotes.get("addingnote").toString();
	}
	
	public void patientnotes_click() {
		patientnote.click();
	}
	
	public void addnote_click() {
		//addnote.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", addnote);
		executor.executeScript("arguments[0].click();", addnote);
	}
	
	public void addnote_input() {
		patientnotevalue.sendKeys(patientnotes);
	}
	
	public void savenote_click() {
		savenote.click();
	}
	
	public void deletenote_click() {
		Actions actions=new Actions(driver);
		actions.moveToElement(deleterow).click().build().perform();
	}
	
	public void editnote_click() {
		editrow.click();
	}
	
	public void okbutton_click() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", okbutton);
		executor.executeScript("arguments[0].click();", okbutton);
		//okbutton.click();
	}
	
	public void patientnote_validation() {
		String patientnote= "AutomationTesting";
		String actualpatientnote=notesrow.getAttribute("textContent").trim();
		System.out.println("Patientnote:" +actualpatientnote);
		Assert.assertEquals(patientnote, actualpatientnote);
	}
	
	public void patientnoteedit_input() {
		patientnoteedit.sendKeys("patientedit");
	}
	
	public void patientnoteedit_validation() {
		String patientnoteafteredit= "AutomationTestingpatientedit";
		String actualpatientnoteedit=notesrow.getAttribute("textContent").trim();
		System.out.println("Patientnote:" +actualpatientnoteedit);
		Assert.assertEquals(patientnoteafteredit, actualpatientnoteedit);
	}
	
	public void patienteditsavebutton_click() {
		patientnoteeditsavebutton.click();
	}
	
	
}
