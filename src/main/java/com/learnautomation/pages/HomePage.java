package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage 
{
	WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By allTabs=By.xpath("//a[@class='firstLevelMenu']//b");
	By adminTab=By.xpath("//b[text()='Admin']");
	By welcomeTab=By.xpath("//a[@id='welcome']");
	By logout=By.xpath("//a[text()='Logout']");
	
	public LoginPage logOutFromApplication()
	{
		driver.findElement(welcomeTab).click();
		driver.findElement(logout).click();
		return new LoginPage(driver);
	}
	

	public int countTabs()
	{
		int count=driver.findElements(allTabs).size();
		
		return count;
	}
	
	public AdminPage clickOnAdmin()
	{
		driver.findElement(adminTab).click();
		return new AdminPage(driver);
	}
	
	
}
