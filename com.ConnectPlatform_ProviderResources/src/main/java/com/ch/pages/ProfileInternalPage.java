package com.ch.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.ch.base.TestBase;

public class ProfileInternalPage extends TestBase {

	@FindBy(xpath = "//header/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")
	WebElement mainmenu;
	
	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	WebElement profilemenu;
	
	@FindBy(css = "#firstName")
	WebElement firstname;
	
	@FindBy(css = "#mi")
	WebElement middleinitial;
	
	@FindBy(css = "#lastName")
	WebElement lastname;
	
	@FindBy(css = "#employeeID")
	WebElement employeeid;
	
	@FindBy(css = "#companyName")
	WebElement companyname;
	
	@FindBy(css = "#dob")
	WebElement dob;
	
	@FindBy(css = "#phone")
	WebElement phone;
	
	@FindBy(css = "#email")
	WebElement email;
	
	@FindBy(css = "#saveProfile")
	WebElement saveprofilebutton;
	
	@FindBy(css = "#changesSavedMsg")
	public WebElement savemsg;
	
	@FindBy(css = "#errorSummaryMsg")
	public WebElement errormsg;
	
	public ProfileInternalPage() {
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
		dob.isDisplayed();
		phone.isDisplayed();
		email.isDisplayed();
		saveprofilebutton.isDisplayed();
	}
	
	public void modifyprofiledata () {
		phone.clear();
		String phoneinput = RandomStringUtils.randomNumeric(10);
		phone.click(); 
		phone.sendKeys(phoneinput);	
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
	
	public void profilesuccessmsg() {
		
		
	}
	
	
}