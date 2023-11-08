package com.ch.tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.base.TestBase;
import com.ch.pages.ClaimsSubmissionPage;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.PersonalInfoPage;
import com.ch.pages.TIPPage;
import com.ch.util.CommonMethods;

import junit.framework.Assert;

public class UnfinishedClaimsPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	ClaimsSubmissionPage claimssubmissionPage;
	TIPPage tipPage;
	PersonalInfoPage patientprofilePage;
	CommonMethods commonMethods;

	int normalWaitTime = 35;
	int defaultWaitTime = 30;
	String reason;

	String deletetipquery;

	public UnfinishedClaimsPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		claimssubmissionPage = new ClaimsSubmissionPage();
		tipPage = new TIPPage();
		patientprofilePage = new PersonalInfoPage();
		commonMethods = new CommonMethods();
		commonMethods.implicitwait(normalWaitTime);
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(description ="Verification of successful submission of unfinished clams workflow", groups = {"Sanity", "Regression"}, priority =1)
	public void unfinishedclaims_successfulValidation1() throws InterruptedException, IOException, ParseException {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		commonMethods.implicitwait(defaultWaitTime);
		dashboardPage.searchtext.sendKeys("MTM0021");
		commonMethods.implicitwait(defaultWaitTime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		commonMethods.implicitwait(defaultWaitTime);
		Thread.sleep(8000); 
		commonMethods.implicitwait(normalWaitTime);
		patientprofilePage.clickStartClaim();
		commonMethods.implicitwait(normalWaitTime);
		claimssubmissionPage.selectReason();
		commonMethods.implicitwait(normalWaitTime); Select dropdown = new
				Select(claimssubmissionPage.reasonDropdownLocator); 
				WebElement abc=dropdown.getFirstSelectedOption(); 
				reason= abc.getText();
				System.out.println("selected reason: " + reason);
				claimssubmissionPage.selectService();
				commonMethods.implicitwait(normalWaitTime);
				claimssubmissionPage.selectOutcome_input();
				commonMethods.implicitwait(normalWaitTime);
				claimssubmissionPage.datepickerfortip_sendkeys();
				commonMethods.implicitwait(normalWaitTime);
				claimssubmissionPage.clickNextButton();
				commonMethods.implicitwait(defaultWaitTime);
				claimssubmissionPage.selectMedication("Other");
				commonMethods.implicitwait(defaultWaitTime); tipPage.medinput();
				commonMethods.implicitwait(defaultWaitTime); tipPage.medselect();
				commonMethods.implicitwait(defaultWaitTime);
				claimssubmissionPage.clickNextMedButton();
				commonMethods.implicitwait(defaultWaitTime);
				claimssubmissionPage.leaveclaimpending_click();
				commonMethods.implicitwait(defaultWaitTime);
				claimssubmissionPage.pharmacistaction_click();
				commonMethods.implicitwait(defaultWaitTime);
				claimssubmissionPage.saveandcontinue_click();
				commonMethods.implicitwait(defaultWaitTime);
				String unfinishedclaim= tipPage.unfinishedclaimlistheader.getText();
				System.out.println("Unfinished claims header:" +unfinishedclaim);

				String unfinishedclaim2=
						tipPage.unfinishedclaimlistheader.getAttribute("textContent");
				System.out.println("Unfinished claims header2:" +unfinishedclaim2);

				String unfinishedclaim3=
						tipPage.unfinishedclaimlistheader.getAttribute("innerHTML");
				System.out.println("Unfinished claims header3:" +unfinishedclaim3);

				String unfinishedclaim4=
						tipPage.unfinishedclaimlistheader.getAttribute("value");
				System.out.println("Unfinished claims header4:" +unfinishedclaim4);

				String unfinishedclaim5=
						tipPage.unfinishedclaimlistheader.getAttribute("innerText");
				System.out.println("Unfinished claims header5:" +unfinishedclaim5);
				String unfinishedclaim1= tipPage.unfinishedclaimlistheader.getText().trim().substring(0,1);
				System.out.println("Unfinished claims header1:" +unfinishedclaim1);
				int availableclaims=Integer.parseInt(unfinishedclaim1);
				System.out.println("Available Claims: " + availableclaims);
				for (int j = 1; j <= availableclaims; j++) 
				{
					//if (driver.findElement(By.cssSelector("md-list-item:nth-of-type(" + j + ") .ember-view.flex .opportunity-name")).getText().contains("Adherence"))
					if (driver.findElement(By.cssSelector("md-list-item:nth-of-type(" + j + ") .ember-view.flex .opportunity-name")).getAttribute("textContent").contains("Adherence - "))
					{
						Thread.sleep(5000);
						WebElement element = driver.findElement(By.cssSelector("md-list-item:nth-of-type(" + j + ") .ember-view.flex .opportunity-name"));
						Actions actions = new Actions(driver);
						actions.moveToElement(element).click().build().perform();							
						//driver.findElement(By.cssSelector("md-list-item:nth-of-type(" + j + ") .ember-view.flex .opportunity-name")).click();
						commonMethods.implicitwait(normalWaitTime);
						claimssubmissionPage.clickContinueButton();
						commonMethods.implicitwait(normalWaitTime);
						claimssubmissionPage.clickSubmitClaimButton();
						System.out.println("Unfinished claim flow completed successfully.");
						commonMethods.implicitwait(defaultWaitTime);
						claimssubmissionPage.mtmclaimshistory_click();
						commonMethods.implicitwait(defaultWaitTime);
						claimssubmissionPage.searchbydate();
						commonMethods.implicitwait(defaultWaitTime);
						claimssubmissionPage.deleteclaimrow_click();
						commonMethods.implicitwait(defaultWaitTime);
						JavascriptExecutor js1 = (JavascriptExecutor) driver;
						js1.executeScript("window.scrollBy(0,8000)", "");
						claimssubmissionPage.cancelclaim1_click();
						commonMethods.implicitwait(defaultWaitTime);
						claimssubmissionPage.okbutton_click();
						commonMethods.implicitwait(defaultWaitTime);	
						break;
					} 
				}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
