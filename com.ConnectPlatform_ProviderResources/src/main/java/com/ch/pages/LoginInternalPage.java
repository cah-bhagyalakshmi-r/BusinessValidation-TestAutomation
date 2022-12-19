package com.ch.pages;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.ch.base.TestBase;
import com.ch.util.JsonFileReader;
import junit.framework.Assert;

public class LoginInternalPage extends TestBase{
	
	@FindBy(css="#username")
	WebElement username;
	
	@FindBy(css="#password")
	WebElement password;
	
	@FindBy(css="#login")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Username?')]")
	public WebElement forgotusername;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Password?')]")
	public WebElement forgotpassword;
	
	@FindBy(xpath="//h2[contains(text(),'Forgot Username?')]")
	public WebElement forgotusernamelabel;
	
	@FindBy(xpath="//h2[contains(text(),'Forgot Password?')]")
	public WebElement forgotpasswordlabel;
	
	String fname, lname, useremail;
	
	JsonFileReader jsonreader=new JsonFileReader();
	
	public LoginInternalPage() throws IOException, ParseException{
		PageFactory.initElements(driver, this);
		readTestData();
	}
	
	private void readTestData() throws IOException, ParseException {
		JsonFileReader.getdata();
		fname=JsonFileReader.Login.get("firstname").toString();
		lname=JsonFileReader.Login.get("lastname").toString();
		useremail=JsonFileReader.Login.get("email").toString();
	}

	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public DashboardPage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();		    	
		return new DashboardPage();
	}
	
	public void invalidlogin() {
		username.sendKeys("test.automation");
		password.sendKeys("test");
		loginBtn.click();	
	}
	
	public void forgotusername_click() {
		forgotusername.click();
	}
	
	public void forgotpwd_click() {
		forgotpassword.click();
	}
	
	public void forgotpwdlabel() {
		forgotpasswordlabel.isDisplayed();
	}
	
	public void forgotusernamelabel() {
		forgotusernamelabel.isDisplayed();
	}
	
	public void internaluserinvalidcreds_validation() {
		String actualuname = username.getText();
		String expecteduname ="";
		Assert.assertEquals(expecteduname,actualuname);
		String actualpwd = password.getText();
		String expectedpwd ="";
		Assert.assertEquals(actualpwd,expectedpwd);
	}
	
	
}