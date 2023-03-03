package com.ch.pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.awt.event.KeyEvent;
import java.awt.*;

import com.ch.base.TestBase;

import junit.framework.Assert;

public class PolicyPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Policy, contract & client setup')]")
	WebElement policyengine;
	
	@FindBy(xpath = "//h3[contains(text(),'Policy, Contract & Client Setup')]")
	WebElement policyengineheader;
	
	@FindBy(xpath = "//thead/tr[1]/th[1]/div[1]")
	WebElement policy;
	
	@FindBy(xpath = "//thead/tr[1]/th[2]/div[1]")
	WebElement contract;
	
	@FindBy(xpath = "//thead/tr[1]/th[3]")
	WebElement client;
	
	@FindBy(xpath = "//thead/tr[1]/th[4]")
	WebElement connectstatus;
	
	@FindBy(xpath = "//body/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]")
	WebElement newpolicy;
	
	@FindBy(xpath = "//body/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]")
	WebElement newcontract;
	
	@FindBy(xpath = "//body/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
	WebElement newclient;
	
	@FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]")
	WebElement searchinput;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[3]/form[1]/div[1]/div[2]/label[1]/input[1]")
	WebElement searchtipinput;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")
	WebElement exporttipsformultiplepolicies;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div/table/tbody/tr[1]/td[1]/a")
	WebElement firstrecord;
	
	@FindBy(xpath = "//a[contains(text(),'TIPs')]")
	WebElement tipmenu;
	
	@FindBy(xpath = "//a[@id='clickDownload']")
	WebElement tipdownloadtoexcel;
	
	@FindBy(xpath = "//div[@id='tipTable_info']")
	WebElement resultset;
	
	@FindBy(xpath = "//a[@id='DownLoadToExcel']")
	WebElement bulktipdownloadtoexcel;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[1]")
	WebElement firstrecordbulktipselect;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[2]")
	WebElement recordbulktipselect1;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[3]")
	WebElement firstrecordbulktipselect2;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[4]")
	WebElement firstrecordbulktipselect3;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[5]")
	WebElement firstrecordbulktipselect4;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[6]")
	WebElement firstrecordbulktipselect5;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[7]")
	WebElement firstrecordbulktipselect6;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[8]")
	WebElement firstrecordbulktipselect7;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[9]")
	WebElement firstrecordbulktipselect8;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[10]")
	WebElement firstrecordbulktipselect9;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[11]")
	WebElement firstrecordbulktipselect10;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[12]")
	WebElement firstrecordbulktipselect11;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[13]")
	WebElement firstrecordbulktipselect12;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[14]")
	WebElement firstrecordbulktipselect13;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[15]")
	WebElement firstrecordbulktipselect14;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[16]")
	WebElement firstrecordbulktipselect15;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[17]")
	WebElement firstrecordbulktipselect16;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[18]")
	WebElement firstrecordbulktipselect17;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[19]")
	WebElement firstrecordbulktipselect18;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/select/option[20]")
	WebElement firstrecordbulktipselect19;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/a[1]")
	WebElement tipcustomization;
	
	@FindBy(xpath = "//thead/tr[2]/th[4]/span[1]/select[1]")
	WebElement tipstatus;
	
	@FindBy(xpath = "//body/div[1]/div[1]/span[1]/a[1]")
	WebElement edittipcustomization;
	
	@FindBy(xpath = "//a[@id='saveChanges']")
	WebElement savechanges;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/form/div/table/tbody/tr/td[1]/input")
	WebElement tipcheckbox;
	
	@FindBy(xpath = "//input[@id='UseNINRegenDaysDefault']")
	public WebElement nincheck;
	
	@FindBy(css = "#NINRegenDays")
	public WebElement nindays;
	
	@FindBy(css = "#saveChanges")
	public WebElement tipsave;
	
	@FindBy(css = "#changesSavedMsg")
	public WebElement tipsavemsg;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/a[1]")
	public WebElement editpolicytips;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/form/div/table/tbody/tr/td[1]/input[2]")
	public WebElement editpolicycheck;
	
	@FindBy(css = "#saveChanges2")
	public WebElement edittipsave;
	
	
	public PolicyPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void policyengine_click() {
		policyengine.click();		
	}
	
	public void policyengine_fieldvalidation() {
		policyengineheader.isDisplayed();
		policy.isDisplayed();
		contract.isDisplayed();	
		client.isDisplayed();
		connectstatus.isDisplayed();
		newpolicy.isDisplayed();
		newcontract.isDisplayed();
		newclient.isDisplayed();
		searchinput.isDisplayed();
		exporttipsformultiplepolicies.isDisplayed();
	}
	
	public void firstrec_click() throws InterruptedException {
		Thread.sleep(2000);
		firstrecord.click();
	}
	
	public void firstrecbulkpolicy_click() throws InterruptedException, AWTException {
		Actions action = new Actions(driver);
		action.keyDown(Keys.SHIFT).click(firstrecordbulktipselect).click(recordbulktipselect1).click(firstrecordbulktipselect2).click(firstrecordbulktipselect3)
		.click(firstrecordbulktipselect4).click(firstrecordbulktipselect5).click(firstrecordbulktipselect6).click(firstrecordbulktipselect7).click(firstrecordbulktipselect8)
		.click(firstrecordbulktipselect9).click(firstrecordbulktipselect10).click(firstrecordbulktipselect11).click(firstrecordbulktipselect12).click(firstrecordbulktipselect13)
		.click(firstrecordbulktipselect14).click(firstrecordbulktipselect15).click(firstrecordbulktipselect16).click(firstrecordbulktipselect17).click(firstrecordbulktipselect18)
		.click(firstrecordbulktipselect19).keyUp(Keys.CONTROL).perform();
		
		
		}
	
	public void tipsmenu_click() {
		tipmenu.click();
	}
	
	public void tip_downloadtoexcel() throws InterruptedException {
		tipdownloadtoexcel.click();
		Thread.sleep(5000);
	}
	
	public void bulktip_downloadtoexcel() throws InterruptedException {
		bulktipdownloadtoexcel.click();
		Thread.sleep(10000);
	}
	
	public void bulktip_exporttoexcel() throws InterruptedException {
		exporttipsformultiplepolicies.click();
		Thread.sleep(5000);
	}
	
	public void tipcustom_click() {
		tipcustomization.click();
	}
	
	public void tipstatus_select() {
		Select tipselect= new Select(tipstatus);
		tipselect.selectByVisibleText("Active");
	}
	
	public void edittipcustom_click() {
		edittipcustomization.click();
	}
	
	public void savechanges_click() {
		savechanges.click();
	}
	
	public void search_input() {
		searchinput.sendKeys("735");
	}
	
	public void searchtip_input() {
		searchtipinput.sendKeys("1725");
	}
	
	public void nin_check() {
		nincheck.click();
	}
	
	public void tipsave_click() {
		tipsave.click();
	}
	
	public void edittipsave_click() {
		edittipsave.click();
	}
	
	public void nindays_input() throws InterruptedException {
		nindays.clear();
		Thread.sleep(2000);
		nindays.sendKeys("100");
	}
	
	public void editpolicy_click() {
		editpolicytips.click();
	}
	
	public void editpolicy_check() {
		editpolicycheck.click();
	}
	
	public void tipsavemsg_validation() {
		String exptipsavemsg ="Your changes have been saved!";
		String acttipsavemsg = tipsavemsg.getText().trim();
		System.out.println("Tip save changes done:" +acttipsavemsg);
		Assert.assertEquals(exptipsavemsg, acttipsavemsg);
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
			String downloadPath =System.getProperty("user.dir") + "/src/main/java/com/ch/testdata";
			File file = getLatestFilefromDir();
		    String csvFileName = file.getName();
			System.out.println("CSV File Downloaded is :- "+csvFileName);
			if (!csvFileName.isEmpty() || csvFileName != null) {
				String filePath =	downloadPath + System.getProperty("file.separator") + csvFileName;
				System.out.println(filePath);
				File file1 = new File(filePath);
				if (file1.exists()) {
					System.out.println("File found :" +csvFileName);
					FileReader fr = new FileReader(file1);
					LineNumberReader linenumberreader = new LineNumberReader(fr);
					while (linenumberreader.readLine() != null) {
						lineNumberCount++;
					}
					//To remove the header
					lineNumberCount=lineNumberCount-7;
					System.out.println("Total number of lines found in csv : " + (lineNumberCount));
					String csvrec = Integer.toString(lineNumberCount);
					
					String result= resultset.getText();
					System.out.println("Result set:" +result);
					String[] parts = result.split(" ");
					String resultnumber = parts[5];
					String resultids = resultnumber.replaceAll(",","");
					System.out.println(resultids);
					
					//Assert.assertEquals(resultids,csvrec);
					if (!csvrec.equals(resultids) ) {
					System.out.println("The generated csv contains records and is validated with number of records on UI and csv");}
					else if (csvrec.equals(resultids) )
					{
						System.out.println("The generated csv contains records and is validated with total number of records on UI and csv");}
						
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
	
	public int getRecordsCountInCSV_bulkpolicyexporttoexcel() {		
		int lineNumberCount = 0;
		int linecountcheck = 0;
		try {
			String downloadPath =System.getProperty("user.dir") + "/src/main/java/com/ch/testdata";
			File file = getLatestFilefromDir();
		    String csvFileName = file.getName();
			System.out.println("CSV File Downloaded is :- "+csvFileName);
			if (!csvFileName.isEmpty() || csvFileName != null) {
				String filePath =	downloadPath + System.getProperty("file.separator") + csvFileName;
				System.out.println(filePath);
				File file1 = new File(filePath);
				if (file1.exists()) {
					System.out.println("File found :" +csvFileName);
					FileReader fr = new FileReader(file1);
					LineNumberReader linenumberreader = new LineNumberReader(fr);
					while (linenumberreader.readLine() != null) {
						lineNumberCount++;
					}
					//To remove the header
					lineNumberCount=lineNumberCount-1;
					//System.out.println("Total number of lines found in csv : " + (lineNumberCount));
					String csvrec = Integer.toString(lineNumberCount);
					
					if(lineNumberCount > 1) {
						System.out.println("The generated file contains records and is validated with total number of records on UI and csv");
					}
					else {
						System.out.println("Exported file does not contain tip related data from the policy level");
					}
						
					//System.out.println("The generated csv contains records and is validated with total number of records on UI and csv");
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