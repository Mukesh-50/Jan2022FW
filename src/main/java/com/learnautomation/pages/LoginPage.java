package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By username=By.id("txtUsername");
	By password=By.id("txtPassword");
	By loginButton=By.id("btnLogin");
	
	public void enterUserName(String uname)
	{
		driver.findElement(username).sendKeys(uname);
	}
	
	public void enterPassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickOnLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	
	public HomePage loginAsAdmin(String uname,String pass)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
		
		return new HomePage(driver);
	}
	

}
