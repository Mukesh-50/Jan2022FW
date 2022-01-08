package com.learnautomation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learnautomation.utility.Helper;

public class AdminPage {

	WebDriver driver;
	
	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By addButton=By.xpath("//input[@value='Add']");
	
	By userRole=By.xpath("//select[contains(@id,'systemUser_userType')]");
	
	By empName=By.xpath("//input[@id=\"systemUser_employeeName_empName\"]");
	
	By userName=By.xpath("//input[@id=\"systemUser_userName\"]");
	
	By password=By.xpath("//input[@id=\"systemUser_password\"]");
	
	By confirmPassword=By.xpath("//input[@id=\"systemUser_confirmPassword\"]");
	
	By saveButton=By.xpath("//input[@id=\"btnSave\"]");
	
	By successMsg=By.xpath("//*[contains(text(),'Successfully Saved') and @class]");
	
	public void createUser(String uRole,String eName,String uName,String pass)
	{
		driver.findElement(addButton).click();
		
		Select userRoleDD=new Select(driver.findElement(userRole));
		
		userRoleDD.selectByVisibleText(uRole);
		
		driver.findElement(empName).sendKeys(eName);
		
		driver.findElement(userName).sendKeys(uName+System.currentTimeMillis());
		
		//driver.findElement(userName).sendKeys(uName+ new Faker().number().randomDigit());
		
		driver.findElement(password).sendKeys(pass);
		
		driver.findElement(confirmPassword).sendKeys(pass);
		
		Helper.wait(2);
		
		driver.findElement(saveButton).click();	
	}
	
	public boolean isSuccessMsgDisplayed()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		return wait.until(ExpectedConditions.elementToBeClickable(successMsg)).isDisplayed();
	}

}
