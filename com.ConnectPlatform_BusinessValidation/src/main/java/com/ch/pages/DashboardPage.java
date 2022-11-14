package com.ch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ch.base.TestBase;

public class DashboardPage extends TestBase {

	@FindBy(xpath = "//img[@id='logo']")
	public WebElement dashboardlink;

	@FindBy(xpath = "//span[contains(text(),'OUTCOMES TRAINING PHARMACY #1')]")
	WebElement outcomesfdrpdwn;
	
	@FindBy(xpath = "//input[@id='patientSearchInput']")
	public WebElement searchtext;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/connect-platform-navigation[1]/div[1]/div[1]/div[1]/span[2]/span[1]/button[1]/flux-icon[1]/span[1]")
	public WebElement searchboxclick;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/oc-dashboard[1]/span[1]/div[1]/span[1]/span[1]/h4[1]")
	WebElement patientsdisplay;

	@FindBy(css = "#connectLogo")
	WebElement connectlogo;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[3]/div[3]/div/oc-dashboard/span/div/div/div")
	public WebElement mtmoppurtunitieslink;
	
	@FindBy(css = "span#web-component-root tr:nth-child(\" + i + \") > td:nth-child(1)")
	public WebElement patientrow;
	
	@FindBy(css = "span#web-component-root tr:nth-child(\" + i + \") > td:nth-child(5)")
	public WebElement cmrrecordfound;
	
	@FindBy(css = "//body/div[@id='clientPage']/div[@id='app']/div[@id='ember331']/div[@id='connect-client']/div[@id='connect-dashboard']/oc-dashboard[1]/span[1]/div[1]/table[1]/tbody/tr[3]")
	public WebElement patientrecordfound;
	
	@FindBy(xpath = "//span[contains(text(),'Menu')]")
	WebElement mainmenu;

	@FindBy(css="#patientName")
	public WebElement lastname;

	@FindBy(css="#dobAndAge")
	public WebElement dob;

	@FindBy(css="#mtmId")
	public WebElement id;
	
	@FindBy(xpath="//body/div[@id='lookHere']/div[1]/div[1]/div[1]/div[1]/p[1]/span[5]")
	public WebElement srchphnum;

	@FindBy(css="#noResultsMessage")
	public WebElement invalidsearchmsg;
	
	@FindBy(css="#ptSearchBtn")
	public WebElement searchresultsbutton;
	
	@FindBy(xpath="//body/div[@id='lookHere']/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]/span[1]/span[1]")
	public WebElement multipleresultsbutton;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]")
	public WebElement claimsreviewandresubmit;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]")
	public WebElement claimsresult;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/form[2]/div[1]/h1[1]")
	public WebElement mtmclaimsheader;
	
	@FindBy(xpath="//div[@id='dataTable_info']")
	public WebElement totalnumberofpatientsheader;
	
	@FindBy(xpath = "//span[contains(text(),'Menu')]")
	WebElement mtmclaimsmenuheader;
	
	@FindBy(xpath = "//select[@id='dateselect']")
	public WebElement selectdaterangedrpdown;
	
	@FindBy(xpath = "//select[@id='claimStatus']")
	public WebElement claimsstatusdrpdown;
	
	@FindBy(xpath = "//select[@id='validationStatusID']")
	public WebElement validationpaymentdrpdown;
	
	@FindBy(xpath = "//select[@id='result']")
	public WebElement resultdrpdown;
	
	@FindBy(xpath = "/html/body/div[2]/form[2]/div/div[1]/ul[2]/li/select")
	public WebElement showresultentries;
	
	@FindBy(xpath = "//th[@id='claimSort']")
	WebElement claim;
	
	@FindBy(xpath = "//th[@id='patientSort']")
	WebElement patient;
	
	@FindBy(xpath = "//th[@id='claimDateSort']")
	WebElement claimdate;
	
	@FindBy(xpath = "//th[contains(text(),'Reason, Action, Result')]")
	WebElement rar;
	
	@FindBy(xpath = "//th[contains(text(),'Medication')]")
	WebElement medication;
	
	@FindBy(xpath = "//th[@id='serviceProviderSort']")
	WebElement serviceprovider;
	
	@FindBy(xpath = "//th[@id='statusSort']")
	WebElement status;
	
	@FindBy(xpath = "//a[@id='dataTable_previous']")
	WebElement previousbutton;
	
	@FindBy(xpath = "//a[@id='dataTable_next']")
	WebElement nextbutton;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/a[2]")
	WebElement ptntinprogress;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/a[2]/div[2]/div[1]")
	public WebElement patientsresult;
	
	@FindBy(xpath="//th[contains(text(),'Patient Name')]")
	public WebElement patientname;
	
	@FindBy(xpath="//th[contains(text(),'DOB')]")
	public WebElement ptdob;
	
	@FindBy(xpath="//th[contains(text(),'Plan')]")
	public WebElement plan;
	
	@FindBy(xpath="//th[contains(text(),'Contact Info')]")
	public WebElement contactinfo;
	
	@FindBy(xpath="//thead/tr[1]/th[5]")
	public WebElement rxfilled;
	
	@FindBy(xpath="//th[contains(text(),'Last CMR Offered')]")
	public WebElement lastcmroffered;
	
	@FindBy(xpath="//th[contains(text(),'Last CMR Completed')]")
	public WebElement lastcmrcompleted;
	
	@FindBy(xpath="//th[contains(text(),'MTM Opportunities')]")
	public WebElement mtmoppurtunities;
	
	@FindBy(xpath="//th[@id='pcpSort']")
	public WebElement prescriber;
	
	@FindBy(xpath = "//h1[contains(text(),'Patient List')]")
	WebElement patientlistheader;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/a[3]/div[2]/div[1]")
	public WebElement scheduledcmrresult;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/a[3]")
	WebElement scheduledcmr;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/a[4]/div[2]/div[1]")
	public WebElement adherenceresult;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/a[4]")
	WebElement adherence;
	
	@FindBy(xpath = "//h1[contains(text(),'Adherence Monitoring')]")
	WebElement adherenceheader;
	
	@FindBy(xpath = "//th[contains(text(),'Patient')]")
	WebElement adherencepatient;
	
	@FindBy(xpath = "//th[contains(text(),'Medication')]")
	WebElement adherencemedication;
	
	@FindBy(xpath = "//thead/tr[1]/th[3]")
	WebElement adherencestatus;
	
	@FindBy(xpath = "//thead/tr[1]/th[4]")
	WebElement adherencecheckpointstatus;

	public String dashboardPageUrl = prop.getProperty("url") + "index.cfm#/dashboard";
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public void patientsdisplay() {
		WebElement root = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/my-pharmacy-component"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		shadowroot.findElement(By.cssSelector("#opportunities > div.flux-flex-row.flux-flex-item-12.flux-align-center.border-bottom.header")).isDisplayed();
		//patientsdisplay.isDisplayed();
	}
	
	public void dashboardpage_Validation() {
		searchtext.isDisplayed();
		dashboardlink.isDisplayed();
		connectlogo.isDisplayed();
		mainmenu.isDisplayed();
		patientsdisplay();
	}
	
	public void searchbuttonclick() {
		searchboxclick.click();
	}
	
	public void mtmoppurtunitieslink_click() {
		mtmoppurtunitieslink.click();
	}
	
	public void goToDashboard() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", dashboardlink);
		executor.executeScript("arguments[0].click();", dashboardlink);
	}
	
	public void enterSearchText(String searchinput) {
		searchtext.sendKeys(searchinput);
	}
	
	public boolean verifySearch() {
		if (driver.getPageSource().contains("Comprehensive Medication Review")) {
			return true;
		} else
			return false;
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean searchbtn_display() {		
		if(!searchresultsbutton.isDisplayed()){
			return false;
		}else 
			return true;
	}
	
	public void claimsreviewresubmit_click() {
		claimsreviewandresubmit.click();
	}
	
	public void mtmclaims_validation() {
		mtmclaimsmenuheader.isDisplayed();
		selectdaterangedrpdown.isDisplayed();
		claimsstatusdrpdown.isDisplayed();
		validationpaymentdrpdown.isDisplayed();
		resultdrpdown.isDisplayed();
		showresultentries.isDisplayed();
		claim.isDisplayed();
		patient.isDisplayed();
		rar.isDisplayed();
		medication.isDisplayed();
		serviceprovider.isDisplayed();
		status.isDisplayed();
		previousbutton.isDisplayed();
		nextbutton.isDisplayed();	
	}
	
	
	public void patientprogress_click() {
		ptntinprogress.click();
	}
	
	public void patientlist_validation() {
		patientname.isDisplayed();
		ptdob.isDisplayed();
		plan.isDisplayed();
		contactinfo.isDisplayed();
		rxfilled.isDisplayed();
		lastcmroffered.isDisplayed();
		lastcmrcompleted.isDisplayed();
		mtmoppurtunities.isDisplayed();
		prescriber.isDisplayed();
		patientlistheader.isDisplayed();
	}
	
	public void scheduledcmr_click() {
		scheduledcmr.click();
	}
	
	public void adherence_click() {
		adherence.click();
	}
	
	public void adherencemonitoring_validation() {
		adherenceheader.isDisplayed();
		adherencepatient.isDisplayed();
		adherencemedication.isDisplayed();
		adherencestatus.isDisplayed();
		adherencecheckpointstatus.isDisplayed();
	}
	
	
	
	
	
	
	
}