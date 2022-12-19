package com.ch.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.ch.base.TestBase;

public class ProfileExternalPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Menu')]")
	WebElement mainmenu;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/a[1]/div[1]")
	WebElement profilemenu;
	
	@FindBy(css = "#firstName")
	WebElement firstname;
	
	@FindBy(css = "#MI")
	WebElement middleinitial;
	
	@FindBy(css = "#lastName")
	WebElement lastname;
	
	@FindBy(css = "#employeeID")
	WebElement employeeid;
	
	@FindBy(css = "#pharmacistNPI")
	WebElement pharmacistnpi;
	
	@FindBy(css = "#addressLine1")
	WebElement addressline1;
	
	@FindBy(css = "#addressLine2")
	WebElement addressline2;
	
	@FindBy(css = "#city")
	public WebElement city;
	
	@FindBy(css = "#state")
	WebElement state;
	
	@FindBy(css = "#zip")
	WebElement zip;
	
	@FindBy(css = "#dob")
	WebElement dob;
	
	@FindBy(css = "#phone")
	WebElement phone;
	
	@FindBy(css = "#email")
	WebElement email;
	
	@FindBy(css = "#saveProfileChanges")
	WebElement saveprofilebutton;
	
	@FindBy(css = "#changesSavedMsg")
	public WebElement savemsg;
	
	@FindBy(css = "#errorSummaryMsg")
	public WebElement errormsg;
	
	public ProfileExternalPage() {
		PageFactory.initElements(driver, this);
	}

	public void mainmenuclick() {
		mainmenu.click();
	}
	
	public void profilemenuclick() {
		profilemenu.click();		
	}
	
	public void profilepage_validation() {
		firstname.isDisplayed();
		middleinitial.isDisplayed();
		lastname.isDisplayed();
		employeeid.isDisplayed();
		pharmacistnpi.isDisplayed();
		addressline1.isDisplayed();
		addressline2.isDisplayed();
		city.isDisplayed();
		state.isDisplayed();
		zip.isDisplayed();
		dob.isDisplayed();
		phone.isDisplayed();
		email.isDisplayed();
		saveprofilebutton.isDisplayed();
	}
	
	public void modifyprofiledata () {
		city.clear();
	    String cityinput = RandomStringUtils.randomAlphabetic(8);
	    city.sendKeys(cityinput);			
	}
	
	public void modifyemaildata () {
		email.clear();
		String emailinput = RandomStringUtils.randomAlphabetic(6);
		email.click(); 
		email.sendKeys(emailinput + "@test.com");	
	}
	
	
	public void saveprofilebuttonclick() {
		saveprofilebutton.click();
	}
	
	
	
}