package com.ch.tests;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.TIPPage;
import com.ch.pages.TIPPerfPage;
import com.ch.util.CommonMethods;

public class TIPEnginePageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	TIPPage tipenginePage;
	CommonMethods commonMethods;

	XSSFWorkbook wb = null;
	XSSFSheet sh = null;

	int defaultwaittime=35;
	int normalwaittime=10;
	String tipname;

	public TIPEnginePageTest(){
		super();			
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {		
		internalinitialization();
		tipenginePage = new TIPPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(description = "Create and Edit tip Validation", priority =3, groups = {"Regression"})
	public void tipEngine_createandedittip_Validation() throws IOException, InterruptedException, ParseException
	{	
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.tipengine_click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.tip_fieldvalidation();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.tipdetails_input();
		commonMethods.implicitwait(defaultwaittime); String
		tipname=tipenginePage.tiptitleinput.getAttribute("value");
		System.out.println("tip name:" +tipname);
		commonMethods.implicitwait(defaultwaittime); 
		tipenginePage.savetip_click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.searchinput.sendKeys(tipname);
		commonMethods.implicitwait(defaultwaittime);
		String newtipcreated= tipenginePage.newtipdata.getText().trim();
		System.out.println("new tip created :" +newtipcreated);
		Assert.assertEquals(tipname, newtipcreated);
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.newtipdata.click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.edittip_click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.tipgeneration_change();
		commonMethods.implicitwait(defaultwaittime); 
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,-1000)", "");
		commonMethods.implicitwait(defaultwaittime); 
		tipenginePage.savetip_click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.editipsave_msgvalidation();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.searchinput.sendKeys(tipname);
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.newtipdata.click();
		commonMethods.implicitwait(defaultwaittime);
		js.executeScript("window.scrollBy(0,3000)", "");
		
	}
	
	@Test(description = "TipBuilder Validation", priority =3, groups = {"Regression"})
	public void tipEngine_tipbuildererror_Validation() throws IOException, InterruptedException, ParseException
	{	
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.tipengine_click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.searchinput.sendKeys("cardinalaccnt915");
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.newtipdata.click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.edittip_click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.tipbuildererror_validation();
		commonMethods.implicitwait(defaultwaittime);
	}

	@Test(description = "Edit copied tip Validation", priority =2, groups = {"Regression"})
	public void editcopiedtip_Validation() throws IOException, InterruptedException, ParseException
	{	
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.tipengine_click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.newtipdata.click();
		commonMethods.implicitwait(defaultwaittime); 
		tipenginePage.copytip_click();
		commonMethods.implicitwait(defaultwaittime); 
		tipenginePage.tittitle_input();
		commonMethods.implicitwait(defaultwaittime); 
		String copiedtip=tipenginePage.tiptitleinput.getAttribute("value");
		System.out.println("copied tip name:" +copiedtip);
		commonMethods.implicitwait(defaultwaittime); 
		tipenginePage.savetip_click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.copytipsave_msgvalidation();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.searchinput.sendKeys(copiedtip);
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.newtipdata.click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.edittip_click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.tipexpdays_change();
		commonMethods.implicitwait(defaultwaittime);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-2000)", "");
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.savetip_click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.editipsave_msgvalidation();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.searchinput.sendKeys(copiedtip);
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.newtipdata.click();
		js.executeScript("window.scrollBy(0,2000)", "");
		System.out.println("Copied tip is edited and saved successfuuly");
	}

	@Test(description = "Add, Edit and Delete Alternative- tip engine Validation", priority =1, groups = {"Regression"})
	public void addeditdelete_alternativetip_Validation() throws IOException, InterruptedException, ParseException
	{	
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.tipengine_click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.newtipdata.click();
		commonMethods.implicitwait(defaultwaittime); 
		tipenginePage.edittip_click();
		commonMethods.implicitwait(defaultwaittime); 
		tipenginePage.includealternatives_check();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.addalternative();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.savetip_click();
		System.out.println("Alternatives added successfully");
		commonMethods.implicitwait(defaultwaittime); 
		tipenginePage.newtipdata.click();
		commonMethods.implicitwait(defaultwaittime); 
		tipenginePage.edittip_click();
		commonMethods.implicitwait(defaultwaittime); 
		tipenginePage.alternatives_click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.addalternative_input();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-1000)", "");
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.savetip_click();
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.editipsave_msgvalidation();
		System.out.println("Alternatives edited successfully");
		commonMethods.implicitwait(defaultwaittime); 
		tipenginePage.newtipdata.click();
		commonMethods.implicitwait(defaultwaittime); 
		tipenginePage.edittip_click();
		commonMethods.implicitwait(defaultwaittime); 
		tipenginePage.alternatives_click();
		commonMethods.implicitwait(defaultwaittime);
		js.executeScript("window.scrollBy(0,1000)", "");
		tipenginePage.deletealternative_click();
		commonMethods.implicitwait(defaultwaittime);
		js.executeScript("window.scrollBy(0,-2000)", "");
		commonMethods.implicitwait(defaultwaittime);
		tipenginePage.savetip_click();
		commonMethods.implicitwait(defaultwaittime);
		System.out.println("Alternatives deleted successfuuly");
	}


	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
}


