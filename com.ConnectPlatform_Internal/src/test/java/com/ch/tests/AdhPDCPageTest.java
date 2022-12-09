package com.ch.tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ch.base.TestBase;
import com.ch.pages.AdhPDCPage;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.util.CommonMethods;

import junit.framework.Assert;

public class AdhPDCPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	AdhPDCPage adherencepdcrulesPage;
	CommonMethods commonMethods;

	int defaultwaittime=35;
	int normalwaittime=5;

	public AdhPDCPageTest(){
		super();			
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {		
		internalinitialization();
		adherencepdcrulesPage = new AdhPDCPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(description = "Adherence PDC Rules- create,Edit,lookback change and pdcstatus off Validation", priority =1, groups = {"Regression"})
	public void adherencepdcaddandeditrules_Validation() throws IOException, InterruptedException, ParseException
	{	
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.adherencepdcrules_click();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.adherencepdcrulesfields_display();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.newpdcrule_click();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.adherencepdcrulename_input();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.rxrule_input();	
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.rxrule_selectrecord();
		commonMethods.implicitwait(defaultwaittime);
		String adherencerulename=adherencepdcrulesPage.adherencerulenameinput.getAttribute("value");
		System.out.println("adherence rulename:" +adherencerulename);
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.submit_click();
		System.out.println("New PDC rule created successfully: " +adherencerulename);
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.searchinput.sendKeys(adherencerulename);
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.editrecord_click();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.lookback_change();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.rxrule_inputchange();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.rxrule_selectrecord();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.submit_click();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.searchinput.sendKeys(adherencerulename);
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.editrecord_click();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.pdcstatus_click();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.submit_click();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.searchinput.sendKeys(adherencerulename);
		commonMethods.implicitwait(defaultwaittime);
		String pdcstatus= adherencepdcrulesPage.statusvalue.getAttribute("innerText");
		System.out.println("PDC Status changed to :" +pdcstatus);
		commonMethods.implicitwait(defaultwaittime);
		Assert.assertEquals("Off", pdcstatus);	
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.editrecord_click();
		adherencepdcrulesPage.lookback.isSelected();
		System.out.println("lookback status is changed to year to date");
		String rxrulechange= adherencepdcrulesPage.rxruleinput.getAttribute("value");
		if(rxrulechange.contains("ip")) {
			System.out.println("Rx rule has been changed");}
		else {
		    System.out.println("Rx rule has not been changed");	
		}
		
	}

	@Test(description = "Adherence PDC rules export results Validation", priority =2, groups = {"Regression"})
	public void adherencepdcrules_exportexcelresults_Validation() throws IOException, InterruptedException, ParseException
	{	
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.adherencepdcrules_click();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.adherencepdcrulesfields_display();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.downloadexcel_click();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.getRecordsCountInExcel_downloadtoexcel();
		commonMethods.implicitwait(defaultwaittime);
		adherencepdcrulesPage.delete_file();
		commonMethods.implicitwait(defaultwaittime);
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
}


