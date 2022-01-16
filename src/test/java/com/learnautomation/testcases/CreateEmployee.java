package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataproviders.CustomDataProvider;
import com.learnautomation.pages.EmployeePage;



public class CreateEmployee extends BaseClass {
	
	
		EmployeePage employee;
		public WebDriver driver;
		
		@BeforeMethod
		public void setupDriver()
		{
			driver=getDriver();
		}
	
	@Test(dataProvider = "EmployeeCreation",dataProviderClass = CustomDataProvider.class,priority = 0)
	public void login(String fName,String lName,String id,String username, String pass, String confirmpass, String status) 
	{
		employee=PageFactory.initElements(driver, EmployeePage.class);
		employee.addEmployee(fName,lName,id,username,pass,confirmpass,status);
		
		
		
	}
	

}
