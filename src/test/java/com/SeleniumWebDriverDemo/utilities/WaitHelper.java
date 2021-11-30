package com.SeleniumWebDriverDemo.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;

public class WaitHelper {

	public WebDriver driver;

	public WaitHelper (WebDriver driver) {
		this.driver = driver;
	}

	// wait for a certain condition to occur before proceeding further
	// Wait to avoid catching errors while the browser is loading
	public void ExplicitWaitForElement(long timeOutInSeconds, String expectedCondition, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		if (expectedCondition == "visibilityOf") {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		if (expectedCondition == "elementToBeClickable") {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		if (expectedCondition == "alertIsPresent") {
			wait.until(ExpectedConditions.alertIsPresent());
		}
	}

	// WebDriver cannot locate an object immediately because of its unavailability
	public void ImplicitWaitForElement(long timeOutInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOutInSeconds));
	}

	// define the maximum amount of time to wait for a condition to take place
	// define frequency with which to check the existence of the object condition
	public void FluentWaitForElement(long timeOutInSeconds, long polling, String expectedCondition, WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
			.pollingEvery(Duration.ofMillis(polling))
			.withMessage("The " + element + " didn't appear in the allotted " + timeOutInSeconds + " seconds.");

		if (expectedCondition == "visibilityOf") {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		if (expectedCondition == "elementToBeClickable") {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		if (expectedCondition == "alertIsPresent") {
			wait.until(ExpectedConditions.alertIsPresent());
		}
	}
}
