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
	int defaultwaittime = 20;
	int normalwaittime = 25;

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
		//System.out.println("username and password");
		commonMethods.implicitwait(10);
		readTestData();
	}

	private void readTestData() throws IOException, ParseException {
		jsonreader.getdata();
		phone=JsonFileReader.Search.get("phone").toString();
		dob=JsonFileReader.Search.get("dob").toString();
		lastname=JsonFileReader.Search.get("lastname").toString();
		claimid=JsonFileReader.Search.get("claimid").toString();
		id=JsonFileReader.Search.get("id").toString();
		invalidsearch=JsonFileReader.Search.get("invalidsearch").toString();
	}
	
	@Test(description= "Verify search by lastname, dob and id in the dashboard screen", priority = 2, groups = {"Sanity", "Regression"})
	public void dashboardpagemultiplesearch_validation() throws IOException, InterruptedException{		
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys("CMR-a81c8e3b-ed79-4320-99e2-92ca820b8c5e");
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		commonMethods.implicitwait(defaultwaittime);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/pharmacy-patient-hub"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		WebElement dob= shadowroot.findElement(By.cssSelector(".flux-text-small"));
		
				String ptdob=dob.getAttribute("textContent").substring(0,10);
				System.out.println("patient dob:" +ptdob);	
				WebElement id= shadowroot.findElement(By.cssSelector("span[data-testid='displayid']"));
				String ptid= id.getAttribute("textContent").trim().substring(4);
				System.out.println("patient id:" +ptid);
				WebElement lastname= shadowroot.findElement(By.cssSelector(".patient-name.flux-text-display-sm"));
				String ptlname= lastname.getAttribute("textContent").substring(5).trim();
				System.out.println("patient lastname:" +ptlname);
				dashboardPage.goToDashboard();
				Thread.sleep(5000);
				dashboardPage.searchtext.sendKeys(ptdob);
				commonMethods.implicitwait(normalwaittime);
				//dashboardPage.searchbuttonclick();
				dashboardPage.searchtext.sendKeys(Keys.ENTER);
				commonMethods.implicitwait(normalwaittime);
				Assert.assertEquals(ptdob, ptdob);
				System.out.println("patient dob search is successful");
				dashboardPage.goToDashboard();
				commonMethods.implicitwait(normalwaittime);
				dashboardPage.searchtext.sendKeys(ptid);
				commonMethods.implicitwait(normalwaittime);
				//dashboardPage.searchbuttonclick();
				dashboardPage.searchtext.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				Assert.assertEquals(ptid, ptid);
				System.out.println("patient id search is successful");
				dashboardPage.goToDashboard();
				commonMethods.implicitwait(normalwaittime);
				dashboardPage.searchtext.sendKeys(ptlname);
				commonMethods.implicitwait(normalwaittime);
				//dashboardPage.searchbuttonclick();
				dashboardPage.searchtext.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				Assert.assertEquals(ptlname, ptlname);
				System.out.println("patient lastname search is successful");
				commonMethods.implicitwait(normalwaittime);				
		
	
		
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}


