package com.ch.tests;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.MedEngPage;
import com.ch.pages.TIPPerfPage;
import com.ch.util.CommonMethods;

public class MedEngPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	MedEngPage medicalrulesenginePage;
	CommonMethods commonMethods;

	int defaultwaittime=25;
	int normalwaittime=5;

	public MedEngPageTest(){
		super();			
	}
	
	@Test(description = "Medical Rules Engine Add rule Validation", priority =1, groups = {"Regression"})
	public void Medicalrulesengine_addrule_Validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		medicalrulesenginePage = new MedEngPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.medicalrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.medicalrulesenginefields_display();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.newrule_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.newrule_inputdetails();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.createrulesuccessmsg_validation();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.addforapproval_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.okbutton_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.addforapprovalmsg_validation();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.logout_click();
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage = loginPage.login(prop.getProperty("intusername"), prop.getProperty("intpassword"));
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.medicalrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.existingrule_input();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.firstrec_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.approverule_validation();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.deleterule_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.okbutton_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.deleterulesuccessmsg_validation();
		commonMethods.implicitwait(defaultwaittime);
	}


	@Test(description = "Medical Rules Engine edit rule Validation", priority =3, groups = {"Regression"})
	public void Medicalrulesengine_editrule_Validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		medicalrulesenginePage = new MedEngPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.medicalrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.medicalrulesenginefields_display();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.firstrec_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.editrule_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.effdate_clear();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.effectivedate_input();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.notesinput();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.diagnosiscode_edit();
		commonMethods.implicitwait(defaultwaittime);
		String diagnosisinpt= medicalrulesenginePage.diagnoscode.getAttribute("value");
		medicalrulesenginePage.preview_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.savebutton_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.okbutton_click();
		Thread.sleep(5000);
		String actdiagnosisinpt= medicalrulesenginePage.diagnoscode.getAttribute("value");
		//medicalrulesenginePage.editrulesuccessmsg_validation();
		Assert.assertEquals(diagnosisinpt, actdiagnosisinpt);
		System.out.println("Rule edited successfully");
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.notesdrpdown_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.delete_click();	
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.addforapproval_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.okbutton_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.addforapprovalmsg_validation();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.logout_click();
		commonMethods.implicitwait(defaultwaittime);
		dashboardPage = loginPage.login(prop.getProperty("intusername"), prop.getProperty("intpassword"));
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.medicalrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.firstrec_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.approverule_validation();
		commonMethods.implicitwait(defaultwaittime);
	}
	
	@Test(description = "Medical Rules Engine export rule Validation", priority =5, groups = {"Regression"})
	public void Medicalrulesengine_exportall_Validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		medicalrulesenginePage = new MedEngPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.medicalrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.medicalrulesenginefields_display();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.exportall_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.getRecordsCountInCSV_exportallrule();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.delete_file();
		commonMethods.implicitwait(defaultwaittime);
	}
	
	@Test(description = "Medical Rules Engine export individual rule Validation", priority =4, groups = {"Regression"})
	public void Medicalrulesengine_exportindividualrule_Validation() throws IOException, InterruptedException, ParseException
	{	
		internalinitialization();
		medicalrulesenginePage = new MedEngPage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.medicalrulesengine_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.medicalrulesenginefields_display();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.firstrec_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.preview_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.exportindividual_click();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.getRecordsCountInCSV_exportindividualrule();
		commonMethods.implicitwait(defaultwaittime);
		medicalrulesenginePage.delete_file_individualrule();
		commonMethods.implicitwait(defaultwaittime);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
}


