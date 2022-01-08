package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataproviders.CustomDataProvider;
import com.learnautomation.pages.AdminPage;
import com.learnautomation.pages.HomePage;
import com.learnautomation.pages.LoginPage;


public class LoginTestWithPOMWithFactory extends BaseClass
{
	LoginPage login;
	HomePage home;
	AdminPage admin;
	public WebDriver driver;
	
	@BeforeMethod
	public void setupDriver()
	{
		driver=getDriver();
	}
	
	@Test(dataProvider = "Login",dataProviderClass = CustomDataProvider.class,priority = 0)
	public void login(String uname,String pass) 
	{
		login=PageFactory.initElements(driver, LoginPage.class);
		
		home= login.loginAsAdmin(uname, pass);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"URL pattern did not match");
	}
	
	@Test(priority = 1)
	public void verifyTabs()
	{
		int tabCount=home.countTabs();
		
		Assert.assertEquals(tabCount, 11);
	}
	

	@Test(priority = 2)
	public void logOutApplication()
	{
		home.logOutFromApplication();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}

}
