package com.SeleniumWebDriverDemo.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

	protected static WebDriver driver;

	public void setWebDriver(WebDriver driver) {
		BasePage.driver = driver;
	}
}
