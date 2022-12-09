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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ch.base.TestBase;
import com.ch.util.CommonMethods;

import junit.framework.Assert;

public class DxEngPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'DxRules Engine')]")
	WebElement dxrulesengine;

	@FindBy(xpath = "//span[contains(text(),'DX Rules Engine')]")
	WebElement dxrulesengineheader;

	@FindBy(xpath = "//button[contains(text(),'New Rule')]")
	WebElement newrule;

	@FindBy(xpath = "//h3[contains(text(),'Existing Disease State')]")
	WebElement existingdiseasestateheader;

	@FindBy(xpath = "//th[contains(text(),'Name')]")
	WebElement name;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement existingdiseasestateinput;

	@FindBy(xpath = "//th[contains(text(),'ID')]")
	WebElement id;

	@FindBy(xpath = "//thead/tr[1]/th[3]")
	WebElement status;

	@FindBy(xpath = "//input[@id='disease-name-input']")
	WebElement diseasenameinput;
	
	@FindBy(xpath = "//input[@id='display-name-input']")
	WebElement displaynameinput;
	
	@FindBy(xpath = "//select[@id='category-select']")
	WebElement category;
	
	@FindBy(xpath = "//input[@id='effective-date-input']")
	WebElement effectivedateinput;
	
	@FindBy(xpath = "//input[@id='cboisCore']")
	WebElement core;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/select[1]/option[1]")
	WebElement overlap;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]/option[2]")
	public WebElement ruleselection;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/section[2]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")
	public WebElement ruleselected;

	@FindBy(xpath = "//button[@id='btnCreate']")
	WebElement create;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/textarea[1]")
	WebElement notes;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/textarea[1]")
	WebElement editnotes;

	@FindBy(xpath = "//a[contains(text(),'Export All')]")
	WebElement exportall;
	
	@FindBy(xpath = "//a[contains(text(),'Export Rule')]")
	WebElement exportrule;

	@FindBy(xpath = "//button[contains(text(),'Save Note')]")
	WebElement savenote;
	
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement save;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement firstrecord;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[3]")
	WebElement statusrecord;

	@FindBy(xpath = "//button[@id='btnEditRule']")
	WebElement editrule;

	@FindBy(xpath = "//button[contains(text(),'Delete Rule')]")
	WebElement deleterule;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/section[1]/div[3]/div[1]/div[1]/p[2]")
	WebElement savednote;
	
	@FindBy(xpath = "//button[contains(text(),'Add Selection')]")
	WebElement addselection;
	
	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement okbutton;
	
	@FindBy(xpath = "//div[contains(text(),'Rule created successfully')]")
	WebElement createrulesuccessmsg;
	
	@FindBy(xpath = "//div[contains(text(),'Rule deleted successfully')]")
	WebElement deleterulesuccessmsg;
		
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]")
	WebElement editrulesuccessmsg;
	
	@FindBy(xpath = "//div[contains(text(),'Rule Status was updated')]")
	WebElement addforapprovalsuccessmsg;
	
	@FindBy(xpath = "//div[contains(text(),'Rule was successfully approved. Rule will not beco')]")
	WebElement approverulesuccessmsg;
	
	@FindBy(xpath = "//button[contains(text(),'Add for Approval')]")
	WebElement addforapproval;
	
	@FindBy(xpath = "//button[contains(text(),'Approve Rule')]")
	WebElement approverule;
	
	@FindBy(xpath = "/html[1]/body[1]/header[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/b[1]")
	WebElement logdropdown;
	
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	WebElement logout;
	
	
	String csvFileName;
	int defaultwaittime=15;
	
	CommonMethods commonMethods;

	public DxEngPage() {
		PageFactory.initElements(driver, this);
		commonMethods = new CommonMethods();
	}

	public void dxrulesengine_click() {
		dxrulesengine.click();		
	}

	public void newrule_click() {
		newrule.click();		
	}
	
	public void logdropdown_click() {
		logdropdown.click();
	}
	
	public void logout_click() {
		logdropdown_click();
		logout.click();
	}
	
	public void dxrulesenginefields_display() {
		dxrulesengineheader.isDisplayed();
		newrule.isDisplayed();
		existingdiseasestateheader.isDisplayed();
		name.isDisplayed();
		id.isDisplayed();
		status.isDisplayed();
	}

	public void notesinput() {
		notes.sendKeys("AutomationTesting");
	}
	
	public void existingstate_input() {
		existingdiseasestateinput.sendKeys("CardinalAutomationTesting");
	}

	public void newrule_save() throws InterruptedException {
		newrule_click();
		commonMethods.implicitwait(defaultwaittime);
		newrule_inputdetails();
		commonMethods.implicitwait(defaultwaittime);
		createbutton_click();
		commonMethods.implicitwait(defaultwaittime);
		okbutton_click();
		commonMethods.implicitwait(defaultwaittime);
	    newrulevalidation();
	}
	
	public void editnotesinput() {
		editnotes.sendKeys("AutomationTesting");
	}	

	public void firstrec_click() throws InterruptedException {
		firstrecord.click();
		Thread.sleep(2000);
	}

	public void save_click() {
		savenote.click();
	}
	
	public void delete_click() throws InterruptedException {
		//deletedraft.click();
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", deleterule);
		executor.executeScript("arguments[0].click();", deleterule);
	}

	public void savednote_validation() {
		String actualtext=savednote.getText();
		System.out.println("Note:" +actualtext);
		String expectedtext = "AutomationTesting";
		Assert.assertEquals(expectedtext, actualtext);
	}

	public void diseasename_input() {
		diseasenameinput.sendKeys("CardinalAutomationTesting");
	}
	
	public void displayname_input() {
		displaynameinput.sendKeys("CardinalAutoTesting");
	}
	
	public void category_select() {
		Select select = new Select(category);
		select.selectByVisibleText("GI");
	}
	
	public void core_click() {
		core.click();
	}
	
	public void overlap_click() {
		overlap.click();
	}
	
	public void ruleselection_click() throws InterruptedException {
		ruleselection.click();
	}
	
	public void addselection_click() {
		addselection.click();
	}
	
	public void editrule_click() {
		editrule.click();
	}
	
	public void savebutton_click() throws InterruptedException {
		//save.click();
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", save);
		executor.executeScript("arguments[0].click();", save);
	}
	
	public void effectivedate_input() {
		effectivedateinput.click();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String futuredate = dateFormat.format(tomorrow);
		effectivedateinput.sendKeys(futuredate);
		effectivedateinput.sendKeys(Keys.TAB);
	}
	
	public void effectivedate_clear() throws InterruptedException{
		effectivedateinput.clear();
		//effectivedateinput.sendKeys(Keys.COMMAND + "a");
		//effectivedateinput.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
	}
	
	public void effectivedate_gettext(){
		String addedeffdate= effectivedateinput.getAttribute("value");
		System.out.println("added effectivedate:" +addedeffdate);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String futuredate = dateFormat.format(tomorrow);
		System.out.println("expected effectivedate:" +futuredate);
		
		Assert.assertEquals(futuredate, addedeffdate);
	}
	
	public void newrule_inputdetails() throws InterruptedException {
		diseasename_input();
		displayname_input();
		category_select();
		core_click();
		overlap_click();
		effectivedate_input();
		ruleselection_click();
		addselection_click();
		notesinput();
	}
	
	public void createbutton_click() {
		create.click();
	}
	
	public void okbutton_click() {
		okbutton.click();
	}
	
	public void addforapproval_click() throws InterruptedException {
		addforapproval.click();
		Thread.sleep(2000);
	}
	
	public void approverule_click() throws InterruptedException {
		approverule.click();
		Thread.sleep(2000);
	}
	
	public void addforapproval_validation() throws InterruptedException {
	addforapproval_click();
	commonMethods.implicitwait(defaultwaittime);
	okbutton_click();
	commonMethods.implicitwait(defaultwaittime);
	addforapprovalmsg_validation();
	commonMethods.implicitwait(defaultwaittime);
	}
	
	public void approverule_validation() throws InterruptedException {
	approverule_click();
	commonMethods.implicitwait(defaultwaittime);
	okbutton_click();
	commonMethods.implicitwait(defaultwaittime);
	approverulemsg_validation();
	commonMethods.implicitwait(defaultwaittime);
	}
	
	public void status_check() {
		String status=statusrecord.getText().trim();
		System.out.println("Status is validated and it is :" +status );
		Assert.assertEquals("Approved", status);
	}
	
	public void createrulesuccessmsg_validation() {
		String actualsuccessmsg= createrulesuccessmsg.getText().trim();
		System.out.println("createrule success message:" +actualsuccessmsg);
		String expectedsuccessmssg = "Rule created successfully";
		Assert.assertEquals(expectedsuccessmssg, actualsuccessmsg);	
	}
	
	public void deleterulesuccessmsg_validation() {
		String actualdeletesuccessmsg= deleterulesuccessmsg.getText().trim();
		System.out.println("deleterule success message:" +actualdeletesuccessmsg);
		String expecteddeletesuccessmssg = "Rule deleted successfully";
		Assert.assertEquals(expecteddeletesuccessmssg, actualdeletesuccessmsg);	
	}
	
	public void editrulesuccessmsg_validation() {
		String actualeditsuccessmsg= editrulesuccessmsg.getAttribute("innerhtml");
		System.out.println("editrule success message:" +actualeditsuccessmsg);
		String expectededitsuccessmssg = "Rule modified successfully";
		Assert.assertEquals(expectededitsuccessmssg, actualeditsuccessmsg);	
	}
	
	public void addforapprovalmsg_validation() {
		String actualaddforapprovalsuccessmsg= addforapprovalsuccessmsg.getText().trim();
		System.out.println("addforapproval success message:" +actualaddforapprovalsuccessmsg);
		String expectedaddforapprovalsuccessmsg = "Rule Status was updated";
		Assert.assertEquals(expectedaddforapprovalsuccessmsg, actualaddforapprovalsuccessmsg);	
	}
	
	public void approverulemsg_validation() {
		String actualapproverulesuccessmsg= approverulesuccessmsg.getText().trim();
		System.out.println("approverule success message:" +actualapproverulesuccessmsg);
		String expectedruleapprovalsuccessmsg = "Rule was successfully approved. Rule will not become active until the effective date.";
		Assert.assertEquals(expectedruleapprovalsuccessmsg, actualapproverulesuccessmsg);	
	}
	
	public void newrulevalidation() {
		String actualtext=diseasenameinput.getAttribute("value");
		System.out.println("rulename:" +actualtext);
		String expectedtext = "CardinalAutomationTesting";
		Assert.assertEquals(expectedtext, actualtext);	
	}

	public void exportall_click() throws InterruptedException {
		exportall.click();
		Thread.sleep(3000);
	}
	
	public void exportrule_click() throws InterruptedException {
		exportrule.click();
		Thread.sleep(3000);
	}
	
	
	public void rowcountfromtable() {
		List<WebElement> rowcount = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/div/div/div[3]/div[2]/section[2]/div/table/tbody/tr"));
		int count = rowcount.size();
		System.out.println("ROW COUNT : "+count);
	}

	public void existingrulevalidation() {
		String actualtext=diseasenameinput.getAttribute("value");
		System.out.println("rulename:" +actualtext);
		String expectedtext = "CardinalAutomationTesting";
		Assert.assertEquals(expectedtext, actualtext);	
	}

	public void delete_file() throws InterruptedException {
		Thread.sleep(5000);
		File dir = new File(System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/");
		for (File f : dir.listFiles()) {
			if (f.getName().startsWith("Export_")) {
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
					lineNumberCount=lineNumberCount-2;
					System.out.println("Total number of lines found in csv : " + (lineNumberCount));
					String csvrec = Integer.toString(lineNumberCount);
					
					List<WebElement> rowcount = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/div/div/div[3]/div[2]/section[2]/div/table/tbody/tr"));
					int count = rowcount.size();
					String uicount= Integer.toString(count).trim();
					System.out.println("ROW COUNT : "+count);
					Assert.assertEquals(csvrec,uicount);
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