package com.ch.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ch.base.TestBase;
import com.ch.util.CommonMethods;

import junit.framework.Assert;

public class RxRulesPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'RxRules Engine')]")
	WebElement rxrulesengine;

	@FindBy(xpath = "//span[contains(text(),'RX Rules Engine')]")
	WebElement rxrulesengineheader;

	@FindBy(xpath = "//a[contains(text(),'New Rule')]")
	WebElement newrule;

	@FindBy(xpath = "//a[contains(text(),'Drug Lookup')]")
	WebElement druglookup;

	@FindBy(xpath = "//h3[contains(text(),'Clinical Rules Lookup')]")
	WebElement clinicalruleslookupheader;

	@FindBy(xpath = "//th[contains(text(),'Rule Name')]")
	WebElement rulename;

	@FindBy(xpath = "//body[1]/div[2]/section[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")
	WebElement id;

	@FindBy(xpath = "//th[contains(text(),'Status')]")
	WebElement status;

	@FindBy(xpath = "//h1[contains(text(),'Rx Rule')]")
	WebElement rxruleheader;

	@FindBy(xpath = "//input[@id='clinicalTitle']")
	public WebElement rulenameinput;

	@FindBy(css = "#newNoteEntry")
	WebElement clinicalnotes;

	@FindBy(xpath = "//button[@id='logicPreviewRule']")
	WebElement previewrule;

	@FindBy(xpath = "//button[@id='btnExportRxResults']")
	WebElement exporttoexcel;
	
	@FindBy(xpath = "//button[@id='drugLookupBtn']")
	WebElement druglookupexporttoexcel;

	@FindBy(css = "#btnSaveNote")
	WebElement savenote;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement firstrecord;

	@FindBy(xpath = "//a[contains(text(),'Edit Rule')]")
	WebElement editrule;

	@FindBy(xpath = "//a[@id='navDeleteDraftLink']")
	WebElement deletedraft;

	@FindBy(xpath = "//a[@id='navApproveLink']")
	WebElement approve;

	@FindBy(xpath = "//span[@id='infoSuccess']")
	WebElement notessuccessmsg;

	@FindBy(xpath = "//body/div[2]/section[2]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]")
	WebElement notesdropdown;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/section[2]/div[1]/div[1]/div[1]/p[2]")
	WebElement savednote;

	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[6]/div[1]/div[1]/div[4]/button[2]")
	WebElement deletenotealert;

	@FindBy(xpath = "//input[@id='conditionalRowValue1']")
	public
	WebElement diagnoscode;

	@FindBy(xpath = "//body[1]/div[3]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]")
	WebElement gpi;

	@FindBy(xpath = "//body[1]/div[3]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")
	WebElement ndc;

	@FindBy(xpath = "//th[contains(text(),'Drug Name Strength')]")
	WebElement drugnamestrength;

	@FindBy(xpath = "//body[1]/div[3]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[4]")
	WebElement chronic;

	@FindBy(xpath = "//th[contains(text(),'Ingredient Name')]")
	WebElement ingredientname;

	@FindBy(xpath = "//th[contains(text(),'Generic')]")
	WebElement generic;

	@FindBy(xpath = "//th[contains(text(),'Manufacturer')]")
	WebElement manufacturer;

	@FindBy(xpath = "//th[contains(text(),'AHSF')]")
	WebElement ahsf;

	@FindBy(xpath = "//body/div[3]/div[7]/div[1]/div[1]/div[4]/button[2]")
	WebElement savedraftedrule;

	@FindBy(xpath = "//input[@id='saveRuleAgree']")
	WebElement saveruleagree;

	@FindBy(xpath = "//span[@id='infoSuccess']")
	WebElement createrulesuccessmsg;

	@FindBy(xpath = "//input[@id='draftYes']")
	WebElement deletedraftyes;

	@FindBy(xpath = "//body/div[3]/div[9]/div[1]/div[1]/div[4]/button[2]")
	WebElement deletebutton;

	@FindBy(xpath = "//a[@id='saveRuleLink']")
	WebElement savenewrule;

	@FindBy(xpath = "//body/div[2]/section[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
	WebElement deletedropdown;

	@FindBy(xpath = "/html/body/div[3]/section[1]/div/div/div/div[3]/div[1]/div")
	WebElement resultset;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
	WebElement resultset1;
	
	@FindBy(xpath = "//a[contains(text(),'Add for Approval')]")
	WebElement addforapproval;
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[11]/div[1]/div[1]/div[4]/button[2]")
	WebElement approvebutton;
	
	@FindBy(xpath = "//span[@id='infoSuccess']")
	WebElement addforapprovalsuccessmsg;
	
	@FindBy(xpath = "//a[@id='navApproveLink']")
	WebElement approverule;
	
	@FindBy(xpath = "//input[@id='approveAgree']")
	WebElement approveagree;
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[10]/div[1]/div[1]/div[4]/button[2]")
	WebElement approveruleapprovebutton;
	
	@FindBy(xpath = "/html[1]/body[1]/header[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/b[1]")
	WebElement logdropdown;
	
	@FindBy(xpath = "//input[@id='searchInput']")
	public WebElement filterinput;
	
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	WebElement logout;
	
	@FindBy(xpath = "//input[@id='lookupVal']")
	WebElement druglookupsearch;
	
	String csvFileName;
	CommonMethods commonMethods;
	
	int defaultwaittime=15;

	public RxRulesPage() {
		PageFactory.initElements(driver, this);
		commonMethods = new CommonMethods();
	}

	public void rxrulesengine_click() {
		rxrulesengine.click();		
	}

	public void newrule_click() {
		newrule.click();		
	}

	public void rxrulesenginefields_display() {
		rxrulesengineheader.isDisplayed();
		newrule.isDisplayed();
		druglookup.isDisplayed();
		clinicalruleslookupheader.isDisplayed();
		rulename.isDisplayed();
		id.isDisplayed();
		status.isDisplayed();
		rxruleheader.isDisplayed();
	}

	public void notesinput() {
		clinicalnotes.sendKeys("AutomationTesting");
	}
	
	public void editrule_click() throws InterruptedException {
		//editrule.click();
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", editrule);
		executor.executeScript("arguments[0].click();", editrule);
	}
	
	public void druglookup_click() {
		druglookup.click();
	}
	
	public void druglookup_input() throws InterruptedException {
		druglookupsearch.sendKeys("292");
		Thread.sleep(3000);
	}
	
	
	public void firstrec_click() throws InterruptedException {
		Thread.sleep(3000);
		firstrecord.click();
		Thread.sleep(2000);
	}

	public void saverule_click() throws InterruptedException {
		//savenewrule.click();
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", savenewrule);
		executor.executeScript("arguments[0].click();", savenewrule);
	}

	public void notesdrpdown_click() {
		notesdropdown.click();
	}

	public void save_click() {
		savenote.click();
	}

	public void savedraftedrule_click() {
		savedraftedrule.click();
	}
	
	public void filterrule_input() throws InterruptedException {
		filterinput.sendKeys("CardinalAutomationTesting");
		//filterinput.sendKeys(Keys.TAB);
		Thread.sleep(5000);
	}

	
	public void save() throws InterruptedException {
		saverule_click();
		commonMethods.implicitwait(defaultwaittime);
		saveruleagree_click();
		commonMethods.implicitwait(defaultwaittime);
		savedraftedrule_click();
		commonMethods.implicitwait(defaultwaittime);
	}

	public void delete_click() throws InterruptedException {
		//deletedraft.click();
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", deletedraft);
		executor.executeScript("arguments[0].click();", deletedraft);
	}
	
	public void approve_click() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", approvebutton);
		executor.executeScript("arguments[0].click();", approvebutton);
	}
	
	public void approveruleapprovebutton_click() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", approveruleapprovebutton);
		executor.executeScript("arguments[0].click();", approveruleapprovebutton);
	}
	
	
	
	public void addforapprovalmsg_validation() {
		String actualaddforapprovalsuccessmsg= addforapprovalsuccessmsg.getText().trim();
		System.out.println("addforapproval success message:" +actualaddforapprovalsuccessmsg);
		String expectedaddforapprovalsuccessmsg = "Rule will not be active until it is approved.";
		Assert.assertEquals(expectedaddforapprovalsuccessmsg, actualaddforapprovalsuccessmsg);	
	}
	
	public void approverulemsg_validation() {
		String actualapproverulesuccessmsg= addforapprovalsuccessmsg.getText().trim();
		System.out.println("approverule success message:" +actualapproverulesuccessmsg);
		String expectedruleapprovalsuccessmsg = "Rule was successfully approved.";
		Assert.assertEquals(expectedruleapprovalsuccessmsg, actualapproverulesuccessmsg);	
	}
	
	public void addforapproval_validation() throws InterruptedException {
		addforapproval_click();
		commonMethods.implicitwait(defaultwaittime);
		approve_click();
		commonMethods.implicitwait(defaultwaittime);
		addforapprovalmsg_validation();
		commonMethods.implicitwait(defaultwaittime);
	}
	
	public void approverule_validation() throws InterruptedException {
		approverule_click();
		commonMethods.implicitwait(defaultwaittime);
		approveagree_click();
		commonMethods.implicitwait(defaultwaittime);
		approveruleapprovebutton_click();
		commonMethods.implicitwait(defaultwaittime);
		approverulemsg_validation();
	}

	public void deletedropdwn_click() {
		deletedropdown.click();
	}
	
	public void approverule_click() throws InterruptedException {
		approverule.click();
		Thread.sleep(2000);
	}

	public void saveruleagree_click() {
		saveruleagree.click();
	}
	
	public void approveagree_click() {
		approveagree.click();
	}

	public void savednote_validation() {
		String actualtext=savednote.getText();
		System.out.println("Note:" +actualtext);
		String expectedtext = "AutomationTesting";
		Assert.assertEquals(expectedtext, actualtext);
	}
	
	
	public void addforapproval_click() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", addforapproval);
		executor.executeScript("arguments[0].click();", addforapproval);
		//addforapproval.click();
		Thread.sleep(2000);
	}

	public void rulename_input() {
		String rxrulename = "CardinalTesting" + RandomStringUtils.randomNumeric(3);
		rulenameinput.sendKeys(rxrulename);
	}

	public void newrule_inputdetails() {
		rulename_input();
		diagnosiscode_input();
		notesinput();
	}
	
	public void diagnosiscode_input() {
		diagnoscode.sendKeys("292");
	}
	
	public void diagnosiscode_clear() {
		diagnoscode.clear();
	}
	
	public void diagnosiscode_edit() throws InterruptedException {
		Thread.sleep(2000);
		String diagnosisinpt= diagnoscode.getAttribute("value");
		//System.out.println("Diagnosis code:" +diagnosisinpt);
		if(diagnosisinpt.contains("G912")){
			diagnosiscode_clear();
			diagnoscode.sendKeys("G6");}
		else if(diagnosisinpt.contains("G6")){
			diagnosiscode_clear();
			diagnoscode.sendKeys("G912");}		
		else {
			diagnosiscode_clear();
			diagnoscode.sendKeys("G912");}
	}
	
	public void logdropdown_click() {
		logdropdown.click();
	}
	
	public void logout_click() {
		logdropdown_click();
		logout.click();
	}

	public void preview_click() throws InterruptedException {
		//preview.click();
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", previewrule);
		executor.executeScript("arguments[0].click();", previewrule);

	}

	public void preview_display() {
		gpi.isDisplayed();
		ndc.isDisplayed();
		drugnamestrength.isDisplayed();
		chronic.isDisplayed();
		ingredientname.isDisplayed();
		generic.isDisplayed();
		manufacturer.isDisplayed();
		ahsf.isDisplayed();
	}

	public void newrulevalidation() {
		String actualtext=rulenameinput.getAttribute("value");
		System.out.println("rulename:" +actualtext);
		String expectedtext = "CardinalAutomationTesting";
		Assert.assertEquals(expectedtext, actualtext);	
	}

	public void rulesuccessmsg_validation() {
		String actualsuccessmsg= createrulesuccessmsg.getText().trim();
		System.out.println("rule success message:" +actualsuccessmsg);
		String expectedsuccessmssg = "Rule has been saved successfully.";
		Assert.assertEquals(expectedsuccessmssg, actualsuccessmsg);	
	}

	public void notessuccessmsg_validation() {
		String actualsuccessmsg= notessuccessmsg.getText().trim();
		System.out.println("notes success message:" +actualsuccessmsg);
		String expectedsuccessmssg = "Note has been saved successfully.";
		Assert.assertEquals(expectedsuccessmssg, actualsuccessmsg);	
	}

	public void exporttoexcel_click() throws InterruptedException {
		exporttoexcel.click();
		Thread.sleep(8000);
	}
	
	public void druglookup_exporttoexcel() throws InterruptedException {
		druglookupexporttoexcel.click();
		Thread.sleep(3000);
	}

	public void deletedraft_click() {
		deletedraftyes.click();
	}

	public void deletebutton_click() {
		deletebutton.click();
	}

	public void deletenotealert_click() {
		deletenotealert.click();
	}

	public void resultset_validation() {
		String result= resultset.getText();
		System.out.println("Result set:" +result);
		String[] parts = result.split(" ");
		String OS = parts[3];
		//int a=Integer.parseInt(OS);
		System.out.println(OS);
	}
	
	public void resultset1_validation() {
		String result= resultset1.getText();
		System.out.println("Result set:" +result);
		String[] parts = result.split(" ");
		String OS = parts[3];
		//int a=Integer.parseInt(OS);
		System.out.println(OS);
	}
	
	public void existingrulevalidation() {
		String actualtext=rulenameinput.getAttribute("value");
		System.out.println("rulename:" +actualtext);
		String expectedtext = "CardinalAutomationTesting";
		Assert.assertEquals(expectedtext, actualtext);	
	}

	public static String check_file_exist() {
		String home = System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
		String file_name = "Medical.*\\csv";
		String file_with_location = home + file_name;
		System.out.println("file location: " + home + file_name);
		File file = new File(file_with_location);
		if (file.getName().startsWith("Medical")) {
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

	public void delete_file() throws InterruptedException {
		Thread.sleep(5000);
		File dir = new File(System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/");
		for (File f : dir.listFiles()) {
			if (f.getName().contains("Export")) {
				f.delete();
			}
		}	
	}

	private File getLatestFilefromDir(){
		String dirPath =System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
	
	public int getRecordsCountInCSV_exportrule() {		
		int lineNumberCount = 0;
		try {
			String downloadPath =System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
			File file = getLatestFilefromDir();
		    csvFileName = file.getName();
			System.out.println("CSV File Downloaded is :- "+csvFileName);
			if (!csvFileName.isEmpty() || csvFileName != null) {
				String filePath =	downloadPath + System.getProperty("file.separator") + csvFileName;
				System.out.println(filePath);
				File file1 = new File(filePath);
				if (file.exists()) {
					System.out.println("File found :" +csvFileName);
					FileReader fr = new FileReader(file1);
					LineNumberReader linenumberreader = new LineNumberReader(fr);
					while (linenumberreader.readLine() != null) {
						lineNumberCount++;
					}
					//To remove the header
					lineNumberCount=lineNumberCount-1;
					System.out.println("Total number of lines found in csv : " + (lineNumberCount));
					String csvrec = Integer.toString(lineNumberCount);
					
					String result= resultset.getText();
					System.out.println("Result set:" +result);
					String[] parts = result.split(" ");
					String resultnumber = parts[5];
					String resultids = resultnumber.replaceAll(",","");
					//int a=Integer.parseInt(OS);
					System.out.println(resultids);
					Assert.assertEquals(resultids,csvrec);
					System.out.println("The generated csv contains records and is validated with total number of records on UI and csv");
					linenumberreader.close();
				} else {
					System.out.println("File does not exists");
				}	
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return lineNumberCount;
	}
	
	public int getRecordsCountInCSV_exportrule1() {		
		int lineNumberCount = 0;
		try {
			String downloadPath =System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
			File file = getLatestFilefromDir();
		    csvFileName = file.getName();
			System.out.println("CSV File Downloaded is :- "+csvFileName);
			if (!csvFileName.isEmpty() || csvFileName != null) {
				String filePath =	downloadPath + System.getProperty("file.separator") + csvFileName;
				System.out.println(filePath);
				File file1 = new File(filePath);
				if (file.exists()) {
					System.out.println("File found :" +csvFileName);
					FileReader fr = new FileReader(file1);
					LineNumberReader linenumberreader = new LineNumberReader(fr);
					while (linenumberreader.readLine() != null) {
						lineNumberCount++;
					}
					//To remove the header
					lineNumberCount=lineNumberCount-1;
					System.out.println("Total number of lines found in csv : " + (lineNumberCount));
					String csvrec = Integer.toString(lineNumberCount);
					
					String result= resultset1.getText();
					System.out.println("Result set:" +result);
					String[] parts = result.split(" ");
					String resultnumber = parts[5];
					String resultids = resultnumber.replaceAll(",","");
					//int a=Integer.parseInt(OS);
					System.out.println(resultids);
					Assert.assertEquals(resultids,csvrec);
					System.out.println("The generated csv contains records and is validated with total number of records on UI and csv");
					linenumberreader.close();
				} else {
					System.out.println("File does not exists");
				}	
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return lineNumberCount;
	}






}