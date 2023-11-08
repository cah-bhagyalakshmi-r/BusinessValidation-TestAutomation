package com.ch.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ch.base.TestBase;
import com.ch.util.CommonMethods;
import com.ch.util.JsonFileReader;
import com.ch.util.excelReader;

public class DataGeneratorPage extends TestBase {

	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[28]/a[1]/button[1]")
	WebElement tipbutton;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[2]/ul[1]/div[5]/div[1]/div[1]/div[1]/input[1]")
	WebElement center;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[2]/ul[1]/div[5]/div[1]/div[2]/ul[1]/li[1]/div[1]")
	WebElement centerfielddataclick;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextbutton;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[2]/ul[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement client;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[2]/ul[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/div[1]")
	WebElement clientclick;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[2]/ul[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement contract;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[2]/ul[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/div[1]")
	WebElement contractclick;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[2]/ul[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement policy;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[2]/ul[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/div[1]")
	WebElement policyclick;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[2]/ul[1]/div[3]/div[1]/div[1]/div[1]/input[1]")
	public WebElement patient;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[2]/ul[1]/div[3]/div[1]/div[2]/ul[1]/li[1]/div[1]")
	WebElement patientclick;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[2]/ul[1]/div[2]/div[1]/span[1]")
	WebElement tipoptionclick;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/form[1]/div[7]/div[1]/div[2]/div[1]/div[1]/div[1]")
	public WebElement tiptitleselect;
	
	@FindBy(xpath = "//*[contains(text(),'High Risk Medication - Vasodilator')]")
	public WebElement tiphighriskmedoption;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/form[1]/div[8]/div[1]/div[2]/div[1]/div[1]/div[1]")
	WebElement tipstatus;
	
	@FindBy(xpath = "//*[contains(text(),'TIP_IDENTIFIED')]")
	WebElement tipidentifiedoption;
	
	@FindBy(xpath = "//span[contains(text(),'Create')]")
	WebElement createbutton;
	
	@FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[1]/div/div[2]/div[3]/div/div[12]/div/div[2]")
	public WebElement tipcreateddate;
	
	@FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[2]/button[2]/span[1]")
	WebElement finishbutton;
	
	@FindBy(xpath = "//body/div[@id='menu-tipDetailTitle']/div[2]/ul[1]")
	WebElement tipdropdwonlist;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/button[1]/span[1]")
	WebElement createmoredatabutton;
	
	@FindBy(xpath = "//span[contains(text(),\"Ok, I'll go talk to a developer now\")]")
	public WebElement duplicatetipmsg;
	
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]/span[1]")
	public WebElement creatorsmenu;
	
	String centerdata, clientdata, policydata, contractdata, patientlastname;
	int defaultWaitTime = 10;
	int normalWaitTime = 5;
	
	XSSFWorkbook wb = null;
	XSSFSheet sh = null;
	
	CommonMethods commonMethods;
	JsonFileReader jsonreader=new JsonFileReader();

	public DataGeneratorPage() throws IOException, ParseException {
		PageFactory.initElements(driver, this);
		commonMethods = new CommonMethods();
		readTestData();
	}
	
	private void readTestData() throws IOException, ParseException {
		JsonFileReader.getdata();
		centerdata=JsonFileReader.DataGeneratortip.get("center").toString();
		clientdata=JsonFileReader.DataGeneratortip.get("client").toString();
		policydata=JsonFileReader.DataGeneratortip.get("policy").toString();
		contractdata=JsonFileReader.DataGeneratortip.get("contract").toString();
		patientlastname=JsonFileReader.DataGeneratortip.get("patientlastname").toString();
	}
	
	public void tipbuttonclick() {
		tipbutton.click();
	}
	
	public boolean tipbuttondisplay() {
		if(tipbutton.isDisplayed()){
			return true;
		}else 
			return false;
	}
	
	
	public void centerfieldinput() {
		center.sendKeys(centerdata);
	}
	
	public void centerfieldinputclick() {
		centerfielddataclick.click();
	}
	
	public void nextbuttonclick() {
		nextbutton.click();
	}
	
	public void centersectioninputdata() {
		centerfieldinput();
		commonMethods.implicitwait(defaultWaitTime);
		centerfieldinputclick();
		commonMethods.implicitwait(normalWaitTime);
		nextbuttonclick();	
	}
	
	public void clientfieldinput() {
		client.sendKeys(clientdata);
	}
	
	public void clientfieldinputclick() {
		clientclick.click();
	}
	
	public void clientsectioninputdata() {
		clientfieldinput();
		commonMethods.implicitwait(defaultWaitTime);
		clientfieldinputclick();
		commonMethods.implicitwait(normalWaitTime);
		nextbuttonclick();	
	}
	
	public void contractfieldinput() {
		contract.sendKeys(contractdata);
	}
	
	public void contractfieldinputclick() {
		contractclick.click();
	}
	
	public void contractsectioninputdata() {
		contractfieldinput();
		commonMethods.implicitwait(defaultWaitTime);
		contractfieldinputclick();
		commonMethods.implicitwait(normalWaitTime);
		nextbuttonclick();	
	}
	
	public void policyfieldinput() {
		policy.sendKeys(policydata);
	}
	
	public void policyfieldinputclick() {
		contractclick.click();
	}
	
	public void policysectioninputdata() {
		policyfieldinput();
		commonMethods.implicitwait(defaultWaitTime);
		policyfieldinputclick();
		commonMethods.implicitwait(normalWaitTime);
		nextbuttonclick();	
	}
	
	public void patientfieldinput() {	
		excelReader reader = new excelReader("./src/main/java/com/ch/testdata/TIPData_Test.xlsx");
		String sheetName = "tipdata"; 
		int rowCount = reader.getRowCount(sheetName);
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
		String patientid = reader.getCellData(sheetName, "PatientID", rowNum);
		patient.sendKeys(patientid);
		}
	}
	
	public void patientfieldinputclick() {
		patientclick.click();
	}
	
	public void patientsectioninputdata() {
		patientfieldinputclick();
		commonMethods.implicitwait(normalWaitTime);
		nextbuttonclick();	
	}
	
	public void tiplabelclick() {
		tipoptionclick.click();
	}
	
	public void tiptitleclick () {
		tiptitleselect.click();
		commonMethods.implicitwait(normalWaitTime);
		tiphighriskmedoption.click();	
	}
	
	public void tipstatusclick() {
		tipstatus.click();
		commonMethods.implicitwait(normalWaitTime);
		//Actions actions= new Actions(driver);
		//actions.moveToElement(tipidentifiedoption).click();
		//tipidentifiedoption.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", tipidentifiedoption);
		executor.executeScript("arguments[0].click();", tipidentifiedoption);
	}
	
	public void createbuttonclick() {
		createbutton.click();
	}
	
	public void tipcreateddate() {
		tipcreateddate.isDisplayed();
	}
	
	public void finishbuttonclick() {
		finishbutton.click();
	}
	
	public void createmoredatabtn() {
		createmoredatabutton.click();
	}
	
	public boolean tipcreatedata_display() {
		if(tipcreateddate.isDisplayed()){
			return true;
		}else 
			return false;
		}
	
	public void writecurrpwd_xlsfile() throws IOException {
		File file = new File(
				System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/UserSecurity_TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(0);
		Row row1 = sh.getRow(1);
		Cell cell3 = row1.getCell(2);
		String changepwd=cell3.getStringCellValue();
		sh.getRow(1).createCell(1).setCellValue(changepwd);
		String currpwd = "Automatecard" + RandomStringUtils.randomAlphabetic(3) + "@" + RandomStringUtils.randomNumeric(3);
		sh.getRow(1).createCell(2).setCellValue(currpwd);
		sh.getRow(1).createCell(3).setCellValue(currpwd);
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
	}
	
}