package com.SeleniumWebDriverDemo.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SeleniumWebDriverDemo.utilities.WaitHelper;
import com.SeleniumWebDriverDemo.pages.BasePage;

public class BaseWebDriver {

	private static WebDriver driver;
	protected static BasePage basePage;
	protected static WaitHelper waitHelper;

	@BeforeAll
	public static void setUp(){
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver();
		waitHelper = new WaitHelper(driver);
		driver.get("https://www.saucedemo.com");

		// wait on page rendering to complete before trying to interact with the element
		// wait is set for the life of a Webdriver instance
		// WebDriver element methods will wait a maximum of 10 seconds finding an element before proceeding to execute the next step
		waitHelper.ImplicitWaitForElement(10);

		if (!driver.getCurrentUrl().contains("saucedemo.com")){
			throw new IllegalStateException("Current URL is NOT https://www.saucedemo.com: " + driver.getCurrentUrl());
		}

		basePage = new BasePage();
		basePage.setWebDriver(driver);
	}

	@AfterAll
	public static void tearDown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
