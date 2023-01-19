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

public class CMRtargetPage extends TestBase {

	@FindBy(xpath = "//body/div[1]/div[1]/div[1]/aside[1]/ul[1]/li[1]/ul[1]/li[2]/a[1]")
	WebElement cmrtargetedmembers;
		
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/h3[1]")
	WebElement cmrtargetedmembersheader;
	
	@FindBy(xpath = "//th[contains(text(),'Client')]")
	WebElement client;
	
	@FindBy(xpath = "//th[contains(text(),'Policy')]")
	WebElement policy;
	
	@FindBy(xpath = "//th[contains(text(),'Jan')]")
	WebElement january;
	
	@FindBy(xpath = "//th[contains(text(),'Feb')]")
	WebElement february;
	
	@FindBy(xpath = "//th[contains(text(),'Mar')]")
	WebElement march;
	
	@FindBy(xpath = "//th[contains(text(),'Apr')]")
	WebElement april;
	
	@FindBy(xpath = "//th[contains(text(),'May')]")
	WebElement may;
	
	@FindBy(xpath = "//th[contains(text(),'Jun')]")
	WebElement june;
	
	@FindBy(xpath = "//th[contains(text(),'Jul')]")
	WebElement july;
	
	@FindBy(xpath = "//th[contains(text(),'Aug')]")
	WebElement august;
	
	@FindBy(xpath = "//th[contains(text(),'Sep')]")
	WebElement september;
	
	@FindBy(xpath = "//th[contains(text(),'Oct')]")
	WebElement october;

	@FindBy(xpath = "//th[contains(text(),'Nov')]")
	WebElement november;
	
	@FindBy(xpath = "//th[contains(text(),'Dec')]")
	WebElement december;
	
	@FindBy(xpath = "//th[contains(text(),'Total')]")
	WebElement total;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[2]/label[1]")
	WebElement searchlabel;
	
	@FindBy(css = "#clientTable_info")
	WebElement resultentries;
	
	@FindBy(css = "#clientTable_previous")
	WebElement previousbutton;
	
	@FindBy(css = "#clientTable_next")
	WebElement nextbutton;
	
	@FindBy(xpath = "//body/div[1]/div[4]/div[1]/a[1]")
	WebElement downloadtoexcel;
	
	
	public CMRtargetPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void cmrtargetedmembers_click() {
		cmrtargetedmembers.click();		
	}
	
	public void cmrtargetedmembers_display() {
		cmrtargetedmembersheader.isDisplayed();	
	}
	
	public void cmrtargetedmembersfields_display() {
		client.isDisplayed();
		policy.isDisplayed();
		january.isDisplayed();
		february.isDisplayed();
		march.isDisplayed();
		april.isDisplayed();
		may.isDisplayed();
		june.isDisplayed();
		july.isDisplayed();
		august.isDisplayed();
		september.isDisplayed();
		october.isDisplayed();
		november.isDisplayed();
		december.isDisplayed();
		total.isDisplayed();
		searchlabel.isDisplayed();
		resultentries.isDisplayed();
		previousbutton.isDisplayed();
		nextbutton.isDisplayed();
		downloadtoexcel.isDisplayed();		
	}
	
	public void downloadtoexcel_click() throws InterruptedException {
		downloadtoexcel.click();
		Thread.sleep(5000);
	}
	
	public static String check_file_exist() {
		String home = System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
		String file_name = "Export_.*\\csv";
		String file_with_location = home + file_name;
		//System.out.println("file location: " + home + file_name);
		File file = new File(file_with_location);
		if (file.getName().startsWith("Export")) {
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
			    if (f.getName().startsWith("Export")) {
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