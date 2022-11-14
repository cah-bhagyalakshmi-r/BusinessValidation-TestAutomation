package com.ch.pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.ch.base.TestBase;

import junit.framework.Assert;

public class ClaimsActivityIntranetPage extends TestBase {

	@FindBy(xpath = "//body/div[1]/div[1]/div[1]/aside[1]/ul[1]/li[1]/ul[1]/li[5]/a[1]")
	WebElement claimactivity;
	
	@FindBy(xpath = "//h3[contains(text(),'Claim Activity Search')]")
	WebElement claimactivitysearchheader;
	
	@FindBy(xpath = "//label[contains(text(),'Date Range:')]")
	WebElement daterange;
	
	@FindBy(xpath = "//label[contains(text(),'Display Interval:')]")
	WebElement displayinterval;
		
	@FindBy(xpath = "//label[contains(text(),'Client:')]")
	WebElement client;
	
	@FindBy(xpath = "//label[contains(text(),'Policy Type:')]")
	WebElement policytype;
	
	@FindBy(xpath = "//label[contains(text(),'Policy:')]")
	WebElement policy;
	
	@FindBy(xpath = "//label[contains(text(),'Service Type:')]")
	WebElement servicetype;
	
	@FindBy(xpath = "//label[contains(text(),'Chain:')]")
	WebElement chain;

	@FindBy(xpath = "//body/div[1]/form[1]/div[2]/div[1]/div[10]/label[1]")
	WebElement mtmcenterid;
	
	@FindBy(xpath = "//label[contains(text(),'Exclude MTM Center ID:')]")
	WebElement excludemtmcenterid;
	
	@FindBy(xpath = "//a[@id='searchClaimActivity']")
	WebElement searchbutton;
	
	@FindBy(xpath = "//a[@id='resetFields']")
	WebElement clearsearchbutton;
	
	@FindBy(css = "#summary-tab")
	WebElement generaltab;
	
	@FindBy(css = "#reason-tab")
	WebElement reasontab;
	
	@FindBy(css = "#result-tab")
	WebElement resulttab;
	
	@FindBy(xpath = "//th[contains(text(),'Date Range')]")
	WebElement daterangecolumn;
	
	@FindBy(xpath = "//th[contains(text(),'Unique Patients')]")
	WebElement uniquepatients;
	
	@FindBy(xpath = "//th[contains(text(),'MTM Claims')]")
	WebElement mtmclaimscolumn;
	
	@FindBy(xpath = "//th[contains(text(),'Participating MTM Centers')]")
	WebElement participatingmtmcenters;
	
	@FindBy(xpath = "//th[contains(text(),'MTM Provider Fees')]")
	WebElement mtmproviderfees;
	
	@FindBy(xpath = "//th[contains(text(),'Validation Fees')]")
	WebElement validationfees;
	
	@FindBy(xpath = "//th[contains(text(),'Cost Savings')]")
	WebElement costsavings;
	
	@FindBy(css = "#fileDownloadCustomRichExperience")
	WebElement downloadtoexcel;
	
	@FindBy(xpath = "//th[contains(text(),'TIP Claims')]")
	WebElement tipclaims;
	
	@FindBy(xpath = "//th[contains(text(),'Rph Initiated Claims')]")
	WebElement rphinitiatedclaims;
	
	@FindBy(xpath = "//th[contains(text(),'CMR Claims')]")
	WebElement cmrclaims;
	
	@FindBy(xpath = "//thead/tr[2]/th[6]")
	WebElement cmr;
	
	@FindBy(xpath = "//th[contains(text(),'Patient Ed/Mon')]")
	WebElement patientedormon;
	
	@FindBy(xpath = "//th[contains(text(),'Patient Consult')]")
	WebElement patientconsult;
	
	@FindBy(xpath = "//th[contains(text(),'Prescriber Consult')]")
	WebElement prescriberconsult;
	
	@FindBy(xpath = "//th[contains(text(),'Prescriber Refusal')]")
	WebElement prescriberrefusal;
	
	@FindBy(xpath = "//th[contains(text(),'Unable to Reach Prescriber')]")
	WebElement unabletoreachprescriber;
	
	@FindBy(xpath = "//th[contains(text(),'Patient Refusal')]")
	WebElement patientrefusal;
	
	@FindBy(xpath = "//th[contains(text(),'Unable to Reach Patient')]")
	WebElement unabletoreachpatient;
	
	@FindBy(xpath = "//div[@id='reportTable_info']")
	WebElement resultentries;

	
	public ClaimsActivityIntranetPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void claimactivityclick() {
		claimactivity.click();		
	}
	
	public void claimactivitysearch_display() {
		claimactivitysearchheader.isDisplayed();	
	}
	
	public void claimintranetfields_display() {
		claimactivitysearchheader.isDisplayed();
		daterange.isDisplayed();
		displayinterval.isDisplayed();
		client.isDisplayed();
		policytype.isDisplayed();
		policy.isDisplayed();
		servicetype.isDisplayed();
		chain.isDisplayed();
		mtmcenterid.isDisplayed();
		excludemtmcenterid.isDisplayed();
		searchbutton.isDisplayed();
		clearsearchbutton.isDisplayed();
	}
	
	public void searchbutton_click() {
		searchbutton.click();		
	}
	
	public void claimactivityreport_tabdisplay() {
		generaltab.isDisplayed();
		reasontab.isDisplayed();
		resulttab.isDisplayed();		
	}
	
	public void claimreasontab_click() {
		reasontab.click();		
	}
	
	public void claimresulttab_click() {
		resulttab.click();		
	}
			
	public void claimactivityreport_generaldisplay() {		
		daterangecolumn.isDisplayed();
		uniquepatients.isDisplayed();
		mtmclaimscolumn.isDisplayed();
		participatingmtmcenters.isDisplayed();
		mtmproviderfees.isDisplayed();
		validationfees.isDisplayed();
		costsavings.isDisplayed();
	}
	
	public void claimactivityreport_claimoriginorreasondisplay() {
		daterangecolumn.isDisplayed();
		mtmclaimscolumn.isDisplayed();
		tipclaims.isDisplayed();
		rphinitiatedclaims.isDisplayed();
		cmrclaims.isDisplayed();
		cmr.isDisplayed();
		patientedormon.isDisplayed();
		patientconsult.isDisplayed();
		prescriberconsult.isDisplayed();
	}
	
	public void claimactivityreport_claimresultdisplay() {
		daterangecolumn.isDisplayed();
		mtmclaimscolumn.isDisplayed();
		patientconsult.isDisplayed();
		prescriberconsult.isDisplayed();
		prescriberrefusal.isDisplayed();
		unabletoreachprescriber.isDisplayed();
		patientrefusal.isDisplayed();
		unabletoreachpatient.isDisplayed();	
	}
	
	public void downloadtoexcel_click() throws InterruptedException {
		downloadtoexcel.click();	
		Thread.sleep(3000);
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
						lineNumberCount=lineNumberCount-1;
						System.out.println("Total number of lines found in csv : " + (lineNumberCount));
						String csvrec = Integer.toString(lineNumberCount);
						
						String result= resultentries.getText();
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