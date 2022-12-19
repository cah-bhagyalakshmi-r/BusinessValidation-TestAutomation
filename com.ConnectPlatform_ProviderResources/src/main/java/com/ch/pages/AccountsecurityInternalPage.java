package com.ch.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ch.base.TestBase;

public class AccountsecurityInternalPage extends TestBase {

	@FindBy(xpath = "//header/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")
	WebElement mainmenu;
	
	@FindBy(xpath = "//input[@id='username']")
	public WebElement username;
	
	@FindBy(css = "#currentPassword")
	WebElement currentpassword;
	
	@FindBy(css = "#password")
	WebElement changepassword;
	
	@FindBy(css = "#passwordConfirm")
	WebElement passwordconfirm;
	
	@FindBy(css = "#securityQ1")
	WebElement securityquestion1;
	
	@FindBy(css = "#securityQ2")
	WebElement securityquestion2;
	
	@FindBy(css = "#securityQ3")
	WebElement securityquestion3;
	
	@FindBy(css = "#securityQ1Answer")
	WebElement securityanswer1;
	
	@FindBy(css = "#securityQ2Answer")
	WebElement securityanswer2;
	
	@FindBy(css = "#securityQ3Answer")
	WebElement securityanswer3;
	
	@FindBy(xpath = "//a[contains(text(),'Account Security')]")
	WebElement accountsecuritymenu;
	
	@FindBy(css = "#saveAccount")
	WebElement savesecuritychangesbutton;
	
	@FindBy(css = "#changesSavedMsg")
	public WebElement savemsg;
	
	@FindBy(css="#login")
	WebElement loginBtn;
	
	XSSFWorkbook wb = null;
	XSSFSheet sh = null;
	
	public AccountsecurityInternalPage() {
		PageFactory.initElements(driver, this);
	}

	public void mainmenuclick() {
		mainmenu.click();
	}
	
	public void accountsecuritymenuclick() {
		accountsecuritymenu.click();		
	}
	
	public void accountsecurityfields_Validation() {
		username.isDisplayed();
		currentpassword.isDisplayed();
		changepassword.isDisplayed();
		passwordconfirm.isDisplayed();
		securityquestion1.isDisplayed();
		securityquestion2.isDisplayed();
		securityquestion3.isDisplayed();
		securityanswer1.isDisplayed();
		securityanswer2.isDisplayed();
		securityanswer3.isDisplayed();	
	}
	
	public void changeusername() {
		username.clear();
		String uname= "InternalProfile.AutomationAccount" + RandomStringUtils.randomNumeric(3);
		username.sendKeys(uname);
	}
	
	public void password() {
		currentpassword.sendKeys("Automation@456");
	}
	
	public void revertusername() {
		username.clear();
		String uname= "InternalProfile.AutomationAccount";
		username.sendKeys(uname);
	}
	
	public void savebutton() {
		savesecuritychangesbutton.click();
	}
	
	public void readuserdata_xlsfile() throws IOException {
		File file = new File(
				System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/UserSecurity_TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(0);
		Row row1 = sh.getRow(1);
		Cell cell1 = row1.getCell(0);
		Cell cell2 = row1.getCell(1);
		String uname=cell1.getStringCellValue();
		String currpwd=cell2.getStringCellValue();
		username.sendKeys(uname);
		changepassword.sendKeys(currpwd);
		loginBtn.click();
	}
	
	public void updatecreds_xlsfile() throws IOException {
		File file = new File(
				System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/UserSecurity_TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(0);
		Row row1 = sh.getRow(1);
		Cell cell2 = row1.getCell(1);
		Cell cell3 = row1.getCell(2);
		Cell cell4 = row1.getCell(3);
		String currpwd=cell2.getStringCellValue();
		String changepwd=cell3.getStringCellValue();
		String confchangepwd=cell4.getStringCellValue();
		currentpassword.sendKeys(currpwd);
		changepassword.sendKeys(changepwd);
		passwordconfirm.sendKeys(confchangepwd);
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