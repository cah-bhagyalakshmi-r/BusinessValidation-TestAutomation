package com.ch.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import com.ch.pages.LoginPage;
import com.ch.util.TestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public String testEnvironment = "staging"; // stage-phi, staging, or secure (prod)
	public boolean trialMode = true;
	public String baseURL = "https://" + testEnvironment + ".outcomesmtm.com/";
	public static HashMap<String, Object> jsonMap;
	public static String testDataFileName;
	public static String testDataPath = "/src/main/java/com/ch/testdata/testdata.json";
	
	LoginPage loginpage;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/ch"
					+ "/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public void initialization(){
		String browserName = prop.getProperty("browser");	
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/Resources/chromedriver");
			//System.out.println("path..."+System.getProperty("user.dir")+"src/main/Resources/chromedriver");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();

			Map<String,Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
			prefs.put("plugins.always_open_pdf_externally", true);

			prefs.put("download.default_directory", System.getProperty("user.dir") + "/src/main/java/com/ch/testdata"); 
			options.setExperimentalOption("prefs", prefs);

			//prefs.put("profile.default_content_settings.popups", 0);

			//HashMap<String, Object> chromePref = new HashMap<>();
			options.addArguments("--no-proxy-server");
			options.setExperimentalOption("excludeSwitches", Arrays.asList("test-type"));
			//options.addArguments("proxy-bypass-list=<-loopback>");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--proxy-server='direct://'");
			options.addArguments("--proxy-bypass-list=*");
			options.setAcceptInsecureCerts(true);
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-gpu");
			options.addArguments("test-type");
			options.addArguments("disable-popup-blocking");
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--disable-web-security");
			options.addArguments("useAutomationExtension", "False");
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource
			options.addArguments("disable-infobars"); // disabling infobars
			options.addArguments("--disable-extensions"); // disabling extensions
			options.addArguments("--window-size=1920,1080"); // Bypass OS security model
			//options.addArguments("--headless");
			//options.addArguments("--no-sandbox");

		driver = new ChromeDriver(options);
		
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "src/main/java/Resources/geckodriver");	
			driver = new FirefoxDriver(); 
		}			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println("URL.....: "+prop.getProperty("Stagingurl"));

		driver.get(prop.getProperty("Stagingurl"));

	}
	
	public void internalinitialization(){
		String browserName = prop.getProperty("browser");	
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/Resources/chromedriver");
			//System.out.println("path..."+System.getProperty("user.dir")+"src/main/Resources/chromedriver");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			Map<String,Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
			prefs.put("plugins.always_open_pdf_externally", true);
			prefs.put("download.default_directory", System.getProperty("user.dir") + "/src/main/java/com/ch/testdata"); 
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--no-proxy-server");
			options.setExperimentalOption("excludeSwitches", Arrays.asList("test-type"));
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--proxy-server='direct://'");
			options.addArguments("--proxy-bypass-list=*");
			options.setAcceptInsecureCerts(true);
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-gpu");
			options.addArguments("test-type");
			options.addArguments("disable-popup-blocking");
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--disable-web-security");
			options.addArguments("useAutomationExtension", "False");
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource
			options.addArguments("disable-infobars"); // disabling infobars
			options.addArguments("--disable-extensions"); // disabling extensions
			options.addArguments("--window-size=1920,1080"); // Bypass OS security model
			//options.addArguments("--headless");
			//options.addArguments("--no-sandbox");

		driver = new ChromeDriver(options);
		
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "src/main/java/Resources/geckodriver");	
			driver = new FirefoxDriver(); 
		}			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		System.out.println("URL.....: "+prop.getProperty("internalurl"));
		
		driver.get(prop.getProperty("internalurl"));
		
	}



}