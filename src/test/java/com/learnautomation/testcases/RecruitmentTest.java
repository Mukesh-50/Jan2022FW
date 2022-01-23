package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataproviders.AppliCationDataSet;
import com.learnautomation.dataproviders.CustomDataProvider;
import com.learnautomation.pages.AdminPage;
import com.learnautomation.pages.HomePage;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.pages.RecruitmentPage;

public class RecruitmentTest extends BaseClass {

	LoginPage login;
	HomePage home;
	AdminPage admin;
	RecruitmentPage recruitment;

	public WebDriver driver;

	@BeforeMethod()
	public void setupDriver() {
		driver = getDriver();

	}

	@Test(dataProvider = "Login", dataProviderClass = CustomDataProvider.class, priority = 1)
	public void login(String uname, String pass) {
		login = new LoginPage(driver);
		home = login.loginAsAdmin(uname, pass);
		System.out.println("Current URL after " + driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "URL pattern did not match");
	}

	@Test(dependsOnMethods = "login")
	public void addCandidateTest() {
		recruitment = home.clickOnRecruitMent();
		Assert.assertTrue(
				recruitment.addCandidate(AppliCationDataSet.candidateFirstName, AppliCationDataSet.candidatLastName,
						AppliCationDataSet.candidateContact, AppliCationDataSet.vacancyType));
	}

}
