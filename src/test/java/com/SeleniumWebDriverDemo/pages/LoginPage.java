package com.SeleniumWebDriverDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.ElementNotVisibleException;
//import org.openqa.selenium.Cookie;

import com.SeleniumWebDriverDemo.utilities.WaitHelper;
//import com.SeleniumWebDriverDemo.utilities.StoreCookieInfo;

public class LoginPage extends BasePage {

	private WaitHelper waitHelper;
	//private StoreCookieInfo storeCookieInfo;

	private WebElement usernameBox = driver.findElement(By.id("user-name"));
	private WebElement passwordBox = driver.findElement(By.id("password"));
	private WebElement loginButton = driver.findElement(By.id("login-button"));

	private WebElement loginBox = driver.findElement(By.className("login-box"));
	private WebElement loginBoxForm = loginBox.findElement(By.tagName("form"));
	private WebElement errorMessageContainer = loginBoxForm.findElement(By.className("error-message-container"));
	public boolean errorMessageContainerError;

	public LoginPage() {
		waitHelper = new WaitHelper(driver);
	}

	public String loginNegative(String incorrectUsername, String incorrectPassword) {
		driver.manage().deleteAllCookies();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		usernameBox.sendKeys(incorrectUsername);
		passwordBox.sendKeys(incorrectPassword);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		loginButton.click();

		errorMessageContainerError = (errorMessageContainer.getAttribute("class").contains("error-message-container error")) ? true : false;

		usernameBox.clear();
		passwordBox.clear();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return driver.getCurrentUrl();
	}

	public String loginPositive(String correctUsername, String correctPassword) {
		usernameBox.sendKeys(Keys.chord(Keys.COMMAND, "a"), correctUsername);
		passwordBox.sendKeys(Keys.chord(Keys.COMMAND, "a"), correctPassword);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		loginButton.click();

		return driver.getCurrentUrl();
	}
}
