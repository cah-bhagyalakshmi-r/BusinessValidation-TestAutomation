package com.ch.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.RxRulesPage;
import com.ch.util.CommonMethods;

public class RxEnginePageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	RxRulesPage rxrulesenginePage;
	CommonMethods commonMethods;

	int defaultwaittime=35;
	int normalwaittime=5;

	public RxEnginePageTest(){
		super();			
	}

	@Test(description = "Rx Rules Engine Add rule Validation", priority =1, groups = {"Regression"})
	public void rxrulesengine_addrule_Validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		rxrulesenginePage = new RxRulesPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.rxrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.rxrulesenginefields_display();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.newrule_click();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.newrule_inputdetails();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.preview_click();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.preview_display();
		commonMethods.implicitwait(defaultwaittime); 
		String rxrulename=rxrulesenginePage.rulenameinput.getAttribute("value");
		System.out.println("adherence rulename:" +rxrulename);
		rxrulesenginePage.save(); commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.rulesuccessmsg_validation();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.addforapproval_validation();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.logout_click();
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage = loginPage.login(prop.getProperty("intusername"), prop.getProperty("intpassword"));
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.rxrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		String before_xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["; 
		String after_xpath = "]/td[1]";
		List rows = driver.findElements(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr"));
		int rowSize = rows.size();
		System.out.println(rowSize);
		for (int i = 1; i <= rowSize; i++) {
			String firstNames = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getAttribute("innerHTML");
			if (firstNames.contains(rxrulename)) {
				driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[" + i + "]/td[1]")).click(); 
				break;
			}
		}
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.approverule_validation();
		commonMethods.implicitwait(defaultwaittime);

	}

	@Test(description = "Rx Rules Engine edit rule Validation", priority =2, groups = {"Regression"})
	public void rxrulesengine_editrule_Validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		rxrulesenginePage = new RxRulesPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password")); commonMethods.implicitwait(defaultwaittime);
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.rxrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.rxrulesenginefields_display();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.firstrec_click();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.editrule_click();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.notesinput();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.diagnosiscode_edit();
		commonMethods.implicitwait(defaultwaittime);
		String diagnosisinpt= rxrulesenginePage.diagnoscode.getAttribute("value");
		rxrulesenginePage.saverule_click();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.saveruleagree_click();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.savedraftedrule_click();
		commonMethods.implicitwait(defaultwaittime);
		String actdiagnosisinpt= rxrulesenginePage.diagnoscode.getAttribute("value");
		Thread.sleep(3000);
		rxrulesenginePage.rulesuccessmsg_validation();
		Assert.assertEquals(diagnosisinpt, actdiagnosisinpt);
		System.out.println("rule was edited successfully");	
		commonMethods.implicitwait(defaultwaittime);	
		rxrulesenginePage.addforapproval_validation();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.logout_click();
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage = loginPage.login(prop.getProperty("intusername"), prop.getProperty("intpassword"));
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.rxrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.firstrec_click();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.approverule_validation();
		commonMethods.implicitwait(defaultwaittime);
		
	}

	//@Test(description = "Rx Rules Engine export rule Validation", priority =3, groups = {"Regression"})
	public void rxrulesengine_exportrule_Validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		rxrulesenginePage = new RxRulesPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password")); commonMethods.implicitwait(defaultwaittime);
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.rxrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.rxrulesenginefields_display();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.firstrec_click();
		commonMethods.implicitwait(defaultwaittime);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,5000)", "");
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.resultset_validation();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.exporttoexcel_click();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.getRecordsCountInCSV_exportrule();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.delete_file();
		commonMethods.implicitwait(defaultwaittime);
	}

	//@Test(description = "Rx Rules Engine drug lookup Validation", priority =4, groups = {"Regression"})
	public void rxrulesengine_druglookup_Validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		rxrulesenginePage = new RxRulesPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password")); commonMethods.implicitwait(defaultwaittime);
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.rxrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.druglookup_click();
		commonMethods.implicitwait(defaultwaittime);
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(browserTabs .get(1)); 
		//driver.switchTo().window(browserTabs .get(0));
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.druglookup_input();
		commonMethods.implicitwait(defaultwaittime);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,5000)", "");
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.resultset1_validation();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.druglookup_exporttoexcel();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.getRecordsCountInCSV_exportrule1();
		commonMethods.implicitwait(defaultwaittime);
		rxrulesenginePage.delete_file();
		commonMethods.implicitwait(defaultwaittime);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
}


