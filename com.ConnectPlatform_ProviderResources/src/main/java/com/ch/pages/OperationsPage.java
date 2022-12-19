package com.ch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ch.base.TestBase;
import com.ch.util.CommonMethods;

public class OperationsPage extends TestBase {
	
	@FindBy(xpath = "//span[contains(text(),'Select a report')]")
	public WebElement reportstodownload;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/ul[1]/li[1]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	public WebElement reportstodownloadinput;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/aside[2]/div[2]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
	public WebElement salesforce;

	@FindBy(xpath = "//a[contains(text(),'Legacy')]")
	public WebElement legacy;
	
	@FindBy(xpath = "//a[contains(text(),'Patient Look-up')]")
	public WebElement patientlookup;
	
	@FindBy(xpath = "//a[contains(text(),'Continue to Salesforce')]")
	public WebElement continuetosalesforce;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	public WebElement cancelbutton;
	
	@FindBy(xpath = "//h3[contains(text(),'Patient Lookup Tool')]")
	public WebElement patientlookupheader;
	
	@FindBy(xpath = "//label[contains(text(),'Patient ID:')]")
	public WebElement patientid;
	
	@FindBy(xpath = "//label[contains(text(),'First Name:')]")
	public WebElement firstname;
	
	@FindBy(xpath = "//label[contains(text(),'Last Name:')]")
	public WebElement lastname;
	
	@FindBy(xpath = "//label[contains(text(),'Date of Birth:')]")
	public WebElement dob;
	
	@FindBy(xpath = "//label[contains(text(),'Phone Number:')]")
	public WebElement phonenumber;
	
	@FindBy(xpath = "//label[contains(text(),'Select Policies:')]")
	public WebElement selectpolicies;
	
	@FindBy(xpath = "//label[contains(text(),'Patient`s Policy:')]")
	public WebElement patientspolicy;
	
	@FindBy(xpath = "//label[contains(text(),'Patient`s Eligibility:')]")
	public WebElement patientseligibility;
	
	@FindBy(xpath = "//h3[contains(text(),'Please perform a search')]")
	public WebElement performsearch;
		
	@FindBy(xpath = "//span[contains(text(),'Select a report')]")
	public WebElement selectreport;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/ul[1]/li[1]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	public WebElement selectreportinput;
	
	@FindBy(css = "#downloadreportBtn")
	public WebElement downloadreport;

	public String dashboardPageUrl = prop.getProperty("url") + "index.cfm#/dashboard";
	int defaultwaittime=25;
	int normalwaittime=20;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	CommonMethods commonMethods;

	public OperationsPage() {
		PageFactory.initElements(driver, this);
		commonMethods = new CommonMethods();
	}
	
	public void reportstodownload_click() {
		reportstodownload.click();
	}
	
	public void reportstodownload_input() {
		reportstodownloadinput.sendKeys("approval");
	}
	
	public void salesforce_click() {
		salesforce.click();
	}
	
	public void legacy_click() {
		legacy.click();
	}
	
	public void patientlookup_click() {
		patientlookup.click();
	}	
	
	public void continuesalesforce_click() {
		js.executeScript("arguments[0].click();", continuetosalesforce);
	}
	
	public void cancelbutton_click() {
		cancelbutton.click();
	}
	
	public void patientlookup_display() {
		patientlookupheader.isDisplayed();
		patientid.isDisplayed();
		firstname.isDisplayed();
		lastname.isDisplayed();
		dob.isDisplayed();
		phonenumber.isDisplayed();
		selectpolicies.isDisplayed();
		patientspolicy.isDisplayed();
		patientseligibility.isDisplayed();
		performsearch.isDisplayed();
	}
	
	public void selectreport_click() {
		selectreport.click();
	}
	
	public void selectreport_input() {
		//selectreportinput.sendKeys("Approval");
		selectreportinput.sendKeys("PDX");
		selectreportinput.sendKeys(Keys.TAB);
	}
	
	public void downloadreport_click() {
		downloadreport.click();
	}

}