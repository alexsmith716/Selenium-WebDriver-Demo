package com.SeleniumWebDriverDemo.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

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
		driver = new ChromeDriver();
		waitHelper = new WaitHelper(driver);
		driver.get("https://www.saucedemo.com");

		waitHelper.ImplicitWaitForElement(5);

		if (!driver.getCurrentUrl().contains("saucedemo.com")){
			throw new IllegalStateException("Current URL is NOT https://www.saucedemo.com: " + driver.getCurrentUrl());
		}

		basePage = new BasePage();
		basePage.setWebDriver(driver);
	}

	@AfterAll
	public static void tearDown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
