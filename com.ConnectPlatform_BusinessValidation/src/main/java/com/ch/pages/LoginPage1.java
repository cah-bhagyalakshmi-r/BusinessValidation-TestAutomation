package com.ch.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.ch.base.TestBase;
import com.ch.util.JsonFileReader;
import com.ch.util.excelReader;
import com.google.common.collect.Table.Cell;

import junit.framework.Assert;

public class LoginPage1 extends TestBase{
	
	@FindBy(css="#username")
	WebElement username;
	
	@FindBy(css="#password")
	WebElement password;
	
	@FindBy(css="#login")
	WebElement loginBtn;
	
	@FindBy(css="#errorSummaryMsg")
	public WebElement invalidloginmsg;
	
	@FindBy(css="#forgotUsername")
	public WebElement forgotusername;
	
	@FindBy(css="#forgotPassword")
	public WebElement forgotpassword;
	
	@FindBy(xpath="//h1[contains(text(),'Forgot your username?')]")
	public WebElement forgotusernamelabel;
	
	@FindBy(xpath="//h1[contains(text(),'Forgot Password?')]")
	public WebElement forgotpasswordlabel;
	
	@FindBy(css="#firstName")
	public WebElement firstname;
	
	@FindBy(css="#lastName")
	public WebElement lastname;
	
	@FindBy(css="#email")
	public WebElement email;
	
	@FindBy(css="#sendUsername")
	public WebElement sendusername;
	
	@FindBy(xpath="//h1[contains(text(),'Your username has been sent!')]")
	public WebElement usernamesuccessmsg;
	
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	public WebElement returntologin;
	
	@FindBy(xpath="//span[contains(text(),'Log in')]")
	public WebElement loginscreen;
	
	@FindBy(xpath="//p[@id='errorSummaryMsg']")
	public WebElement errormsg;

	@FindBy(css="#resetPassword")
	public WebElement resetpwdnextbtn;
	
	@FindBy(css="#userName")
	public WebElement fpusername;
	
	@FindBy(css="#DOBdatepicker")
	public WebElement fpdob;
	
	@FindBy(css="#register")
	WebElement signupbutton;
	
	@FindBy(xpath="//h1[contains(text(),'Registration')]")
	WebElement registrationlabel;
		
	@FindBy(xpath="/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]")
	WebElement captcha;
	
	@FindBy(css="#firstName")
	public
	WebElement registerfirstName;
	
	@FindBy(css="#lastName")
	public
	WebElement registerlastName;
	
	@FindBy(xpath="//label[contains(text(),'Client')]")
	WebElement role;
	
	@FindBy(xpath="//label[contains(text(),'Pharmacist')]")
	WebElement role1;
	
	@FindBy(css="#addressLine1")
	WebElement addressline1;
	
	@FindBy(css="#city")
	WebElement city;
	
	@FindBy(xpath="//select[@id='state']")
	WebElement state;
	
	@FindBy(css="#zip")
	WebElement registerzip;
	
	@FindBy(css="#dob")
	WebElement registerdob;
	
	@FindBy(css="#phone")
	WebElement registerphone;
	
	@FindBy(css="#email")
	public
	WebElement registeremail;
	
	@FindBy(css="#username")
	public
	WebElement registerusername;
	
	@FindBy(css="#password")
	WebElement registerpassword;
		
	@FindBy(css="#passwordConfirm")
	WebElement registerconfpwd;
	
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
	
	@FindBy(css = "#register")
	WebElement submitbutton;
	
	@FindBy(css = "#companyName")
	WebElement companyname;
	
	@FindBy(css = "#jobTitle")	
	WebElement jobtitle;
	
	@FindBy(xpath = "/html/body/div/form/div/div/p[12]/span")
	WebElement existingusernameerrormsg;
	
	@FindBy(xpath = "/html/body/div/div/div/div/h1")
	WebElement signupsuccessmsg;
	
	@FindBy(xpath = "//a[contains(text(),'Log into your account')]")
	WebElement logintoaccount;
	
	@FindBy(xpath = "//select[@id='PharmacyLicenseState1']")
	public
	WebElement pharmacystate;
	
	@FindBy(xpath = "//input[@id='PharmacyLicenseNumber1']")
	public
	WebElement pharmacistlicensenumber;
	
	String fname, lname, useremail;
	
	JsonFileReader jsonreader=new JsonFileReader();
	
	public LoginPage1() throws IOException, ParseException{
		PageFactory.initElements(driver, this);
		readTestData();
	}
	
	private void readTestData() throws IOException, ParseException {
		JsonFileReader.getdata();
		fname=JsonFileReader.Login.get("firstname").toString();
		lname=JsonFileReader.Login.get("lastname").toString();
		useremail=JsonFileReader.Login.get("email").toString();
	}

	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public DashboardPage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();		    	
		return new DashboardPage();
	}
	
	public void invalidlogin() {
		username.sendKeys("test.automation");
		password.sendKeys("test");
		loginBtn.click();	
	}
	
	public void forgotusername_click() {
		forgotusername.click();
	}
	
	public void forgotpwd_click() {
		forgotpassword.click();
	}
	
	public void forgotpwdlabel() {
		forgotpasswordlabel.isDisplayed();
	}
	
	public void forgotusernamelabel() {
		forgotusernamelabel.isDisplayed();
	}
	
	public void firstname() {
		firstname.sendKeys(fname);
	}
	
	public void lastname() {
		lastname.sendKeys(lname);
	}
	
	public void email() {
		email.sendKeys(useremail);
	}
	
	public void sendusername_click() {
		sendusername.click();
	}
	
	public void returntologin_click() {
		returntologin.click();
	}	
		
	public void loginpage_display() {
		loginscreen.isDisplayed();
	}
	
	public void forgotunamemissingfield() {
		firstname.sendKeys("");
		lastname.sendKeys("");
		email.sendKeys("");
	}
	
	public void forgotunameinvaliddata() {
		firstname.sendKeys("Generic");
		lastname.sendKeys("account");
		email.sendKeys("genericaccounttest");
	}
	
	public void forgotunamemissingfirstandlastname() {
		firstname.sendKeys("");
		lastname.sendKeys("");
		email.sendKeys("genericaccounttest");
	}
	
	public void forgotunameemmailmissing() {
		firstname.sendKeys("Test");
		lastname.sendKeys("Automation");
		email.sendKeys("");
	}
	
	public void forgotuname_clear() {
		firstname.clear();
		lastname.clear();
		email.clear();
	}
	
	public void nextbutton_click() {
		resetpwdnextbtn.click();
	}
	
	public void missingname() {
		fpusername.sendKeys("");
		fpdob.click();
		fpdob.sendKeys("05/10/1987");
		fpdob.sendKeys(Keys.TAB);
	}
	
	public void missingdob() {
		fpusername.sendKeys("Test.Automation");
		fpdob.sendKeys("");
		fpdob.sendKeys(Keys.TAB);
	}
	
	public void missingcaptcha() throws InterruptedException {
		fpusername.sendKeys("Test.Automation");
		fpdob.click();
		Thread.sleep(10);
		fpdob.sendKeys("05/10/1987");
		fpdob.sendKeys(Keys.TAB);
	}
		
	public void forgotpname_clear() {
		fpusername.clear();
		fpdob.clear();
		fpdob.sendKeys(Keys.TAB);
	}
	
	public void signup_click() {
		signupbutton.click();
	}
	
	public void registrationlabel_display() {
		registrationlabel.isDisplayed();
	}
	
	public void registerfirstname_inputdata() {
		//registerfirstName.sendKeys("Test");
		
		registerfirstName.sendKeys("Auto");
	}

	
	public void registerlastname_inputdata() {
		//String lname = "account0";
		String lname = "cardaccnt" + RandomStringUtils.randomNumeric(3);
		//String lname = "cardaccnt0";
	    //String lnameincrement = lname + (Integer.parseInt(lname.substring(9,lname.length()))+1);
	    //System.out.println(lnameincrement);
		registerlastName.sendKeys(lname);
	}
	
	public void role_click() {
		role.click();
	}
	
	public void pharmacistrole_click() {
		role1.click();
	}
	
	public void addressline1_inputdata() {
		addressline1.sendKeys("Addressline1");
	}
		
	public void city_inputdata() {
		  String cityinput = RandomStringUtils.randomAlphabetic(8);
		  city.sendKeys(cityinput);	
	}
	
	public void state_inputdata() {
		Select select=new Select(state);
		select.selectByIndex(1);
	}
	
	public void zip_inputdata() {
		 String zipinput = RandomStringUtils.randomNumeric(8);
		 registerzip.sendKeys(zipinput);	
	}
	
	public void dob_inputdata() {
		registerdob.click();
		registerdob.sendKeys("05/10/1999");	
	}
	
	public void phone_inputdata() {
		registerphone.click();
		String phoneinput = RandomStringUtils.randomNumeric(10);
		registerphone.sendKeys(phoneinput);	
	}
	
	public void email_inputdata() {
		registeremail.sendKeys("bhagyalakshmi.r@cardinalhealth.com");	
	}
		
	public void chooseusername() {
		//String uname = "TestAccount0";
		String uname = "TestAccount" + RandomStringUtils.randomNumeric(3);
	    //String unameincrement = uname + (Integer.parseInt(uname.substring(8,uname.length()))+1);
	    //System.out.println(unameincrement);
	    registerusername.sendKeys(uname);
	}
	
	public void choosepassword() {
		registerpassword.sendKeys("Changeme@123");
	}
	
	public void cnfirmpassword() {
		registerconfpwd.sendKeys("Changeme@123");
	}
	public void selectsecurityquestion1() {
		Select select=new Select(securityquestion1);
		select.selectByIndex(1);
	}
	
	public void selectsecurityquestion2() {
		Select select=new Select(securityquestion2);
		select.selectByIndex(1);
	}
	
	public void selectsecurityquestion3() {
		Select select=new Select(securityquestion3);
		select.selectByIndex(1);
	}
	
	public void securityanswer1() {
		securityanswer1.sendKeys("test");
	}
	
	public void securityanswer2() {
		securityanswer2.sendKeys("test");
	}
	
	public void securityanswer3() {
		securityanswer3.sendKeys("test");
	}
	
	public void submitbutton_click() {
		submitbutton.click();
	}
	
	public void companyname_inputdata() {
		companyname.sendKeys("CardinalHealth");
	}
	
	public void jobtitle_inputdata() {
		jobtitle.sendKeys("AutomationEngineer");
	}
	
	public void profdetails() {
		companyname_inputdata();
		jobtitle_inputdata();
	}
	
	public void signupsuccessmsg() {
		String expecteddataactualmsg=signupsuccessmsg.getText();
		String actualexpectedmsg= "Thanks for registering!";
		Assert.assertEquals(expecteddataactualmsg, actualexpectedmsg);
	}
	
	public void register_inputdetails() {
		registerfirstname_inputdata();
		registerlastname_inputdata();
		role_click();
		addressline1_inputdata();
		city_inputdata() ;
		state_inputdata();
		zip_inputdata();
		dob_inputdata();
		phone_inputdata();
		email_inputdata();
		chooseusername();
		choosepassword();
		cnfirmpassword();
		selectsecurityquestion1();
		securityanswer1();
		selectsecurityquestion2();
		securityanswer2();
		selectsecurityquestion3();
		securityanswer3();
	}
	
	public void register_inputdetails1() throws IOException {
		pharmacistrole_click();
		addressline1_inputdata();
		city_inputdata() ;
		state_inputdata();
		zip_inputdata();
		choosepassword();
		cnfirmpassword();
		selectsecurityquestion1();
		securityanswer1();
		selectsecurityquestion2();
		securityanswer2();
		selectsecurityquestion3();
		securityanswer3();
	}
	
	public void pharmacystate() {
		List<WebElement> itemsInDropdown = driver.findElements(By.xpath("/html/body/div/form/div/div/div[4]/p[1]/select/option"));
		int size = itemsInDropdown.size();
		int randnMumber = ThreadLocalRandom.current().nextInt(0, size);
		itemsInDropdown.get(randnMumber).click();
	}
	

	public void logintoaccount_click() {
		logintoaccount.click();
	}
	
}