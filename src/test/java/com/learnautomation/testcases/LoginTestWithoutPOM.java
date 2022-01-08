package com.learnautomation.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataproviders.CustomDataProvider;

public class LoginTestWithoutPOM extends BaseClass
{

	@Test(dataProvider = "Login",dataProviderClass = CustomDataProvider.class)
	public void login(String uname,String pass) 
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"URL pattern did not match");
	}

}
