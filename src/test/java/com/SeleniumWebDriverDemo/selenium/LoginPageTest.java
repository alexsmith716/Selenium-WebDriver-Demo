package com.SeleniumWebDriverDemo.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SeleniumWebDriverDemo.pages.LoginPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginPageTest extends BaseWebDriver {

	@Test
	@Order(1)
	public void login() {
		LoginPage loginPage = new LoginPage();
		String URL = loginPage.login("performance_glitch_user", "secret_sauce");

		assertEquals("https://www.saucedemo.com/inventory.html", URL, "unsuccessfully redirected");
	}
}
