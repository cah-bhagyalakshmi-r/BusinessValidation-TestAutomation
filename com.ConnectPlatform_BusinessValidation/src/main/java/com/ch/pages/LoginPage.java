package com.ch.pages;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.ch.base.TestBase;
import com.ch.util.JsonFileReader;
import junit.framework.Assert;

public class LoginPage extends TestBase{
	
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
	WebElement registerfirstName;
	
	@FindBy(css="#lastName")
	WebElement registerlastName;
	
	@FindBy(xpath="//label[contains(text(),'Client')]")
	WebElement role;
	
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
	WebElement registeremail;
	
	@FindBy(css="#username")
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
	
	@FindBy(xpath = "/html/body/div/div/div/h1")
	WebElement signupsuccessmsg;
	
	String fname, lname, useremail;
	
	JsonFileReader jsonreader=new JsonFileReader();
	
	public LoginPage() throws IOException, ParseException{
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
	
	public void invalidcredmsg() {
		String actinvalidmsg = invalidloginmsg.getText();
		String expinvalidloginmsg ="Invalid username and password combination, or your password has expired. Please try again. After 5 failed attempts, you will be required to reset your password. You may use Forgot Password? or Forgot Username? at any time.";
		Assert.assertEquals(expinvalidloginmsg,actinvalidmsg);
	}
	
	
	public void forgotusrnamesuccessmsg() {
		String forgotunameactualmsg=usernamesuccessmsg.getText();
		String forgotunameexpectedmsg= "Your username has been sent!";
		Assert.assertEquals(forgotunameexpectedmsg, forgotunameactualmsg);
	}
	
	public void forgotusrnamemissingfieldmsg() {
		String missingfieldactualmsg=errormsg.getText();
		String missingfieldexpectedmsg= "Please enter your full name and e-mail address.";
		Assert.assertEquals(missingfieldexpectedmsg, missingfieldactualmsg);
	}
	
	public void forgotusrnameinvaliddatamsg() {
		String invaliddataactualmsg=errormsg.getText();
		String invaliddataexpectedmsg= "The information you provided did not match our records. Please try again or call us for help.";
		Assert.assertEquals(invaliddataexpectedmsg, invaliddataactualmsg);
	}
	
	public void forgotusrnamemissingnamemsg() {
		String missingnameactualmsg=errormsg.getText();
		String missingnameexpectedmsg= "Please enter your full name.";
		Assert.assertEquals(missingnameexpectedmsg, missingnameactualmsg);
	}
	
	public void forgotusrnamemissingemailmsg() {
		String missingemailactualmsg=errormsg.getText();
		String missingeemailexpectedmsg= "Please enter your e-mail address.";
		Assert.assertEquals(missingeemailexpectedmsg, missingemailactualmsg);
	}
	
	public void forgotpasswordmissingfieldmsg() {
		String missingfieldactualmsg=errormsg.getText();
		String missingfieldexpectedmsg= "* Username required\n"
				+ "* DOB must be in format mm/dd/yyyy\n"
				+ "* Captcha wasn't checked";
		Assert.assertEquals(missingfieldexpectedmsg, missingfieldactualmsg);
	}
	
	public void forgotpasswordmissingusernamemsg() {
		String missingfieldactualmsg=errormsg.getText();
		String missingfieldexpectedmsg= "* Username required\n"
				+ "* Captcha wasn't checked";
		Assert.assertEquals(missingfieldexpectedmsg, missingfieldactualmsg);
	}
	
	public void forgotpasswordmissingdobmsg() {
		String missingfieldactualmsg=errormsg.getText();
		String missingfieldexpectedmsg= "* DOB must be in format mm/dd/yyyy\n"
				+ "* Captcha wasn't checked";
		Assert.assertEquals(missingfieldexpectedmsg, missingfieldactualmsg);
	}
	
	public void forgotpasswordmissingcaptchamsg() {
		String missingfieldactualmsg=errormsg.getText();
		String missingfieldexpectedmsg= "* Captcha wasn't checked";
		Assert.assertEquals(missingfieldexpectedmsg, missingfieldactualmsg);
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
		registerdob.sendKeys("05/10/1999");	
	}
	
	public void phone_inputdata() {
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
	
	public void chooseexistingusername() {
		String uname = "Testcard12";
		registerusername.clear();
	    registerusername.sendKeys(uname);
	}
	
	public void existingusernameerrormsg() {
		String expectedmsg=existingusernameerrormsg.getText();
		String actualmsg= "* This username is already taken, please try a different one";
		Assert.assertEquals(expectedmsg, actualmsg);
	}
	
	public void signupmissingfieldserrormsg() {
		String invaliddataactualmsg=errormsg.getText();
		String invaliddataexpectedmsg= "Please correct the errors highlighted in red below.";
		Assert.assertEquals(invaliddataexpectedmsg, invaliddataactualmsg);
	}
	
	
}