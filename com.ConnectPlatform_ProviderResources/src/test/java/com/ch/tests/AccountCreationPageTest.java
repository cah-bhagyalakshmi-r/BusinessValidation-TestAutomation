package com.ch.tests;

import org.testng.annotations.AfterMethod;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.util.CommonMethods;

public class AccountCreationPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CommonMethods commonMethods;

	int defaultwaittime=15;
	int longerwaittime=30;
	public String testEnvironment = "staging"; // stage-phi, staging, or secure (prod)
	public String internalURL = "https://" + testEnvironment + ".outcomesmtm.com/internal/index.cfm?event=logout";

	public AccountCreationPageTest(){
		super();			
	}

	//@Test(description= "Account creation error for username an password verification", priority = 1, groups = {"Regression"})
	public void accountverification_usernameandpassword_errorValidation() throws IOException, InterruptedException, ParseException
	{	
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		commonMethods.implicitwait(10);
		loginPage.signup_click();
		Thread.sleep(3000);
		loginPage.registrationlabel_display();
		Thread.sleep(3000);
		loginPage.register_pwddetails();
		Thread.sleep(3000);
		loginPage.submitbutton_click();
		Thread.sleep(3000);
		loginPage.pwderrormsg();
		Thread.sleep(3000);
		loginPage.username_req();
		Thread.sleep(3000);
		loginPage.submitbutton_click();
		Thread.sleep(3000);
		loginPage.usernameerrormsg();
		Thread.sleep(3000);
	}

	//@Test(description= "Verify successful signup functionality for roles technician and pharmacyAdmin", priority = 2, groups = {"Regression"})
	public void techandpharmacyadminrole_signupsuccessfulValidation() throws IOException, InterruptedException, ParseException
	{	
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		commonMethods.implicitwait(10);
		loginPage.signup_click(); 
		Thread.sleep(3000);
		loginPage.registrationlabel_display();
		Thread.sleep(3000);
		loginPage.register_inputdetails();
		Thread.sleep(3000); 
		loginPage.submitbutton_click();
		Thread.sleep(3000); 
		loginPage.profdetails();
		Thread.sleep(3000); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,8000)", "");
		loginPage.dobandphone();
		Thread.sleep(3000); 
		String username =loginPage.registerusername.getAttribute("value");
		System.out.println("New username is:" +username);
		loginPage.submitbutton_click();
		Thread.sleep(3000);
		loginPage.signupsuccessmsg(); 
		Thread.sleep(3000);
		driver.navigate().to(internalURL);
		Thread.sleep(3000);
		dashboardPage = loginPage.login(prop.getProperty("intusername"), prop.getProperty("intpassword"));
		Thread.sleep(3000);
		loginPage.manageuseraccount_click();
		Thread.sleep(3000);
		loginPage.manageuseraccountusername.sendKeys(username);
		Thread.sleep(3000);
		loginPage.manageuser_Searchbutton();
		Thread.sleep(3000);
		loginPage.roleslist_validation();
		Thread.sleep(3000);
	}

	//@Test(description= "Verify successful signup functionality for roles pharmacist and client", priority = 3, groups = {"Regression"})
	public void pharmacistandclientrole_signupsuccessfulValidation() throws IOException, InterruptedException, ParseException
	{	
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		Thread.sleep(3000);
		loginPage.signup_click(); 
		Thread.sleep(3000);
		loginPage.registrationlabel_display();
		Thread.sleep(3000);
		loginPage.register_inputdetails();
		Thread.sleep(3000);
		loginPage.roles_click1();
		Thread.sleep(3000);
		loginPage.submitbutton_click(); 
		Thread.sleep(3000);
		loginPage.profdetails(); 
		Thread.sleep(3000); 
		loginPage.pharmacydetails(); 
		Thread.sleep(3000);
		String username =loginPage.registerusername.getAttribute("value");
		System.out.println("New username is:" +username);
		loginPage.submitbutton_click(); 
		Thread.sleep(3000);
		loginPage.signupsuccessmsg(); 
		Thread.sleep(3000);
		driver.navigate().to(internalURL);
		Thread.sleep(3000);
		dashboardPage=loginPage.login(prop.getProperty("intusername"),prop.getProperty("intpassword"));
		Thread.sleep(3000);
		loginPage.manageuseraccount_click();
		Thread.sleep(3000);
		loginPage.manageuseraccountusername.sendKeys(username);
		Thread.sleep(3000);
		loginPage.manageuser_Searchbutton();
		Thread.sleep(3000);
		loginPage.roleslist_validation1();
		Thread.sleep(3000);
	}

	@Test(description= "Verify manageuseraccounts access and links validation", priority = 4, groups = {"Regression"})
	public void manageuseraccountslinksandaccess_validation() throws IOException, InterruptedException, ParseException
	{	
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		Thread.sleep(3000);
		driver.navigate().to(internalURL);
		Thread.sleep(3000);
		dashboardPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(3000);
		loginPage.manageuseraccount_click();
		Thread.sleep(3000);
		loginPage.manageuseraccountusername.sendKeys("testaccount635");
		Thread.sleep(3000);
		loginPage.manageuser_Searchbutton();
		Thread.sleep(3000);
		loginPage.securityquestions_validation();
		Thread.sleep(3000);
		loginPage.manageusername_input();
		Thread.sleep(3000);
		loginPage.manageuser_Searchbutton();
		Thread.sleep(3000);
		loginPage.viewlicenses_validation();
		Thread.sleep(3000);
		loginPage.actionloginasuser_validation(); 
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(browserTabs .get(1));
		Thread.sleep(5000);
		loginPage.dashboard.isDisplayed();
		System.out.println("Dashboard page is displayed"); 
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
		Thread.sleep(3000);
		loginPage.actioneditprofile_validation();
		Thread.sleep(3000);
		List<String> browserTabs1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(browserTabs1.get(1));
		Thread.sleep(3000);
		loginPage.profileheader();
		System.out.println("Profile page is displayed"); 
		driver.close();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}

}


