package com.ch.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	public WebElement registerusername;
	
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
	
	@FindBy(xpath = "//span[@id='passwordError']")
	WebElement pwderrormsg;
	
	@FindBy(xpath = "//span[@id='usernameError']")
	WebElement usernameerrormsg;
	
	@FindBy(xpath = "/html/body/div/div/div/div/h1")
	WebElement signupsuccessmsg;
	
	@FindBy(xpath="//input[@id='role1']")
	WebElement pharmacistrole;
	
	@FindBy(xpath="//input[@id='role4']")
	WebElement techrole;
	
	@FindBy(xpath="//input[@id='role16']")
	WebElement pharmacyadminrole;
	
	@FindBy(xpath = "//a[contains(text(),'Manage user accounts & access')]")
	public WebElement manageuseraccount;
	
	@FindBy(xpath = "//input[@id='username']")
	public WebElement manageuseraccountusername;
	
	@FindBy(xpath = "//a[@id='search']")
	public WebElement searchbutton;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/span[1]")
	public WebElement roleslist;
	
	@FindBy(xpath = "/html/body/div/form/div/div/div[4]/p[1]/input")
	public WebElement pharmacynumber;
	
	@FindBy(xpath="/html/body/div/form/div/div/div[4]/p[1]/select")
	WebElement pharmacystate;
	
	@FindBy(css="#openSecurityQuestions")
	WebElement securityquestions;
	
	@FindBy(xpath="/html[1]/body[1]/div[7]/div[1]/span[1]")
	WebElement securityquestionsheader;
	
	@FindBy(xpath="/html[1]/body[1]/div[7]/div[1]/button[1]")
	WebElement securityquestionsclosebutton;
	
	@FindBy(xpath="/html[1]/body[1]/div[7]/div[2]/div[1]/p[1]/label[1]/strong[1]")
	WebElement securityquestionslabel1;
	
	@FindBy(xpath="/html[1]/body[1]/div[7]/div[2]/div[1]/p[2]/label[1]/strong[1]")
	WebElement securityquestionslabel2;
	
	@FindBy(xpath="/html[1]/body[1]/div[7]/div[2]/div[1]/p[3]/label[1]/strong[1]")
	WebElement securityquestionslabel3;
	
	@FindBy(xpath="//a[contains(text(),'View license(s)')]")
	WebElement viewlicenses;
	
	@FindBy(xpath="/html[1]/body[1]/div[8]/div[1]/span[1]")
	WebElement viewlicensesheader;
	
	@FindBy(xpath="/html[1]/body[1]/div[8]/div[1]/button[1]")
	WebElement viewlicensesclosebutton;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/form[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/a[1]/i[1]")
	WebElement action;
	
	@FindBy(css="#loginAsPharmacist")
	WebElement loginasuser;
	
	@FindBy(css="#editProfile")
	WebElement editprofile;
	
	@FindBy(xpath="//img[@id='logo']")
	public WebElement dashboard;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/form[1]/div[1]/h1[1]")
	public WebElement profile;
	
	@FindBy(xpath="/html[1]/body[1]/div[7]/div[1]/button[1]")
	public WebElement sectyquestnsclosebutton;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/form[1]/div[1]/h1[1]")
	public WebElement profileheader;
	
	
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
		registerfirstName.sendKeys("Auto");
	}

	public void registerlastname_inputdata() {
		String lname = "cardaccnt" + RandomStringUtils.randomNumeric(3);
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
		String uname = "TestAccount" + RandomStringUtils.randomNumeric(3);
	    registerusername.sendKeys(uname);
	}
	
	public void choosepassword() {
		registerpassword.sendKeys("Changeme@123");
	}
	
	public void choosepassword_req() {
		registerpassword.sendKeys("changeme123");
		registerconfpwd.sendKeys("changeme123");
	}
	
	public void cnfirmpassword() {
		registerconfpwd.sendKeys("Changeme@123");
	}
	
	public void correctpwd() {
		choosepassword();
		cnfirmpassword();
	}
	
	public void username_req() {
		registerusername.clear();
		registerusername.sendKeys("test");
		registerpassword.clear();
		registerpassword.sendKeys("Changeme@123");
		registerconfpwd.clear();
		registerconfpwd.sendKeys("Changeme@123");
	}
	
	public void username_input() {
		registerusername.clear();
		chooseusername();
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
	
	public void profdetails() throws InterruptedException {
		companyname_inputdata();
		jobtitle_inputdata();
		Thread.sleep(3000);
	}
	
	public void dobandphone() throws InterruptedException {
		dob_inputdata();
		Thread.sleep(2000);
		phone_inputdata();
		Thread.sleep(3000);
	}
	
	public void pharmacystate() {
		List<WebElement> itemsInDropdown = driver.findElements(By.xpath("/html/body/div/form/div/div/div[4]/p[1]/select/option"));
		int size = itemsInDropdown.size();
		int randnMumber = ThreadLocalRandom.current().nextInt(0, size);
		itemsInDropdown.get(randnMumber).click();
	}
	
	public void pharmacydetails() throws InterruptedException {
		pharmacynumber.sendKeys("9999990");
		pharmacystate();
		Thread.sleep(2000);
		dob_inputdata();
		phone_inputdata();
	}
		
	public void signupsuccessmsg() {
		String expecteddataactualmsg=signupsuccessmsg.getText();
		String actualexpectedmsg= "Thanks for registering!";
		Assert.assertEquals(expecteddataactualmsg, actualexpectedmsg);
	}
	
	public void register_inputdetails() {
		registerfirstname_inputdata();
		registerlastname_inputdata();
		roles_click();
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
	
	public void register_pwddetails() {
		registerfirstname_inputdata();
		registerlastname_inputdata();
		roles_click();
		addressline1_inputdata();
		city_inputdata() ;
		state_inputdata();
		zip_inputdata();
		dob_inputdata();
		phone_inputdata();
		email_inputdata();
		chooseusername();
		choosepassword_req();
		selectsecurityquestion1();
		securityanswer1();
		selectsecurityquestion2();
		securityanswer2();
		selectsecurityquestion3();
		securityanswer3();
	}
	
	public void roles_click() {
		techrole.click();
		pharmacyadminrole.click();
	}
	
	public void roles_click1() {
		techrole.click();
		pharmacyadminrole.click();
		role.click();
		pharmacistrole.click();
	}
	
	public void clientroles_click() {
		role.click();
		pharmacistrole.click();
	}
	
	public void chooseexistingusername() {
		String uname = "Testcard12";
		registerusername.clear();
	    registerusername.sendKeys(uname);
	}
	
	public void manageuseraccount_click() {
		manageuseraccount.click();
	}
	
	public void manageusername_input() {
		manageuseraccountusername.clear();
		manageuseraccountusername.sendKeys("test.automation");
	}
	
	public void manageuser_Searchbutton() {
		searchbutton.click();
	}
	
	public void manageusername_input1() {
		manageuseraccountusername.sendKeys("Internal.testAutomation");
	}
	
	
	public void securityquestions_validation() {
		securityquestions.click();
		securityquestionsheader.isDisplayed();
		securityquestionsclosebutton.click();
		securityquestionslabel1.isDisplayed();
		securityquestionslabel2.isDisplayed();
		securityquestionslabel3.isDisplayed();
		System.out.println("Security questions modal dialog is viewed, question and answers are present and modal dialog is closed");	
	}
	
	public void securityquestnsclosebtn_click() {
		sectyquestnsclosebutton.click();
	}
	
	public void viewlicenses_validation() throws InterruptedException {
		viewlicenses.click();
		Thread.sleep(3000);
		viewlicensesheader.isDisplayed();
		viewlicensesclosebutton.click();
		System.out.println("View license modal dialog is viewed and closed");
	}
	
	public void action_click() {
		action.click();		
	}
	
	public void loginasuser_click() {
		//loginasuser.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", loginasuser);
	}
	
	public void actionloginasuser_validation() throws InterruptedException {
		action_click();
		Thread.sleep(2000);
		loginasuser_click();
		Thread.sleep(2000);
	}
	
	public void actioneditprofile_validation() throws InterruptedException {
		action_click();
		Thread.sleep(2000);
		editprofile.click();
		Thread.sleep(3000);
	}
	
	public void roleslist_validation() {
		String expectedroles=roleslist.getText().trim();
		System.out.println("Roles list:" +expectedroles);
		String actualroles= "Pharmacy Administrator - Set up access\n"
				+ "Tech/Pharm Intern or Student";
		Assert.assertEquals(expectedroles, actualroles);
		System.out.println("Roles 'Pharmacy Administrator' and 'Tech/Pharm Intern or Student' is displayed in the roles list");
	}
	
	public void roleslist_validation1() {
		String expectedroles=roleslist.getText().trim();
		System.out.println("Roles list:" +expectedroles);
		String actualroles= "Client - Set up access\n"
				+ "Pharmacist - View license(s)";
		Assert.assertEquals(expectedroles, actualroles);
		System.out.println("Roles 'Pharmacist' and 'client' is displayed in the roles list");
	}
	
	public void existingusernameerrormsg() {
		String expectedmsg=existingusernameerrormsg.getText();
		String actualmsg= "* This username is already taken, please try a different one";
		Assert.assertEquals(expectedmsg, actualmsg);
	}
	
	public void pwderrormsg() {
		String missingfieldactualmsg=pwderrormsg.getText();
		System.out.println("Password error:" +missingfieldactualmsg);
		String missingfieldexpectedmsg= "* The password you entered does not meet our security requirements";
		Assert.assertEquals(missingfieldexpectedmsg, missingfieldactualmsg);
	}
	
	public void usernameerrormsg() {
		String missingfieldactualmsg=usernameerrormsg.getText();
		System.out.println("Username error:" +missingfieldactualmsg);
		String missingfieldexpectedmsg= "* Username must be at least 6 characters long";
		Assert.assertEquals(missingfieldexpectedmsg, missingfieldactualmsg);
	}
	
	public void profileheader() throws InterruptedException {
		String profile= profileheader.getAttribute("textContent").substring(0,11);
		//System.out.println("Profileheader:"+profile);
		String actprofileheader="Profile for";
		Assert.assertEquals(profile, actprofileheader);
	}
	
	
}