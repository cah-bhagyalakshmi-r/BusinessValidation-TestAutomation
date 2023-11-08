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

public class QAAdminReportsPage extends TestBase {

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

	@FindBy(xpath = "//button[contains(text(),'Go')]")
	public WebElement gobutton;

	@FindBy(css = "#submitswitchRoles")
	public WebElement gobutton1;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/connect-platform-navigation[1]/div[1]/div[2]/div[2]/div[1]/span[1]/span[1]/span[1]/a[1]/p[1]")
	public WebElement mtmclaims;

	@FindBy(xpath = "//p[contains(text(),'MedRec Claims')]")
	public WebElement medrecclaims;

	@FindBy(xpath = "//p[contains(text(),'MedSync Claims')]")
	public WebElement medsyncclaims;

	@FindBy(xpath = "//p[contains(text(),'MTM Claims - Adherence')]")
	public WebElement mtmclaimsadherence;

	@FindBy(xpath = "//h1[contains(text(),'MTM Claims')]")
	public WebElement mtmclaimsheader;

	@FindBy(xpath = "//select[@id='claimStatus']")
	public WebElement claimstatus;

	@FindBy(xpath = "//select[@id='ClaimStatusList']")
	public WebElement claimstatuslist;

	@FindBy(xpath = "//input[@id='nabp']")
	public WebElement ncdp;

	@FindBy(xpath = "//input[@id='NCPDPList']")
	public WebElement ncdplist;

	@FindBy(css = "#searchClaimsQA")
	public WebElement searchbutton;

	@FindBy(xpath = "//h1[contains(text(),'MTM Claims Report')]")
	public WebElement mtmcclaimsreportheader;

	@FindBy(xpath = "//h1[contains(text(),'MedRec Claim Detail Report')]")
	public WebElement medreccclaimsreportheader;

	@FindBy(xpath = "//h1[contains(text(),'MedSync Medication Detail Report')]")
	public WebElement medsyncclaimsreportheader;

	@FindBy(xpath = "//h1[contains(text(),'MedRec Claims')]")
	public WebElement medrecclaimsheader;

	@FindBy(xpath = "//h1[contains(text(),'MedSync Claims')]")
	public WebElement medsyncclaimsheader;

	@FindBy(xpath = "//p[contains(text(),'Adherence Claims Report')]")
	public WebElement mtmclaimsadherenceheader;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/div/div[2]/div/div[2]/div[4]/div/div[1]/div/div[1]/div/div/div[1]")
	public WebElement claimstatusinput;

	@FindBy(xpath = "//select[@id='dateselect']")
	public WebElement daterange;

	@FindBy(css = "#claimSummarySort")
	public WebElement claimsummary;

	@FindBy(css = "#claimDateSort")
	public WebElement encounterdate;

	@FindBy(css = "#medicationSort")
	public WebElement medications;

	@FindBy(css = "#patientSort")
	public WebElement patient;

	@FindBy(css = "#pharmacySort")
	public WebElement pharmacy;

	@FindBy(css = "#serviceProviderSort")
	public WebElement serviceprovider;

	@FindBy(css = "#claimStatusSort")
	public WebElement status;

	@FindBy(css = "#fileDownloadCustomRichExperience")
	public WebElement downloadtoexcel;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/form[1]/div[1]/p[1]/a[2]")
	public WebElement downloadtotext;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]")
	public WebElement claimnumber;

	@FindBy(xpath = "//tbody/tr[1]/td[8]/a[1]")
	public WebElement vieweditlink;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/h1[1]")
	public WebElement claimnumresult;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/form[1]/div[1]/div[1]/div[1]/span[1]")
	public WebElement recordresult;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/form[1]/div[1]/div[1]/div[1]/span[1]")
	public List<WebElement> recordresult1;

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

	@FindBy(xpath = "/html/body/div[1]/div/div/connect-platform-navigation/div/div[1]/div[5]/flux-card/div/div/select")
	public WebElement rolelistnew;

	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	public WebElement dashboardlink;
	
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	public WebElement mtmadherencesearch;
	
	@FindBy(xpath = "//input[@id='adherenceClaimsReportPharmacy']")
	public WebElement mtmadherencepharmacyinput;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[1]")
	public WebElement Adherenceclaimsummary;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[2]")
	public WebElement Adherencedate;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[3]")
	public WebElement Adherencemedication;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[4]")
	public WebElement Adherencepatient;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[5]")
	public WebElement Adherencepharmacy;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[6]")
	public WebElement Adherenceserviceprovider;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[7]")
	public WebElement Adherencestatus;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[8]")
	public WebElement Adherenceview;
	
	@FindBy(xpath = "//button[contains(text(),'Export All')]")
	public WebElement exportall;

	String currentDate = new SimpleDateFormat("MMddyyyy").format(new Date());
	Date todayDate = new Date();
	Date tomorrowDate = new Date(todayDate.getTime() + (1000 * 60 * 60 * 24));
	String cmrDate = new SimpleDateFormat("MMddyyyy").format(tomorrowDate);
	int defaultWaittime = 5;

	CommonMethods commonMethods = new CommonMethods();

	public QAAdminReportsPage() {
		PageFactory.initElements(driver, this);
	}

	public void mainmenuclick() throws InterruptedException {
		Thread.sleep(2000);
		mainmenu.click();
	}

	public void switchrolesmenu() {
		rolelabel.click();
	}

	public void dashboard_display() throws InterruptedException {
		Thread.sleep(10000);
		dashboardlink.isDisplayed();
		Thread.sleep(3000);
	}

	public void roleselectnew(String roleselector) throws InterruptedException {
		rolelistnew.click();
		Select rolesel = new Select(rolelistnew);
		rolesel.selectByVisibleText(roleselector);
		Thread.sleep(2000);
		rolelistnew.click();
	}

	public void roleselect(String roleselector) throws InterruptedException {
		// rolelist.click();
		Select rolesel = new Select(rolelist);
		rolesel.selectByVisibleText(roleselector);
		Thread.sleep(1000);
		rolelist.click();
	}

	public void roleselect1(String roleselector) {
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

	public void medrecclaims_click() {
		medrecclaims.click();
	}

	public void medsyncclaims_click() {
		medsyncclaims.click();
	}

	public void mtmclaimsadherence_click() {
		mtmclaimsadherence.click();
	}

	public void mtmclaimsheader_display() {
		mtmclaimsheader.isDisplayed();
	}

	public void medrecclaimsheader_display() {
		medrecclaimsheader.isDisplayed();
	}

	public void medsyncclaimsheader_display() {
		medsyncclaimsheader.isDisplayed();
	}

	public void mtmclaimsadherenceheader_display() {
		mtmclaimsadherenceheader.isDisplayed();
	}

	public void claimstatus_select() throws InterruptedException {
		Thread.sleep(2000);
		Select select = new Select(claimstatus);
		select.selectByValue("Pending approval");
	}

	public void claimstatus_input() throws InterruptedException {
		claimstatusinput.click();
		Thread.sleep(2000);
		claimstatusinput.sendKeys("Pending Approval");
	}

	public void claimstatuslist_select() throws InterruptedException {
		Thread.sleep(2000);
		Select select = new Select(claimstatuslist);
		select.selectByValue("2");
	}

	public void ncdp_input() {
		ncdp.sendKeys("9999990");
	}
	
	public void adherencencdp_input() {
		mtmadherencepharmacyinput.sendKeys("9999990");
	}

	public void ncdplist_input() {
		ncdplist.sendKeys("9999990");
	}

	public void searchbutton_click() {
		searchbutton.click();
	}

	public void mtmclaimsreportheader_display() {
		mtmcclaimsreportheader.isDisplayed();
	}

	public void medrecclaimsreportheader_display() {
		medreccclaimsreportheader.isDisplayed();
	}

	public void medsyncclaimsreportheader_display() {
		medsyncclaimsreportheader.isDisplayed();
	}

	public void datarange_select() {
		// daterange
	}

	public void mtmclaimsreport_validation() {
		claimsummary.isDisplayed();
		encounterdate.isDisplayed();
		medications.isDisplayed();
		patient.isDisplayed();
		pharmacy.isDisplayed();
		serviceprovider.isDisplayed();
		status.isDisplayed();
	}

	public void downloadexcel_click() {
		downloadtoexcel.click();
	}

	public void downloadtext_click() {
		downloadtotext.click();
	}

	public static String check_file_exist() {
		String home = System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
		String file_name = "Export_.*\\csv";
		String file_with_location = home + file_name;
		// System.out.println("file location: " + home + file_name);
		File file = new File(file_with_location);
		if (file.getName().startsWith("Export_")) {
			// System.out.println(file_with_location + " is present");
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
	
	public static String check_file_exist1() {
		String home = System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
		String file_name = "Adherence-.*\\csv";
		String file_with_location = home + file_name;
		// System.out.println("file location: " + home + file_name);
		File file = new File(file_with_location);
		if (file.getName().startsWith("Adherence")) {
			 System.out.println(file_with_location + " is present");
			String result = "File Present";
			return result;
		} else {
			System.out.println(file_with_location + " is not present");
			String result = "File not Present";
			String result1 = result;
			return result1;
		}
	}

	public void delete_file1() throws InterruptedException {
		Thread.sleep(3000);
		File dir = new File(System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/");
		for (File f : dir.listFiles()) {
			if (f.getName().startsWith("Adherence-Report.csv")) {
				f.delete();
			}
		}
	}

	public void viewedit_click() {
		vieweditlink.click();
	}

	public void pagination_validation() {
		String recordcount = recordresult.getAttribute("innerText").trim();
		System.out.println(recordcount);
		String reccnt1 = recordcount.substring(19, 21);
		System.out.println(reccnt1);
		int recnt = Integer.parseInt(reccnt1);
		if (recnt > 50) {
			previousbutton.isDisplayed();
			nextbutton.isDisplayed();
			nextbutton.isEnabled();
			System.out.println(
					"The previous button is disabled next button is enabled and record count is greater than 50");
		} else {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			Boolean disabledprevious = (Boolean) executor
					.executeScript("return arguments[0].hasAttribute(\"disabled\");", previousbutton);
			Boolean disablednext = (Boolean) executor.executeScript("return arguments[0].hasAttribute(\"disabled\");",
					nextbutton);
			Assert.assertEquals(disabledprevious, disablednext);
			System.out.println("The buttons are disabled and record count is less than 50");
		}
	}

	public void medsort_select() throws InterruptedException {
		medsortdrpdown.click();
		commonMethods.implicitwait(defaultWaittime);
		Select selmeddrp = new Select(medsortdrpdown);
		selmeddrp.selectByValue("sortInitialDrugAsc");
	}

	public void statussort_select() {
		statussortdrpdown.click();
		commonMethods.implicitwait(defaultWaittime);
		Select selstatdrp = new Select(statussortdrpdown);
		selstatdrp.selectByValue("sortStatusAsc");

	}

	public void encounterdate_sort() {
		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> elementList = driver
				.findElements(By.xpath("/html[1]/body[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr/td[3]"));
		System.out.println(elementList.size());
		for (WebElement we : elementList) {
			obtainedList.add(we.getText());
		}
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}

		// Ascending Order
		Collections.sort(sortedList);
		Assert.assertTrue(sortedList.equals(obtainedList));
	}

	public void medications_sort() throws InterruptedException {
		medsort_select();
		commonMethods.implicitwait(defaultWaittime);
		ArrayList<String> obtainedList1 = new ArrayList<>();
		List<WebElement> elementList1 = driver.findElements(By.xpath("//tbody/tr/td[4]/span[1]/span[1]"));
		System.out.println(elementList1.size());
		for (WebElement we : elementList1) {
			obtainedList1.add(we.getText());
		}
		ArrayList<String> sortedList1 = new ArrayList<>();
		for (String s : obtainedList1) {
			sortedList1.add(s);
		}

		// Ascending Order
		Collections.sort(sortedList1);
		Assert.assertTrue(sortedList1.equals(obtainedList1));
	}

	public void status_sort() throws InterruptedException {
		statussort_select();
		commonMethods.implicitwait(defaultWaittime);
		ArrayList<String> obtainedList1 = new ArrayList<>();
		List<WebElement> elementList1 = driver
				.findElements(By.xpath("/html[1]/body[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr/td[8]/span[1]"));
		System.out.println(elementList1.size());
		for (WebElement we : elementList1) {
			obtainedList1.add(we.getText());
		}
		ArrayList<String> sortedList1 = new ArrayList<>();
		for (String s : obtainedList1) {
			sortedList1.add(s);
		}

		// Ascending Order
		Collections.sort(sortedList1);
		// Collections.reverse(sortedList1);
		Assert.assertTrue(sortedList1.equals(obtainedList1));
	}

	public void claimresultexcel_validation() throws InterruptedException  {
		Thread.sleep(3000);
		String medreccount = medrecclaimresult.getAttribute("textContent").substring(6, 8);
		System.out.println(medreccount);
		if (medreccount.length() > 0) {
			downloadexcel_click();
			boolean downloadexcelclicked = true;
			if (downloadexcelclicked) {
				check_file_exist();
				commonMethods.implicitwait(defaultWaittime);
				delete_file();
			}

		} else {
			System.out.println("There are no records for Medrec claims Report");
		}
	}
	
	public void mtmadherence_search() {
		mtmadherencesearch.click();
	}
	
	 
	 public void adherenceexport_fielddisplay() {
		Adherenceclaimsummary.isDisplayed();
		Adherencedate.isDisplayed();
		Adherencemedication.isDisplayed();
		Adherencepatient.isDisplayed();
		Adherencepharmacy.isDisplayed();
		Adherenceserviceprovider.isDisplayed();
		Adherencestatus.isDisplayed();
		Adherenceview.isDisplayed();
		exportall.isDisplayed();
			
	 }
	 
	 public void exportall_click() {
		 exportall.click();
	 }

	public void claimresulttext_validation() throws InterruptedException {
		Thread.sleep(3000);
		String medreccount = medrecclaimresult.getAttribute("textContent").substring(6, 8);
		System.out.println(medreccount);
		if (medreccount.length() > 0) {
			downloadtext_click();
			boolean downloadtextclicked = true;
			if (downloadtextclicked) {
				check_file_exist();
				commonMethods.implicitwait(defaultWaittime);
				delete_file();
				Thread.sleep(2000);
			}

		} else {
			System.out.println("There are no records for Medrec/Medsync claims Report");
		}
	}}


