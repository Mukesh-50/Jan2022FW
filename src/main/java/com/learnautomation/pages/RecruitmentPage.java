package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learnautomation.utility.BaseCommands;

public class RecruitmentPage {

	WebDriver driver;
	BaseCommands bc;

	public RecruitmentPage(WebDriver driver) {
		this.driver = driver;
		bc = new BaseCommands(driver);
	}

	/**
	 * Private By Locators to identify the WebElemens of Recruitment Page
	 */

	private By addButton = By.id("btnAdd");
	private By candidateFirstName = By.id("addCandidate_firstName");
	private By candidateLastName = By.id("addCandidate_lastName");
	private By candidateEmail = By.id("addCandidate_email");
	private By candidateContactNo = By.id("addCandidate_contactNo");
	private By jobVacancyType = By.id("addCandidate_vacancy");
	private By addCandidateSaveBtn = By.id("btnSave");
	private By successMsg = By.xpath("//div[contains(text(),'Successfully Saved')]");
	private By editButton=By.xpath("//input[@type='button' and @value='Edit']");

	/**
	 * Public Page Actions for the Recruitment Page
	 * 
	 * @return
	 */

	public boolean addCandidate(String firstName, String lastName, String contact, String vacancyType) {
		bc.waitForElementClickability(addButton, 5).click();
		bc.waitForElementVisibility(candidateFirstName, 5).sendKeys(firstName);
		bc.enterElementText(candidateLastName, lastName, true);
		bc.enterElementText(candidateEmail, bc.generateRandomEmail(), true);
		bc.enterElementText(candidateContactNo, contact, true);
		bc.selectFromDropList(jobVacancyType, vacancyType);
		bc.clickOnElement(addCandidateSaveBtn, 3);

		if (bc.waitForElementVisibility(editButton, 3).isDisplayed()) {

			return true;

		}

		return false;

	}

}
