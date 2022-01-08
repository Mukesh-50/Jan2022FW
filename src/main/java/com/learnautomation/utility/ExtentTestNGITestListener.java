package com.learnautomation.utility;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ExtentTestNGITestListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	

	public synchronized void onFinish(ITestContext context) {
		System.out.println("LOG:INFO- Reports getting ready");
		extent.flush();
		System.out.println("LOG:INFO- Reports ready");
	}

	public synchronized void onTestStart(ITestResult result) {
		ExtentTest parent = extent.createTest(result.getMethod().getMethodName());
		parentTest.set(parent);
	}

	public synchronized void onTestSuccess(ITestResult result) {
		parentTest.get().pass("Test Passed");
	}

	public synchronized void onTestFailure(ITestResult result) 
	{
		System.out.println("******* Test Failed ********");
		
		WebDriver driver=null;
		
		try 
		{
		Field f=result.getTestClass().getRealClass().getDeclaredField("driver");
		
		Object obj=f.get(result.getInstance());
		
		driver=(WebDriver) obj;
		
		/*
		 * driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		 * 
		 */
		
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("Driver value is "+driver);
		
		parentTest.get().fail("Test Failed " + result.getThrowable().getMessage(), MediaEntityBuilder
				.createScreenCaptureFromBase64String(Helper.captureScreenshot(driver)).build());
	}

	public synchronized void onTestSkipped(ITestResult result) {
		parentTest.get().skip("Test Skipped");
	}

}
