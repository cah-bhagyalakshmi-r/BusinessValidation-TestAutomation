package com.ch.tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.DxEngPage;
import com.ch.pages.LoginPage;
import com.ch.util.CommonMethods;

import junit.framework.Assert;

public class DxEngPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	DxEngPage dxrulesenginePage;
	CommonMethods commonMethods;

	int defaultwaittime=35;
	int normalwaittime=5;

	public DxEngPageTest(){
		super();			
	}

	@Test(description = "Dx Rules Engine Add rule Validation", priority =1, groups = {"Regression"})
	public void dxrulesengine_addrule_Validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		dxrulesenginePage = new DxEngPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods(); 
		dashboardPage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.dxrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.dxrulesenginefields_display();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.newrule_save();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.createrulesuccessmsg_validation();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.addforapproval_validation();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.logout_click();
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage = loginPage.login(prop.getProperty("intusername"), prop.getProperty("intpassword"));
		dxrulesenginePage.dxrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.existingstate_input();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.firstrec_click();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.approverule_validation();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.status_check();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.delete_click();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.okbutton_click();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.deleterulesuccessmsg_validation();
		commonMethods.implicitwait(defaultwaittime);
	}

	@Test(description = "Dx Rules Engine edit rule Validation", priority =2, groups = {"Regression"})
	public void dxrulesengine_editrule_Validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		dxrulesenginePage = new DxEngPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods(); 
		dashboardPage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.dxrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.dxrulesenginefields_display();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.firstrec_click();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.editrule_click();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.ruleselection_click();
		commonMethods.implicitwait(defaultwaittime);
		String rulesel= dxrulesenginePage.ruleselection.getText();
		System.out.println("rule selection:" +rulesel);
		dxrulesenginePage.addselection_click();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.editnotesinput();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.effectivedate_clear();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.effectivedate_input();
		commonMethods.implicitwait(defaultwaittime);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,-8000)", "");
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.savebutton_click();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.okbutton_click();
		Thread.sleep(2000);
		executor.executeScript("window.scrollBy(0,10000)", "");
		Thread.sleep(2000);
		//dxrulesenginePage.editrulesuccessmsg_validation();
		//String ruleselected= dxrulesenginePage.ruleselected.getText();
		System.out.println("rule selected is displayed:" +rulesel);
		commonMethods.implicitwait(defaultwaittime);
		//Assert.assertEquals(rulesel, ruleselected);
		Thread.sleep(2000);
		dxrulesenginePage.effectivedate_gettext();
		System.out.println("rule was edited successfully");			
	}

	//@Test(description = "Dx Rules Engine export individual rule Validation", priority =3, groups = {"Regression"})
	public void dxrulesengine_exportindividualrule_Validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		dxrulesenginePage = new DxEngPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods(); 
		dashboardPage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.dxrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.dxrulesenginefields_display();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.firstrec_click();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.exportrule_click();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.getRecordsCountInCSV_exportrule();
		commonMethods.implicitwait(defaultwaittime);
		dxrulesenginePage.delete_file();
		commonMethods.implicitwait(defaultwaittime);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
}