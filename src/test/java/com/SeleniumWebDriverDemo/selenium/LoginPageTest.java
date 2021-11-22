package com.SeleniumWebDriverDemo.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import com.SeleniumWebDriverDemo.pages.LoginPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginPageTest extends BaseWebDriver {

	@Test
	@Order(1)
	public void loginNegativeTest() {
		LoginPage loginPage = new LoginPage();
		String URL = loginPage.loginNegative("incorrect_username", "incorrect_password");

		assertAll("Should return an Unsuccessfull Login",
				() -> assertTrue(loginPage.errorMessageContainerError),
				() -> assertEquals("https://www.saucedemo.com/", URL, "Unsuccessfully redirected")
		);
	}

	@Test
	@Order(2)
	public void loginPositiveTest() {
		LoginPage loginPage = new LoginPage();
		String URL = loginPage.loginPositive("performance_glitch_user", "secret_sauce");

		assertEquals("https://www.saucedemo.com/inventory.html", URL, "Unsuccessfully redirected");
	}
}
