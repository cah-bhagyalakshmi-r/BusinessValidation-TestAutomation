package com.ch.pages;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ch.base.TestBase;
import com.ch.util.CommonMethods;
import com.ch.util.JsonFileReader;

public class PatientNotesPage1 extends TestBase {

	@FindBy(css = "button#add-medication-button > .mat-button-wrapper")
	public WebElement addMedicationButton;
	
	@FindBy(xpath = "//div[contains(text(),'Patient Notes')]")
	public WebElement patientnote;
	
	@FindBy(xpath = "//button[contains(text(),'Add Note')]")
	public WebElement addnote;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[3]/connect-plus-patient-notes[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/textarea[1]")
	public WebElement patientnotevalue;
	
	@FindBy(xpath = "//button[contains(text(),'Save Note')]")
	public WebElement savenote;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[3]/connect-plus-patient-notes[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/weld-icon[1]/span[1]")
	public WebElement deletenote;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/md-dialog[1]/md-dialog-actions[1]/button[2]")
	public WebElement okbutton;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[3]/connect-plus-patient-notes[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/p[1]")
	public WebElement notesrow;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div[3]/connect-plus-patient-notes/div/div/div/div/div[2]/div/div[2]/div/div/div/div[1]/span/flux-icon[1]")
	public WebElement deleterow;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div[3]/connect-plus-patient-notes/div/div/div/div/div[2]/div/div[2]/div/div/div/div[1]/span/flux-icon[2]")
	public WebElement editrow;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[3]/connect-plus-patient-notes[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/textarea[1]")
	public WebElement patientnoteedit;
	
	@FindBy(xpath = "//button[contains(text(),'Save Note')]")
	public WebElement patientnoteeditsavebutton;
	
	
	int normalWaitTime = 4;
	int defaultWaitTime = 5;
	String patientnotes;
	boolean removenote = true;
	boolean removedrug = true;
	boolean removecondition = true;

	Actions act = new Actions(driver);
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	CommonMethods commonMethods = new CommonMethods();
	JsonFileReader jsonreader = new JsonFileReader();

	public PatientNotesPage1() throws IOException, ParseException {
		PageFactory.initElements(driver, this);
		readTestData();
	}

	private void readTestData() throws IOException, ParseException {
		jsonreader.getdata();
		patientnotes = jsonreader.Patientnotes.get("addingnote").toString();
	}
	
	public void patientnotes_click() throws InterruptedException {
		Thread.sleep(5000);
		//patientnote.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/pharmacy-patient-hub"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.elementToBeClickable(addplantologo));
		//addplantologo.click();	
		WebElement pt=shadowroot.findElement(By.cssSelector("#pharmacy-patient-hub-side-nav > button"));
		pt.click();
	}
	
	public void addnote_click() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/pharmacy-patient-hub"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		WebElement root1 =shadowroot.findElement(By.cssSelector("div > connect-plus-patient-notes"));
		SearchContext shadowroot1 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root1);
		Thread.sleep(2000);
		WebElement addnote=shadowroot1.findElement(By.cssSelector(".flux-btn.flux-btn-primary.flux-btn-sm"));
		executor.executeScript("arguments[0].scrollIntoView();", addnote);
		executor.executeScript("arguments[0].click();", addnote);
	}
	
	public void addnote_input() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/pharmacy-patient-hub"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		WebElement root1 =shadowroot.findElement(By.cssSelector("div > connect-plus-patient-notes"));
		SearchContext shadowroot1 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root1);
		Thread.sleep(1000);
		WebElement patientnote=shadowroot1.findElement(By.cssSelector(".flux-marg-b-xs"));
		patientnote.sendKeys(patientnotes);
	}
	
	public void savenote_click() throws InterruptedException {
		Thread.sleep(1000);
		//savenote.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/pharmacy-patient-hub"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		WebElement root1 =shadowroot.findElement(By.cssSelector("div > connect-plus-patient-notes"));
		SearchContext shadowroot1 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root1);
		Thread.sleep(1000);
		WebElement savenote=shadowroot1.findElement(By.cssSelector(".flux-btn.flux-btn-sm.flux-btn-primary.action"));
		savenote.click();
	}
	
	public void deletenote_click() throws InterruptedException {
		//Actions actions=new Actions(driver);
		//actions.moveToElement(deleterow).click().build().perform();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/pharmacy-patient-hub"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		WebElement root1 =shadowroot.findElement(By.cssSelector("div > connect-plus-patient-notes"));
		SearchContext shadowroot1 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root1);
		Thread.sleep(1000);
		WebElement deleterow=shadowroot1.findElement(By.cssSelector("flux-icon[icon='delete']"));
		deleterow.click();	
	}
	
	public void editnote_click() throws InterruptedException {
		//editrow.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/pharmacy-patient-hub"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		WebElement root1 =shadowroot.findElement(By.cssSelector("div > connect-plus-patient-notes"));
		SearchContext shadowroot1 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root1);
		Thread.sleep(1000);
		WebElement editrow=shadowroot1.findElement(By.cssSelector("flux-icon[icon='pencil']"));
		editrow.click();
	}
	
	public void okbutton_click() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", okbutton);
		executor.executeScript("arguments[0].click();", okbutton);
		//okbutton.click();
	}
	
	public void patientnote_validation() throws InterruptedException {
		Thread.sleep(2000);
		String patientnote= "AutomationTesting";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/pharmacy-patient-hub"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		WebElement root1 =shadowroot.findElement(By.cssSelector("div > connect-plus-patient-notes"));
		SearchContext shadowroot1 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root1);
		Thread.sleep(1000);
		WebElement notesrow=shadowroot1.findElement(By.cssSelector(".note-text"));
		String actualpatientnote=notesrow.getAttribute("textContent").trim();
		System.out.println("Patientnote:" +actualpatientnote);
		Assert.assertEquals(patientnote, actualpatientnote);
	}
	
	public void patientnoteedit_input() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/pharmacy-patient-hub"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		WebElement root1 =shadowroot.findElement(By.cssSelector("div > connect-plus-patient-notes"));
		SearchContext shadowroot1 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root1);
		Thread.sleep(1000);
		WebElement patientnoteedit=shadowroot1.findElement(By.cssSelector(".flux-marg-b-xs"));
		patientnoteedit.sendKeys("patientedit");
	}
	
	public void patientnoteedit_validation() throws InterruptedException {
		String patientnoteafteredit= "AutomationTestingpatientedit";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/pharmacy-patient-hub"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		WebElement root1 =shadowroot.findElement(By.cssSelector("div > connect-plus-patient-notes"));
		SearchContext shadowroot1 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root1);
		Thread.sleep(1000);
		WebElement notesrow=shadowroot1.findElement(By.cssSelector(".note-text"));
		String actualpatientnoteedit=notesrow.getAttribute("textContent").trim();
		System.out.println("Patientnote:" +actualpatientnoteedit);
		Assert.assertEquals(patientnoteafteredit, actualpatientnoteedit);
	}
	
	public void patienteditsavebutton_click() throws InterruptedException {
		//patientnoteeditsavebutton.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/pharmacy-patient-hub"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		WebElement root1 =shadowroot.findElement(By.cssSelector("div > connect-plus-patient-notes"));
		SearchContext shadowroot1 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root1);
		Thread.sleep(1000);
		WebElement savenote=shadowroot1.findElement(By.cssSelector(".flux-btn.flux-btn-sm.flux-btn-primary.action"));
		savenote.click();
	}
	
	public SearchContext expandRootElement (WebElement element) {
	       SearchContext shadowRoot = (SearchContext) ((JavascriptExecutor) driver).executeScript (
	           "return arguments[0].shadowRoot", element);
	       return shadowRoot;
	   }
	
	   public String getSomeText () {
	       return driver.findElement (By.xpath ("/html/body/div[2]/div[1]/div[2]/pharmacy-patient-hub"))
	           .getText ();
	   }

	   public String getShadowDomText () {
	       WebElement shadowHost = driver.findElement (By.id ("shadow_host"));
	       SearchContext shadowRoot = shadowHost.getShadowRoot ();
	       String text = shadowRoot.findElement (By.xpath("/html/body/div[2]/div[1]/div[2]/pharmacy-patient-hub"))
	           .getText ();
	       return text;
	   }


	
	
}
