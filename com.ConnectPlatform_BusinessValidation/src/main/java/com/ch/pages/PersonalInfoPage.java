package com.ch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ch.base.TestBase;
import com.ch.util.CommonMethods;

public class PersonalInfoPage extends TestBase {
	
	@FindBy(id = "mtmId")
	WebElement patientIdLocator;
	
	@FindBy(css = "p#startClaimLink")
	WebElement startLinkLocator;
	
	@FindBy(css = "input#ptTakingRefMedY")
	WebElement firstOptionLocator;
	
	@FindBy(css = "//*[@id='input-paperInputMask']")
	WebElement dateSelector;
	
	@FindBy(css = ".ember-view.md-button.md-default-theme.md-no-style")
	WebElement TipButtonLocator;
	
	@FindBy(css = "img#connectLogo")
	WebElement DashboardIcon;
	
	@FindBy(xpath = "//p[@id='startClaimLink']")
	public WebElement startClaimButtonLocator;
	
	@FindBy(css = "a:nth-of-type(2) > .navItem")
	WebElement claimsHistoryLocator;
	
	@FindBy(css = "span:nth-of-type(2) > .selectable.subNavTab > .tabUrl")
	WebElement medicationTabLocator;
	
	@FindBy(css = "a:nth-of-type(2) > .navItem")
	WebElement rxHistoryLocator;
	
	@FindBy(xpath = "//span[contains(text(),'Personal Info')]")
	WebElement personalInfotab;
	
	@FindBy(xpath = "//h4[contains(text(),'About the Patient')]")
	WebElement aboutpatientheader;
	
	@FindBy(xpath = "//h4[contains(text(),'MTM Program Info')]")
	WebElement personalInfomtmheader;
	
	@FindBy(xpath = "//span[contains(text(),'Gender')]")
	WebElement personalInfogender;
	
	@FindBy(xpath = "//span[contains(text(),'Date of Birth')]")
	WebElement personalInfodob;
	
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/weld-card[1]/div[2]/div[3]/span[1]")
	WebElement personalInfoAddress;
	
	@FindBy(xpath = "//span[contains(text(),'Primary Phone')]")
	WebElement personalInfoprimaryphone;
	
	@FindBy(xpath = "//span[contains(text(),'Primary Language')]")
	WebElement personalInfoprimarylanguage;

	@FindBy(xpath = "//span[contains(text(),'Policy')]")
	WebElement personalInfopolicy;
	
	@FindBy(xpath = "//span[contains(text(),'Member ID')]")
	WebElement personalInfomemberid;
		
	@FindBy(xpath = "//span[contains(text(),'MTM Effective Date')]")
	WebElement personalInfomtmeffectivedate;
	
	@FindBy(xpath = "//span[contains(text(),'% Rx Filled at Your Pharmacy')]")
	WebElement personalInforxpahrmacy;
	
	@FindBy(css="#dobAndAge")
	public WebElement dob;
	
	@FindBy(css="#gender")
	public WebElement gender;
	
	@FindBy(css="#phoneNumber")
	public WebElement phonenumber;
	
	@FindBy(css="#mtmId")
	public WebElement id;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/weld-card[1]/div[2]/div[1]/strong[1]")
	WebElement patientgender;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/weld-card[1]/div[2]/div[2]/strong[1]")
	WebElement patientdob;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/weld-card[1]/div[2]/div[4]/strong[1]")
	WebElement patientphone;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/weld-card[1]/div[2]/div[2]/strong[1]")
	WebElement patientmemberid;
	
	@FindBy(xpath = "//span[contains(text(),'Policy')]")
	WebElement policy;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/weld-card[1]/div[2]/div[1]/strong[1]")
	WebElement patientpolicy;

	CommonMethods commonMethods;
			
	public PersonalInfoPage() {
		PageFactory.initElements(driver, this);
		commonMethods = new CommonMethods();
	}
	
	public String getPatientId(){
		return driver.findElement(By.id("mtmId")).getAttribute("value");
	}
	
	public void clickClaimLink(){
		startLinkLocator.click();
	}
	
	public void clickRxHistory(){
		rxHistoryLocator.click();
	}
	
	public void clickMedicationTab(){
		medicationTabLocator.click();
	}
	
	public void clickClaimsHistory(){
		claimsHistoryLocator.click();
	}
	
	public void clickStartClaim() throws InterruptedException{
		//Thread.sleep(2000);
		//startClaimButtonLocator.click();
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/pharmacy-patient-hub"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		//Thread.sleep(8000);
		WebElement startclaim=shadowroot.findElement(By.cssSelector("div:nth-child(7) > flux-side-nav:nth-child(2) > flux-side-nav-item:nth-child(10)"));
		 startclaim.click();
	}
	
	public boolean verifyClaimsPage(String url){
		if(url.contains("claimSubmit")){
			return true;
		}else
			return false;
		}
	
	public void clickFirstOption(){
		firstOptionLocator.click();
	}
	
	public void clickTipButton(){
		TipButtonLocator.click();
	}
	
	public void clickIcon(){
		DashboardIcon.click();
	}
	
	public void personalinfotab_click() {
		personalInfotab.click();
	}
	
	public void personalinfo_Validation() {
		aboutpatientheader.isDisplayed();
		personalInfomtmheader.isDisplayed();
		personalInfogender.isDisplayed();
		personalInfodob.isDisplayed();
		personalInfoAddress.isDisplayed();
		personalInfoprimaryphone.isDisplayed();
		personalInfoprimarylanguage.isDisplayed();
		personalInfopolicy.isDisplayed();
		personalInfomemberid.isDisplayed();
		personalInfomtmeffectivedate.isDisplayed();
		personalInforxpahrmacy.isDisplayed();
	}
	
	public void patientinfodetails_validation() {
		String ptdob=dob.getAttribute("textContent").substring(0,10);
		System.out.println("patient dob:" +ptdob);
		
		String ptphnum=phonenumber.getAttribute("textContent").trim();
		System.out.println("patient phonenumber:" +ptphnum);	
		
		String ptpolicy=policy.getAttribute("textContent").trim();
		System.out.println("patient policy:" +ptpolicy);
		
		String ptid= id.getAttribute("textContent").substring(4).trim();
		System.out.println("patient id:" +ptid);
		
		String ptgender= gender.getAttribute("textContent").substring(0).trim();
		System.out.println("patient gender:" +ptgender);
		
		String ptdob1=patientdob.getAttribute("textContent").substring(0,10);
		System.out.println("patient dob:" +ptdob1);
		
		String ptphnum1=patientphone.getAttribute("textContent").trim();
		System.out.println("patient phonenumber:" +ptphnum1);	
		
		String ptpolicy1=patientpolicy.getAttribute("textContent").trim();
		System.out.println("patient policy:" +ptpolicy1);
		
		String ptid1= patientmemberid.getAttribute("textContent").substring(0).trim();
		System.out.println("patient id:" +ptid1);
		
		String ptgender1= patientgender.getAttribute("textContent").substring(0).trim();
		System.out.println("patient gender:" +ptgender1);
		
		Assert.assertEquals(ptdob, ptdob1);
		Assert.assertEquals(ptphnum, ptphnum1);
		Assert.assertEquals(ptpolicy, ptpolicy1);
		Assert.assertEquals(ptid, ptid1);
		Assert.assertEquals(ptgender, ptgender1);
		
		
	}
}
