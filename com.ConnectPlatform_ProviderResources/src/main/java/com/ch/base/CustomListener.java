package com.ch.base;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ch.util.TestUtil;

public class CustomListener extends TestUtil implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed Test");
		try {
			takeScreenshotAtEndOfTest(result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
