package com.ch.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.util.CommonMethods;

public class MTMDashboardPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CommonMethods commonMethods;

	int defaultwaittime=20;
	int normalwaittime=25;

	public MTMDashboardPageTest(){
		super();			
	}


	//@Test(description= "Verify mtmdashboard- SwitchPharmacies, Pagination and Search Validation", priority = 1, groups = {"Regression"})
	public void mtmcenterdashboard_searchAndswitchpharmachAndPagevalidation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		commonMethods.implicitwait(defaultwaittime);
		loginPage.manageuseraccount_click();
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.manageusername_input1();
		commonMethods.implicitwait(defaultwaittime);
		loginPage.manageuser_Searchbutton();
		commonMethods.implicitwait(defaultwaittime);
		loginPage.actionloginasuser_validation();
		commonMethods.implicitwait(defaultwaittime);
		Set<String> handles=driver.getWindowHandles();
		String currentHandle= driver.getWindowHandle();
		boolean flowComplete = false;
		boolean dataFoundWithPatient = false;
		int maxPatientRecordsToCheck = 50;
		for(String actual: handles) {
			if(!actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.usermenuclick();
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.switchpharmacy_validation();
				commonMethods.implicitwait(defaultwaittime);
				for (int i = 2; i <= maxPatientRecordsToCheck; i++) {
					WebElement root = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/my-pharmacy-component"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
					js.executeScript("window.scrollBy(0,5000)", "");
					Thread.sleep(4000);
					WebElement pageselection= shadowroot.findElement(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div > div:nth-child(2) > div > div.paging-info-per-page.flux-flex.flex-align-items-center > div.v-popover > div > div > div"));
					pageselection.click();
					WebElement pageselection1= driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div[1]/div/div/div/div[2]"));
					pageselection1.click();
					commonMethods.implicitwait(defaultwaittime);
					commonMethods.implicitwait(defaultwaittime);
					dashboardPage.pagination_validation();
					commonMethods.implicitwait(defaultwaittime);
					System.out.println("Maximum number of patients-50 are viewed");
					js.executeScript("window.scrollBy(0,-5000)", "");	
					commonMethods.implicitwait(normalwaittime);
					if
					(shadowroot.findElements(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div > div:nth-child(2) > ul > li:nth-child("+ i +") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).size() == 0) { 
						break; }
					commonMethods.implicitwait(defaultwaittime);
					if (shadowroot.findElement(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div > div:nth-child(2) > ul > li:nth-child("+ i +") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).getText().contains("CMR") || (shadowroot.findElement(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div > div:nth-child(2) > ul > li:nth-child("+ i +") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).getText().contains("TIP"))){
						dataFoundWithPatient = true;
						shadowroot.findElement(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div > div:nth-child(2) > ul > li:nth-child("+ i +") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).click();
						commonMethods.implicitwait(normalwaittime); 
						String ptid= dashboardPage.id.getAttribute("textContent").trim().substring(4);
						System.out.println("patient id:" +ptid);
						dashboardPage.goToDashboard();
						commonMethods.implicitwait(normalwaittime);
						dashboardPage.searchtext.sendKeys(ptid);
						commonMethods.implicitwait(normalwaittime);
						//dashboardPage.searchbuttonclick();
						dashboardPage.searchtext.sendKeys(Keys.ENTER);
						commonMethods.implicitwait(normalwaittime);
						String ptid1= dashboardPage.id.getAttribute("textContent").trim().substring(4);
						AssertJUnit.assertEquals(ptid, ptid1);
						System.out.println("patient id search is successful");
						dashboardPage.goToDashboard();
						commonMethods.implicitwait(normalwaittime);
						flowComplete = true;
						break;
					} 
					else {
						dataFoundWithPatient = false;
						System.out.println("CMR or TIP not present in the patient record.");
					}
					if (flowComplete) {
						break;
					} else if (dataFoundWithPatient) {
						dashboardPage.goToDashboard();
						commonMethods.implicitwait(defaultwaittime);
					}
				}		
				
			}
		}}	
	
	//@Test(description= "Verify mtmdashboardvalidation", priority = 1, groups = {"Regression"})
	public void mtmcenterdashboard_validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		commonMethods.implicitwait(defaultwaittime);
		loginPage.manageuseraccount_click();
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.manageusername_input1();
		commonMethods.implicitwait(defaultwaittime);
		loginPage.manageuser_Searchbutton();
		commonMethods.implicitwait(defaultwaittime);
		loginPage.actionloginasuser_validation();
		commonMethods.implicitwait(defaultwaittime);
		Set<String> handles=driver.getWindowHandles();
		String currentHandle= driver.getWindowHandle();
		for(String actual: handles) {
			if(!actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.oppurtunitysummary_validation1();
				commonMethods.implicitwait(normalwaittime);
			}
			driver.close();
		}}

	
	//@Test(description= "Verify mtmdashboardvalidation", priority = 1, groups = {"Regression"})
	public void mtmcenterdashboard_validation1() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		commonMethods.implicitwait(defaultwaittime);
		loginPage.manageuseraccount_click();
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.manageusername_input1();
		commonMethods.implicitwait(defaultwaittime);
		loginPage.manageuser_Searchbutton();
		commonMethods.implicitwait(defaultwaittime);
		loginPage.actionloginasuser_validation();
		commonMethods.implicitwait(defaultwaittime);
		Set<String> handles=driver.getWindowHandles();
		String currentHandle= driver.getWindowHandle();
		for(String actual: handles) {
			if(!actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);
				commonMethods.implicitwait(normalwaittime);
				dashboardPage.oppurtunitysummary_validation();
				commonMethods.implicitwait(normalwaittime);
			}
			//driver.close();
		}}	


	@Test(description= "Verify mtmcenter menu validation", priority = 1, groups = {"Regression"})
	public void mtmcentermenu_validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		commonMethods.implicitwait(defaultwaittime);
		loginPage.manageuseraccount_click();
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.manageusername_input1();
		commonMethods.implicitwait(defaultwaittime);
		loginPage.manageuser_Searchbutton();
		commonMethods.implicitwait(defaultwaittime);
		loginPage.actionloginasuser_validation();
		commonMethods.implicitwait(defaultwaittime);
		Set<String> handles=driver.getWindowHandles();
		String currentHandle= driver.getWindowHandle();
		for(String actual: handles) {
			if(!actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.mainmenuclick();
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.resources_validation();
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.usermenuclick();
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.managepharmacy_validation();
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.usermenuclick();
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.accountsecurity_validation();
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.usermenuclick();
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.profileheader_validation();
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.usermenuclick();
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.switchroles_validation();
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.usermenuclick();
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.logout_validation();
				commonMethods.implicitwait(defaultwaittime);
				driver.close();
			}
		}
	}

	//@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}

}


