package com.ch.tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.base.TestBase;
import com.ch.pages.DashboardPage;
import com.ch.pages.LoginPage;
import com.ch.pages.PatientNotesPage;
import com.ch.util.CommonMethods;
import com.ch.util.JsonFileReader;

public class PatientNotesPageTest extends TestBase {
	int normalwaittime=50;
	int defaultwaittime=30;
	int longerwaittime=40;

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CommonMethods commonMethods;
	PatientNotesPage patientnotesPage;
	JsonFileReader jsonreader=new JsonFileReader();

	public PatientNotesPageTest(){
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException, ParseException {		
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonMethods = new CommonMethods();
		patientnotesPage = new PatientNotesPage();
		commonMethods.implicitwait(normalwaittime);
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		commonMethods.implicitwait(normalwaittime);
	}


	@Test(description = "Add/edit/delete patient notes successfully",priority= 1,groups = {"Sanity", "Regression"})
	public void addeditdelete_patientnotes_validation() throws IOException, InterruptedException, ParseException {
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
					 Thread.sleep(8000);
					 JavascriptExecutor executor = (JavascriptExecutor) driver;
					// WebElement root = driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[2]/div[3]/div[2]/div[2]/ul/li[1]/div/div[2]/flux-card"));
					//	JavascriptExecutor js = (JavascriptExecutor) driver;
						//SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
					//executor.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector("#view-cmr")));
					//executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("#view-cmr")));
					commonMethods.implicitwait(defaultwaittime);
				patientnotesPage.patientnotes_click();
				commonMethods.implicitwait(normalwaittime);
				patientnotesPage.addnote_click(); 
				commonMethods.implicitwait(normalwaittime);
				patientnotesPage.addnote_input(); 
				commonMethods.implicitwait(normalwaittime);
				patientnotesPage.savenote_click();
				commonMethods.implicitwait(normalwaittime);
				patientnotesPage.patientnote_validation();
				System.out.println("Patient note added successfully");
				commonMethods.implicitwait(normalwaittime);
				patientnotesPage.editnote_click();
				commonMethods.implicitwait(normalwaittime);
				patientnotesPage.patientnoteedit_input();
				commonMethods.implicitwait(normalwaittime);
				patientnotesPage.patienteditsavebutton_click();
				commonMethods.implicitwait(normalwaittime);
				patientnotesPage.patientnoteedit_validation();
				commonMethods.implicitwait(normalwaittime);
				System.out.println("Patient note modified successfully");
				patientnotesPage.deletenote_click();
				commonMethods.implicitwait(normalwaittime);
				System.out.println("Patient note deleted successfully");
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

	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.close();
	}
}


