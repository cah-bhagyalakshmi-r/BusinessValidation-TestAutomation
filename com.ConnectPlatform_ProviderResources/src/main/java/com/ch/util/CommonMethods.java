package com.ch.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;


import com.ch.base.TestBase;

public class CommonMethods extends TestBase{
	
	public CommonMethods() {
		super();
	}
	
	public void implicitwait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
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
