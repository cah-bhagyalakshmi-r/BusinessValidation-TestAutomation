package com.ch.pages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ch.base.TestBase;
import com.ch.util.CommonMethods;

public class PharmacyAdminReportsPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Menu')]")
	WebElement mainmenu;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[2]/p[1]")
	public WebElement rolelabel;

	@FindBy(css = "#switchRoles")
	public WebElement switchroles;

	@FindBy(css = "#roleList")
	public WebElement rolelist1;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/connect-platform-navigation[1]/div[1]/div[1]/div[5]/flux-card[1]/div[1]/div[1]/select[1]")
	public WebElement rolelist;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/connect-platform-navigation/div/div[1]/div[5]/flux-card/div/div/select")
	public WebElement rolelistnew;

	@FindBy(xpath = "//button[contains(text(),'Go')]")
	public WebElement gobutton;
	
	@FindBy(css = "#submitswitchRoles")
	public WebElement gobutton1;

	@FindBy(xpath = "//p[contains(text(),'MTM Claims')]")
	public WebElement mtmclaims;
	
	@FindBy(xpath = "//span[contains(text(),'Opportunity')]")
	public WebElement oppurtunity;

	@FindBy(xpath = "//p[contains(text(),'Opps by Center')]")
	public WebElement oppsbycenter;
	
	@FindBy(xpath = "//p[contains(text(),'Current TIPs')]")
	public WebElement currenttips;
	
	@FindBy(xpath = "//span[contains(text(),'Performance')]")
	public WebElement performance;
	
	@FindBy(xpath = "//p[contains(text(),'TIP Performance')]")
	public WebElement tipperformance;
	
	@FindBy(xpath = "//p[contains(text(),'CMR Performance')]")
	public WebElement cmrperformance;
	
	@FindBy(xpath = "//select[@id='claimStatus']")
	public WebElement claimstatus;
	
	@FindBy(xpath = "//select[@id='ClaimStatusList']")
	public WebElement claimstatuslist;

	@FindBy(xpath = "//input[@id='nabp']")
	public WebElement ncdp;
	
	@FindBy(xpath = "//input[@id='NCPDPList']")
	public WebElement ncdplist;

	@FindBy(css = "#searchClaims")
	public WebElement searchbutton;
	
	@FindBy(css = "#searchMTMOpps")
	public WebElement oppscentersearchbutton;
	
	@FindBy(css = "#searchBtn")
	public WebElement currenttipsearchbutton;
	
	@FindBy(css = "#searchTIPActivity")
	public WebElement tipperformacesearchbutton;

	@FindBy(xpath = "//h1[contains(text(),'MTM Claims Report')]")
	public WebElement mtmcclaimsreportheader;
	
	@FindBy(xpath = "//h1[contains(text(),'Opportunities by Center Report')]")
	public WebElement oppsbycenterreportheader;
	
	@FindBy(xpath = "//h1[contains(text(),'Current TIP Report')]")
	public WebElement currenttipreportheader;
	
	@FindBy(xpath = "//h1[contains(text(),'TIP Performance')]")
	public WebElement tipperformancereportheader;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	public WebElement claimstatusinput;
	
	@FindBy(xpath = "//select[@id='dateselect']")
	public WebElement daterange;

	@FindBy(css = "#claimSummarySort")
	public WebElement claimsummary;

	@FindBy(css = "#claimDateSort")
	public WebElement encounterdate;

	@FindBy(css = "#medicationSort")
	public WebElement medications;

	@FindBy(css = "#pharmacySort")
	public WebElement pharmacy;

	@FindBy(css = "#serviceProviderSort")
	public WebElement serviceprovider;

	@FindBy(css = "#claimStatusSort")
	public WebElement status;
	
	@FindBy(xpath = "//body[1]/div[2]/form[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")
	public WebElement oppsbycenterpharmacysummary;
	
	@FindBy(xpath = "//body[1]/div[2]/form[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]")
	public WebElement oppsbycenterpharmacy;
	
	@FindBy(xpath = "//body[1]/div[2]/form[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]")
	public WebElement oppsbycentercmrs;
	
	@FindBy(xpath = "//body[1]/div[2]/form[1]/div[1]/table[1]/thead[1]/tr[1]/th[4]")
	public WebElement oppsbycentertips;
	
	@FindBy(xpath = "//body[1]/div[2]/form[1]/div[1]/table[1]/thead[1]/tr[1]/th[5]")
	public WebElement oppsbycenterclaims;
	
	@FindBy(css = "#tipTitleSort")
	public WebElement tiptitle;
	
	@FindBy(css = "#tipDateSort")
	public WebElement tipdate;
	
	@FindBy(xpath = "//th[contains(text(),'Pharmacy Info')]")
	public WebElement pharmacyinfo;
	
	@FindBy(xpath = "//th[contains(text(),'TIP Categories')]")
	public WebElement tipcategories;
	
	@FindBy(xpath = "//th[contains(text(),'TIP Opportunities')]")
	public WebElement tipoppurtunities;
	
	@FindBy(xpath = "//th[contains(text(),'Attempted TIPs')]")
	public WebElement attemptedtips;
	
	@FindBy(xpath = "//th[contains(text(),'Completed TIPs')]")
	public WebElement completedtips;
	
	@FindBy(xpath = "//th[contains(text(),'Unsuccessful TIP Attempts')]")
	public WebElement unsuccessfultipattempts;
	
	@FindBy(xpath = "//span[contains(text(),'Summary')]")
	public WebElement summary;
	
	@FindBy(xpath = "//span[contains(text(),'Policy')]")
	public WebElement policy;
	
	@FindBy(xpath = "//span[contains(text(),'MTM Center')]")
	public WebElement cmrmtmcenter;
	
	@FindBy(xpath = "//body/div[@id='clientPage']/div[@id='root']/div[@id='connect-reporting-client']/div[@id='lookHere']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/button[1]")
	public WebElement exportcmrreport;
	
	@FindBy(xpath = "//div[@id='completedDonut-title']")
	public WebElement cmrcompletion;
	
	@FindBy(xpath = "//div[contains(text(),'Patients Eligible')]")
	public WebElement patientseligible;

	@FindBy(css = "#fileDownloadCustomRichExperience")
	public WebElement downloadtoexcel;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/form[1]/div[1]/p[1]/a[2]")
	public WebElement downloadtotext;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/form[1]/div[1]/p[2]/a[2]")
	public WebElement oppsbycenterdownloadtotext;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/form[1]/p[1]/a[2]")
	public WebElement currenttipdownloadtotext;
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/p[1]/a[2]")
	public WebElement tipperformancedownloadtotext;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]")
	public WebElement claimnumber;
	
	@FindBy(xpath = "//tbody/tr[1]/td[8]/a[1]")
	public WebElement vieweditlink;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/h1[1]")
	public WebElement claimnumresult;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/form[1]/div[1]/div[1]/div[1]/span[1]")
	public WebElement recordresult;
	
	@FindBy(css = " #dataTable_previous")
	public WebElement previousbutton;
	
	@FindBy(css = "#dataTable_next")
	public WebElement nextbutton;
	
	@FindBy(xpath = "//select[@id='medSort']")
	public WebElement medsortdrpdown;
	
	@FindBy(xpath = "//select[@id='statusSort']")
	public WebElement statussortdrpdown;
	
	@FindBy(xpath = "//tbody/tr/td[4]/span[1]/span[1]")
	public WebElement medicationlist;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/form[1]/div[1]/div[1]/div[1]/span[1]")
	public WebElement medrecclaimresult;
	
	@FindBy(xpath = "//h1[contains(text(),'MTM Claims')]")
	public WebElement mtmclaimsheader;
	
	@FindBy(xpath = "//h1[contains(text(),'Opportunities by Center')]")
	public WebElement oppsbycenterheader;
	
	@FindBy(xpath = "//h1[contains(text(),'Current TIPs')]")
	public WebElement currenttipsheader;
	
	@FindBy(xpath = "//h1[contains(text(),'TIP Performance')]")
	public WebElement tipperformanceheader;
	
	@FindBy(xpath = "//span[@id='cmr-performance-title']")
	public WebElement cmrperformanceheader;
	
	@FindBy(css = "#oppTypeCMR")
	public WebElement needscmr;
	
	@FindBy(css = "#oppTypeTIP")
	public WebElement tips;
	
	@FindBy(css = "#mtmCenter")
	public WebElement mtmcenter;
	
	@FindBy(css = "#nonMtmCenter")
	public WebElement nonmtmcenter;
	
	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	public WebElement dashboardlink;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/connect-platform-navigation[1]/div[1]/div[1]/div[5]/flux-card[1]/div[1]/div[1]/select[1]")
	public WebElement rolelistperf;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/button[1]")
	public WebElement exportcmrrept;
	
	String currentDate = new SimpleDateFormat("MMddyyyy").format(new Date());
	Date todayDate = new Date();
	Date tomorrowDate = new Date(todayDate.getTime() + (1000 * 60 * 60 * 24));
	String cmrDate = new SimpleDateFormat("MMddyyyy").format(tomorrowDate);
	int defaultWaittime = 5;
	
	CommonMethods commonMethods = new CommonMethods();

	public PharmacyAdminReportsPage() {
		PageFactory.initElements(driver, this);
	}

	public void mainmenuclick() throws InterruptedException {
		//mainmenu.click();
		Thread.sleep(5000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", mainmenu);
		executor.executeScript("arguments[0].click();", mainmenu);
	}

	public void switchrolesmenu() {
		rolelabel.click();
	}
	
	public void dashboard_display() throws InterruptedException {
		Thread.sleep(10000);
		dashboardlink.isDisplayed();
		Thread.sleep(3000);
	}

	public void roleselect(String roleselector) throws InterruptedException {
		rolelist.click();
		Select rolesel = new Select(rolelist);
		rolesel.selectByVisibleText(roleselector);
		Thread.sleep(1000);
		rolelist.click();
	}
	
	public void roleselectnew(String roleselector) throws InterruptedException {
		Thread.sleep(2000);
		rolelistnew.click();
		Select rolesel = new Select(rolelistnew);
		rolesel.selectByVisibleText(roleselector);
		Thread.sleep(2000);
		rolelistnew.click();
	}
	
	
	
	public void roleselect1(String roleselector) throws InterruptedException {
		Thread.sleep(2000);
		Select rolesel = new Select(rolelist1);
		rolesel.selectByVisibleText(roleselector);
	}


	public void gobutton_click() throws InterruptedException {
		gobutton.click();
		Thread.sleep(10000);
	}
	
	public void gobutton_click1() {
		gobutton1.click();
	}

	public void mtmclaims_click() {
		mtmclaims.click();
	}
	
	public void claimstatus_select() throws InterruptedException {
		Thread.sleep(2000);
		Select select = new Select(claimstatus);
		select.selectByValue("Pending approval");
	}
	
	public void oppurtunitycenter_click() {
		oppurtunity.click();
	}
	
	public void oppsbycenter_click() {
		oppsbycenter.click();
	}
	
	public void currenttips_click() {
		currenttips.click();
	}
	
	public void performance_click() {
		performance.click();
	}
	
	public void tipperformance_click() throws InterruptedException {
		Thread.sleep(5000);
		tipperformance.click();
	}
	
	public void cmrperformance_click() throws InterruptedException {
		Thread.sleep(5000);
		cmrperformance.click();
	}
	
	public void claimstatus_input() throws InterruptedException {
		claimstatusinput.click();
		Thread.sleep(1000);
		
		  //claimstatusinput.sendKeys("Pending approval"); 
			/*
			 * JavascriptExecutor jse = (JavascriptExecutor)driver; jse.
			 * executeScript("document.getElementById('elementID').setAttribute('Pending approval', 'claimstatusinput')"
			 * ); jse.
			 * executeScript("document.getElementById('claimstatusinput').value='Pending approval';"
			 * ); claimstatusinput.sendKeys(Keys.ENTER);
			 */
		
		  List<WebElement> allOptions = driver.findElements(By.xpath(
		  "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"
		  )); for(int i = 0; i<=allOptions.size()-1; i++) {
		  if(allOptions.get(i).getText().contentEquals("Pending approval")) {
		  allOptions.get(i).click(); break; } }
		 
	}
	
	public void claimstatuslist_select() throws InterruptedException {
		Thread.sleep(2000);
		Select select = new Select(claimstatuslist);
		select.selectByValue("2");
	}
	
	

	public void ncdp_input() {
		ncdp.sendKeys("9999990");
	}
	
	public void ncdplist_input() {
		ncdplist.sendKeys("9999990");
	}
	
	public void searchbutton_click() {
		searchbutton.click();
	}
	
	public void oppscentersearchbutton_click() {
		oppscentersearchbutton.click();
	}
	
	public void currenttipsearchbutton_click() {
		currenttipsearchbutton.click();
	}
	
	public void tipperformancesearchbutton_click() {		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", tipperformacesearchbutton);
		executor.executeScript("arguments[0].click();", tipperformacesearchbutton);
	}
	
	public void mtmopp_click() {
		mtmcenter.click();
		commonMethods.implicitwait(defaultWaittime);
		nonmtmcenter.click();
		commonMethods.implicitwait(defaultWaittime);
		needscmr.click();
		commonMethods.implicitwait(defaultWaittime);
		tips.click();
	}

	public void mtmclaimsreportheader_display() {
		mtmcclaimsreportheader.isDisplayed();
	}

	public void oppsbycenterreportheader_display() {
		oppsbycenterreportheader.isDisplayed();
	}
	
	public void currenttipreportheader_display() {
		currenttipreportheader.isDisplayed();
	}
	
	public void tipperformacnereportheader_display() {
		tipperformancereportheader.isDisplayed();
	}
	
	public void mtmclaimsreport_validation() {
		claimsummary.isDisplayed();
		encounterdate.isDisplayed();
		medications.isDisplayed();
		pharmacy.isDisplayed();
		serviceprovider.isDisplayed();
		status.isDisplayed();
	}
	
	public void oppsbycenterreport_validation() {
		oppsbycenterpharmacysummary.isDisplayed();
		oppsbycenterpharmacy.isDisplayed();
		oppsbycentercmrs.isDisplayed();
		oppsbycentertips.isDisplayed();
		oppsbycenterclaims.isDisplayed();
	}
	
	public void currenttipsreport_validation() {
		tiptitle.isDisplayed();
		tipdate.isDisplayed();
		pharmacyinfo.isDisplayed();		
	}
	
	public void tipperformancereport_validation() {
		tipcategories.isDisplayed();
		tipoppurtunities.isDisplayed();
		attemptedtips.isDisplayed();
		completedtips.isDisplayed();
		unsuccessfultipattempts.isDisplayed();	
	}
	

	public void cmrperformancereport_validation() {
		summary.isDisplayed();
		policy.isDisplayed();
		cmrmtmcenter.isDisplayed();
		exportcmrreport.isDisplayed();
		cmrcompletion.isDisplayed();
		patientseligible.isDisplayed();
	}

	public void downloadexcel_click() {
		downloadtoexcel.click();
	}
	
	public void tipperfdownloadexcel_click() throws InterruptedException {
		Thread.sleep(5000);
		downloadtoexcel.click();
	}
	
	public void downloadtext_click() throws InterruptedException {
		Thread.sleep(3000);
		downloadtotext.click();
	}
	
	public void oppsbycenterdownloadtext_click() throws InterruptedException {
		Thread.sleep(3000);
		oppsbycenterdownloadtotext.click();
	}
	
	public void currenttipdownloadtext_click() throws InterruptedException {
		Thread.sleep(3000);
		currenttipdownloadtotext.click();
	}
	
	public void tipperformancedownloadtext_click() throws InterruptedException {
		Thread.sleep(5000);
		tipperformancedownloadtotext.click();
	}
	
	
	
	public static String check_file_exist() {
		String home = System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
		String file_name = "Export_.*\\csv";
		String file_with_location = home + file_name;
		//System.out.println("file location: " + home + file_name);
		File file = new File(file_with_location);
		if (file.getName().startsWith("Export_")) {
			//System.out.println(file_with_location + " is present");
			String result = "File Present";
			return result;
		} else {
			System.out.println(file_with_location + " is not present");
			String result = "File not Present";
			String result1 = result;
			return result1;
		}
	}

	 public void delete_file() {
		 File dir = new File(System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/");
		 for (File f : dir.listFiles()) {
			    if (f.getName().startsWith("Export_")) {
			        f.delete();
			    }
			}
	 }
	 
	 public static String check_file_exist_cmrreport() {
			String home = System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
			String file_name = "CMR-Performance-.*\\xlsx";
			String file_with_location = home + file_name;
			//System.out.println("file location: " + home + file_name);
			File file = new File(file_with_location);
			if (file.getName().startsWith("CMR-Performance-")) {
				//System.out.println(file_with_location + " is present");
				String result = "File Present";
				return result;
			} else {
				System.out.println(file_with_location + " is not present");
				String result = "File not Present";
				String result1 = result;
				return result1;
			}
		}
	 
	 public void deletecmrreport_file() throws InterruptedException {
		 Thread.sleep(5000);
		 File dir = new File(System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/");
		 for (File f : dir.listFiles()) {
			    if (f.getName().startsWith("CMR-Performance-Report-")) {
			        f.delete();
			    }
			}
	 }
	 
	 public void viewedit_click() {
		 vieweditlink.click();
	 }
	 
	 public void pagination_validation1(){
		 String recordcount=recordresult.getText().substring(12,14);
		 if(recordcount.length() > 50) {
			 previousbutton.isDisplayed();
			 nextbutton.isDisplayed();
			 nextbutton.isEnabled();
			 System.out.println("The previous button is disabled and record count is greater than 50");
		 }
		 else {
			 JavascriptExecutor executor = (JavascriptExecutor) driver;
			 Boolean disabledprevious = (Boolean) executor.executeScript("return arguments[0].hasAttribute(\"disabled\");", previousbutton);
			 Boolean disablednext = (Boolean) executor.executeScript("return arguments[0].hasAttribute(\"disabled\");", nextbutton);
			 Assert.assertEquals(disabledprevious, disablednext);
			 System.out.println("The buttons are disabled and record count is less than 50");	 
		 }
	 }
	 
	 public void mtmclaimsheader_display() {
			mtmclaimsheader.isDisplayed();
		}
	 
	 public void oppsbycenterheader_display() {
		 oppsbycenterheader.isDisplayed();
		}
	 
	 public void currenttipsheader_display() {
		 currenttipsheader.isDisplayed();
		}
	 
	 public void tipperformanceheader_display() {
		 tipperformanceheader.isDisplayed();
		}
	 
	 public void cmrperformanceheader_display() {
		 cmrperformanceheader.isDisplayed();
		}
	 
	 public void pagination_validation(){
			 previousbutton.isDisplayed();
			 nextbutton.isDisplayed();
	 }
	 
	 public void medsort_select() throws InterruptedException {
		 medsortdrpdown.click();
		 commonMethods.implicitwait(defaultWaittime);
		 Select selmeddrp=new Select(medsortdrpdown);
		 selmeddrp.selectByValue("sortInitialDrugAsc");
	 }
	 
	 public void statussort_select() {
		 statussortdrpdown.click();
		 commonMethods.implicitwait(defaultWaittime);
		 Select selstatdrp=new Select(statussortdrpdown);
		 selstatdrp.selectByValue("sortStatusAsc");
		 
	 }
	 
	 public void encounterdate_sort() {
		 ArrayList<String> obtainedList = new ArrayList<>(); 
			List<WebElement> elementList= driver.findElements(By.xpath("/html[1]/body[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr/td[3]"));
			System.out.println(elementList.size());
			for(WebElement we:elementList){
				obtainedList.add(we.getText());
			}
			ArrayList<String> sortedList = new ArrayList<>();   
			for(String s:obtainedList){
				sortedList.add(s);
			}

			//Ascending Order
			Collections.sort(sortedList);
			Assert.assertTrue(sortedList.equals(obtainedList));	
	 }
	 
	 public void medications_sort() throws InterruptedException {
		 	medsort_select();
			commonMethods.implicitwait(defaultWaittime);
			ArrayList<String> obtainedList1 = new ArrayList<>(); 
			List<WebElement> elementList1= driver.findElements(By.xpath("//tbody/tr/td[4]/span[1]/span[1]"));
			System.out.println(elementList1.size());
			for(WebElement we:elementList1){
				obtainedList1.add(we.getText());
			}
			ArrayList<String> sortedList1 = new ArrayList<>();   
			for(String s:obtainedList1){
				sortedList1.add(s);
			}

			//Ascending Order
			Collections.sort(sortedList1);
			Assert.assertTrue(sortedList1.equals(obtainedList1));		
	 }
	 
	 public void status_sort() throws InterruptedException {
		 	statussort_select();
			commonMethods.implicitwait(defaultWaittime);
			ArrayList<String> obtainedList1 = new ArrayList<>(); 
			List<WebElement> elementList1= driver.findElements(By.xpath("/html[1]/body[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr/td[8]/span[1]"));
			System.out.println(elementList1.size());
			for(WebElement we:elementList1){
				obtainedList1.add(we.getText());
			}
			ArrayList<String> sortedList1 = new ArrayList<>();   
			for(String s:obtainedList1){
				sortedList1.add(s);
			}

			//Ascending Order
			Collections.sort(sortedList1);
			//Collections.reverse(sortedList1);
			Assert.assertTrue(sortedList1.equals(obtainedList1));		
	 }
	 
	 public void claimresultexcel_validation() {
		 String medreccount= medrecclaimresult.getAttribute("textContent").substring(6,8);
		 System.out.println(medreccount);
		 if(medreccount.length() > 0) {
			 downloadexcel_click();
			 boolean downloadexcelclicked= true;
			 if(downloadexcelclicked) {
				 check_file_exist();
				 commonMethods.implicitwait(defaultWaittime);
				 delete_file();			 
			 }
			 
		 }
		 else {
			 System.out.println("There are no records for Medrec claims Report");
		 }
	 }
	 
	 public void claimresulttext_validation() throws InterruptedException {
		 String medreccount= medrecclaimresult.getAttribute("textContent").substring(6,8);
		 System.out.println(medreccount);
		 if(medreccount.length() > 0) {
			 downloadtext_click();
			 boolean downloadtextclicked= true;
			 if(downloadtextclicked) {
				 delete_file();
				 commonMethods.implicitwait(defaultWaittime);
				 check_file_exist();			 
			 }
			 
		 }
		 else {
			 System.out.println("There are no records for Medrec/Medsync claims Report");
		 }
	 }
	 
	 public void roleselectperf(String roleselector) throws InterruptedException {
			rolelistperf.click();
			Select rolesel = new Select(rolelistperf);
			rolesel.selectByVisibleText(roleselector);
			Thread.sleep(2000);
			rolelistperf.click();
		}
	 
	 public void exportcmrreport_click() {
		// exportcmrrept.click();
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView();", exportcmrrept);
			executor.executeScript("arguments[0].click();", exportcmrrept);
	 }


	 

	
}