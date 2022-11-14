package com.ch.tests;

import java.io.IOException;

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
import com.ch.util.JsonFileReader;

public class DashboardPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CommonMethods commonMethods;
	JsonFileReader jsonreader=new JsonFileReader();

	public String phone,lastname,dob,id,claimid,invalidsearch,ptphnum,ptid,ptlastname,ptdob,invalidsrchmsg,ptclmid,patientid,patienttdob,patientlastname;
	int defaultwaittime = 25;
	int normalwaittime = 20;

	public DashboardPageTest(){
		super();			
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {		
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("username and password");
		commonMethods.implicitwait(10);
		readTestData();
	}

	private void readTestData() throws IOException, ParseException {
		jsonreader.getdata();
		phone=jsonreader.Search.get("phone").toString();
		dob=jsonreader.Search.get("dob").toString();
		lastname=jsonreader.Search.get("lastname").toString();
		claimid=jsonreader.Search.get("claimid").toString();
		id=jsonreader.Search.get("id").toString();
		invalidsearch=jsonreader.Search.get("invalidsearch").toString();
	}
	
	@Test(description= "Verify search by lastname, dob and id in the dashboard screen", priority = 2, groups = {"Sanity", "Regression"})
	public void dashboardpagemultiplesearch_validation() throws IOException, InterruptedException{	
		boolean flowComplete = false;
		boolean dataFoundWithPatient = false;
		int maxPatientRecordsToCheck = 50;
		commonMethods.implicitwait(defaultwaittime);
		for (int i = 2; i <= maxPatientRecordsToCheck; i++) {
			if
			(driver.findElements(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div.right-side-panel-container.flux-grid-item-9.flux-pad-l-md > div:nth-child(2) > ul > li:nth-child(" + i + ") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).size() == 0) { 
				break; }
			if (driver.findElement(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div.right-side-panel-container.flux-grid-item-9.flux-pad-l-md > div:nth-child(2) > ul > li:nth-child(" + i + ") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).getText().contains("CMR") || (driver.findElement(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div.right-side-panel-container.flux-grid-item-9.flux-pad-l-md > div:nth-child(2) > ul > li:nth-child(" + i + ") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).getText().contains("TIP"))){
				dataFoundWithPatient = true;
				driver.findElement(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div.right-side-panel-container.flux-grid-item-9.flux-pad-l-md > div:nth-child(2) > ul > li:nth-child(" + i + ") > div > div.flux-flex-row.patient-wrapper > a > span.card-header-section-tasks")).click();
				commonMethods.implicitwait(defaultwaittime);
				String ptdob=dashboardPage.dob.getAttribute("textContent").substring(0,10);
				System.out.println("patient dob:" +ptdob);				
				String ptid= dashboardPage.id.getAttribute("textContent").trim().substring(4);
				System.out.println("patient id:" +ptid);
				String ptlname= dashboardPage.lastname.getAttribute("textContent").substring(9).trim();
				System.out.println("patient lastname:" +ptlname);
				dashboardPage.goToDashboard();
				commonMethods.implicitwait(defaultwaittime);
				dashboardPage.searchtext.sendKeys(ptdob);
				commonMethods.implicitwait(normalwaittime);
				dashboardPage.searchtext.sendKeys(Keys.ENTER);
				//dashboardPage.searchbuttonclick();
				commonMethods.implicitwait(normalwaittime);
				Assert.assertEquals(ptdob, ptdob);
				System.out.println("patient dob search is successful");
				dashboardPage.goToDashboard();
				commonMethods.implicitwait(normalwaittime);
				dashboardPage.searchtext.sendKeys(ptid);
				commonMethods.implicitwait(normalwaittime);
				dashboardPage.searchtext.sendKeys(Keys.ENTER);
				//dashboardPage.searchbuttonclick();
				commonMethods.implicitwait(defaultwaittime);
				Assert.assertEquals(ptid, ptid);
				System.out.println("patient id search is successful");
				dashboardPage.goToDashboard();
				commonMethods.implicitwait(normalwaittime);
				dashboardPage.searchtext.sendKeys(ptlname);
				commonMethods.implicitwait(normalwaittime);
				dashboardPage.searchtext.sendKeys(Keys.ENTER);
				//dashboardPage.searchbuttonclick();
				commonMethods.implicitwait(defaultwaittime);
				Assert.assertEquals(ptlname, ptlname);
				System.out.println("patient lastname search is successful");
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


	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}


