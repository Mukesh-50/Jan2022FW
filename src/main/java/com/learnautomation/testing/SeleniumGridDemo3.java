package com.learnautomation.testing;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridDemo3 {

	@Test
	public void testOnWin11ChromeLatest() throws MalformedURLException 
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os_version", "15");
		caps.setCapability("device", "iPhone 13 Pro");
		caps.setCapability("real_mobile", "true");
		
		final String USERNAME = "mukeshotwani_p5NVfe";
		final String AUTOMATE_KEY = "5ZAx21YD45weRsZSecRy";
		final String finalURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		
		URL hubURL=new URL(finalURL);
		
		WebDriver driver=new RemoteWebDriver(hubURL, caps);
		
		driver.get("http://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("Selenium Grid");
		
		driver.quit();
		
	}

}
