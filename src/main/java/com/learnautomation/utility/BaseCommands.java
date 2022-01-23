package com.learnautomation.utility;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseCommands {

	WebDriver driver;

	public BaseCommands(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitForElementClickability(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitForElementVisibility(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void enterElementText(By locator, String value, boolean clear) {

		try {
			WebElement element = driver.findElement(locator);
			if (clear) {
				element.clear();
			}
			element.sendKeys(value);

		} catch (Exception e) {
			System.out.println("Error in Element");
		}
	}

	public void selectFromDropList(By Locator, String value) {

		try {
			WebElement element = driver.findElement(Locator);
			Select select = new Select(element);
			select.selectByVisibleText(value);

		} catch (Exception e) {
			System.out.println("Error in Element");
		}

	}

	public void clickOnElement(By Locator, int timOut) {

		waitForElementClickability(Locator, timOut).click();

	}

	public String generateRandomEmail() {
		return "Test" + ThreadLocalRandom.current().nextInt(2000) + "@gmail.com";
	}

}
