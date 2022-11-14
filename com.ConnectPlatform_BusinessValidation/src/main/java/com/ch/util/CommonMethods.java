package com.ch.util;

import java.time.Duration;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;


import com.ch.base.TestBase;

public class CommonMethods extends TestBase{
	
	public CommonMethods() {
		super();
	}
	
	public void implicitwait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public void waitBySeconds(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickElement(WebElement element) {
		element.click();
	}

	

}
