package com.ch.pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ch.base.TestBase;

import junit.framework.Assert;

public class TIPPerfPage extends TestBase {

	@FindBy(xpath = "//body/div[1]/div[1]/div[1]/aside[1]/ul[1]/li[1]/ul[1]/li[4]/a[1]")
	WebElement tipperformance;
	
	@FindBy(xpath = "//h3[contains(text(),'Tip Performance Search')]")
	WebElement tipperformancesearchheader;
	
	@FindBy(xpath = "//label[contains(text(),'Date Range:')]")
	WebElement daterange;
	
	@FindBy(xpath = "//select[@id='dateselect']")
	WebElement daterangeselect;
	
	@FindBy(xpath = "//input[@id='startDate']")
	WebElement startdate;
	
	@FindBy(xpath = "//input[@id='endDate']")
	WebElement enddate;
	
	@FindBy(xpath = "//label[contains(text(),'Chain:')]")
	WebElement chain;
	
	@FindBy(xpath = "//label[contains(text(),'Policy Filter:')]")
	WebElement policyfilter;
	
	@FindBy(xpath = "//label[contains(text(),'Pharmacy:')]")
	WebElement pharmacy;
	
	@FindBy(xpath = "//label[contains(text(),'Patient:')]")
	WebElement patient;
	
	@FindBy(xpath = "//label[contains(text(),'TIP Filters:')]")
	WebElement tipfilters;
	
	@FindBy(xpath = "//label[contains(text(),'TIP Type:')]")
	WebElement tiptype;
	
	@FindBy(xpath = "//label[contains(text(),'TIPs:')]")
	WebElement tips;
	
	@FindBy(xpath = "//a[@id='searchTIPActivity']")
	WebElement search;
	
	@FindBy(xpath = "//a[@id='resetFields']")
	WebElement clearbutton;
	
	@FindBy(xpath = "//a[@id='summary-tab']")
	WebElement summarytab;
	
	@FindBy(xpath = "//a[@id='tip-tab']")
	public WebElement tiptab;
	
	@FindBy(xpath = "//a[@id='pharm-tab']")
	public WebElement pharmacytab;
	
	@FindBy(xpath = "//a[@id='policy-tab']")
	public WebElement policytab;
	
	@FindBy(xpath = "//a[@id='chain-tab']")
	public WebElement chaintab;
	
	@FindBy(xpath = "//body/div[1]/div[1]/p[1]/a[1]")
	public WebElement downloadtoexcel;
	
	@FindBy(xpath = "//body/div[1]/div[1]/form[1]/p[1]/a[1]")
	public WebElement pharmacydownloadtoexcel;
	
	@FindBy(xpath = "//th[contains(text(),'TIP Categories')]")
	public WebElement tipcategories;
	
	@FindBy(xpath = "//th[contains(text(),'TIP Opportunities')]")
	public WebElement tippoppurtunitiescolumn;
	
	@FindBy(xpath = "//th[contains(text(),'Attempted TIPs')]")
	public WebElement attemptedtipscolumn;
	
	@FindBy(xpath = "//th[contains(text(),'Completed TIPs')]")
	public WebElement completedtipscolumn;
	
	@FindBy(xpath = "//th[contains(text(),'Unsuccessful TIP Attempts')]")
	public WebElement unsuccessfultipattemptscolumn;
	
	@FindBy(xpath = "//div[@id='reportTable_info']")
	public WebElement resultset;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/span[1]")
	public WebElement resultset1;
	
	String currentDate = new SimpleDateFormat("MMddyyyy").format(new Date());

	
	public TIPPerfPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void tipperformance_click() {
		tipperformance.click();		
	}
	
	public void tipperformancesearch_display() {
		tipperformancesearchheader.isDisplayed();	
	}
	
	public void tipperformancefields_display() {
		tipperformancesearchheader.isDisplayed();
		daterange.isDisplayed();
		chain.isDisplayed();
		policyfilter.isDisplayed();
		pharmacy.isDisplayed();
		patient.isDisplayed();
		tipfilters.isDisplayed();
		chain.isDisplayed();
		tiptype.isDisplayed();
		tips.isDisplayed();
		search.isDisplayed();
		clearbutton.isDisplayed();
	}
	
	public void searchbutton_click() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", search);
		search.click();
	}
	

	public void downloadtoexcel_click() throws InterruptedException {
		Thread.sleep(3000);
		downloadtoexcel.click();	
		Thread.sleep(3000);
	}
	
	public void pharmacy_downloadtoexcel_click() throws InterruptedException {
		Thread.sleep(3000);
		pharmacydownloadtoexcel.click();	
		Thread.sleep(3000);
	}
	
	public void date_select() throws InterruptedException {
		Select select = new Select(daterangeselect);
		select.selectByValue("Custom date range");	
		Thread.sleep(2000);
		date_input();
	}
	
	public void date_input() throws InterruptedException {
		Calendar c = Calendar.getInstance();   // this takes current date
	    c.set(Calendar.DAY_OF_MONTH, 1);
	    Date currentmonth=c.getTime();
	    System.out.println(c.getTime()); 
	    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");    
		startdate.click();
		Thread.sleep(2000);
		String date= dateFormat.format(currentmonth);
		startdate.sendKeys(date);
		Thread.sleep(2000);
		enddate.click();
		Thread.sleep(2000);
		enddate.sendKeys(currentDate);
	}
	
	public void tipperformancecolumn_display() {
		summarytab.isDisplayed();
		tiptab.isDisplayed();
		pharmacytab.isDisplayed();
		policytab.isDisplayed();
		chaintab.isDisplayed();
		downloadtoexcel.isDisplayed();
		tipcategories.isDisplayed();
		tippoppurtunitiescolumn.isDisplayed();
		attemptedtipscolumn.isDisplayed();
		completedtipscolumn.isDisplayed();
		unsuccessfultipattemptscolumn.isDisplayed();
	}
	
	public void policytab_click() throws InterruptedException {
		/*
		 * Thread.sleep(2000); JavascriptExecutor executor = (JavascriptExecutor)
		 * driver; executor.executeScript("arguments[0].scrollIntoView();", policytab);
		 * Thread.sleep(8000); policytab.click();
		 */
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(policytab)); 
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}
	
	
	public static String check_file_exist() {
		String home = System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
		String file_name = "Export.*\\csv";
		String file_with_location = home + file_name;
		System.out.println("file location: " + home + file_name);
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
	
	public void delete_file() throws InterruptedException {
		Thread.sleep(5000);
		File dir = new File(System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/");
		for (File f : dir.listFiles()) {
			if (f.getName().contains("Export")) {
				f.delete();
				Thread.sleep(3000);
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
	
	public int getRecordsCountInCSV_exporttoexcel() {		
		int lineNumberCount = 0;
		try {
			String downloadPath =System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
			File file = getLatestFilefromDir();
		    String csvFileName = file.getName();
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
	
	public void reccount_validation() {
        String result= resultset.getText();
        System.out.println("Result set:" +result);
        String[] parts = result.split(" ");
        String resultnumber = parts[5];
        String resultids = resultnumber.replaceAll(",","");
        int reccount= Integer.parseInt(resultids);
        int chkreccount =1;
        System.out.println(reccount);
        if(reccount > 0) {
               System.out.println("The record count is greater than 0 and further validation can be done");      
        }
        else {
               System.out.println("The record count is not greater than 0 and further validation needs to be manually tested to confirm if its a issue");
               Assert.assertEquals(reccount, chkreccount);
        }
 }

	
	public int getRecordsCountInCSV_exporttoexcel1() {		
		int lineNumberCount = 0;
		try {
			String downloadPath =System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
			File file = getLatestFilefromDir();
		    String csvFileName = file.getName();
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

	
	public int getRecordsCountInCSV_pharmacybreakdownexporttoexcel() {		
		int lineNumberCount = 0;
		try {
			String downloadPath =System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
			File file = getLatestFilefromDir();
		    String csvFileName = file.getName();
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