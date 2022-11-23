package com.ch.tests;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.ReasoncodeTIPconfigurationPage;
import com.ch.pages.RefusalreasonPage;
import com.ch.pages.TIPPerformancePage;
import com.ch.util.CommonMethods;

import junit.framework.Assert;

public class RefusalPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	RefusalreasonPage refusalreasonPage;
	CommonMethods commonMethods;

	int defaultwaittime=15;
	int normalwaittime=5;

	public RefusalPageTest(){
		super();			
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {		
		internalinitialization();
		refusalreasonPage = new RefusalreasonPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(description = "Refusal reason view Validation", priority =2, groups = {"Regression"})
	public void refusalreasonview_Validation() throws IOException, InterruptedException, ParseException
	{	
		commonMethods.implicitwait(defaultwaittime);
		refusalreasonPage.refusalreasons_click();
		commonMethods.implicitwait(defaultwaittime);
		refusalreasonPage.refusalreasons_fieldvalidation();
		commonMethods.implicitwait(defaultwaittime);
		Select selectreason = new Select(refusalreasonPage.selectreasontype);
		selectreason.selectByIndex(1);	
		WebElement selreason = selectreason.getFirstSelectedOption();
		String selectreason1= selreason.getText();
		System.out.println("Reason:" +selectreason1);
		commonMethods.implicitwait(defaultwaittime);
		refusalreasonPage.selectresult();
		commonMethods.implicitwait(defaultwaittime);
		refusalreasonPage.search_click();
		commonMethods.implicitwait(defaultwaittime);
		String refusalresult= refusalreasonPage.reasonrec.getText().trim();
		System.out.println("Reason result:" +refusalresult);
		refusalreasonPage.resultec.isDisplayed();
		Assert.assertEquals(selectreason1, refusalresult);
		System.out.println("select reason type and result is displayed in search results");		
	}
	
	@Test(description = "Change Refusal reason and save Validation", priority =1, groups = {"Regression"})
	public void refusalreasonsave_Validation() throws IOException, InterruptedException, ParseException
	{	
		commonMethods.implicitwait(defaultwaittime);
		refusalreasonPage.refusalreasons_click();
		commonMethods.implicitwait(defaultwaittime);
		refusalreasonPage.refusalreasons_fieldvalidation();
		commonMethods.implicitwait(defaultwaittime);
		refusalreasonPage.selectreasontype();
		commonMethods.implicitwait(defaultwaittime);
		refusalreasonPage.selectresult();
		commonMethods.implicitwait(defaultwaittime);
		refusalreasonPage.search_click();
		commonMethods.implicitwait(defaultwaittime);
		refusalreasonPage.includedcheck();
		commonMethods.implicitwait(defaultwaittime);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)", "");
		commonMethods.implicitwait(defaultwaittime);
		refusalreasonPage.save_click();
		System.out.println("Included column value for refusalreasons is changed and saved successfully");		
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
}


