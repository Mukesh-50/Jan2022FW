package com.learnautomation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learnautomation.utility.Helper;

public class EmployeePage {
WebDriver driver;
	
	public EmployeePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By navigatePIMTab=By.xpath("//input[@id='menu_pim_viewPimModule']");
	
	By addEmployeeTab=By.xpath("//input[@id='menu_pim_addEmployee']");
	
	By firstName=By.xpath("//input[@id='firstName']");
	
	By lastName=By.xpath("//input[@id='lastName']");
	
	By employeeId=By.xpath("//input[@id='employeeId']");	
	
	By saveButton=By.xpath("//input[@id=\"btnSave\"]");
	
	By checkBox=By.xpath("//input[@id='chkLogin']");
	
	By userName=By.xpath("//input[@id='user_name']");
	
	By password=By.xpath("//input[@id='user_password']");
	
	By confirmPassword=By.xpath("//input[@id='re_password']");
	
		
	public void addEmployee(String fName,String lName,String id,String username, String pass, String confirmpass, String status)
	{
		driver.findElement(navigatePIMTab).click();
		driver.findElement(addEmployeeTab).click();		
		driver.findElement(firstName).sendKeys(fName);
		driver.findElement(lastName).sendKeys(lName);
		driver.findElement(employeeId).sendKeys(id);
		driver.findElement(checkBox).click();
		driver.findElement(userName).sendKeys(fName);
		driver.findElement(password).sendKeys(fName);
		driver.findElement(confirmPassword).sendKeys(fName);
				
		Helper.wait(2);
		
		driver.findElement(saveButton).click();	
	}
	
	

}
