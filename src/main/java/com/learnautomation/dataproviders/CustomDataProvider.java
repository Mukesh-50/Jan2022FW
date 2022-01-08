package com.learnautomation.dataproviders;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
	
	@DataProvider(name="Login")
	public static Object[][] getLoginData()
	{
		return ExcelUtility.getDataFromSheet("login");
	}
	
	@DataProvider(name="User")
	public static Object[][] getUserData()
	{
		return ExcelUtility.getDataFromSheet("User");
	}
	
	/*
	@DataProvider(name="User")
	public static Object[][] getUserData()
	{
		return ExcelUtility.getDataFromSheet("login");
	}

	
	@DataProvider(name="Emp")
	public static Object[][] getEmpData()
	{
		return ExcelUtility.getDataFromSheet("login");
	}
	*/
}
