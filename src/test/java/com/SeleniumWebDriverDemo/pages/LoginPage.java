package com.SeleniumWebDriverDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.SeleniumWebDriverDemo.utilities.WaitHelper;
import com.SeleniumWebDriverDemo.utilities.StoreCookieInfo;

public class LoginPage extends BasePage {

	private WaitHelper waitHelper;
	private StoreCookieInfo storeCookieInfo;

	WebElement usernameBox = driver.findElement(By.id("user-name"));
	WebElement passwordBox = driver.findElement(By.id("password"));
	WebElement loginButton = driver.findElement(By.id("login-button"));

	public LoginPage() {
		waitHelper = new WaitHelper(driver);
		waitHelper.ExplicitWaitForElement(5, "elementToBeClickable", usernameBox);
		waitHelper.FluentWaitForElement(5, 250, "visibilityOf", passwordBox);
	}

	public String login(String username, String password) {
		usernameBox.sendKeys(username);
		passwordBox.sendKeys(password);
		loginButton.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			storeCookieInfo.StoreCookie();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return driver.getCurrentUrl();
	}
}
