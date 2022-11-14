package com.ch.tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.PrescriberfaxPage;
import com.ch.util.CommonMethods;

public class PrescriberfaxPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	PrescriberfaxPage prescriberfaxPage;
	CommonMethods commonMethods;

	int defaultWaittime = 45;
	int normalWaittime = 20;
	

	public PrescriberfaxPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		prescriberfaxPage = new PrescriberfaxPage();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}


	@Test(description = "Verify addingrecommendations and pdf validation", priority = 2, groups = { "Sanity", "Regression" })
	public void addingrecommendations_prescriberfax_validation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		//WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]"));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		//shadowroot.findElement(By.xpath(/html/body/div[2]/div/div[1]/div/div[1]/div/flux-icon//span).
		prescriberfaxPage.usermenuclick();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.roleselect("Physician");
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.searchtext.sendKeys("MTM0136");
		commonMethods.implicitwait(defaultWaittime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		//dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.prescriberfax_click();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.prescriberfax_Validation();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.addrecommendation_click();
		commonMethods.implicitwait(defaultWaittime);  
		prescriberfaxPage.additionalrecommendatation_input();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.createandsavedocument_click();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.usermenuclick1();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.switchroles1.click();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.roleselect1("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
	}
	
	
	@Test(description = "Verify preview document in prescriber fax page", priority = 3, groups = { "Sanity", "Regression" })
	public void previewdocument_prescriberfax_validation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.usermenuclick();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.roleselect("Physician");
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.searchtext.sendKeys("MTM0136");
		commonMethods.implicitwait(defaultWaittime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		//dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.prescriberfax_click();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.addrecommendation_click();
		commonMethods.implicitwait(defaultWaittime);  
		prescriberfaxPage.additionalrecommendatation_input();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.previewdocument_click();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.check_file_exist1();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.usermenuclick1();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.switchroles1.click();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.roleselect1("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
	}
	
	
	@Test(description = "Verify saved documents in prescriber fax page", priority = 4, groups = { "Sanity", "Regression" })
	public void saveddocument_prescriberfax_validation() throws IOException, InterruptedException {
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.usermenuclick();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.switchroles.click();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.roleselect("Physician");
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.searchtext.sendKeys("MTM0136");
		commonMethods.implicitwait(defaultWaittime);
		dashboardPage.searchtext.sendKeys(Keys.ENTER);
		//dashboardPage.searchbuttonclick();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.prescriberfax_click();
		commonMethods.implicitwait(defaultWaittime);
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.addrecommendation_click();
		commonMethods.implicitwait(defaultWaittime);  
		prescriberfaxPage.additionalrecommendatation_input();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.viewsavedocument_click();
		commonMethods.implicitwait(defaultWaittime); 
		prescriberfaxPage.saveddocsselect();
		commonMethods.implicitwait(defaultWaittime); 
		prescriberfaxPage.opendoc_click();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.check_file_exist();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.delete_file();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.usermenuclick1();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.switchroles1.click();
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.roleselect1("Pharmacist");
		commonMethods.implicitwait(defaultWaittime);
		prescriberfaxPage.gobutton_click();
		commonMethods.implicitwait(defaultWaittime);
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
