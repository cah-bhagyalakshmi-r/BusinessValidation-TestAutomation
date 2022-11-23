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
import org.openqa.selenium.support.ui.Select;

import com.ch.base.TestBase;

import junit.framework.Assert;

public class RefusalrsnPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Refusal reasons')]")
	WebElement refusalreasons;
	
	@FindBy(xpath = "//h3[contains(text(),'Manage Refusal Reasons by Reason/Result Codes')]")
	WebElement refusalreasonsheader;
	
	@FindBy(xpath = "//select[@id='reasonTypeID']")
	public WebElement selectreasontype;
	
	@FindBy(xpath = "//select[@id='resultTypeID']")
	WebElement selectresult;
	
	@FindBy(xpath = "//a[@id='search']")
	public WebElement search;
	
	@FindBy(xpath = "//h3[contains(text(),'Search Results')]")
	public WebElement searchresultsheader;
	
	@FindBy(xpath = "//thead/tr[1]/th[1]")
	public WebElement reason;
	
	@FindBy(xpath = "//th[contains(text(),'Result')]")
	public WebElement result;
	
	@FindBy(xpath = "//th[contains(text(),'Refusal Reason')]")
	public WebElement refusalreason;
	
	@FindBy(xpath = "//th[contains(text(),'Included')]")
	public WebElement included;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
	public WebElement reasonrec;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")
	public WebElement resultec;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/input[1]")
	public WebElement includedradiobtn;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/input[2]")
	public WebElement excludedradiobtn;
	
	@FindBy(xpath = "//a[@id='save']")
	public WebElement save;
	
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
	

	public RefusalrsnPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void refusalreasons_click() {
		refusalreasons.click();		
	}
	
	public void refusalreasons_fieldvalidation() {
		refusalreasonsheader.isDisplayed();
		selectreasontype.isDisplayed();
		selectresult.isDisplayed();
		search.isDisplayed();
		searchresultsheader.isDisplayed();
		reason.isDisplayed();
		result.isDisplayed();
		refusalreason.isDisplayed();
		included.isDisplayed();
	}
	
	public void selectreasontype() {
		Select selectreason = new Select(selectreasontype);
		selectreason.selectByIndex(1);	
		WebElement abc = selectreason.getFirstSelectedOption();
		String abc1= abc.getText();
		System.out.println("Reason:" +abc1);
		
	}
	
	public void selectresult() {
		Select selectreason = new Select(selectresult);
		selectreason.selectByVisibleText("Patient refused");	
	}
	
	public void search_click() {
		search.click();
	}
	
	
	
}