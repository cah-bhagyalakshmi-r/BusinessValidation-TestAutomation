package com.ch.pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.ch.base.TestBase;

import junit.framework.Assert;

public class NINrsnPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'NIN reasons')]")
	WebElement ninreasons;
	
	@FindBy(xpath = "//h3[contains(text(),'Manage NIN Reasons by Reason Code')]")
	WebElement ninreasonsheader;
	
	@FindBy(xpath = "//select[@id='reasonTypeID']")
	public WebElement reasontype;
	
	@FindBy(xpath = "//h3[contains(text(),'Search Results')]")
	WebElement searchresultsheader;
	
	@FindBy(xpath = "//th[contains(text(),'Reason')]")
	WebElement reason;
	
	@FindBy(xpath = "//th[contains(text(),'NIN Status')]")
	WebElement ninstatus;
	
	@FindBy(xpath = "//th[contains(text(),'Included')]")
	WebElement included;
	
	@FindBy(xpath = "//body/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/label[1]/input[1]")
	WebElement searchinput;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
	public WebElement firstrecord;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/input[1]")
	public WebElement includedradiobtn;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/input[2]")
	public WebElement excludedradiobtn;
	
	@FindBy(xpath = "//a[@id='save']")
	public WebElement save;
	
	
	public NINrsnPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void ninreasons_click() {
		ninreasons.click();		
	}
	
	public void ninreasons_fieldvalidation() {
		ninreasonsheader.isDisplayed();
		reasontype.isDisplayed();
		ninstatus.isDisplayed();	
		included.isDisplayed();
		searchinput.isDisplayed();		
	}
	
	public void firstrec_click() {
		firstrecord.click();
	}
	
	public void includedcheck() {
		if(includedradiobtn.isSelected()) {
			excludedradiobtn.click();
		}
		else if (excludedradiobtn.isSelected()) {
			includedradiobtn.click();		
		}
		else
		{
			System.out.println("The search results are not displayed to update the changes");
		}
	}
	
	public void save_click() {
		save.click();
	}
	
	
}