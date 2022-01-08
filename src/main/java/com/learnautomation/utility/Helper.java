package com.learnautomation.utility;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	
	/*
	 *dynamic wait 		
	 *DD	
	 *Actions
	 *screenshots
	 *JSExecutor
	 *switchToCommands
	 *WebElements 
	 *broken link
	 *broken images
	 *
	 */
	
	public static void wait(int seconds)
	{
		try 
		{
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static WebElement waitForWebElement(WebDriver driver,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(locator));	
		return ele;
	}
	
	public static String captureScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String image=ts.getScreenshotAs(OutputType.BASE64);
		System.out.println("Base64 data is "+image);
		return image;
		
	}
	
	public static String getCurrentDateTime()
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		
		return dateformat.format(new Date());
	}
	
	
	
}
