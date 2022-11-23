package com.ch.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.PolicyEnginePage;
import com.ch.util.CommonMethods;

public class PolicyPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	PolicyEnginePage policyenginePage;
	CommonMethods commonMethods;

	int defaultwaittime=35;
	int normalwaittime=5;

	public PolicyPageTest(){
		super();			
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {		
		internalinitialization();
		policyenginePage = new PolicyEnginePage();
		loginPage = new LoginPage();
		commonMethods = new CommonMethods();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(description = "Policy Engine- Export tip from policy level validation", priority =1, groups = {"Regression"})
	public void policyengine_exportipfrompolicylevel_Validation() throws IOException, InterruptedException, ParseException
	{	
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.policyengine_click();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.policyengine_fieldvalidation();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.firstrec_click();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.tipsmenu_click();	
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.tip_downloadtoexcel();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.getRecordsCountInCSV_exporttoexcel();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.delete_file();
		commonMethods.implicitwait(defaultwaittime);		
	}

	@Test(description = "Policy Engine- Bulk tip export validation", priority =2, groups = {"Regression"})
	public void policyengine_bulktipexport_Validation() throws IOException, InterruptedException, ParseException, AWTException
	{	
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.policyengine_click();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.policyengine_fieldvalidation();
		commonMethods.implicitwait(defaultwaittime);;
		policyenginePage.bulktip_exporttoexcel();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.firstrecbulkpolicy_click();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.bulktip_downloadtoexcel();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.getRecordsCountInCSV_bulkpolicyexporttoexcel();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.delete_file();
		commonMethods.implicitwait(defaultwaittime);		
	}

	@Test(description = "Policy Engine- Tip customization validation", priority =3, groups = {"Regression"})
	public void policyengine_tipcustomization_Validation() throws IOException, InterruptedException, ParseException
	{	
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.policyengine_click();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.policyengine_fieldvalidation();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.search_input();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.firstrec_click();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.tipsmenu_click();	
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.searchtip_input();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.tipcustom_click();		
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.edittipcustom_click();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.nin_check();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.nindays_input();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.tipsave_click();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.tipsavemsg_validation();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.nin_check();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.tipsave_click();
		commonMethods.implicitwait(defaultwaittime);
	}

	@Test(description = "Policy Engine- Associating tip validation", priority =4, groups = {"Regression"})
	public void policyengine_associatingtip_Validation() throws IOException, InterruptedException, ParseException
	{	
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.policyengine_click();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.policyengine_fieldvalidation();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.firstrec_click();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.tipsmenu_click();	
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.editpolicy_click();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.searchtip_input();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.editpolicy_check();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.edittipsave_click();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.tipsavemsg_validation();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.searchtip_input();
		Thread.sleep(3000);
		policyenginePage.editpolicy_check();
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.edittipsave_click();	
		commonMethods.implicitwait(defaultwaittime);
		policyenginePage.searchtip_input();
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,5000)", "");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
}


