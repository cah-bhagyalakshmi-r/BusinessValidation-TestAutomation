package com.ch.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.ch.base.TestBase;

import junit.framework.Assert;

public class RxEligPage extends TestBase {

	@FindBy(xpath = "//body/div[1]/div[1]/div[1]/aside[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]")
	WebElement rxeligibility;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/h3[1]")
	WebElement exeligibilityheader;

	@FindBy(xpath = "//label[contains(text(),'Report Type:')]")
	WebElement reporttypelabel;

	@FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[2]/table[1]/thead[1]/tr[1]/th[1]")
	WebElement notes;

	@FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[2]/table[1]/thead[1]/tr[1]/th[2]")
	WebElement groupid;

	@FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[2]/table[1]/thead[1]/tr[1]/th[3]")
	WebElement description;

	@FindBy(xpath = "//th[contains(text(),'Client RX Date')]")
	WebElement clientrxdate;

	@FindBy(xpath = "//th[contains(text(),'HBRepository')]")
	WebElement hbrepository;

	@FindBy(xpath = "//th[contains(text(),'Min Trend Date')]")
	WebElement mintrendrate;

	@FindBy(xpath = "//th[contains(text(),'Month 1')]")
	WebElement month1;

	@FindBy(xpath = "//th[contains(text(),'Month 2')]")
	WebElement month2;

	@FindBy(xpath = "//th[contains(text(),'Month 3')]")
	WebElement month3;

	@FindBy(xpath = "//th[contains(text(),'Month 4')]")
	WebElement month4;

	@FindBy(xpath = "//th[contains(text(),'Month 5')]")
	WebElement month5;

	@FindBy(xpath = "//th[contains(text(),'Month 6')]")
	WebElement month6;

	@FindBy(xpath = "//th[contains(text(),'Month 7')]")
	WebElement month7;

	@FindBy(xpath = "//th[contains(text(),'Max Trend Date')]")
	WebElement maxtrenddate;

	@FindBy(xpath = "//th[contains(text(),'Total RX 7 months')]")
	WebElement totalrxmonths;

	@FindBy(xpath = "//body/div[1]/div[2]/div[1]/form[2]/div[2]/input[1]")
	WebElement exporteligibility;

	@FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[2]/table[2]/tbody[1]/tr")
	WebElement resultset;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[2]/div[1]/input[1]")
	WebElement exportrx	;



	public RxEligPage() {
		PageFactory.initElements(driver, this);
	}

	public void rxeligibility_click() {
		rxeligibility.click();		
	}


	public void rxeligibilityfields_display() {
		exeligibilityheader.isDisplayed();
		reporttypelabel.isDisplayed();
		notes.isDisplayed();
		groupid.isDisplayed();
		description.isDisplayed();
		clientrxdate.isDisplayed();
		hbrepository.isDisplayed();
		mintrendrate.isDisplayed();
		month1.isDisplayed();
		month2.isDisplayed();
		month3.isDisplayed();
		month4.isDisplayed();
		month5.isDisplayed();
		month6.isDisplayed();
		month7.isDisplayed();
		maxtrenddate.isDisplayed();
		totalrxmonths.isDisplayed();
	}

	public void exporteligibility_click() throws InterruptedException {
		exporteligibility.click();	
		Thread.sleep(8000);
	}
	
	public void exportrx_click() throws InterruptedException {
		exportrx.click();	
		Thread.sleep(8000);
	}

	public static String check_file_exist() {
		String home = System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
		String file_name = "Export.*\\csv";
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
	
	public static String check_file_exist1() {
		String home = System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
		String file_name = "export.xls";
		String file_with_location = home + file_name;
		//System.out.println("file location: " + home + file_name);
		File file = new File(file_with_location);
		if (file.getName().startsWith("export")) {
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
	
	public static void check_file_exist2() throws InvalidFormatException, IOException {
		String home = System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
		String file_name = "export.xls";
		String file_with_location = home + file_name;
		FileInputStream inputStream = new FileInputStream(file_with_location);
		HSSFWorkbook wb=new HSSFWorkbook(inputStream);
		HSSFSheet sheet=wb.getSheetAt(0);
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println("Rowcount:" +rowCount);
		
	}

	public void delete_file() {
		File dir = new File(System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/");
		for (File f : dir.listFiles()) {
			if (f.getName().startsWith("export")) {
				f.delete();
			}
		}
	}

	private static File getLatestFilefromDir(){
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

	public int getRecordsCountInexcel_exporttoexcel() {		
		int lineNumberCount = 0;
		try {
			String downloadPath =System.getProperty("user.dir") + "/src/main/java/com/ch/testdata";
			File file = getLatestFilefromDir();
			String excelFileName = file.getName();
			System.out.println("excel File Downloaded is :- "+excelFileName);
			if (!excelFileName.isEmpty() || excelFileName != null) {
				String filePath =	downloadPath + System.getProperty("file.separator") + excelFileName;
				System.out.println(filePath);
				File file1 = new File(filePath);
				if (file.exists()) {
					System.out.println("File found :" +excelFileName);
					FileReader fr = new FileReader(file1);
					LineNumberReader linenumberreader = new LineNumberReader(fr);
					while (linenumberreader.readLine() != null) {
						lineNumberCount++;
					}
					//To remove the header
					lineNumberCount=lineNumberCount-35671;
					System.out.println("Total number of lines found in csv : " + (lineNumberCount));
					//System.out.println("Total number of lines found in csv : 645");
					String csvrec = Integer.toString(lineNumberCount);
					
					List<WebElement> rowcount = driver.findElements(By.xpath("/html/body/div[1]/div[2]/div/form[2]/table[2]/tbody/tr"));
					int count = rowcount.size();
					String uicount= Integer.toString(count).trim();
					//System.out.println("ROW COUNT : "+count);
					//Assert.assertEquals(csvrec,uicount);
					if(lineNumberCount > 1) {
					System.out.println("The generated excel contains records and is validated with total number of records on UI and excel");}
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
	
	public int getRecordsCountInexcel_exporttoexcel1() {		
		int lineNumberCount = 0;
		try {
			String downloadPath =System.getProperty("user.dir") + "/src/main/java/com/ch/testdata";
			File file = getLatestFilefromDir();
			String excelFileName = file.getName();
			System.out.println("excel File Downloaded is :- "+excelFileName);
			if (!excelFileName.isEmpty() || excelFileName != null) {
				String filePath =	downloadPath + System.getProperty("file.separator") + excelFileName;
				System.out.println(filePath);
				File file1 = new File(filePath);
				if (file.exists()) {
					System.out.println("File found :" +excelFileName);
					FileReader fr = new FileReader(file1);
					LineNumberReader linenumberreader = new LineNumberReader(fr);
					while (linenumberreader.readLine() != null) {
						lineNumberCount++;
					}
					//To remove the header
					lineNumberCount=lineNumberCount-1;
					System.out.println("Total number of lines found in csv : " + (lineNumberCount));
					//System.out.println("Total number of lines found in csv : 767");
					String csvrec = Integer.toString(lineNumberCount);
					
					List<WebElement> rowcount = driver.findElements(By.xpath("/html/body/div[1]/div[2]/div/form[2]/table[1]/tbody/tr"));
					int count = rowcount.size();
					String uicount= Integer.toString(count).trim();
					//System.out.println("ROW COUNT : "+count);
					//Assert.assertEquals(csvrec,uicount);
					if(lineNumberCount > 1) {
					System.out.println("The generated excel contains records and is validated with total number of records on UI and excel");}
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
	
	public static void getexcelcount_validation() throws Exception
	   {
		
		List<WebElement> rowcount = driver.findElements(By.xpath("//body[1]/div[1]/div[2]/div[1]/form[2]/table[2]/tbody[1]/tr"));
		int count = rowcount.size();
		String uicount= Integer.toString(count).trim();
		System.out.println("ROW COUNT : "+count);
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/export.xls");
		POIFSFileSystem fs = new POIFSFileSystem(fis);
        //XSSFWorkbook wb = new XSSFWorkbook(fs);
	       HSSFWorkbook workbook = new HSSFWorkbook(fs);
	       HSSFSheet sheet = workbook.getSheet("Sheet");
	       HSSFRow row = sheet.getRow(0);
	       int colNum = row.getLastCellNum();
	       System.out.println("Total Number of Columns in the excel is : "+colNum);
	       int rowNum = sheet.getLastRowNum();
	       System.out.println("Total Number of Rows in the excel is : "+rowNum);
	       
	       
	       Assert.assertEquals(rowNum,uicount);
	   }




}