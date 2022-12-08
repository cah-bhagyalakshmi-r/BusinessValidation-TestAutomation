package com.ch.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ch.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public boolean trialMode = true;
	public static HashMap<String, Object> jsonMap;
	public static String testDataFileName;
	public static String testDataPath = "/src/main/java/com/ch/testdata/testdata.json";

	LoginPage loginpage;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/ch" + "/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void internalinitialization() {
		String browserName = prop.getProperty("browser");	
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/Resources/chromedriver");
			//System.out.println("path..."+System.getProperty("user.dir")+"src/main/Resources/chromedriver");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			Map<String,Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
			prefs.put("plugins.always_open_pdf_externally", true);
			prefs.put("profile.default_content_settings.popups", 0);
			prefs.put("download.prompt_for_download", "false");
			prefs.put("download.default_directory", System.getProperty("user.dir") + "/src/main/java/com/ch/testdata"); 
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--no-proxy-server");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--proxy-server='direct://'");
			options.addArguments("--proxy-bypass-list=*");
			options.addArguments("--start-maximised");
			options.setAcceptInsecureCerts(true);
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-gpu");
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--disable-web-security");
			options.addArguments("useAutomationExtension", "False");
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource
			options.addArguments("disable-infobars"); // disabling infobars
			options.addArguments("--disable-extensions"); // disabling extensions
			options.addArguments("--window-size=1920,1080"); // Bypass OS security model
			//options.addArguments("--headless");
			//options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			options.addArguments("window-size=1024,768"); // Bypass OS security model
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "src/main/java/Resources/geckodriver");	
			driver = new FirefoxDriver(); 
		}			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println("URL.....: "+prop.getProperty("internalstagephiurl"));
		driver.get(prop.getProperty("internalstagephiurl"));
	}


}