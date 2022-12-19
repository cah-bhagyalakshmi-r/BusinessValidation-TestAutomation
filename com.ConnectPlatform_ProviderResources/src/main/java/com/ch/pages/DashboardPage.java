package com.ch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ch.base.TestBase;
import com.ch.util.CommonMethods;

public class DashboardPage extends TestBase {

	@FindBy(xpath = "//img[@id='logo']")
	public WebElement dashboardlink;

	@FindBy(xpath = "//span[contains(text(),'OUTCOMES TRAINING PHARMACY #1')]")
	WebElement outcomesfdrpdwn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/connect-platform-navigation[1]/div[1]/div[1]/div/span[2]/span/input[1]")
	public WebElement searchtext;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/connect-platform-navigation[1]/div[1]/div[1]/span[2]/button[1]")
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

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/connect-platform-navigation[1]/div[1]/div[1]/div[3]/button[1]/flux-icon[1]/span[1]")
	WebElement mainmenu;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/connect-platform-navigation[1]/div[1]/div[1]/div[1]/div[1]/div[1]/flux-icon[1]")
	WebElement usermenu;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/connect-platform-navigation/div/div[1]/div[1]/div[1]/flux-icon/span")
	WebElement clientusermenu;

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
	public WebElement patientlistheader;

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
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/connect-platform-navigation[1]/div[1]/div[1]/div[3]/div[1]/flux-card[1]/div[1]/div[1]/a[3]")
	WebElement resourcesmenu;
	
	@FindBy(xpath = "//h1[contains(text(),'Resources')]")
	WebElement resourcesmenuheader;
	
	@FindBy(xpath = "//a[@id='managePharmacies']")
	WebElement managepharmaciesmenu;
	
	@FindBy(xpath = "/html/body/div[2]/form/div/h1")
	WebElement managepharmaciesheader;
	
	@FindBy(xpath = "//a[contains(text(),'View Profile')]")
	WebElement profilemenu;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/form[1]/div[1]/h1[1]")
	public WebElement profileheader;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/connect-platform-navigation/div/div[1]/div[1]/div[2]/flux-card/div/div/a[2]")
	WebElement accountsecuritymenu;
	
	@FindBy(xpath = "//h1[contains(text(),'Account Security')]")
	WebElement accountsecurityheader;
	
	@FindBy(xpath = "//flux-card-header/div[1]/div[1]/div[1]")
	WebElement switchroles;
	
	@FindBy(xpath = "//h4[contains(text(),'Switch Roles')]")
	WebElement switchrolesheader;
	
	@FindBy(xpath = "//input[@id='username']")
	public WebElement manageuseraccountusername;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/connect-platform-navigation[1]/div[1]/div[1]/div[1]/div[2]/flux-card[1]/div[1]/div[1]/select[1]")
	public WebElement rolelist;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/connect-platform-navigation/div/div[1]/div[1]/div[2]/flux-card/div/div/select")
	public WebElement rolelist1;
	
	@FindBy(xpath = "//button[contains(text(),'Go')]")
	public WebElement gobutton;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/connect-platform-navigation/div/div[1]/div[1]/div[2]/flux-card/flux-card-header/div/div/span")
	public WebElement roleheader;
	
	@FindBy(xpath = "//h3[contains(text(),'Login')]")
	public WebElement login;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/connect-platform-navigation[1]/div[1]/div[1]/div[1]/div[2]/flux-card[1]/flux-card-footer[1]/a[1]")
	WebElement logoutbutton;
	
	@FindBy(xpath = "//span[contains(text(),'Select a report')]")
	public WebElement reportstodownload;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/ul[1]/li[1]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	public WebElement reportstodownloadinput;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/aside[2]/div[2]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]")
	public WebElement salesforce;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/aside[2]/div[2]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]")
	public WebElement legacy;
	
	@FindBy(xpath = "//a[contains(text(),'Patient Look-up')]")
	public WebElement patientlookup;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/connect-platform-navigation[1]/div[1]/div[1]/div[1]/div[1]/div[2]/flux-card[1]/flux-card-header[1]/div[1]/div[3]")
	public WebElement switchpharmacies;
	
	@FindBy(css = "#downshift-0-input")
	public WebElement switchpharmacydrpdwn;
	
	@FindBy(css = "#downshift-0-item-1")
	public WebElement switchpharmacyselect;
	
	@FindBy(xpath = "//flux-card/flux-card-header/div/div[2]/span[1]")
	public WebElement switchpharmacyheader;
	

	public String dashboardPageUrl = prop.getProperty("url") + "index.cfm#/dashboard";
	int defaultwaittime=25;
	int normalwaittime=20;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	CommonMethods commonMethods;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
		commonMethods = new CommonMethods();
	}
	
	public void mainmenuclick() {
		mainmenu.click();
	}
	
	public void usermenuclick() {
		usermenu.click();
	}
	
	public void clientusermenuclick() {
		clientusermenu.click();
	}
	
	public void resourcesmenuclick() {
		resourcesmenu.click();
	}
	
	public void managepharmaciesmenuclick() {
		managepharmaciesmenu.click();
	}
	
	public void managepharmaciesheader() {
		managepharmaciesheader.isDisplayed();
	}
	
	public void switchrolesheader() {
		switchrolesheader.isDisplayed();
	}
	
	public void profilemenuclick() {
		profilemenu.click();
	}
	
	public void logindisplay() {
		login.isDisplayed();
	}
	
	public void roleheader_display() {
		String exproleheader= roleheader.getAttribute("textContent");
		System.out.println("roleheader:"+roleheader);
		String actroleheader="Client";
		Assert.assertEquals(exproleheader, actroleheader);
	}
	
	public void logoutbuttonclick() {
		logoutbutton.click();
	}
	
	public void roleselect(String roleselector) throws InterruptedException {
		rolelist.click();
		Select rolesel = new Select(rolelist);
		rolesel.selectByVisibleText(roleselector);
		Thread.sleep(1000);
		rolelist.click();
	}
	
	public void roleselect1(String roleselector) throws InterruptedException {
		rolelist1.click();
		Select rolesel = new Select(rolelist1);
		rolesel.selectByVisibleText(roleselector);
		Thread.sleep(1000);
		rolelist1.click();
	}
	
	public void gobutton_click() throws InterruptedException {
		gobutton.click();
		Thread.sleep(10000);
	}
	
	public void accountsecuritymenuclick() {
		accountsecuritymenu.click();		
	}
	
	public void switchrolesclick() {
		switchroles.click();		
	}
	
	public void switchpharmaciesclick() {
		switchpharmacies.click();		
	}
	
	public void switchpharmacydrpdwn() {
		//switchpharmacydrpdwn.click();	
		switchpharmacydrpdwn.sendKeys("56498498");
	}
	
	public void switchpharmacydrpdwn1() {
		//switchpharmacydrpdwn.click();	
		switchpharmacydrpdwn.sendKeys("9999990");
	}
	
	public void switchpharmacydrpdwn_select() {
		int position=1;
		for(int i = 0; i <= position; i++){
		    Actions actions = new Actions(driver);
		    actions.sendKeys(Keys.DOWN).build().perform();//press down arrow key
		    actions.sendKeys(Keys.ENTER).build().perform();//press enter
		}
				
	}
	
	public void switchpharmacyheader_validation() {
		//switchpharmacydrpdwn.click();	
		String header=switchpharmacyheader.getAttribute("textContent");
		System.out.println("switchpharmacyheader:"+header);
		String actheader="ucare_test_center";
		Assert.assertEquals(header, actheader);
	}
	
	public void switchpharmacyheader_validation1() {
		//switchpharmacydrpdwn.click();	
		String header=switchpharmacyheader.getAttribute("textContent");
		System.out.println("switchpharmacyheader:"+header);
		String actheader="OUTCOMES TRAINING PHARMACY #1";
		Assert.assertEquals(header, actheader);
	}
	
	public void switchpharmacy_validation() throws InterruptedException {
		switchpharmaciesclick();
		Thread.sleep(2000);
		switchpharmacydrpdwn();
		Thread.sleep(1000);
		switchpharmacydrpdwn_select();
		Thread.sleep(1000);
		gobutton_click();
		Thread.sleep(10000);
		usermenuclick();
		Thread.sleep(1000);
		switchpharmacyheader_validation();	
		Thread.sleep(1000);
		switchpharmaciesclick();
		Thread.sleep(2000);
		switchpharmacydrpdwn1();
		Thread.sleep(1000);
		switchpharmacydrpdwn_select();
		Thread.sleep(1000);
		gobutton_click();
		Thread.sleep(10000);
		usermenuclick();
		Thread.sleep(1000);
		switchpharmacyheader_validation1();	
		Thread.sleep(1000);
	}
	

	public void resourcesheader() throws InterruptedException {
		String resources= resourcesmenuheader.getAttribute("textContent");
		System.out.println("Resourcesheader:"+resources);
		String actresourcesheader="Resources";
		Assert.assertEquals(resources, actresourcesheader);
	}
	
	public void manageusername_input() {
		manageuseraccountusername.sendKeys("testaccount635");
	}
	
	public void manageusername_input1() {
		manageuseraccountusername.sendKeys("test.automation");
	}
	
	public void resources_validation() throws InterruptedException {
		resourcesmenuclick();
		commonMethods.implicitwait(defaultwaittime);
		resourcesheader();
	}
	
	public void managepharmacy_validation() throws InterruptedException {
		managepharmaciesmenuclick();
		commonMethods.implicitwait(defaultwaittime);
		managepharmaciesheader();
	}
	
	public void accountsecurity_validation() throws InterruptedException {
		accountsecuritymenuclick();
		commonMethods.implicitwait(defaultwaittime);
		accountsecurityheader();
	}
	
	public void profileheader_validation() throws InterruptedException {
		profilemenuclick();
		commonMethods.implicitwait(defaultwaittime); 
		profileheader();
	}
	
	public void switchroles_validation() throws InterruptedException {
		switchrolesclick();
		commonMethods.implicitwait(defaultwaittime);
		roleselect("Client");
		commonMethods.implicitwait(defaultwaittime);
		gobutton_click();
		commonMethods.implicitwait(defaultwaittime);
		clientusermenuclick();
		//commonMethods.implicitwait(defaultwaittime);
		//roleheader_display();
		commonMethods.implicitwait(defaultwaittime);
		switchrolesclick();
		commonMethods.implicitwait(defaultwaittime);
		roleselect1("Pharmacist");
		commonMethods.implicitwait(defaultwaittime);
		gobutton_click();
	}
	
	public void logout_validation() throws InterruptedException {
		logoutbuttonclick();
		commonMethods.implicitwait(defaultwaittime);
		logindisplay();
	}

	public void profileheader() throws InterruptedException {
		String profile= profileheader.getAttribute("textContent").substring(0,11);
		System.out.println("Profileheader:"+profile);
		String actprofileheader="Profile for";
		Assert.assertEquals(profile, actprofileheader);
	}
	
	public void accountsecurityheader() {
		String acctsecurity= accountsecurityheader.getAttribute("textContent").trim();	
		System.out.println("Accountsecurityheader:"+acctsecurity);
		String actsecurityheader="Account Security";
		Assert.assertEquals(acctsecurity, actsecurityheader);
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

	public void oppurtunitysummary_validation2() throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/my-pharmacy-component"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		shadowroot.findElement(By.cssSelector("#opportunities-summary > div:nth-child(1)")).click();
		commonMethods.implicitwait(normalwaittime);
		String mtmclaims= mtmclaimsheader.getAttribute("textContent").trim().substring(0,9);
		System.out.println("mtmclaimsheader:"+mtmclaims);
		String actmtmclaims= "MTM Claim";
		Assert.assertEquals(mtmclaims,actmtmclaims);
		goToDashboard();
		Thread.sleep(5000);
		//WebElement root1 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/my-pharmacy-component"));
		SearchContext shadowroot1 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		shadowroot1.findElement(By.cssSelector("#opportunities-summary > div:nth-child(2)")).click();
		commonMethods.implicitwait(normalwaittime);
		String patientlist= patientlistheader.getAttribute("textContent").trim().substring(0,12);
		System.out.println("Patientlistheader:"+patientlist);
		String actpatientlist= "Patient List";
		Assert.assertEquals(patientlist,actpatientlist);
		goToDashboard();
		
	}
	public void oppurtunitysummary_validation3() throws InterruptedException {
	Thread.sleep(5000);
	WebElement root2 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/my-pharmacy-component"));
	SearchContext shadowroot2 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root2);
	shadowroot2.findElement(By.cssSelector("#opportunities-summary > div:nth-child(3)")).click();
	commonMethods.implicitwait(normalwaittime);
	String patientlist1= patientlistheader.getAttribute("textContent").trim().substring(0,12);
	System.out.println("Scheduledcmrs:"+patientlist1);
	String actpatientlist= "Patient List";
	Assert.assertEquals(actpatientlist,patientlist1);
	goToDashboard();
	Thread.sleep(5000);
	WebElement root3 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/my-pharmacy-component"));
	SearchContext shadowroot3 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root3);
	shadowroot3.findElement(By.cssSelector("#opportunities-summary > div:nth-child(4)")).click();
	commonMethods.implicitwait(normalwaittime);
	String adherencemonitoring= adherenceheader.getAttribute("textContent").trim().substring(0,11);
	System.out.println("Adherencemonitoringheader:"+adherencemonitoring);
	String actadherencemonitoring= "Patient List";
	Assert.assertEquals(adherencemonitoring,actadherencemonitoring);}
	

	public void oppurtunitysummary_validation1() throws InterruptedException {
		commonMethods.implicitwait(normalwaittime);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/my-pharmacy-component"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		shadowroot.findElement(By.cssSelector("#opportunities-summary > div:nth-child(2)")).click();
		commonMethods.implicitwait(normalwaittime);
		String patientlist= patientlistheader.getAttribute("textContent").trim().substring(0,12);
		System.out.println("Patientlistheader:"+patientlist);
		System.out.println("MTMPatientsInProgress: PatientList Page is validated");
		String actpatientlist= "Patient List";
		Assert.assertEquals(patientlist,actpatientlist);
		goToDashboard();
		Thread.sleep(8000);
		WebElement root3 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/my-pharmacy-component"));
		SearchContext shadowroot3 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root3);
		shadowroot3.findElement(By.cssSelector("#opportunities-summary > div:nth-child(4)")).click();
		commonMethods.implicitwait(normalwaittime);
		String adherencemonitoring= adherenceheader.getAttribute("textContent").trim().substring(0,20);
		System.out.println("Adherencemonitoringheader:"+adherencemonitoring);
		String actadherencemonitoring= "Adherence Monitoring";
		Assert.assertEquals(adherencemonitoring,actadherencemonitoring);
		System.out.println("AdherenceMonitoringCheckpoints:AdherenceMonitoring Page is validated");
		goToDashboard();
		Thread.sleep(5000);
		}
	
	public void oppurtunitysummary_validation() throws InterruptedException {
		Thread.sleep(6000);
		WebElement root= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/my-pharmacy-component"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		shadowroot.findElement(By.cssSelector("#opportunities-summary > div:nth-child(1)")).click();
		commonMethods.implicitwait(normalwaittime);
		String mtmclaims= mtmclaimsheader.getAttribute("textContent").trim().substring(0,9);
		System.out.println("mtmclaimsheader:"+mtmclaims);
		System.out.println("MTMClaimsToReviewAndResubmit: MTMClaims Page is validated");
		String actmtmclaims= "MTM Claim";
		Assert.assertEquals(mtmclaims,actmtmclaims);
		goToDashboard();
		Thread.sleep(12000);
		WebElement root2 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/my-pharmacy-component"));
		SearchContext shadowroot2 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root2);
		shadowroot2.findElement(By.cssSelector("#opportunities-summary > div:nth-child(3)")).click();
		commonMethods.implicitwait(normalwaittime);
		String patientlist= patientlistheader.getAttribute("textContent").trim().substring(0,12);
		System.out.println("scheduledcmr:"+patientlist);
		System.out.println("ScheduledCMRs: PatientList Page is validated");
		String actpatientlist= "Patient List";
		Assert.assertEquals(patientlist,actpatientlist);
		goToDashboard();
		Thread.sleep(5000);
		}
	
	public void adherencemonitoringcheckpoint_validation() {
		WebElement root = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/my-pharmacy-component"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		shadowroot.findElement(By.cssSelector("#opportunities-summary > div:nth-child(4)")).click();
		commonMethods.implicitwait(normalwaittime);
		String adherencemonitoring= adherenceheader.getAttribute("textContent").trim().substring(0,11);
		System.out.println("Adherencemonitoringheader:"+adherencemonitoring);
		String actadherencemonitoring= "Patient List";
		Assert.assertEquals(adherencemonitoring,actadherencemonitoring);}


	public void pagination_validation() {
		WebElement root = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/my-pharmacy-component"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		String resultset=shadowroot.findElement(By.cssSelector("#opportunities > div.flux-grid-flush.all-patient-opportunities-container > div > div:nth-child(2) > div > div.paging-info-per-page.flux-flex.flex-align-items-center")).getText().trim();
		System.out.println("resultset:"+resultset);
		String[] parts = resultset.split(" ");
		String resultnumber = parts[3];
		String resultids = resultnumber.replaceAll(",","");
		System.out.println(resultids);
		String expresultids = "50";
		Assert.assertEquals(resultids,expresultids);}




	}