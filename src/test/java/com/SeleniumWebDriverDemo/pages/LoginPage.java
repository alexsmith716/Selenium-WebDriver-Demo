package com.SeleniumWebDriverDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.ElementNotVisibleException;
//import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

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
	private JavascriptExecutor jsExec = (JavascriptExecutor) driver;
	
	public LoginPage() {
		waitHelper = new WaitHelper(driver);
	}

	public void javascriptExecutorClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				(jsExec).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}

	public String loginAssertCorrecPageTitle() {
		String title = (String) jsExec.executeScript("return document.title");
		return title;
	};

	public String loginNegative(String incorrectUsername, String incorrectPassword) throws Exception {
		usernameBox.sendKeys(incorrectUsername);
		passwordBox.sendKeys(incorrectPassword);

		javascriptExecutorClick(loginButton);

		errorMessageContainerError = (errorMessageContainer.getAttribute("class").contains("error-message-container error")) ? true : false;

		usernameBox.clear();
		passwordBox.clear();

		return driver.getCurrentUrl();
	}

	public String loginPositive(String correctUsername, String correctPassword) {
		driver.navigate().refresh();

		driver.findElement(By.id("user-name")).sendKeys(Keys.chord(Keys.COMMAND, "a"), correctUsername);
		driver.findElement(By.id("password")).sendKeys(Keys.chord(Keys.COMMAND, "a"), correctPassword);

		driver.findElement(By.id("login-button")).click();

		return driver.getCurrentUrl();
	}
}
