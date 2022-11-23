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


import com.ch.base.TestBase;

import junit.framework.Assert;

public class AdhPDCPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Adherence (PDC) rules')]")
	WebElement adherencepdcrules;

	@FindBy(xpath = "//h3[contains(text(),'Clinical Setup: Adherence (PDC) Rules')]")
	WebElement adherencepdcrulesheader;

	@FindBy(xpath = "//body/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]")
	WebElement newpdcrule;

	@FindBy(xpath = "//th[contains(text(),'Adherence (PDC) Rule')]")
	WebElement adherencepdcrulescolumn;

	@FindBy(xpath = "//th[contains(text(),'Rx Rule')]")
	WebElement rxrulecolumn;

	@FindBy(xpath = "//th[contains(text(),'Status')]")
	WebElement statuscolumn;

	@FindBy(xpath = "//a[@id='DownLoadToExcel']")
	WebElement downloadtoexcel;

	@FindBy(xpath = "//tbody/tr[1]/td[4]/a[1]")
	WebElement firstrecordedit;
	
	@FindBy(xpath = "//input[@id='PDCruleName']")
	public WebElement adherencerulenameinput;
	
	@FindBy(xpath = "//body/div[1]/div[1]/form[1]/div[1]/span[1]/input[1]")
	public WebElement rxruleinput;
	
	@FindBy(xpath = "//a[@id='formSubmit']")
	WebElement submit;
	
	@FindBy(xpath = "/html[1]/body[1]/ul[1]/li[1]/a[1]/strong[1]")
	WebElement selectfirstrec;
	
	@FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/label[1]/input[1]")
	public WebElement searchinput;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody/tr[1]")
	public WebElement searchfirstrecordresult;
	
	@FindBy(xpath = "//input[@id='statusInactive']")
	public WebElement pdcstatusoff;
	
	@FindBy(xpath = "//input[@id='lookbackYTDchoice']")
	public WebElement lookback;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/table/tbody/tr/td[3]")
	public WebElement statusvalue;
	
	
	String csvFileName, previewrecords;

	public AdhPDCPage() {
		PageFactory.initElements(driver, this);
	}

	public void adherencepdcrules_click() {
		adherencepdcrules.click();		
	}

	public void newpdcrule_click() {
		newpdcrule.click();		
	}

	public void adherencepdcrulesfields_display() {
		adherencepdcrulesheader.isDisplayed();
		newpdcrule.isDisplayed();
		adherencepdcrulescolumn.isDisplayed();
		rxrulecolumn.isDisplayed();
		statuscolumn.isDisplayed();
		downloadtoexcel.isDisplayed();
	}

	public void adherencepdcrulename_input() {
		String adherencerulename = "cardaccnt" + RandomStringUtils.randomNumeric(3);
		adherencerulenameinput.sendKeys(adherencerulename);
	}
	
	public void adherencerule_gettext() {
		String actualtext=adherencerulenameinput.getAttribute("value");
		System.out.println("rulename:" +actualtext);
		String expectedtext = "CardinalAutomationTesting";
		Assert.assertEquals(expectedtext, actualtext);	
	}
	
	public void rxrule_input() {
		rxruleinput.sendKeys("Test");
	}
	
	public void rxrule_inputchange() {
		rxruleinput.clear();
		rxruleinput.sendKeys("lipi");
	}
	
	public void rxrule_selectrecord() {
		selectfirstrec.click();
	}
	
	public void lookback_change() {
		lookback.click();
	}

	public void submit_click() throws InterruptedException {
		submit.click();
		Thread.sleep(5000);
	}
	
	public void downloadexcel_click() throws InterruptedException {
		downloadtoexcel.click();
		Thread.sleep(5000);
	}
	
	public void editrecord_click() {
		firstrecordedit.click();
	}
	
	public void pdcstatus_click() {
		pdcstatusoff.click();
	}

	public static String check_file_exist() {
		String home = System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
		String file_name = "Medical_.*\\csv";
		String file_with_location = home + file_name;
		System.out.println("file location: " + home + file_name);
		File file = new File(file_with_location);
		if (file.getName().startsWith("Medical_")) {
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
		File dir = new File(System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/");
		for (File f : dir.listFiles()) {
			if (f.getName().startsWith("Export_")) {
				f.delete();
			}
		}

		Thread.sleep(5000);
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
	
	public int getRecordsCountInExcel_downloadtoexcel() {		
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
					
					List<WebElement> rowcount = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody/tr"));
					int count = rowcount.size();
					String uicount= Integer.toString(count).trim();
					System.out.println("ROW COUNT : "+count);
					Assert.assertEquals(csvrec,uicount);
					System.out.println("The generated excel contains records and is validated with total number of records on UI and csv");
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