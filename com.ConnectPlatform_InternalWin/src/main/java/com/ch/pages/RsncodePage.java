package com.ch.pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.ch.base.TestBase;

import junit.framework.Assert;

public class RsncodePage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Reason code TIP configurations')]")
	WebElement reasoncodetipconfiguration;
	
	@FindBy(xpath = "//h3[contains(text(),'Manage Reason Code TIP Options')]")
	WebElement managereasoncodeheader;
	
	@FindBy(xpath = "//th[contains(text(),'Reason Code')]")
	WebElement reasoncode;
	
	@FindBy(xpath = "//thead/tr[1]/th[2]")
	WebElement reason;
	
	@FindBy(xpath = "//div[@id='tblReasons_info']")
	public WebElement resultset;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/p[1]/span[2]/a[1]/i[1]")
	public WebElement firstrecord;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")
	public WebElement reasoncodedisplay;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/p[1]/strong[1]")
	public WebElement tipreason;
	
	@FindBy(xpath = "//input[@id='TIPModalQuestion7']")
	public WebElement tipmodalquestion;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/div[2]/div[1]/label[1]")
	public WebElement tipoverviewquestionlabel;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/div[2]/div[2]/label[1]")
	public WebElement actionneededlabel;
	
	@FindBy(xpath = "//textarea[@id='actionVerbiage7']")
	public WebElement actionverbiage;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/div[2]/div[3]/label[1]")
	public WebElement tipguidepdf;	
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/div[2]/div[4]/span[1]/a[1]")
	public WebElement save;	


	public RsncodePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void reasoncodetipconfiguration_click() {
		reasoncodetipconfiguration.click();		
	}
	
	public void reasoncode_fieldvalidation() {
		managereasoncodeheader.isDisplayed();
		reason.isDisplayed();
		reason.isDisplayed();	
	}
	
	public void firstrec_click() {
		firstrecord.click();
	}
	
	public void reasoncode_view() {
		reasoncodedisplay.isDisplayed();
		tipreason.isDisplayed();
		tipmodalquestion.isDisplayed();
		tipoverviewquestionlabel.isDisplayed();
		actionneededlabel.isDisplayed();
		actionverbiage.isDisplayed();
		tipguidepdf.isDisplayed();
		save.isDisplayed();
	}
	
	
	
	
	
}