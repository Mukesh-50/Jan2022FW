package com.learnautomation.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.learnautomation.dataproviders.ConfigUtility;
import com.learnautomation.factory.BrowserFactory;

public abstract class BaseClass {
	
	public WebDriver driver;
	
	public WebDriver getDriver()
	{
		return driver;
	}

	@Parameters({"cloud","os","os_version","browser","browser_version"})
	@BeforeClass
	public void setup(@Optional("false")String cloud,@Optional("")String os,@Optional("")String os_version,@Optional("chrome")String browser,@Optional("")String browser_version) 
	{
		if(cloud.equalsIgnoreCase("true"))
		{
			System.out.println("LOG:INFO - Test is running on cloud");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os", os);
			caps.setCapability("os_version",os_version);
			caps.setCapability("browser",browser);
			caps.setCapability("browser_version",browser_version);
			
			//final String USERNAME = ConfigUtility.getValue("USERNAME");
			final String USERNAME = "mukeshotwani_p5NVfe";
			final String AUTOMATE_KEY =ConfigUtility.getValue("AUTOMATE_KEY");
			final String finalURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
			
			URL hubURL=null;
			try 
			{
				hubURL = new URL(finalURL);
			} catch (MalformedURLException e) 
			{
				System.out.println("URL incorrect - not able to connect to host "+e.getMessage());
			}
			
			driver=new RemoteWebDriver(hubURL, caps);	
		}
		else
		{
			System.out.println("LOG:INFO - Test is running on local");
			driver=BrowserFactory.startBrowser(ConfigUtility.getValue("browser")); 
		}
		driver.get(ConfigUtility.getValue("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
