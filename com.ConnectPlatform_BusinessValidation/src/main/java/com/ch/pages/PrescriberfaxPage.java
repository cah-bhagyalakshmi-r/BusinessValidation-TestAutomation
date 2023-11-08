package com.ch.pages;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ch.base.TestBase;
import com.ch.util.CommonMethods;

public class PrescriberfaxPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Menu')]")
	WebElement mainmenu;
	
	@FindBy(css = "#prescriberFaxLink")
	WebElement prescriberfax;
	
	@FindBy(xpath = "//h1[contains(text(),'Prescriber Communication')]")
	WebElement prescribercommunicationheader;
	
	@FindBy(xpath = "//label[contains(text(),'Which prescriber would you like to send this docum')]")
	WebElement prescriberinfo;
	
	@FindBy(xpath = "//a[contains(text(),'Preview Your')][1]")
	WebElement previewdocument;
	
	@FindBy(xpath = "//a[contains(text(),'Create and Save the Final')]")
	WebElement createandsavedocument;
	
	@FindBy(css = "#openviewSavedDocsDialog")
	WebElement viewsavedocument;
	
	@FindBy(css = "#addRecommendation")
	WebElement addrecommendation;
	
	@FindBy(css = "#PrescriberFaxNumberOther")
	WebElement fax;
	
	@FindBy(xpath = "//span[contains(text(),'Additional Recommendation')]")
	WebElement additionalrecommendation;
	
	@FindBy(xpath = "//span[contains(text(),'Additional Recommendation')]")
	List<WebElement> additionalrecommendations;
	
	@FindBy(css = "#AdditionalRecDetails1_Span")
	public WebElement additionalrecommendationinput;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/form[1]/div[9]/table[1]/tbody[1]/tr")
	public List<WebElement> currentconditionrowExists;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/form[1]/div[9]/table[1]/tbody[1]/tr/td[3]")
	public List<WebElement> deleteconditionrowExists;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/form[1]/div[9]/table[1]/tbody[1]/tr[1]/td[3]/a[1]/i[1]")
	public WebElement deleteaddrecommendbutton;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/form[1]/div[9]/table[1]/tbody[1]/tr[1]/td[3]/a[1]/i[1]")
	public List<WebElement> deleterowbutton;
	
	@FindBy(xpath = "/html/body/pdf-viewer//viewer-toolbar//div/div[3]/viewer-download-controls//cr-icon-button//div/iron-icon")
	public WebElement pdfdownloadbutton;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[2]/p[1]")
	public WebElement rolelabel;
	
	@FindBy(css = "#submitswitchRoles")
	public WebElement gobutton1;
	
	@FindBy(xpath = "//button[contains(text(),'Go')]")
	public WebElement gobutton;
	
	@FindBy(css = "#roleList")
	public WebElement rolelist1;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/connect-platform-navigation[1]/div[1]/div[1]/div[1]/div[1]/div[2]/flux-card[1]/div[1]/select[1]")
	public WebElement rolelist;
	
	@FindBy(xpath = "//flux-card-header/div[1]/div[1]")
	public WebElement switchroles;
	
	@FindBy(xpath = "//select[@id='savedDocs']")
	public WebElement saveddocs;
	
	@FindBy(css = "#openDocument")
	public WebElement opendocument;
	
	@FindBy(xpath = "//input[@id='patientSearchInput']")
	public WebElement searchtext;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/connect-platform-navigation[1]/div[1]/div[1]/div[1]/span[2]/span[1]/button[1]/flux-icon[1]/span[1]")
	public WebElement searchboxclick;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/connect-platform-navigation[1]/div[1]/div[1]/div[1]/div[1]/div[1]/flux-icon[1]")
	WebElement usermenu;
		
	CommonMethods commonMethods = new CommonMethods();
	boolean removeaddrecommend = true;
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	public PrescriberfaxPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void mainmenuclick() {
		mainmenu.click();
	}
	
	public void usermenuclick() {
		usermenu.click();
	}

	public void switchrolesmenu() {
		rolelabel.click();
	}
	
	public void searchbuttonclick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(searchboxclick));
		searchboxclick.click();
	}

	public void roleselect(String roleselector) {
		Select rolesel = new Select(rolelist);
		rolesel.selectByVisibleText(roleselector);
	}
	
	public void saveddocsselect() {
		Select saveddocsel = new Select(saveddocs);
		saveddocsel.selectByIndex(1);
	}

	public void gobutton_click() throws InterruptedException {
		gobutton.click();
		Thread.sleep(10000);
	}

	public void prescriberfax_Validation() throws InterruptedException{
		prescribercommunicationheader.isDisplayed();
		prescriberinfo.isDisplayed();
		previewdocument.isDisplayed();
		createandsavedocument.isDisplayed();
		viewsavedocument.isDisplayed();
		Thread.sleep(5000);
	}
	
	public void prescriberfax_click() throws InterruptedException {
		//prescriberfax.click();
		Thread.sleep(9000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement root = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/pharmacy-patient-hub"));
		SearchContext shadowroot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);

		WebElement prefax=shadowroot.findElement(By.cssSelector("div:nth-child(7) > flux-side-nav:nth-child(2) > flux-side-nav-item:nth-child(8)"));
	//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.elementToBeClickable(prefax));
		//executor.executeScript("arguments[0].scrollIntoView();", prefax);
		//executor.executeScript("arguments[0].click();", prefax);
		//prefax.click();
		Actions action= new Actions(driver);
		action.moveToElement(prefax).click().build().perform();
	}//
	
	public void opendoc_click() {
		opendocument.click();
	}
	
	
	
	public void addrecommendation_click() {
		addrecommendation.click();
	}
	
	public void faxinput() {
		String phoneinput = RandomStringUtils.randomNumeric(10);
		fax.sendKeys(phoneinput);	
	}
	
	public void createandsavedocument_click() {
		createandsavedocument.click();
	}
	
	public void viewsavedocument_click() {
		viewsavedocument.click();
	}
	
	public void previewdocument_click() {
		previewdocument.click();
	}
	
	public void additionalrecommendatation_input() {
		additionalrecommendationinput.sendKeys("Automation Testing");
	}
	
	public void createandsavedocument_display() {
		createandsavedocument.isDisplayed();
	}
	
	public boolean additionalrecommendation_display() {
		if(additionalrecommendation.isDisplayed()){
			return true;
		}else 
			return false;
	}
	
	public static int getPageCount(PDDocument doc) {
		int pageCount = doc.getNumberOfPages();
		return pageCount;
		
	}

	public String readPdfContent(String url) throws IOException {
		URL pdfUrl = new URL(url);
		InputStream in = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(in);
		PDDocument doc = PDDocument.load(bf);	
		int numberOfPages = getPageCount(doc);
		System.out.println("The total number of pages "+numberOfPages);
		String content = new PDFTextStripper().getText(doc);
		doc.close();
	return content;
}
	
	 public String check_file_exist() throws InterruptedException {
			String home = System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
			String file_name = "PrescriberCommPDF.*\\pdf";
			String file_with_location = home + file_name;
			File file = new File(file_with_location);
			Thread.sleep(2000);
			if (file.getName().startsWith("PrescriberCommPDF")) {
				System.out.println(file_with_location + " is present");
				String result = "File Present";
				return result;
			}else {
				System.out.println(file_with_location + " is not present");
				String result = "File not Present";
				String result1 = result;
				return result1;
			}
		}
	 
	 public String check_file_exist1() throws InterruptedException {
			String home = System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/";
			String file_name1 = "index.pdf";
			String file_with_location1 = home + file_name1;
			//System.out.println("file location: " + home + file_name);
			File file1 = new File(file_with_location1);
			Thread.sleep(2000);
			if (file1.getName().startsWith("index")) {
				System.out.println(file_with_location1 + " is present");
				String result = "File Present";
				return result;			
			} else {
				System.out.println(file_with_location1 + " is not present");
				String result = "File not Present";
				String result1 = result;
				return result1;
			}
		}

		 public void delete_file() {
			 File dir = new File(System.getProperty("user.dir") + "/src/main/java/com/ch/testdata/");
			 for (File f : dir.listFiles()) {
				    if (f.getName().startsWith("PrescriberCommPDF") || (f.getName().startsWith("index"))) {
				        f.delete();
				    }
				}
		 }

}

